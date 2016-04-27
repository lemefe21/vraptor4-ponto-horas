package br.com.vraptor.horas.seguranca;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.vraptor.horas.modelos.Usuario;

@Named //para acessar o usuario logado na camada de View
@SessionScoped
public class UsuarioLogado implements Serializable{

	private static final long serialVersionUID = 680715086618903149L;
	
	private Usuario usuario;
	
	public void realizaLogin(Usuario usuario){
		this.usuario = usuario;
	}
	
	public void desloga(){
		this.usuario = null;
	}
	
	public boolean isLogado(){
		return this.usuario != null;
	}

}
