package org.iesalixar.repository;

import java.util.List;
import java.util.Optional;

import org.iesalixar.model.Arsenal;
import org.iesalixar.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArsenalRepository extends JpaRepository<Arsenal,Long> {
	
	//public Optional<Arsenal> findById(Long id);
	//public Arsenal findByNombre(String nombre);
	public List<Arsenal> getAllByUsuario(Usuario user);

}
