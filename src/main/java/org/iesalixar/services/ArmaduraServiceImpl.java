package org.iesalixar.services;

import java.util.ArrayList;
import java.util.List;

import org.iesalixar.model.Armadura;
import org.iesalixar.repository.ArmaduraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArmaduraServiceImpl implements ArmaduraService {
	
	@Autowired
	ArmaduraRepository armaduraRepo;

	@Override
	public List<Armadura> getAllArmadura() {
		// Obtengo el resultado a través del repositorio
		List<Armadura> armaduraDB = armaduraRepo.findAll();

		// Verificando que he obtenido algo
		if (armaduraDB != null && armaduraDB.size() > 0) {

			return armaduraDB;
		}

		// No he obtenido nada devuelvo una lista vacía (para no devolver nulo)
		return new ArrayList<Armadura>();
	}

}
