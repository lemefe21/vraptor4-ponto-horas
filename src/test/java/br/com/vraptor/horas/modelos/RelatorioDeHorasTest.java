package br.com.vraptor.horas.modelos;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class RelatorioDeHorasTest {
	
	@Test
	public void calculaRelatorioQuandoDataSaoIguais(){
		
		//mesmo dia
		Calendar data = new GregorianCalendar(2016, 1, 22);
		HoraLancada hora1 = novaHoraLancada("10:00", "18:00", data);
		HoraLancada hora2 = novaHoraLancada("18:00", "20:00", data);
		
		RelatorioDeHoras relatorio = new RelatorioDeHoras(Arrays.asList(hora1, hora2));
		List<HorasPorDia> horasPorDia = relatorio.getHorasPorDia();
		
		//datas iguais
		Assert.assertEquals(1, horasPorDia.size());
		
		HorasPorDia horasDoDia = horasPorDia.get(0);
		Assert.assertEquals(8.0, horasDoDia.getHorasNormais(), 0.01);
		Assert.assertEquals(2.0, horasDoDia.getHorasExtras(), 0.01);
		
	}
	
	@Test
	public void calculaRelatorioQuandoDataSaoDiferentes(){
		
		//dias diferentes
		Calendar data1 = new GregorianCalendar(2016, 1, 21);
		Calendar data2 = new GregorianCalendar(2016, 1, 22);
		HoraLancada hora1 = novaHoraLancada("10:00", "18:00", data1);
		HoraLancada hora2 = novaHoraLancada("10:00", "20:00", data2);
		
		RelatorioDeHoras relatorio = new RelatorioDeHoras(Arrays.asList(hora1, hora2));
		List<HorasPorDia> horasPorDia = relatorio.getHorasPorDia();
		
		//datas diferentes
		Assert.assertEquals(2, horasPorDia.size());
		
		HorasPorDia horasDoDia1 = horasPorDia.get(0);
		Assert.assertEquals(8.0, horasDoDia1.getHorasNormais(), 0.01);
		Assert.assertEquals(0, horasDoDia1.getHorasExtras(), 0.01);
		
		HorasPorDia horasDoDia2 = horasPorDia.get(1);
		Assert.assertEquals(8.0, horasDoDia2.getHorasNormais(), 0.01);
		Assert.assertEquals(2.0, horasDoDia2.getHorasExtras(), 0.01);
		
	}

	private HoraLancada novaHoraLancada(String horaInicial, String horaFinal, Calendar data) {
		
		HoraLancada hora = new HoraLancada();
		hora.setHoraInicial(horaInicial);
		hora.setHoraFinal(horaFinal);
		hora.setData(data);
		return hora;
		
	}

}
