package com.savetravelsmvc.services;

import java.util.List;

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

}
