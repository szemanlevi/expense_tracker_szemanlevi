package com.example.expense_tracker_szemanlevi.service;

import com.example.expense_tracker_szemanlevi.dao.CategoryDao;
import com.example.expense_tracker_szemanlevi.dao.ExpenseDao;
import com.example.expense_tracker_szemanlevi.entity.Expense;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseDao expenseDao;

    @Autowired
    private CategoryDao categoryDao;


    public List<Expense> findAll() {
        return expenseDao.findAll();
    }


    public Optional<Expense> findById(UUID id) {
        return expenseDao.findById(id);
    }

    public Expense save(Expense expense) {
        return expenseDao.save(expense);
    }

    public Expense update(UUID id, Expense expense) {
        Expense expenseToUpdate = expenseDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Expense not found"));
        expenseToUpdate.setDescription(expense.getDescription());
        expenseToUpdate.setAmount(expense.getAmount());
        expenseToUpdate.setDate(expense.getDate());
        expenseToUpdate.setCategory(expense.getCategory());
        return expenseDao.save(expenseToUpdate);
    }


    public void delete(UUID id) {
        expenseDao.deleteById(id);
    }

//    public ExpenseDto createExpense(ExpenseDto expenseDto) {
//        Expense expense = convertToEntity(expenseDto);
//        ExpenseCategory category = categoryDao.findById(expenseDto.getCategoryId()).orElseThrow(() -> new EntityNotFoundException("Category not found"));
//        expense.setCategory(category);
//        expense = expenseDao.save(expense);
//        return convertToDto(expense);
//    }

//    private ExpenseDto convertToDto(Expense expense) {
//        ExpenseDto expenseDto = new ExpenseDto();
////        expenseDto.setId(expense.getId());
//        expenseDto.setDescription(expense.getDescription());
//        expenseDto.setAmount(expense.getAmount());
//        expenseDto.setDate(expense.getDate());
//        expenseDto.setCategory(new CategoryDto(expense.getCategory().getName()));
//        return expenseDto;
//    }
//
//    private Expense convertToEntity(ExpenseDto expenseDto) {
//        Expense expense = new Expense();
//        expense.setDescription(expenseDto.getDescription());
//        expense.setAmount(expenseDto.getAmount());
//        expense.setDate(expenseDto.getDate());
//        return expense;
//    }
}

