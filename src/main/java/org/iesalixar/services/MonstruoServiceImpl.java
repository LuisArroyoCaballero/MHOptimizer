package org.iesalixar.services;

import java.util.ArrayList;
import java.util.List;

import org.iesalixar.model.Monstruo;
import org.iesalixar.repository.MonstruoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonstruoServiceImpl implements MonstruoService {
	
	@Autowired
	MonstruoRepository monstruoRepo;

	@Override
	public List<Monstruo> getAllMonstruo() {
		// Obtengo el resultado a través del repositorio
		List<Monstruo> monstruoDB = monstruoRepo.findAll();

		// Verificando que he obtenido algo
		if (monstruoDB != null && monstruoDB.size() > 0) {

			return monstruoDB;
		}

		// No he obtenido nada devuelvo una lista vacía (para no devolver nulo)
		return new ArrayList<Monstruo>();
	}

}
