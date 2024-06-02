package lib.src.finance_tracker.service;

import lib.src.finance_tracker.model.Expense;
import lib.src.finance_tracker.model.AppUser;
import lib.src.finance_tracker.repository.ExpenseRepository;
import lib.src.finance_tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private UserRepository userRepository;

    public Expense saveExpense(Expense expense, Long userId) {
        Optional<AppUser> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            expense.setUser(userOptional.get());
            return expenseRepository.save(expense);
        } else {
            throw new RuntimeException("User not found with id: " + userId);
        }
    }

    public List<Expense> getExpensesByUserId(Long userId) {
        return expenseRepository.findByUserId(userId);
    }
}
