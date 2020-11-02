package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import dmacc.beans.Student;
import dmacc.repository.ContactRepository;

@Controller
public class WebController {
	@Autowired
	ContactRepository repo;
	
	@GetMapping({"viewAll" })
	public String viewAllStudent(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewStudent(model);
			}
		model.addAttribute("students",repo.findAll());
		return "results";
	}
	@GetMapping("/inputStudent")
		public String addNewStudent(Model model) {
		Student s = new Student();
		model.addAttribute("newStudent", s);
		return "input";
	}
	@PostMapping("/inputStudent")
	public String addNewStudent(@ModelAttribute Student s, Model model) {
	repo.save(s);
	return viewAllStudent(model);
	
}
	@GetMapping("/edit/{id}")
	public String showUpdateStudent(@PathVariable("id") long id,Model model) {
	Student s = repo.findById(id).orElse(null);
	model.addAttribute("newStudent", s);
	return "input";
	}
	@PostMapping("/update/{id}")
	public String reviseStudent(Student s, Model model) {
	repo.save(s);
	return viewAllStudent(model);
	}
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
	Student s = repo.findById(id).orElse(null);
	 repo.delete(s);
	 return viewAllStudent(model);
	}
}