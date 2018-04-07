package br.com.alexandreaquiles.imc.desktop.model;

import java.util.ArrayList;
import java.util.List;

import br.com.alexandreaquiles.imc.domain.CategoriaImc;
import br.com.alexandreaquiles.imc.domain.Paciente;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ObservablePaciente {
	
	private LongProperty id;
	private StringProperty nome;
	private IntegerProperty idade;
	private StringProperty imc;
	private StringProperty categoriaImc;
	
	public ObservablePaciente(Paciente paciente) {
		this.id =  new SimpleLongProperty(paciente.getId());
		this.nome = new SimpleStringProperty(paciente.getNome());
		this.idade = new SimpleIntegerProperty(paciente.getIdade());
		this.imc = new SimpleStringProperty(String.format("%.2f", paciente.getMedicao().getImc()));
		this.categoriaImc = new SimpleStringProperty(CategoriaImc.categoriza(paciente.getMedicao().getImc()).getDescricao());
	}

	public Long getId() {
		return id.get();
	}

	public void setId(Long id) {
		this.id.set(id);
	}

	public LongProperty getIdProperty() {
		return id;
	}

	public String getNome() {
		return nome.get();
	}

	public void setNome(String nome) {
		this.nome.set(nome);
	}

	public StringProperty getNomeProperty() {
		return nome;
	}

	public Integer getIdade() {
		return idade.get();
	}

	public void setIdade(Integer idade) {
		this.idade.set(idade);;
	}
	
	public IntegerProperty getIdadeProperty() {
		return idade;
	}
	
	public String getImc() {
		return imc.get();
	}

	public void setImc(String imc) {
		this.imc.set(imc);
	}

	public StringProperty getImcProperty() {
		return imc;
	}

	public String getCategoriaImc() {
		return categoriaImc.get();
	}

	public void setCategoriaImc(StringProperty categoriaImc) {
		this.categoriaImc = categoriaImc;
	}

	public StringProperty getCategoriaImcProperty() {
		return categoriaImc;
	}

	public static ObservableList<ObservablePaciente> toObservableList(List<Paciente> pacientes) {
		List<ObservablePaciente> lista = new ArrayList<>();
		for (Paciente paciente : pacientes) {
			lista.add(new ObservablePaciente(paciente));
		}
		return FXCollections.observableList(lista);
	}
	
}