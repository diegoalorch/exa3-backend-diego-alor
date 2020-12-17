package pe.edu.upeu.exa3backenddiegoalor.service;

import java.util.Map;

import pe.edu.upeu.exa3backenddiegoalor.entity.Usuario;

public interface UsuarioService {

	Usuario validarUsuario(String nomuser);
	Map<String, Object> datosUsuario(String username);
	
}
