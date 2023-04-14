package com.example.expense_tracker_szemanlevi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IncomeDto {
    private String description;

    private double amount;

    private Date date;

    private CategoryDto category;

    public IncomeDto(String description, double amount, Date date) {
        this.description = description;
        this.amount = amount;
        this.date = date;
    }
}
