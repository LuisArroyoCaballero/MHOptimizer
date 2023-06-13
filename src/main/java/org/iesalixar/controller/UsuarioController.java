package org.iesalixar.controller;

import java.util.List;
import java.util.Optional;

import org.iesalixar.model.Monstruo;
import org.iesalixar.model.Usuario;
import org.iesalixar.services.RegistroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	RegistroServiceImpl userService;

	
	@GetMapping("")
	public String usuario(@RequestParam(required = false, name = "error") String error, Model model) {

		
		List<Usuario> usuarios = userService.getAllByRol();
		model.addAttribute("usuarios", usuarios);
		
		
		if (error != null) {
			model.addAttribute("error", "Error al visualizar los usuarios.");
		}
		/*
		if (profService.addProfesor(profBD)==null) {
			return "redirect:/profesores/addProfesor?error=Existe&dpto="+prof.getNombre();
		}
		*/
		return "usuarios";
		
	}
	
	@GetMapping("/removeUsuario")
	public String removeUsuario(@RequestParam(required = true, name = "codigo") String codigo, @RequestParam(required = false, name = "error") String error, Model model) {

		if (codigo == null) {
			model.addAttribute("errorUsuario", "Usuario no seleccionado");
			return "redirect:/usuarios?error=notselected";
		}

		//Optional<Usuario> usuario = userService.findUsuarioById(Long.parseLong(codigo));
		
		userService.deleteUsuarioById(Long.parseLong(codigo));
		
		return "redirect:/usuarios";
		
		

	}
	
	@GetMapping("/createUser")
	public String addUserGet(@RequestParam(required = false, name = "error") String error, Model model) {

		
		Usuario user = new Usuario();
		
		
		model.addAttribute("user", user);
		model.addAttribute("error", error);
		
		
		return "addUser";
		
	}
	
	@PostMapping("/createUser")
	public String addUserPost(@ModelAttribute Usuario user,Model model) {
		
		Usuario userBD = new Usuario();
		
		userBD.setNombre(user.getNombre());
		userBD.setPassword(user.getPassword());
		userBD.setEmail(user.getEmail());
		userBD.setRol("ROLE_USER");
		userBD.setActivo(true);
		
		if (userService.addUsuario(userBD)==null) {
			return "redirect:/createUser?error=Existe&user="+user.getNombre();
		}
		
		return "redirect:/usuarios";
	}
	
	@GetMapping("/updateUser")
	public String updateUsuarioGet(@RequestParam(required = true, name = "codigo") String codigo, @RequestParam(required = false, name = "error") String error, Model model) {

		if (codigo == null) {
			model.addAttribute("errorUsuario", "Error al seleccionar usuario.");
			return "redirect:/usuarios?error=notselected";
		}
		
		Optional<Usuario> usuario = userService.findUsuarioById(Long.parseLong(codigo));
	
		
		model.addAttribute("usuario", usuario);
		
		
		model.addAttribute("error", error);

		//Optional<Usuario> usuario = userService.findUsuarioById(Long.parseLong(codigo));
		
		
		return "updateUser";
		
		

	}
	
	@PostMapping("/updateUser")
	public String updateUsuarioPost(@ModelAttribute Usuario user,Model model) {
		
		Optional<Usuario> userBD = userService.findUsuarioById(user.getId());
		
		Usuario usuarioPrueba = userBD.get();
		
		usuarioPrueba.setId(user.getId());
		usuarioPrueba.setNombre(user.getNombre());
		usuarioPrueba.setPassword(user.getPassword());
		usuarioPrueba.setEmail(user.getEmail());
		usuarioPrueba.setRol("ROLE_USER");
		usuarioPrueba.setActivo(true);
		
		
		userService.updateUsuario(usuarioPrueba);
		
		return "redirect:/usuarios";
	}
		
	

}
