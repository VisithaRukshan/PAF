package com.fantasticfour.healthcare.healthCareApiProject;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.StringTokenizer;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class SecurityFilter implements ContainerRequestFilter{

	private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";
	private static final String SECURED_URL_PREFIX = "doctors";
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		if(requestContext.getUriInfo().getPath().contains(SECURED_URL_PREFIX)) {
			List<String> authHeader = requestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);
			
			if(authHeader != null && authHeader.size() > 0) {
				
				String authToken = authHeader.get(0);
				authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
				byte[] decodedBytes  = Base64.getDecoder().decode(authToken);
				String decodeString = new String(decodedBytes);
				
				StringTokenizer tokenizer = new StringTokenizer(decodeString, ":");
				
				String username = tokenizer.nextToken();
				String password = tokenizer.nextToken();
			
				if("admindoc".equals(username) && "admindoc123".equals(password)) {
					return;
				}
			
			}
		
			Response unauthorizedStatus = Response.
											status(Response.Status.UNAUTHORIZED).
											entity("User cannot access ! Enter username & password.").
											build();
			
			requestContext.abortWith(unauthorizedStatus);
		}
		
	}

	
}
