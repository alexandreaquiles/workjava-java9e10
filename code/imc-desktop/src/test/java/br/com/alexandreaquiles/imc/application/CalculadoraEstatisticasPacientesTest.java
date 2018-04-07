package br.com.alexandreaquiles.imc.application;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.alexandreaquiles.imc.domain.CategoriaImc;
import br.com.alexandreaquiles.imc.domain.Medicao;
import br.com.alexandreaquiles.imc.domain.Paciente;

public class CalculadoraEstatisticasPacientesTest {

	private List<Paciente> pacientes;
	private CalculadoraEstatisticasPacientes calculadora;

	@Before
	public void antes() {
		Paciente paciente1 = new Paciente(1L, "Júlia", LocalDate.of(1997, 1, 21));
		Medicao medicao1 = new Medicao(1L, 50.0, 1.80, LocalDate.of(2018, 3, 23), paciente1);
		paciente1.setMedicao(medicao1);
		
		Paciente paciente2 = new Paciente(2L, "Gabriel", LocalDate.of(1994, 2, 24));
		Medicao medicao2 = new Medicao(2L, 80.0, 1.80, LocalDate.of(2018, 3, 23), paciente2);
		paciente2.setMedicao(medicao2);
		
		Paciente paciente3 = new Paciente(3L, "Davi", LocalDate.of(1997, 3, 21));
		Medicao medicao3 = new Medicao(3L, 100.0, 1.80, LocalDate.of(2018, 3, 23), paciente3);
		paciente3.setMedicao(medicao3);
		
		pacientes = Arrays.asList(paciente1, paciente2, paciente3);
		
		calculadora = new CalculadoraEstatisticasPacientes();
	}
	
	@Test
	public void estatisticasBasicas() {
		calculadora.calculaEstatisticas(pacientes);
		assertEquals(3, calculadora.getContagem().longValue());
		assertEquals(30.864, calculadora.getMaximo(), 0.001);
		assertEquals(15.432, calculadora.getMinimo(), 0.001);
		assertEquals(23.662, calculadora.getMedia(), 0.001);
	}

	@Test
	public void histograma() {
		calculadora.calculaEstatisticas(pacientes);

		assertEquals(1, calculadora.getContagemPara(CategoriaImc.MAGREZA_GRAVE).longValue());
		
		assertEquals(0, calculadora.getContagemPara(CategoriaImc.MAGREZA_MODERADA).longValue());
		
		assertEquals(0, calculadora.getContagemPara(CategoriaImc.MAGREZA_LEVE).longValue());

		assertEquals(1, calculadora.getContagemPara(CategoriaImc.SAUDAVEL).longValue());

		assertEquals(0, calculadora.getContagemPara(CategoriaImc.SOBREPESO).longValue());

		assertEquals(1, calculadora.getContagemPara(CategoriaImc.OBESIDADE).longValue());
		
		assertEquals(0, calculadora.getContagemPara(CategoriaImc.OBESIDADE_SEVERA).longValue());
		
		assertEquals(0, calculadora.getContagemPara(CategoriaImc.OBESIDADE_MORBIDA).longValue());
	}

}
