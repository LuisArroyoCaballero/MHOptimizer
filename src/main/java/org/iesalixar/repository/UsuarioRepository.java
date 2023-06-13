package org.iesalixar.repository;

import java.util.List;
import java.util.Optional;

import org.iesalixar.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

	public Usuario findByNombre(String name);
	public List<Usuario> getAllByRol(String rol);
	public Optional<Usuario> findById(Long id);
	public void deleteById(Long id);
}
