package br.com.vraptor.horas.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.vraptor.horas.modelos.Usuario;

@RequestScoped
public class UsuarioDAO {
	
	private EntityManager manager;

	@Inject
	public UsuarioDAO(EntityManager manager){
		//injetado pelo CDI atraves do producer EntityManagerProducer
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

	public Usuario busca(String login, String senha) {
		
		TypedQuery<Usuario> query = manager.createQuery("select u from Usuario u "
				+ "where u.login = :login and u.senha = :senha", Usuario.class);
		
		query.setParameter("login", login);
		query.setParameter("senha", senha);
		
		try{
			return query.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
		
	}

}
