package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class UsuarioRepositoryimpl implements IUsuarioRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Usuario consultarPorNombre(String nombreUsuario) {
		// TODO Auto-generated method stub
		
		TypedQuery<Usuario> myQuery=this.entityManager
				.createQuery("SELECT u FROM Usuario u WHERE u.nombre=:datoNombre", Usuario.class);
		myQuery.setParameter("datoNombre", nombreUsuario);
		return myQuery.getSingleResult();
	}

}
