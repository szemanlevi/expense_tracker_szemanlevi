package com.example.expense_tracker_szemanlevi.controller;

import com.example.expense_tracker_szemanlevi.entity.ExpenseCategory;
import com.example.expense_tracker_szemanlevi.service.ExpenseCategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Validated
public class ExpenseCategoryController {
    private final ExpenseCategoryService expenseCategoryService;

    public ExpenseCategoryController(ExpenseCategoryService expenseCategoryService) {
        this.expenseCategoryService = expenseCategoryService;
    }

    @GetMapping("/expense/category")
    public ResponseEntity<List<ExpenseCategory>> getAllExpenseCategories() {
        List<ExpenseCategory> expenseCategories = expenseCategoryService.findAll();
        return new ResponseEntity<>(expenseCategories, HttpStatus.OK);
    }

    @GetMapping("/expense/category/{id}")
    public ResponseEntity<ExpenseCategory> getExpenseCategoryById(@PathVariable Long id) {
        Optional<ExpenseCategory> expenseCategory = expenseCategoryService.findById(id);
        if (expenseCategory.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(expenseCategory.get(), HttpStatus.OK);
    }

    @PostMapping("/expense/category/")
    public ResponseEntity<ExpenseCategory> addExpenseCategory(@Valid @RequestBody ExpenseCategory expenseCategory,
                                                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(expenseCategoryService.save(expenseCategory), HttpStatus.OK);
    }

    @PutMapping("/expense/category/{id}")
    public ResponseEntity<ExpenseCategory> updateExpenseCategory(@PathVariable Long id,
                                                                 @Valid @RequestBody ExpenseCategory expenseCategory) {
        Optional<ExpenseCategory> expenseCategoryToBeUpdated = expenseCategoryService.findById(id);
        if (expenseCategoryToBeUpdated.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(expenseCategoryService.update(id, expenseCategory), HttpStatus.OK);
    }

    @DeleteMapping("/expense/category/{id}")
    public void deleteExpenseCategory(@PathVariable Long id) {
        expenseCategoryService.delete(id);
    }
}
