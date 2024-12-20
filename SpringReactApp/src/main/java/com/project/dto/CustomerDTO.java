package com.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CustomerDTO {

    private long customerid;

    private String customername;

    private int age;

    private String city;

    private String mobile;
}
