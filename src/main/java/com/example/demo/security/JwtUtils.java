package com.example.demo.security;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {
	
	private static final Logger LOG=LoggerFactory.getLogger(JwtUtils.class);
	
	@Value("${app.jw.secret}")
	private String jwSecret;
	
	@Value("${app.jw.expiration.ms}")
	private Integer jwExpiration;
	
	public String generarJwtToken(String nombre, String semilla, Integer expiracion) {
		//Lo mas comun es que estos datos esten en un archivo properties o en una BD
		LOG.info("Semilla: "+jwSecret+" /Tiempo: "+jwExpiration);
		return Jwts.builder()
				.setSubject(nombre)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis()+expiracion))
				.signWith(SignatureAlgorithm.HS512, semilla)
				.compact();
	}

}
