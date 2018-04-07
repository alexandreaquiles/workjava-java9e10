package br.com.alexandreaquiles.imc.domain;

import java.time.Clock;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.FIELD)
public class Paciente {
	
	@XmlAttribute
	private Long id;
	private String nome;
	
	private LocalDate dataNascimento;
	
	@XmlTransient
	private Clock clock;
	
	private Medicao medicao;

	public Paciente() {
		this.clock = Clock.systemDefaultZone();
	}

	public Paciente(Long id, String nome, LocalDate dataNascimento) {
		this();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}

	public Paciente(Long id, String nome, LocalDate dataNascimento, Clock clock) {
		this(id, nome, dataNascimento);
		this.clock = clock;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, dataNascimento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Paciente other = (Paciente) obj;
		return Objects.equals(nome, other.nome) && Objects.equals(dataNascimento, other.dataNascimento);
	}
	
	@Override
	public String toString() {
		return "Paciente [id=" + id + ", nome=" + nome + ", dataNascimento=" + dataNascimento + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Medicao getMedicao() {
		return medicao;
	}

	public void setMedicao(Medicao medicao) {
		this.medicao = medicao;
	}

	public int getIdade() {
		return Period.between(dataNascimento, LocalDate.now(clock)).getYears();
	}

}
