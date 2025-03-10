package com.examly.springapp.services;

import com.examly.springapp.entities.Budget;
import com.examly.springapp.repositories.BudgetRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class BudgetService {

    private final BudgetRepository budgetRepository;

    public BudgetService(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

    public Budget saveBudget(Budget budget) {
        return budgetRepository.save(budget);
    }

    public List<Budget> getAllBudgets() {
        return budgetRepository.findAll();
        }

        public Optional<Budget> getBudgetById(Long id) {
            return budgetRepository.findById(id);
        }

        public Budget updateBudget(Long id, Budget budget) {
            if (budgetRepository.existsById(id)) {
                budget.setId(id);
                return budgetRepository.save(budget);
            }
            throw new RuntimeException("Budget not found with ID: " + id);
        }

        public void deleteBudget(Long id) {
            if (budgetRepository.existsById(id)) {
                budgetRepository.deleteById(id);
                } else {
                throw new RuntimeException("Budget not found with ID: " + id);
                }
            }

            public List<Budget> getBudgetsByUserIdAndCategory(Long userId, String category) {
                return budgetRepository.findByUserIdAndCategory(userId, category);
            }
            }
                
                
                
                
           
