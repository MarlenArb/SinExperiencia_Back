package com.sinexperiencia.sinexperiencia.security.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.sinexperiencia.sinexperiencia.entities.UserEntity;
import com.sinexperiencia.sinexperiencia.exceptions.messages.DataErrorMessages;
import com.sinexperiencia.sinexperiencia.services.LoginService;

@SuppressWarnings("deprecation")
@Component
public class TokenAdditionalInfo implements TokenEnhancer {
	
	@Autowired
	private LoginService loginService;
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		UserEntity u = loginService.findByUsername(authentication.getName()).orElseThrow(() -> {
			throw new UsernameNotFoundException(DataErrorMessages.USER_NO_CONTENT);
		});
		
		Map<String, Object> info = new HashMap<>();
		
		info.put("name", u.getName());
//		info.put("img", u.getImg());
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		
		return accessToken;
		
	}

}
