package com.example.demo.service.dto;

import io.github.jhipster.service.filter.FloatFilter;
import io.github.jhipster.service.filter.InstantFilter;
import io.github.jhipster.service.filter.StringFilter;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class SalaryCriteria implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private InstantFilter timestamp;

    private StringFilter employer;

    private StringFilter location;

    private StringFilter jobTitle;

    private FloatFilter yearAtEmployer;

    private FloatFilter yearOfExperience;

    private FloatFilter salary;

    private FloatFilter singingBonus;

    private FloatFilter annualBonus;

    private FloatFilter annualStockValueBonus;

    private StringFilter gender;

    private StringFilter additionalComments;

    private String fields;

}
