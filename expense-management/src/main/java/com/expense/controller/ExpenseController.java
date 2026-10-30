package com.expense.controller;

import com.expense.entity.Expense;
import com.expense.service.ExpenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping
    public Expense addExpense(@RequestBody Expense expense) {
        return expenseService.addExpense(expense);
    }

    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable Long id) {
        Expense expense = expenseService.getExpenseById(id);
        if (expense == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(expense);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Expense> updateExpense(
            @PathVariable Long id, @RequestBody Expense expense) {
        Expense updatedExpense = expenseService.updateExpense(id, expense);
        if (updatedExpense == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updatedExpense);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable Long id) {
        boolean deleted = expenseService.deleteExpense(id);
        if (!deleted) return ResponseEntity.notFound().build();
        return ResponseEntity.ok("Expense deleted successfully");
    }

    @GetMapping("/student/{studentId}")
    public List<Expense> getExpensesByStudent(@PathVariable Long studentId) {
        return expenseService.getExpensesByStudent(studentId);
    }

    @GetMapping("/student/{studentId}/total")
    public double getTotalExpenseByStudent(@PathVariable Long studentId) {
        return expenseService.getTotalExpenseByStudent(studentId);
    }
}
