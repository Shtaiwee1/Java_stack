package com.savetravelsmvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.savetravelsmvc.models.Expense;
import com.savetravelsmvc.repositories.ExpenseRepository;


@Service
public class ExpenseService {
	
	private final ExpenseRepository expenseRepository;
	 
	 public ExpenseService(ExpenseRepository expenseRepository) {
	     this.expenseRepository = expenseRepository;
	 }
	 // returns all the expenses
	 public List<Expense> allExpenses() {
	     return expenseRepository.findAll();
	 }
	 // create a new expense
	 public Expense createExpense(Expense e) {
	     return expenseRepository.save(e);
	 }
	 
	// retrieves an expense
		public Expense findExpense(Long id) {
			Optional<Expense> optionalExpense = expenseRepository.findById(id);
			if (optionalExpense.isPresent()) {
				return optionalExpense.get();
			} else {
				return null;
			}
		}
	 
	//Updates an Expense
	 public Expense updateExpense(Long id, Expense expense) {
		 Expense e = findExpense(id);
			e.setName(expense.getName());
			e.setVendor(expense.getVendor());
			e.setAmount(expense.getAmount());
			e.setDescription(expense.getDescription());
			return expenseRepository.save(e);
		}
	 
	//deletes an Expense
	 public void deleteExpense(Long id) {
			Expense expense = this.findExpense(id);
			expenseRepository.delete(expense);

		}
			
		}


