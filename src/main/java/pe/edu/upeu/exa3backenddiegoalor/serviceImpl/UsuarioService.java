package pe.edu.upeu.exa3backenddiegoalor.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;

import pe.edu.upeu.exa3backenddiegoalor.dao.RolDao;
import pe.edu.upeu.exa3backenddiegoalor.dao.UsuarioDao;
import pe.edu.upeu.exa3backenddiegoalor.entity.Usuario;

@Service("userService")
public class UsuarioService implements UserDetailsService {

	Gson g = new Gson();
	
	@Autowired
	private UsuarioDao usuariosDao;
   @Autowired
	private RolDao rolesDao;
   
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {		
		Usuario usuarios = usuariosDao.validarUsuario(username);
		System.out.println(g.toJson(usuarios.getUsername()));
		//System.out.println(g.toJson(rolDao.buscarRolUser(usuario.getIdusuario())));
		UserDetails details = new User(usuarios.getUsername(),usuarios.getPassword(),rolesDao.buscarRolUser(usuarios.getIdusuario()));
		//System.out.println("hola: "+g.toJson(details));
		return details;
	}

}
