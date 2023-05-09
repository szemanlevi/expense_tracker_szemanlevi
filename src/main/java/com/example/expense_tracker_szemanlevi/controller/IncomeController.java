package com.example.expense_tracker_szemanlevi.controller;

import com.example.expense_tracker_szemanlevi.entity.Income;
import com.example.expense_tracker_szemanlevi.service.IncomeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class IncomeController {

    private final IncomeService incomeService;

    public IncomeController(IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    @GetMapping("/balance")
    @Operation(summary = "Calculate balance", description = "calculate balance based on all incomes and expenses")
    public Double getBalance() {
        return incomeService.getBalance();
    }

    @GetMapping("/income")
    @Operation(summary = "Income GetMapping", description = "get all incomes")
    public ResponseEntity<List<Income>> getAllIncomes() {
        List<Income> incomes = incomeService.findAll();
        return new ResponseEntity<>(incomes, HttpStatus.OK);
    }

    @GetMapping("/income/{id}")
    @Operation(summary = "Income GetMapping", description = "get income by id")
    public ResponseEntity<Income> getIncomeById(@Parameter(description = "income id", required = true)
                                                @PathVariable Long id) {
        Optional<Income> income = incomeService.findById(id);
        if (income.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(income.get(), HttpStatus.OK);
    }

    @PostMapping("/income")
    @Operation(summary = "Income PostMapping", description = "post an income")
    public ResponseEntity<Income> addIncome(@Valid @RequestBody Income income,
                                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(incomeService.save(income), HttpStatus.OK);
    }

    @PutMapping("/income/{id}")
    @Operation(summary = "Income PutMapping", description = "update an income by id")
    public ResponseEntity<Income> updateIncome(@Parameter(description = "income id", required = true)
                                               @PathVariable Long id,
                                               @Valid @RequestBody Income income) {
        Optional<Income> incomeToBeUpdated = incomeService.findById(id);
        if (incomeToBeUpdated.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(incomeService.update(id, income), HttpStatus.OK);
    }

    @DeleteMapping("/income/{id}")
    @Operation(summary = "Income DeleteMapping", description = "delete an income by id")
    public void deleteIncome(@Parameter(description = "income id", required = true)
                             @PathVariable Long id) {
        incomeService.delete(id);
    }
}
