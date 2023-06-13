package org.iesalixar.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.iesalixar.model.Arsenal;
import org.iesalixar.services.ArsenalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/arsenal")
public class ArsenalController {
	
	@Autowired
	ArsenalServiceImpl arsenalService;
	
	@GetMapping("")
	public String usuario(@RequestParam(required = false, name = "error") String error, Model model) {

		
		List<Arsenal> arsenal = arsenalService.getAllArsenal();
		model.addAttribute("arsenal", arsenal);
		
		
		
		if (error != null) {
			model.addAttribute("error", "Error al visualizar el arsenal.");
		}
		/*
		if (profService.addProfesor(profBD)==null) {
			return "redirect:/profesores/addProfesor?error=Existe&dpto="+prof.getNombre();
		}
		*/
		return "arsenal";
		
	}

}
