package fr.formation.internalevents.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

public class CustomTokenEnhancer implements TokenEnhancer {

	final static String USER_ID_KEY = "userId";

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

		// Store user id in access token as additional info
		Map<String, Object> additionalInfo = new HashMap<>();

		EmployeeDetails user = (EmployeeDetails) authentication.getPrincipal();
		additionalInfo.put(USER_ID_KEY, user.getId());
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
		return accessToken;
	}
}
