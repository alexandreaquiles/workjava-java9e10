package br.com.alexandreaquiles.imc.desktop.controllers;

import java.io.File;
import java.util.List;

import br.com.alexandreaquiles.imc.application.CalculadoraEstatisticasPacientes;
import br.com.alexandreaquiles.imc.application.ListagemPacientes;
import br.com.alexandreaquiles.imc.desktop.model.ObservablePaciente;
import br.com.alexandreaquiles.imc.domain.CategoriaImc;
import br.com.alexandreaquiles.imc.domain.Paciente;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class TelaPrincipalController {

	private FileChooser fileChooser;

	@FXML
	private Stage stage;
	
	@FXML
	private TableView<ObservablePaciente> tabelaPacientes;

	@FXML
	private VBox painelEstatisticas;
	
	@FXML
	private BarChart<String,Long> graficoImc;
	
	@FXML
	private Text minimo;

	@FXML
	private Text maximo;
	
	@FXML
	private Text media;

	public TelaPrincipalController() {
		fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("XML", "*.xml"));
	}
	
	@FXML
	public void carregaArquivo() {
    	File arquivoXml = fileChooser.showOpenDialog(stage);
    	if (arquivoXml != null) {
    		ListagemPacientes listagemPacientes = new ListagemPacientes();
    		List<Paciente> pacientes = listagemPacientes.lista(arquivoXml);
    		tabelaPacientes.setItems(ObservablePaciente.toObservableList(pacientes));
    		
    		CalculadoraEstatisticasPacientes calculadora = new CalculadoraEstatisticasPacientes();
    		calculadora.calculaEstatisticas(pacientes);
    		minimo.setText(String.format("%.2f", calculadora.getMinimo()));
    		maximo.setText(String.format("%.2f", calculadora.getMaximo()));
    		media.setText(String.format("%.2f", calculadora.getMedia()));
    		
    		XYChart.Series<String, Long> series = new XYChart.Series<>();
    		series.setName("Pacientes");
    		for (CategoriaImc categoria : CategoriaImc.values()) {
    			series.getData().add(new XYChart.Data<>(categoria.getDescricao(), calculadora.getContagemPara(categoria)));
			}
    		
    		graficoImc.getData().add(series);
    		
    		painelEstatisticas.setVisible(true);
    	}

	}

}
