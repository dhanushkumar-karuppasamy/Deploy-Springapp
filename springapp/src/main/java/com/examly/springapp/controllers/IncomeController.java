package com.examly.springapp.controllers;

import com.examly.springapp.entities.Income;
import com.examly.springapp.services.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/incomes")
public class IncomeController {

    @Autowired
    private IncomeService incomeService;

    @PostMapping
    public ResponseEntity<Income> createIncome(@RequestBody Income income) {
        Income savedIncome = incomeService.saveIncome(income);
        return ResponseEntity.status(201).body(savedIncome);
    }

    @GetMapping
    public ResponseEntity<List<Income>> getAllIncomes() {
        List<Income> incomes = incomeService.getAllIncomes();
        return ResponseEntity.ok(incomes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Income> getIncomeById(@PathVariable Long id) {
        return incomeService.getIncomeById(id).map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Income> updateIncome(@PathVariable Long id, @RequestBody Income income) {
        Income updatedIncome = incomeService.updateIncome(id, income);
        return ResponseEntity.ok(updatedIncome);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIncome(@PathVariable Long id) {
        incomeService.deleteIncome(id);
        return ResponseEntity.noContent().build();
        }

        @GetMapping("/sorted")
        public ResponseEntity<List<Income>> getAllIncomesSorted(@RequestParam String sortBy) {
            List<Income> incomes = incomeService.getAllIncomesSorted(sortBy);
            return ResponseEntity.ok(incomes);
        }
    }
