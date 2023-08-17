package com.example.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Usuario;

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
