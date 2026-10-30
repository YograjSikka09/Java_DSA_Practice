package com.expense.service;

import com.expense.entity.Expense;
import com.expense.repository.ExpenseRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public Expense addExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id).orElse(null);
    }

    public Expense updateExpense(Long id, Expense expense) {
        Expense existingExpense = expenseRepository.findById(id).orElse(null);
        if (existingExpense == null) return null;

        existingExpense.setAmount(expense.getAmount());
        existingExpense.setDescription(expense.getDescription());
        existingExpense.setExpenseDate(expense.getExpenseDate());
        existingExpense.setStudentId(expense.getStudentId());
        existingExpense.setCategoryId(expense.getCategoryId());

        return expenseRepository.save(existingExpense);
    }

    public boolean deleteExpense(Long id) {
        if (!expenseRepository.existsById(id)) return false;
        expenseRepository.deleteById(id);
        return true;
    }

    public List<Expense> getExpensesByStudent(Long studentId) {
        return expenseRepository.findByStudentId(studentId);
    }

    public double getTotalExpenseByStudent(Long studentId) {
        List<Expense> expenses = expenseRepository.findByStudentId(studentId);
        double total = 0;

        for (Expense expense : expenses) {
            total = total + expense.getAmount();
        }

        return total;
    }
}
