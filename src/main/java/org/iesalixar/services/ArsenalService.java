package org.iesalixar.services;

import java.util.List;
import java.util.Optional;

import org.iesalixar.model.Armadura;
import org.iesalixar.model.Arsenal;
import org.iesalixar.model.Usuario;

public interface ArsenalService {
	
	public List<Arsenal> getAllArsenal();
	//public Optional<Arsenal> findArsenalById(Long id);
	public List<Arsenal> getAllByIdUsuario(Usuario user);
	public Arsenal addArsenal(Usuario usuario, Armadura armadura);

}
