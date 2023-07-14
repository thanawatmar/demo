package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serial;
import java.io.Serializable;

@Data
@Document(collection = "salary")
public class Salary implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Field("timestamp")
    private String timestamp;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Field("employer")
    private String employer;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Field("location")
    private String location;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Field("job_title")
    private String jobTitle;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Field("years_at_employer")
    private String yearAtEmployer;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Field("years_of_experience")
    private String yearOfExperience;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Field("salary")
    private String salary;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Field("signing_bonus")
    private String singingBonus;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Field("annual_bonus")
    private String annualBonus;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Field("annual_stock_value_bonus")
    private String annualStockValueBonus;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Field("gender")
    private String gender;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Field("additional_comments")
    private String additionalComments;

}
