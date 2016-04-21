package br.com.vraptor.horas.controller;

import javax.inject.Inject;

import org.jboss.logging.Logger;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

@Controller
public class IndexController {

	private final Result result;
	final static Logger logger = Logger.getLogger(IndexController.class);

	/**
	 * @deprecated CDI eyes only
	 */
	protected IndexController() {
		this(null);
	}
	
	@Inject
	public IndexController(Result result) {
		this.result = result;
	}

	@Path("/")
	public void index() {
		System.out.println("Olá VRaptor!");
		logger.info("Olá VRaptor with Logger!");
		result.include("variable", "VRaptor!");
	}
}