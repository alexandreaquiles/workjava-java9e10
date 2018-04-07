package br.com.alexandreaquiles.imc.xml;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import br.com.alexandreaquiles.imc.domain.Paciente;

public class LeitorXml {

	public List<Paciente> le(Path arquivoXml) {
		try (InputStream xmlIs = Files.newInputStream(arquivoXml)) {
			JAXBContext ctx = JAXBContext.newInstance(Pacientes.class);
			Unmarshaller unmarshaller = ctx.createUnmarshaller();
			Pacientes pacientes = (Pacientes) unmarshaller.unmarshal(xmlIs);
			return pacientes.getPacientes();
		} catch (IOException e) {
			throw new RuntimeException("Erro ao abri arquivo XML " + arquivoXml, e);
		} catch (JAXBException e) {
			throw new RuntimeException("Erro ao ler XML!", e);
		}
	}

}
