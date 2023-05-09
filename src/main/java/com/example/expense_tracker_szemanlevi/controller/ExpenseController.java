package com.example.expense_tracker_szemanlevi.controller;

import com.example.expense_tracker_szemanlevi.entity.Expense;
import com.example.expense_tracker_szemanlevi.service.ExpenseService;
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
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/expense")
    @Operation(summary = "Expense GetMapping", description = "get all expenses")
    public ResponseEntity<List<Expense>> getAllExpenses() {
        List<Expense> expenses = expenseService.findAll();
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    @GetMapping("/expense/{id}")
    @Operation(summary = "Expense GetMapping", description = "get expense by id")
    public ResponseEntity<Expense> getExpenseById(@Parameter(description = "expense id", required = true)
                                                  @PathVariable Long id) {
        Optional<Expense> expense = expenseService.findById(id);
        if (expense.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(expense.get(), HttpStatus.OK);
    }

    @PostMapping("/expense")
    @Operation(summary = "Expense PostMapping", description = "post an expense")
    public ResponseEntity<Expense> addExpense(@Valid @RequestBody Expense expense,
                                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(expenseService.save(expense), HttpStatus.OK);
    }

    @PutMapping("/expense/{id}")
    @Operation(summary = "Expense PutMapping", description = "update an expense by id")
    public ResponseEntity<Expense> updateExpense(@Parameter(description = "expense id", required = true)
                                                 @PathVariable Long id,
                                                 @Valid @RequestBody Expense expense) {
        Optional<Expense> expenseToBeUpdated = expenseService.findById(id);
        if (expenseToBeUpdated.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(expenseService.update(id, expense), HttpStatus.OK);
    }

    @DeleteMapping("/expense/{id}")
    @Operation(summary = "Expense DeleteMapping", description = "delete an expense by id")
    public void deleteExpense(@Parameter(description = "expense id", required = true)
                              @PathVariable Long id) {
        expenseService.delete(id);
    }
}
