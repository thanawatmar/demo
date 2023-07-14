package com.example.demo.web.rest;

import com.example.demo.domain.Salary;
import com.example.demo.service.SalaryService;
import com.example.demo.service.dto.SalaryCriteria;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class SalaryResource {

    private final SalaryService salaryService;

    private final MongoTemplate mongoTemplate;

    public SalaryResource(SalaryService salaryService, MongoTemplate mongoTemplate) {
        this.salaryService = salaryService;
        this.mongoTemplate = mongoTemplate;
    }

    @GetMapping("/salary")
    public ResponseEntity<Page<Salary>> getData(SalaryCriteria filter, Pageable pageable) {
        log.info("Rest to get Salary data with filter: {} and page: {}", filter, pageable);
        Query salaryQuery = (new Query()).with(pageable);
        salaryService.prepareCriteria(filter, salaryQuery);
        List<Salary> result = mongoTemplate.find(salaryQuery, Salary.class);
        return ResponseEntity.ok(PageableExecutionUtils.getPage(result, pageable,
                () -> this.mongoTemplate.count(Query.of(salaryQuery).limit(-1).skip(-1L), Salary.class, "salary")));
    }
}
