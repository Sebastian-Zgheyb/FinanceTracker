package lib.src.finance_tracker.controller;

import lib.src.finance_tracker.model.Expense;
import lib.src.finance_tracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @PostMapping
    public Expense createExpense(@RequestBody Expense expense, @RequestParam Long userId) {
        return expenseService.saveExpense(expense, userId);
    }

    @GetMapping("/user/{userId}")
    public List<Expense> getExpensesByUserId(@PathVariable Long userId) {
        return expenseService.getExpensesByUserId(userId);
    }
}
