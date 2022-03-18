package com.savetravelsmvc.ExpenseController;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.savetravelsmvc.models.Expense;
import com.savetravelsmvc.services.ExpenseService;


@Controller
public class ExpenseController {
	@Autowired
	ExpenseService expenseService;
	
	@GetMapping("/expenses")
    public String newExpense(Model model , @ModelAttribute("expense") Expense expense) {
		List<Expense> expenses = expenseService.allExpenses();
		model.addAttribute("expenses", expenses);
        return "index.jsp";
    }
	
	@PostMapping("/expenses")
	public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		}else {
			expenseService.createExpense(expense);
			return "redirect:/expenses";
		}
		
		
	}
	
	@GetMapping("/expenses/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
        Expense expense = expenseService.findExpense(id);
        model.addAttribute("expense", expense);
        return "edit.jsp";
    }
	
	@PutMapping("/expenses/edit/{id}")
	public String update(@PathVariable("id") Long id,@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}else {
			expenseService.updateExpense(id,expense);
			return "redirect:/expenses";
		}

}
	
	@GetMapping("/expenses/{id}")
	public String index(Model model,@PathVariable("id")Long id) {
	Expense expense = expenseService.findExpense(id);
	model.addAttribute("expense", expense);
	return "info.jsp";
}
	
	
	@DeleteMapping("/expenses/delete/{id}")
	    public String destroy(@PathVariable("id") Long id) {
        expenseService.deleteExpense(id);
        return "redirect:/expenses";
		    }
	}

