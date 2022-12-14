package id.belajar.transportationreservationsystemfix.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import id.belajar.transportationreservationsystemfix.service.JwtUserDetailsService;
import io.jsonwebtoken.ExpiredJwtException;

@Component


public class JwtRequestFilter  extends OncePerRequestFilter{

	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;
	
	private final JwtToken jwtTokenUntil;
	
	
	public JwtRequestFilter(JwtToken jwtTokenUntil) {
		this.jwtTokenUntil = jwtTokenUntil;
	}


	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		final String requestTokenHeader = request.getHeader("Authorization");
		String username = null;
		String jwtToken = null;
		
		if(requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			 jwtToken = requestTokenHeader.substring(7);
			 
			 try {
				   username = jwtTokenUntil.getUsernameFromToken(jwtToken);
			} catch (IllegalArgumentException e) {
				// TODO: handle exception
				 System.out.println("Unable to get JWT Token");
			
			} catch (ExpiredJwtException e) {
				// TODO: handle exception
				 System.out.println("JWT Token has expired");
			}
			 
		}
		else if(requestTokenHeader == null) {
			
			logger.info("does not provide Authorization Header ");

		}else if(!requestTokenHeader.startsWith("Bearer ")) {
			logger.warn("jWT Token does not begin with Bearer");
		}
		
		if(username != null && SecurityContextHolder.getContext().getAuthentication()== null) {
			
			UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(username);
			
			if(jwtTokenUntil.validateToken(jwtToken, userDetails)){
				
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				
				userDetails,null, userDetails.getAuthorities());
				
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
			
		}
		filterChain.doFilter(request, response);
		
		
	}
	
	
	
}
