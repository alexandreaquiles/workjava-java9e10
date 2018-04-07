package br.com.alexandreaquiles.imc.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.alexandreaquiles.imc.domain.Paciente;

@XmlRootElement
@XmlAccessorType (XmlAccessType.FIELD)
public class Pacientes {

	@XmlElement(name = "paciente")
	private List<Paciente> pacientes;

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

}
