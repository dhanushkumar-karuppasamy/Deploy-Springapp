package com.examly.springapp.services;

import com.examly.springapp.entities.Income;
import com.examly.springapp.repositories.IncomeRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncomeService {

    private final IncomeRepository incomeRepository;

    public IncomeService(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    public Income saveIncome(Income income) {
        return incomeRepository.save(income);
    }

    public List<Income> getAllIncomes() {
        return incomeRepository.findAll();
    }

    public Optional<Income> getIncomeById(Long id) {
        return incomeRepository.findById(id);
        }

        public Income updateIncome(Long id, Income income) {
            if (incomeRepository.existsById(id)) {
                income.setId(id);
                return incomeRepository.save(income);
            }
            throw new RuntimeException("Income not found with ID: " + id);
        }

        public void deleteIncome(Long id) {
            if (incomeRepository.existsById(id)) {
                incomeRepository.deleteById(id);
            } else {
                throw new RuntimeException("Income not found with ID: " + id);
            }
        }

        public List<Income> getAllIncomesSorted(String sortBy) {
            return incomeRepository.findAll(Sort.by(Sort.Direction.ASC, sortBy));
        }
    }