package com.example.expense_tracker_szemanlevi.controller;

import com.example.expense_tracker_szemanlevi.entity.IncomeCategory;
import com.example.expense_tracker_szemanlevi.service.IncomeCategoryService;
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
public class IncomeCategoryController {
    private final IncomeCategoryService incomeCategoryService;

    public IncomeCategoryController(IncomeCategoryService incomeCategoryService) {
        this.incomeCategoryService = incomeCategoryService;
    }

    @GetMapping("/income/category")
    @Operation(summary = "Income Category GetMapping", description = "get all income categories")
    public ResponseEntity<List<IncomeCategory>> getAllIncomeCategories() {
        List<IncomeCategory> incomeCategories = incomeCategoryService.findAll();
        return new ResponseEntity<>(incomeCategories, HttpStatus.OK);
    }

    @GetMapping("/income/category/{id}")
    @Operation(summary = "Income Category GetMapping", description = "get income category by id")
    public ResponseEntity<IncomeCategory> getIncomeCategoryById(@Parameter(description = "income category id", required = true)
                                                                @PathVariable Long id) {
        Optional<IncomeCategory> incomeCategory = incomeCategoryService.findById(id);
        if (incomeCategory.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(incomeCategory.get(), HttpStatus.OK);
    }

    @PostMapping("/income/category/")
    @Operation(summary = "Income Category PostMapping", description = "post an income category")
    public ResponseEntity<IncomeCategory> addIncomeCategory(@Valid @RequestBody IncomeCategory incomeCategory,
                                                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(incomeCategoryService.save(incomeCategory), HttpStatus.OK);
    }

    @PutMapping("/income/category/{id}")
    @Operation(summary = "Income Category PutMapping", description = "update an income category by id")
    public ResponseEntity<IncomeCategory> updateIncomeCategory(@Parameter(description = "income category id", required = true)
                                                               @PathVariable Long id,
                                                               @Valid @RequestBody IncomeCategory incomeCategory) {
        Optional<IncomeCategory> incomeCategoryToBeUpdated = incomeCategoryService.findById(id);
        if (incomeCategoryToBeUpdated.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(incomeCategoryService.update(id, incomeCategory), HttpStatus.OK);
    }

    @DeleteMapping("/income/category/{id}")
    @Operation(summary = "Income Category DeleteMapping", description = "delete an income category by id")
    public void deleteIncomeCategory(@Parameter(description = "income category id", required = true)
                                     @PathVariable Long id) {
        incomeCategoryService.delete(id);
    }
}
