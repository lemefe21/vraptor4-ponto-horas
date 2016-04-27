package br.com.vraptor.horas.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.vraptor.horas.dao.UsuarioDAO;
import br.com.vraptor.horas.modelos.Usuario;
import br.com.vraptor.horas.seguranca.Open;
import br.com.vraptor.horas.seguranca.UsuarioLogado;

@Controller
public class LoginController {
	
	private UsuarioDAO usuarioDao;
	private UsuarioLogado usuarioLogado;
	private Result result;
	private Validator validator;

	public LoginController() {
	}
	
	@Inject
	public LoginController(UsuarioDAO dao, UsuarioLogado usuarioLogado, 
			Result result, Validator validator){
		this.usuarioDao = dao;
		this.usuarioLogado = usuarioLogado;
		this.result = result;
		this.validator = validator;
	}
	
	@Open
	public void form(){
	}
	
	@Open
	public void login(String login, String senha){
		
		Usuario usuario = usuarioDao.busca(login, senha);
		
		//guardar o usuario na sessão
		if(usuario != null){
			usuarioLogado.realizaLogin(usuario);
			result.redirectTo(UsuarioController.class).lista();
		}else{
			validator.add(new SimpleMessage("login_invalido", "Login ou senha inválida"));
			validator.onErrorRedirectTo(this).form();
		}
		
	}
	
	@Open
	public void deslogaUsuario(){
		usuarioLogado.desloga();
		result.redirectTo(this).form();
	}

}
