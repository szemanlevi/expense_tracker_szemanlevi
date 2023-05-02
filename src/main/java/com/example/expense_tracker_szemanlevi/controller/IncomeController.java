package com.example.expense_tracker_szemanlevi.controller;

import com.example.expense_tracker_szemanlevi.entity.Income;
import com.example.expense_tracker_szemanlevi.service.IncomeService;
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
    public Double getBalance() {
        return incomeService.getBalance();
    }

    @GetMapping("/income")
    public ResponseEntity<List<Income>> getAllIncomes() {
        List<Income> incomes = incomeService.findAll();
        return new ResponseEntity<>(incomes, HttpStatus.OK);
    }

    @GetMapping("/income/{id}")
    public ResponseEntity<Income> getIncomeById(@PathVariable Long id) {
        Optional<Income> income = incomeService.findById(id);
        if (income.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(income.get(), HttpStatus.OK);
    }

    @PostMapping("/income")
    public ResponseEntity<Income> addIncome(@Valid @RequestBody Income income,
                                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(incomeService.save(income), HttpStatus.OK);
    }

    @PutMapping("/income/{id}")
    public ResponseEntity<Income> updateIncome(@PathVariable Long id,
                                               @Valid @RequestBody Income income) {
        Optional<Income> incomeToBeUpdated = incomeService.findById(id);
        if (incomeToBeUpdated.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(incomeService.update(id, income), HttpStatus.OK);
    }

    @DeleteMapping("/income/{id}")
    public void deleteIncome(@PathVariable Long id) {
        incomeService.delete(id);
    }
}
