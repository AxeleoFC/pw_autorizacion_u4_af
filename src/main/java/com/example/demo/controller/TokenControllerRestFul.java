package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.security.JwtUtils;
import com.example.demo.service.To.UsuarioTo;

@RestController
@RequestMapping("/tokens")
@CrossOrigin
public class TokenControllerRestFul {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtUtils jwtUtils;
	
	//@GetMapping(path = "" ,produces = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping("/obtener")
	public String obtenerTokenPorUsuario(@RequestBody UsuarioTo usuario) {
		this.authentocated(usuario.getNombre(), usuario.getPassword());
		return this.jwtUtils.generarJwtToken(usuario.getNombre(),usuario.getSemilla(),usuario.getExpiracion());
	}
	
	private void authentocated(String usuario, String password) {
		Authentication authentication= this.authenticationManager
		.authenticate(new UsernamePasswordAuthenticationToken(usuario, password));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}
}
