package pe.edu.upeu.exa3backenddiegoalor.security;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import pe.edu.upeu.exa3backenddiegoalor.dao.AccesoDao;
import pe.edu.upeu.exa3backenddiegoalor.dao.PersonaDao;
import pe.edu.upeu.exa3backenddiegoalor.dao.UsuarioDao;
import pe.edu.upeu.exa3backenddiegoalor.entity.Persona;
import pe.edu.upeu.exa3backenddiegoalor.entity.Usuario;

@Component
public class InfoAdicionalToken implements TokenEnhancer{

	@Autowired
	private UsuarioDao usuarioDao;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        Map<String, Object> info1 = new HashMap<>();
        Map<String, Object> info2 = new HashMap<>();
        //info2=opcionesDao.listarOpciones(idr);
        info1 = usuarioDao.datosUsuario(authentication.getName());
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info1);

        return accessToken;
	}
}
