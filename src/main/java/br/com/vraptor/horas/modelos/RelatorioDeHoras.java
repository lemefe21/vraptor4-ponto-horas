package br.com.vraptor.horas.modelos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class RelatorioDeHoras {

	private List<HorasPorDia>horasPorDia = new ArrayList<>();
	
	public List<HorasPorDia> getHorasPorDia() {
		return horasPorDia;
	}

	public RelatorioDeHoras(List<HoraLancada> horas) {
	
		//depois dos testes prontos, fazemos a implementação
		calculaHorasPorDia(horas);
	
	}

	private void calculaHorasPorDia(List<HoraLancada> horas) {

		if(!horas.isEmpty()){
			
			double horasDoDia = 0.0;
			Calendar dataAtual = horas.get(0).getData();
			
			for (HoraLancada hora : horas) {
				
				//quando as horas lancadas possuem datas diferentes
				if(!hora.getData().equals(dataAtual)){
					
					//se a data da hora lançada for diferente é realizado o calculo
					//e atualizada a dataAtual para passar a calcular as horas do proximo dia
					calculaHorasDia(horasDoDia, dataAtual);
					dataAtual = hora.getData();
					horasDoDia = 0.0;
					
				}
				
				horasDoDia += hora.getDuracao();
			}
			
			calculaHorasDia(horasDoDia, dataAtual);
		}
		
	}

	private void calculaHorasDia(double horasDoDia, Calendar dataAtual) {
		
		//se horasDoDia for menor que 8 é utilizado o valor da variavel horasDoDia se não 8
		//mais do que 8 entra como hora extra
		double horasNormais = Math.min(8.0, horasDoDia);
		
		//se (horasDoDia - 8) for maior do que 0, significa que foi feita horas extrar no dia
		//com isso é utilizado o valor do calculo, se não 0
		double horasExtras = Math.max(horasDoDia - 8, 0);
		
		HorasPorDia horasPorDia = new HorasPorDia(horasNormais, horasExtras, dataAtual);

		this.horasPorDia.add(horasPorDia);
		
	}

}
