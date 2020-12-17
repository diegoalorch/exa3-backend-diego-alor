package pe.edu.upeu.exa3backenddiegoalor.service;

import java.util.List;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;

import pe.edu.upeu.exa3backenddiegoalor.entity.Persona;

public interface PersonaService {

	int create(Persona p);
	int update(Persona p);
	int update(int id);
	int delete(int id);
	List<Persona> readHola(int id);
	List<Map<String, Object>> read(int id);
	List<Map<String, Object>> readAll();
	List<GrantedAuthority> buscarRolUser(int iduser);
	void convertitMap(Map<String, Object> map);
	
}
