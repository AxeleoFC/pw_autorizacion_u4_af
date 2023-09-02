package com.example.demo.service.To;

import java.io.Serializable;

public class UsuarioTo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String password;
	private String semilla;
	private Integer expiracion;
	
	//Set y Get
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSemilla() {
		return semilla;
	}
	public void setSemilla(String semilla) {
		this.semilla = semilla;
	}
	public Integer getExpiracion() {
		return expiracion;
	}
	public void setExpiracion(Integer expiracion) {
		this.expiracion = expiracion;
	}
	
	

}
