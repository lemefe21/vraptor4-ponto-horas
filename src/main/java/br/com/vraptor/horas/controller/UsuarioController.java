package br.com.vraptor.horas.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.Validator;
import br.com.vraptor.horas.dao.UsuarioDAO;
import br.com.vraptor.horas.modelos.Usuario;

@Controller
public class UsuarioController {
	
	private UsuarioDAO dao;
	private Result result;
	private Validator validator;

	@Inject
	public UsuarioController(UsuarioDAO dao, Result result, Validator validator){
		this.dao = dao;
		this.result = result;
		this.validator = validator;
	}
	
	public UsuarioController(){
	}
	
	public void form(){
	}
	
	@IncludeParameters
	@Post
	public void adiciona(@Valid Usuario usuario){
		
		validator.onErrorRedirectTo(this).form();
		
		dao.adiciona(usuario);
		result.redirectTo(this).lista();
		
	}
	
	public void lista(){
		
		List<Usuario> usuarios = dao.lista();
		
		result.include("usuarios", usuarios);
		
	}

}
