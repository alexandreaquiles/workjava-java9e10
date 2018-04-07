package br.com.alexandreaquiles.imc.application;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.alexandreaquiles.imc.domain.CategoriaImc;
import br.com.alexandreaquiles.imc.domain.Paciente;

public class CalculadoraEstatisticasPacientes {
	
	private Map<CategoriaImc, Long> histograma;
	private DoubleSummaryStatistics estatisticasBasicas;

	public void calculaEstatisticas(List<Paciente> pacientes) {
		calculaEstatisticasBasicas(pacientes);
		calculaHistograma(pacientes);
	}

	private void calculaHistograma(List<Paciente> pacientes) {
		histograma = pacientes.stream()
				.map(p -> p.getMedicao().getImc())
				.collect(Collectors.groupingBy(CategoriaImc::categoriza, Collectors.counting()));
	}

	private void calculaEstatisticasBasicas(List<Paciente> pacientes) {
		estatisticasBasicas = pacientes.stream()
				.collect(Collectors.summarizingDouble(p -> p.getMedicao().getImc()));
	}
	
	public Long getContagem() {
		return estatisticasBasicas.getCount();
	}

	public Double getMedia() {
		return estatisticasBasicas.getAverage();
	}

	public Double getMaximo() {
		return estatisticasBasicas.getMax();
	}

	public Double getMinimo() {
		return estatisticasBasicas.getMin();
	}
	
	public Long getContagemPara(CategoriaImc categoria) {
		Long contagem = histograma.get(categoria);
		return contagem != null? contagem : 0;
	}

}
