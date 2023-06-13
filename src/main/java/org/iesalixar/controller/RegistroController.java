package org.iesalixar.controller;

import java.util.List;


import org.iesalixar.model.Usuario;
import org.iesalixar.services.RegistroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegistroController {
	
	@Autowired
	RegistroServiceImpl userService;

	
	@GetMapping("")
	public String registroGet(@RequestParam(required = false, name = "error") String error, Model model) {

		
		Usuario user = new Usuario();
		
		
		model.addAttribute("user", user);
		model.addAttribute("error", error);
		
		
		return "registro";
		
	}
	
	@PostMapping("")
	public String registroPost(@ModelAttribute Usuario user,Model model) {
		
		Usuario userBD = new Usuario();
		
		userBD.setNombre(user.getNombre());
		userBD.setPassword(user.getPassword());
		userBD.setEmail(user.getEmail());
		userBD.setRol("ROLE_USER");
		userBD.setActivo(true);
		
		if (userService.addUsuario(userBD)==null) {
			return "redirect:/register?error=Existe&user="+user.getNombre();
		}
		
		return "redirect:/";
	}

}
