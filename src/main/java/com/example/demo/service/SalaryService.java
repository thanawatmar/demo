package com.example.demo.service;

import com.example.demo.service.dto.SalaryCriteria;
import io.github.jhipster.service.filter.RangeFilter;
import io.github.jhipster.service.filter.StringFilter;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;

@Service
public class SalaryService {

    private final List<String> fieldsList = List.of("employer", "timestamp", "gender", "location",
            "additional_comments", "annual_bonus", "annual_stock_value_bonus", "job_title", "salary",
            "signing_bonus", "years_at_employer", "years_of_experience");

    public void prepareCriteria(SalaryCriteria filter, Query salaryQuery) {
        setFilter(filter, salaryQuery);
    }

    private void setFilter(SalaryCriteria filter, Query salaryQuery) {

        if (filter.getTimestamp() != null) {
            salaryQuery.addCriteria(createRangeFilter(filter.getTimestamp(), "timestamp"));
        }

        if (filter.getEmployer() != null) {
            salaryQuery.addCriteria(createStringFilter(filter.getEmployer(), "employer"));
        }

        if (filter.getLocation() != null) {
            salaryQuery.addCriteria(createStringFilter(filter.getLocation(), "location"));
        }

        if (filter.getJobTitle() != null) {
            salaryQuery.addCriteria(createStringFilter(filter.getJobTitle(), "job_title"));
        }

        if (filter.getYearAtEmployer() != null) {
            salaryQuery.addCriteria(createRangeFilter(filter.getYearAtEmployer(), "year_at_employer"));
        }

        if (filter.getYearOfExperience() != null) {
            salaryQuery.addCriteria(createRangeFilter(filter.getYearOfExperience(), "years_of_experience"));
        }

        if (filter.getSalary() != null) {
            salaryQuery.addCriteria(createRangeFilter(filter.getSalary(), "salary"));
        }

        if (filter.getSingingBonus() != null) {
            salaryQuery.addCriteria(createRangeFilter(filter.getSingingBonus(), "signing_bonus"));
        }

        if (filter.getAnnualBonus() != null) {
            salaryQuery.addCriteria(createRangeFilter(filter.getAnnualBonus(), "annual_bonus"));
        }

        if (filter.getAnnualStockValueBonus() != null) {
            salaryQuery.addCriteria(createRangeFilter(filter.getAnnualStockValueBonus(), "annual_stock_value_bonus"));
        }

        if (filter.getGender() != null) {
            salaryQuery.addCriteria(createStringFilter(filter.getGender(), "gender"));
        }

        if (filter.getAdditionalComments() != null) {
            salaryQuery.addCriteria(createStringFilter(filter.getEmployer(), "employer"));
        }

        if (StringUtils.hasLength(filter.getFields())) {
            filterExistingFields(filter.getFields(), salaryQuery);
        }

    }

    private Criteria createStringFilter(StringFilter stringFilter, String field) {
        Criteria criteria = Criteria.where(field);

        if (stringFilter.getEquals() != null) {
            criteria.is(stringFilter.getEquals());
        }
        if (stringFilter.getNotEquals() != null) {
            criteria.ne(stringFilter.getNotEquals());
        }
        if (stringFilter.getContains() != null) {
            criteria.regex(stringFilter.getContains());
        }
        if (stringFilter.getDoesNotContain() != null) {
            criteria.not().regex(stringFilter.getContains());
        }
        if (stringFilter.getIn() != null) {
            criteria.in(stringFilter.getIn());
        }
        if (stringFilter.getNotIn() != null) {
            criteria.nin(stringFilter.getNotIn());
        }
        return criteria;
    }

    private Criteria createRangeFilter(RangeFilter<?> rangeFilter, String field) {
        Criteria criteria = Criteria.where(field);

        if (rangeFilter.getEquals() != null) {
            criteria.is(rangeFilter.getEquals());
        }
        if (rangeFilter.getNotEquals() != null) {
            criteria.ne(rangeFilter.getNotEquals());
        }
        if (rangeFilter.getGreaterThan() != null) {
            criteria.gt(rangeFilter.getGreaterThan());
        }
        if (rangeFilter.getGreaterThanOrEqual() != null) {
            criteria.gte(rangeFilter.getGreaterThanOrEqual());
        }
        if (rangeFilter.getLessThan() != null) {
            criteria.lt(rangeFilter.getLessThan());
        }
        if (rangeFilter.getLessThanOrEqual() != null) {
            criteria.lte(rangeFilter.getLessThanOrEqual());
        }
        if (rangeFilter.getIn() != null) {
            criteria.in(rangeFilter.getIn());
        }
        if (rangeFilter.getNotIn() != null) {
            criteria.nin(rangeFilter.getNotIn());
        }
        return criteria;
    }

    private void filterExistingFields(String stringFields, Query salaryQuery) {
        String[] a = stringFields.split(",");
        List<String> xxx = Arrays.stream(a).filter(fieldsList::contains).toList();
        if (!xxx.isEmpty()) {
            xxx.forEach(field -> salaryQuery.fields().include(field));
        } else {
            fieldsList.forEach(field -> salaryQuery.fields().include(field));
        }
    }
}
