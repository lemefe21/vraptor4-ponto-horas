package br.com.vraptor.horas.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.vraptor.horas.modelos.Usuario;

@RequestScoped
public class UsuarioDAO {
	
	private EntityManager manager;

	@Inject
	public UsuarioDAO(EntityManager manager){
		//injetado pelo CDI atraves do Producer
		this.manager = manager;
	}
	
	public UsuarioDAO(){
		this(null);
	}
	
	public void adiciona(Usuario usuario){
		
		manager.getTransaction().begin();
		manager.persist(usuario);
		manager.getTransaction().commit();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario>lista(){
		
		return manager.createQuery("select u from Usuario u").getResultList();
		
	}

}
