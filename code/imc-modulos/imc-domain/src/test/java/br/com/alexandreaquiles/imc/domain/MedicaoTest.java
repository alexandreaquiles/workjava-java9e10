package br.com.alexandreaquiles.imc.domain;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class MedicaoTest {

	private Medicao medicao;

	@Before
	public void antes() {
		Paciente paciente = new Paciente();
		medicao = new Medicao(1L, 80.5, 1.83, LocalDate.of(2018, 3, 25), paciente);
	}
	
	@Test
	public void calculoImc() {
		assertEquals(24.037, medicao.getImc(), 0.001);
	}

}
