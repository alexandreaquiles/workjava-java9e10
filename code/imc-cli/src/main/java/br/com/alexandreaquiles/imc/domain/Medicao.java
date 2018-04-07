package br.com.alexandreaquiles.imc.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Medicao {

	private Long id;
	private Double pesoEmKg;
	private Double alturaEmMetros;

	private LocalDate dataMedicao;
	
	private Paciente paciente;

	public Medicao() {
	}

	public Medicao(Long id, Double pesoEmKg, Double alturaEmMetros, LocalDate dataMedicao, Paciente paciente) {
		this.id = id;
		this.pesoEmKg = pesoEmKg;
		this.alturaEmMetros = alturaEmMetros;
		this.dataMedicao = dataMedicao;
		this.paciente = paciente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(paciente, pesoEmKg, alturaEmMetros, dataMedicao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Medicao other = (Medicao) obj;
		return Objects.equals(paciente, other.paciente) && Objects.equals(pesoEmKg, other.pesoEmKg) 
				&& Objects.equals(alturaEmMetros, other.alturaEmMetros) && Objects.equals(dataMedicao, other.dataMedicao);
	}
	
	@Override
	public String toString() {
		return "Medicao [id=" + id + ", pesoEmKg=" + pesoEmKg + ", alturaEmMetros=" + alturaEmMetros + ", dataMedicao="
				+ dataMedicao + (paciente != null ? ", paciente=" + paciente.getNome() : "") + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPesoEmKg() {
		return pesoEmKg;
	}

	public void setPesoEmKg(Double pesoEmKg) {
		this.pesoEmKg = pesoEmKg;
	}

	public Double getAlturaEmMetros() {
		return alturaEmMetros;
	}

	public void setAlturaEmMetros(Double alturaEmMetros) {
		this.alturaEmMetros = alturaEmMetros;
	}
	
	public LocalDate getDataMedicao() {
		return dataMedicao;
	}

	public void setDataMedicao(LocalDate dataMedicao) {
		this.dataMedicao = dataMedicao;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Double getImc() {
		return pesoEmKg / (alturaEmMetros * alturaEmMetros);
	}

}
