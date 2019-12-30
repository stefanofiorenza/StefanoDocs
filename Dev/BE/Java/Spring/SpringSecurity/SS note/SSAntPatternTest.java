package com.sportradar.tci.test.security;

import javax.servlet.http.HttpServletRequest;

import org.mockito.Mockito;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public class SSAntPatternTest {

	public static void main(String[] args) {
		
		// what exceed servlet mapping uri: http;//host:port/uri-mapping/..
		String servletPath="/uri-mapping"; //what matches dispatcher servlet
		String uriToTest="/controllers/action.htm?param1=a@param2=b";
		String pattern="/uri-mapping/controllers/*";		
		
		boolean matches=testSSPatterns(servletPath,uriToTest,pattern);
		System.out.println(matches);
		
	}
	
	private static boolean testSSPatterns(String uri,String controllerPath,String antPattern){
		
		HttpServletRequest httpRequest=Mockito.mock(HttpServletRequest.class);
		Mockito.when(httpRequest.getServletPath()).thenReturn(uri);	
		Mockito.when(httpRequest.getPathInfo()).thenReturn(controllerPath);		
		
		AntPathRequestMatcher patternMatcher=new AntPathRequestMatcher(antPattern);
		return patternMatcher.matches(httpRequest);
	}

}
