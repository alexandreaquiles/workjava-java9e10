package br.com.alexandreaquiles.imc.application;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

import br.com.alexandreaquiles.imc.domain.Paciente;
import br.com.alexandreaquiles.imc.xml.LeitorXml;

public class ListagemPacientes {
	
	private LeitorXml leitorXml;

	public ListagemPacientes() {
		this.leitorXml = new LeitorXml();
		
	}

	public List<Paciente> lista(File arquivoXml) {
		return lista(arquivoXml.toPath());
	}
	
	public List<Paciente> lista(Path arquivoXml) {
		return leitorXml.le(arquivoXml);
	}

}
