package org.iesalixar.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.iesalixar.model.Armadura;
import org.iesalixar.model.Arsenal;
import org.iesalixar.model.Usuario;
import org.iesalixar.repository.ArsenalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ArsenalServiceImpl implements ArsenalService {
	
	@Autowired
	ArsenalRepository arsenalRepo;

	@Override
	public List<Arsenal> getAllArsenal() {
		
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		String user = authentication.getName();
		
		//Long userId = user.getId();
		/*
		System.out.println("----------------------------------");
		System.out.println("----------------------------------");
		System.out.println("----------------------------------");
		System.out.println("----------------------------------");
		System.out.println("----------------------------------");
		System.out.println(user);
		System.out.println("----------------------------------");
		System.out.println("----------------------------------");
		System.out.println("----------------------------------");
		System.out.println("----------------------------------");
		System.out.println("----------------------------------");
		*/
		// Obtengo el resultado a través del repositorio
		List<Arsenal> arsenalDB = arsenalRepo.findAll();

		// Verificando que he obtenido algo
		if (arsenalDB != null && arsenalDB.size() > 0) {

			return arsenalDB;
		}

		// No he obtenido nada devuelvo una lista vacía (para no devolver nulo)
		return new ArrayList<Arsenal>();
	}

	@Override
	public List<Arsenal> getAllByIdUsuario(Usuario user) {
		
		List<Arsenal> arsenalDB = arsenalRepo.getAllByUsuario(user);
		
		if (arsenalDB != null && arsenalDB.size() > 0) {

			return arsenalDB;
		}
		
		return new ArrayList<Arsenal>();
	}

	@Override
	public Arsenal addArsenal(Usuario usuario, Armadura armadura) {
		
		List<Arsenal> arsenalCompleto = getAllArsenal();
		
		Arsenal arsenal = new Arsenal();
		
		arsenal.setUsuario(usuario);
		arsenal.setArmadura(armadura);
		
		
		if (arsenal != null && !arsenalCompleto.contains(arsenal)) {
			
			Arsenal arsenalMethod = arsenalRepo.save(arsenal);
			return arsenalMethod;
		}

		return null;
	}

	
}
