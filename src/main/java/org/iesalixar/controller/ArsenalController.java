package org.iesalixar.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.iesalixar.model.Armadura;
import org.iesalixar.model.Arsenal;
import org.iesalixar.model.Usuario;
import org.iesalixar.services.ArmaduraServiceImpl;
import org.iesalixar.services.ArsenalServiceImpl;
import org.iesalixar.services.RegistroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
	
	@Autowired
	ArmaduraServiceImpl armaduraService;
	
	@Autowired
	RegistroServiceImpl userService;
	
	@GetMapping("")
	public String arsenal(@RequestParam(required = false, name = "error") String error, Model model) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		String userName = authentication.getName();
		
		Usuario user = userService.getUsuarioByName(userName);
		
	
		
		List<Arsenal> arsenal = arsenalService.getAllByIdUsuario(user);
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
	
	@GetMapping("/add")
	public String addArsenal(@RequestParam(required = false, name = "error") String error, @RequestParam(required = true, name = "codigo") String codigo, Model model) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		String userName = authentication.getName();
		
		Usuario user = userService.getUsuarioByName(userName);
		
		Optional<Armadura> armaduraDB = armaduraService.findArmaduraById(Long.parseLong(codigo));
		
	
		
		Armadura armadura = new Armadura();
		
		armadura.setId(armaduraDB.get().getId());
		armadura.setNombre(armaduraDB.get().getNombre());
		armadura.setRareza(armaduraDB.get().getRareza());
		armadura.setParte(armaduraDB.get().getParte());
		armadura.setMonstruo(armaduraDB.get().getMonstruo());
		
		List<Arsenal> arsenal = arsenalService.getAllByIdUsuario(user);
		model.addAttribute("arsenal", arsenal);
		
		if (arsenalService.addArsenal(user, armadura)==null) {
			return "redirect:/createUser?error=Existe&user="+user.getNombre();
		}
		
		
		
		return "redirect:/armaduras";
		
	
	}

}
