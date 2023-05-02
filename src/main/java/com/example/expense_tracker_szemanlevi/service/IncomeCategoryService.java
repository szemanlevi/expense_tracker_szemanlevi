package com.example.expense_tracker_szemanlevi.service;

import com.example.expense_tracker_szemanlevi.dao.IncomeCategoryDao;
import com.example.expense_tracker_szemanlevi.entity.IncomeCategory;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncomeCategoryService {

    private final IncomeCategoryDao incomeCategoryDao;

    public IncomeCategoryService(IncomeCategoryDao incomeCategoryDao) {
        this.incomeCategoryDao = incomeCategoryDao;
    }

    public List<IncomeCategory> findAll() {
        return incomeCategoryDao.findAll();
    }

    public Optional<IncomeCategory> findById(Long id) {
        return incomeCategoryDao.findById(id);
    }

    public IncomeCategory save(IncomeCategory incomeCategory) {
        return incomeCategoryDao.save(incomeCategory);
    }

    public IncomeCategory update(Long id, IncomeCategory incomeCategory) {
        IncomeCategory incomeCategoryToUpdate = incomeCategoryDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("IncomeCategory not found"));
        incomeCategoryToUpdate.setName(incomeCategory.getName());
        return incomeCategoryDao.save(incomeCategoryToUpdate);
    }

    public void delete(Long id) {
        incomeCategoryDao.deleteById(id);
    }
}
