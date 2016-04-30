package br.com.vraptor.horas.modelos;

import org.junit.Assert;
import org.junit.Test;

import br.com.vraptor.horas.modelos.HoraLancada;

public class HoraLancadaTest {

	@Test
	public void calculaDuracaoQuandoHoraInicialMenorHoraFinal(){
		
		//hora de inicio for menor que a hora final
		
		HoraLancada hora = new HoraLancada();
		hora.setHoraFinal("19:00");
		hora.setHoraInicial("09:00");
		
		//terceiro argumento para arredondamento
		Assert.assertEquals(10.0, hora.getDuracao(), 0.01);
		
	}
	
}
