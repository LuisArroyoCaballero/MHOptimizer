package org.iesalixar.repository;

import java.util.Optional;

import org.iesalixar.model.Armadura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArmaduraRepository extends JpaRepository<Armadura,Long> {
	
	public Optional<Armadura> findById(Long id);
	public Armadura findByNombre(String nombre);

}
