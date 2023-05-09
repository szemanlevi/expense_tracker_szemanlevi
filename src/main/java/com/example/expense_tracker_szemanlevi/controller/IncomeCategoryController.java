package com.example.expense_tracker_szemanlevi.controller;

import com.example.expense_tracker_szemanlevi.entity.IncomeCategory;
import com.example.expense_tracker_szemanlevi.service.IncomeCategoryService;
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
    public ResponseEntity<List<IncomeCategory>> getAllIncomeCategories() {
        List<IncomeCategory> incomeCategories = incomeCategoryService.findAll();
        return new ResponseEntity<>(incomeCategories, HttpStatus.OK);
    }

    @GetMapping("/income/category/{id}")
    public ResponseEntity<IncomeCategory> getIncomeCategoryById(@PathVariable Long id) {
        Optional<IncomeCategory> incomeCategory = incomeCategoryService.findById(id);
        if (incomeCategory.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(incomeCategory.get(), HttpStatus.OK);
    }

    @PostMapping("/income/category/")
    public ResponseEntity<IncomeCategory> addIncomeCategory(@Valid @RequestBody IncomeCategory incomeCategory,
                                                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(incomeCategoryService.save(incomeCategory), HttpStatus.OK);
    }

    @PutMapping("/income/category/{id}")
    public ResponseEntity<IncomeCategory> updateIncomeCategory(@PathVariable Long id,
                                                               @Valid @RequestBody IncomeCategory incomeCategory) {
        Optional<IncomeCategory> incomeCategoryToBeUpdated = incomeCategoryService.findById(id);
        if (incomeCategoryToBeUpdated.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(incomeCategoryService.update(id, incomeCategory), HttpStatus.OK);
    }

    @DeleteMapping("/income/category/{id}")
    public void deleteIncomeCategory(@PathVariable Long id) {
        incomeCategoryService.delete(id);
    }
}
