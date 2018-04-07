package br.com.alexandreaquiles.imc.cli;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import br.com.alexandreaquiles.imc.application.CalculadoraEstatisticasPacientes;
import br.com.alexandreaquiles.imc.application.ListagemPacientes;
import br.com.alexandreaquiles.imc.domain.CategoriaImc;
import br.com.alexandreaquiles.imc.domain.Paciente;

public class CLI {
	
	public static void main(String[] args) {

		if (args.length != 1) {
			System.err.println("Uso: ");
			System.err.println("origem - nome do arquivo XML de origem");
			System.exit(1);
		}
		
		String caminhoXmlOrigem = args[0];
		if (caminhoXmlOrigem == null) {
			System.err.println("Por favor, indique o nome do arquivo XML de origem.");
			System.exit(1);
		}
		
		Path arquivoXmlOrigem = Paths.get(caminhoXmlOrigem);
		if(!Files.exists(arquivoXmlOrigem)) {
			System.err.println("O arquivo " + caminhoXmlOrigem + " não existe!");
			System.exit(1);
		}
		
		ListagemPacientes listagemPacientes = new ListagemPacientes();
		List<Paciente> pacientes = listagemPacientes.lista(arquivoXmlOrigem);
		
		CalculadoraEstatisticasPacientes calculadora = new CalculadoraEstatisticasPacientes();
		calculadora.calculaEstatisticas(pacientes);
		
		System.out.println("Estatísicas de Pacientes");
		System.out.println("------------------------");
		System.out.println("Mínimo: " + String.format("%.2f", calculadora.getMinimo()));
		System.out.println("Máximo: " + String.format("%.2f", calculadora.getMaximo()));
		System.out.println("Média: " + String.format("%.2f", calculadora.getMedia()));

		System.out.println("\nHistograma");
		System.out.println("----------");
		
		for (CategoriaImc categoriaImc : CategoriaImc.values()) {
			System.out.println(categoriaImc.getDescricao()+": "+calculadora.getContagemPara(categoriaImc));
		}
	}

}
