package br.com.alexandreaquiles.imc.xml;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.alexandreaquiles.imc.domain.Medicao;
import br.com.alexandreaquiles.imc.domain.Paciente;
import br.com.alexandreaquiles.imc.xml.LeitorXml;

public class LeitorXmlTest {

	private LeitorXml leitorXml;
	private Path arquivoXml;

	@Before
	public void antes() throws URISyntaxException {
		URL xmlURL = LeitorXmlTest.class.getResource("/pacientes.xml");
		arquivoXml = Paths.get(xmlURL.toURI());
		leitorXml = new LeitorXml();
	}
	
	@Test
	public void leXML() {
		
		List<Paciente> pacientes = leitorXml.le(arquivoXml);

		Assert.assertNotNull(pacientes);
		Assert.assertEquals(1, pacientes.size());
		
		Paciente paciente = pacientes.get(0);
		
		Assert.assertEquals("Alexandre", paciente.getNome());
		Assert.assertEquals(LocalDate.of(1981, 6, 26), paciente.getDataNascimento());
		Assert.assertNotNull(paciente.getIdade());
		
		Medicao medicao = paciente.getMedicao();
		Assert.assertEquals(1.83, medicao.getAlturaEmMetros(), 0.001);
		Assert.assertEquals(80.5, medicao.getPesoEmKg(), 0.001);
		Assert.assertEquals(LocalDate.of(2018, 3, 25), medicao.getDataMedicao());

	}

}
