package com.example.expense_tracker_szemanlevi.controller;

import com.example.expense_tracker_szemanlevi.entity.Expense;
import com.example.expense_tracker_szemanlevi.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/expense")
    public ResponseEntity<List<Expense>> getAllExpenses() {
        List<Expense> expenses = expenseService.findAll();
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    @GetMapping("/expense/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable Long id) {
        Optional<Expense> expense = expenseService.findById(id);
        if (expense.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(expense.get(), HttpStatus.OK);
    }

    @PostMapping("/expense")
    public ResponseEntity<Expense> addExpense(@Valid @RequestBody Expense expense,
                                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(expenseService.save(expense), HttpStatus.OK);
    }

    @PutMapping("/expense/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable Long id,
                                                 @Valid @RequestBody Expense expense) {
        Optional<Expense> expenseToBeUpdated = expenseService.findById(id);
        if (expenseToBeUpdated.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(expenseService.update(id, expense), HttpStatus.OK);
    }

    @DeleteMapping("/expense/{id}")
    public void deleteExpense(@PathVariable Long id) {
        expenseService.delete(id);
    }
}
