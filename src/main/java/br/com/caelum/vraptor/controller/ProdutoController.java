package br.com.caelum.vraptor.controller;

import org.jboss.logging.Logger;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;

@Controller
public class ProdutoController {
	
	final static Logger logger = Logger.getLogger(ProdutoController.class.getName());
	
	@Get
	public void formulario(){
	}
	
	@Post
	public void adiciona(String nome) {
		
		logger.info("Olá VRaptor with Logger!");
		System.out.println("Nome produto: " + nome);
		
	}

}
