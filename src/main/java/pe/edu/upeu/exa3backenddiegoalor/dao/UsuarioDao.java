package pe.edu.upeu.exa3backenddiegoalor.dao;

import java.util.Map;

import pe.edu.upeu.exa3backenddiegoalor.entity.Usuario;

public interface UsuarioDao {

	Usuario validarUsuario(String nomuser);
	Map<String, Object> datosUsuario(String username);
	
}
