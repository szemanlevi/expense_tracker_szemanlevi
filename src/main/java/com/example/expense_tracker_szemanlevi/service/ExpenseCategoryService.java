package com.example.expense_tracker_szemanlevi.service;

import com.example.expense_tracker_szemanlevi.dao.ExpenseCategoryDao;
import com.example.expense_tracker_szemanlevi.entity.Expense;
import com.example.expense_tracker_szemanlevi.entity.ExpenseCategory;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseCategoryService {

    private final ExpenseCategoryDao expenseCategoryDao;

    public ExpenseCategoryService(ExpenseCategoryDao expenseCategoryDao) {
        this.expenseCategoryDao = expenseCategoryDao;
    }

    public List<ExpenseCategory> findAll() {
        return expenseCategoryDao.findAll();
    }

    public Optional<ExpenseCategory> findById(Long id) {
        return expenseCategoryDao.findById(id);
    }

    public ExpenseCategory save(ExpenseCategory expenseCategory) {
        return expenseCategoryDao.save(expenseCategory);
    }

    public ExpenseCategory update(Long id, ExpenseCategory expenseCategory) {
        ExpenseCategory expenseCategoryToUpdate = expenseCategoryDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ExpenseCategory not found"));
        expenseCategoryToUpdate.setName(expenseCategory.getName());
        return expenseCategoryDao.save(expenseCategoryToUpdate);
    }

    public void delete(Long id) {
        expenseCategoryDao.deleteById(id);
    }
}
