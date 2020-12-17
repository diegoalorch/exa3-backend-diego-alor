package pe.edu.upeu.exa3backenddiegoalor.daoImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Repository;

import pe.edu.upeu.exa3backenddiegoalor.dao.PersonaDao;
import pe.edu.upeu.exa3backenddiegoalor.entity.Persona;

@Repository
public class PersonaDaoImpl implements PersonaDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int create(Persona p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Persona p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Persona> readHola(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GrantedAuthority> buscarRolUser(int iduser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void convertitMap(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
	}
}