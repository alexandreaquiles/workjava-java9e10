package br.com.alexandreaquiles.imc.domain;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.ZoneId;

import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;

public class PacienteTest {

	private Paciente paciente;
	
	@Before
	public void antes() {
		ZoneId fusoHorarioSP = ZoneId.of("America/Sao_Paulo");
		Instant instant = MonthDay.of(Month.APRIL, 8).atYear(2018).atStartOfDay().atZone(fusoHorarioSP).toInstant();
		Clock clock = Clock.fixed(instant, fusoHorarioSP);
		
		LocalDate dataNascimento = LocalDate.of(1981, 6, 26);
		
		paciente = new Paciente(1L, "Alexandre", dataNascimento, clock);
	}
	
	
	@Test
	public void idade() {
		Assert.assertEquals(36, paciente.getIdade());
	}

}
