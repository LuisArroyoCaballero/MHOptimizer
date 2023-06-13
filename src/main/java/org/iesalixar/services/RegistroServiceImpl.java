package org.iesalixar.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.iesalixar.SecurityConfiguration;
import org.iesalixar.model.Usuario;
import org.iesalixar.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class RegistroServiceImpl implements RegistroService {
	
	@Autowired
	UsuarioRepository userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private SecurityConfiguration sc;
	
	@Override
	public Optional<Usuario> findUsuarioById(Long id) {

		Optional<Usuario> usuario = null;

		if (id != null) {
			usuario = userRepo.findById(id);
		}

		return usuario;

	}
	
	@Override
	public void deleteUsuarioById(Long id) {
		if (id != null && findUsuarioById(id) != null) {
			userRepo.deleteById(id);

		}

	}
	
	@Override
	public List<Usuario> getAllUsuario() {
		// Obtengo el resultado a través del repositorio
		List<Usuario> userDB = userRepo.findAll();

		// Verificando que he obtenido algo
		if (userDB != null && userDB.size() > 0) {

			return userDB;
		}

		// No he obtenido nada devuelvo una lista vacía (para no devolver nulo)
		return new ArrayList<Usuario>();
	}
	
	@Override
	public List<Usuario> getAllByRol() {
		// Obtengo el resultado a través del repositorio
				List<Usuario> userDB = userRepo.getAllByRol("ROLE_USER");

				// Verificando que he obtenido algo
				if (userDB != null && userDB.size() > 0) {

					return userDB;
				}

				// No he obtenido nada devuelvo una lista vacía (para no devolver nulo)
				return new ArrayList<Usuario>();
	}
	
	
	@Override
	public Usuario addUsuario(Usuario usuario) {
		if (usuario != null && getUsuarioByName(usuario.getNombre()) == null) {
			usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
			Usuario user = userRepo.save(usuario);
			return user;
		}

		return null;
	}
	
	@Override
	public Usuario getUsuarioByName(String nombre) {
		if (nombre != null) {

			Usuario usuario = userRepo.findByNombre(nombre);

			return usuario;
		}

		return null;
	}

	@Override
	public Usuario updateUsuario(Usuario usuario) {
		return userRepo.save(usuario);
	}

	


}