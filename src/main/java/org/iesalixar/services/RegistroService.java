package org.iesalixar.services;

import java.util.List;
import java.util.Optional;

import org.iesalixar.model.Usuario;

public interface RegistroService {
	
	public List<Usuario> getAllUsuario();
	public List<Usuario> getAllByRol();
	public Usuario addUsuario(Usuario usuario);
	public Usuario getUsuarioByName(String nombre);
	public Optional<Usuario> findUsuarioById(Long id);
	public void deleteUsuarioById(Long id);
	public Usuario updateUsuario(Usuario usuario);

}
