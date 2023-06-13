package org.iesalixar.controller;

import java.util.List;

import org.iesalixar.model.Monstruo;
import org.iesalixar.services.MonstruoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/monstruos")
public class MonstruosController {
	
	@Autowired
	MonstruoServiceImpl monstruoService;
	
	@GetMapping("")
	public String monstruos(@RequestParam(required = false, name = "error") String error, Model model) {

		
		List<Monstruo> monstruos = monstruoService.getAllMonstruo();
		model.addAttribute("monstruos", monstruos);
		
		
		
		if (error != null) {
			model.addAttribute("error", "Error al visualizar los monstruos");
		}

		return "monstruos";
		
	}

}
