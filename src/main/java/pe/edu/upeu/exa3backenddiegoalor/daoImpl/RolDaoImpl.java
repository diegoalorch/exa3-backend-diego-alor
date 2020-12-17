package pe.edu.upeu.exa3backenddiegoalor.daoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import oracle.jdbc.OracleTypes;
import pe.edu.upeu.exa3backenddiegoalor.dao.RolDao;
import pe.edu.upeu.exa3backenddiegoalor.entity.Rol;

@Component
public class RolDaoImpl implements RolDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	
	Gson gson =new Gson();
	
	@Override
	public int create(Rol r) {
		// TODO Auto-generated method stub
		return  jdbcTemplate.update("call PKG_ROLES.SP_INS_ROLES(?)", r.getNombre());
	}

	@Override
	public int update(Rol r) {
		// TODO Auto-generated method stub
		return  jdbcTemplate.update("call PKG_ROLES.SP_UPD_ROLES(?,?)", r.getIdrol(),r.getNombre());
	}

	@Override
	public int update(int id) {
		// TODO Auto-generated method stub
		return  jdbcTemplate.update("call PKG_ROLES.sp_delete_logica_rol(?)", id);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_ROLES.SP_DEL_ROLES(?)", id);
	}

	@Override
	public List<Rol> readHola(int id) {
		/*String SQL = "SELECT r.idrol, r.nombre FROM usuarios u " + 
				"INNER JOIN usuarios_roles ur ON u.idusuario=ur.idusuario " + 
				"INNER JOIN roles r ON r.idrol=ur.idrol " + 
				"WHERE u.idusuario = ?";
	String a= "select *from roles where idrol=? ";
		return  jdbcTemplate.query(a, new Object[]{id}, new BeanPropertyRowMapper<Roles>(Roles.class));*/
		return null;
	}
	

	@Override
	public List<Map<String, Object>> read(int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForList("SELECT *FROM roles");	
	}

	@Override
	public List<Map<String, Object>> readAll() {
		List<Map<String,Object>> lista = new ArrayList<>();
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("PKG_ROLES") //nombre del paquete
				.withProcedureName("SP_LIS_ROLES") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("CUR_ROLES", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()));	
				Map<String, Object> map = simpleJdbcCall.execute();
				lista.add(map);
		return lista;
	}

	@Override
	public void convertitMap(Map<String, Object> map) {
		Gson rr = new Gson();
		Object lista =rr.toJson(map.get("CUR_ROLES"));
		System.out.println(lista.toString());

	}
	@Override
	public List<GrantedAuthority> buscarRolUser(int iduser) {

		List<GrantedAuthority> autores = new ArrayList<GrantedAuthority>();
		/*simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("PKG_ROLES")
				.withProcedureName("SP_LIS_ROLES")
				.declareParameters(
						new SqlOutParameter("CUR_ROLES", OracleTypes.REF_CURSOR, new BeanPropertyRowMapper<Roles>(Roles.class))
						,new SqlParameter("VAR_IDUSUARIO", Types.INTEGER));
		SqlParameterSource in = new MapSqlParameterSource().addValue("VAR_IDUSUARIO", iduser);
		List<Roles> roles = (List<Roles>) simpleJdbcCall.execute(in);
		*/
		String SQL = "SELECT r.idrol, r.nombre FROM usuarios u " + 
				"INNER JOIN usuarios_roles ur ON u.idusuario=ur.idusuario " + 
				"INNER JOIN roles r ON r.idrol=ur.idrol " + 
				"WHERE u.idusuario = ?";
		
		List<Rol> roles = jdbcTemplate.query(SQL, new Object[]{iduser}, new BeanPropertyRowMapper<Rol>(Rol.class));
				//jdbcTemplate.(SQL, new Object[]{iduser}, new BeanPropertyRowMapper<Roles>(Roles.class));
		
		for(int i=0;i<roles.size();i++) {		
			autores.add(new SimpleGrantedAuthority(roles.get(i).getNombre()));
		}
		return autores;
	}	
}
