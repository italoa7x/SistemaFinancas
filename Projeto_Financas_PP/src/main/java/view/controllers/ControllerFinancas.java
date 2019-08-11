package view.controllers;

import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class ControllerFinancas implements Initializable{

	private CategoryAxis linhaX = new CategoryAxis();
	private NumberAxis linhaY = new NumberAxis();
	
    @FXML
    private Pane pnlInvestimentos;

    @FXML
    private Label lbBalanco;

    @FXML
    private Label lbRetorno;

    @FXML
    private Label lbLucro;

    @FXML
    private Label lbInvestido;

    @FXML
    private Label lbPendentes;

    @FXML
    private Label lbPercas;

    @FXML
    private BarChart<String, Number> grFinancas = new BarChart<>(linhaX,linhaY);

    
 

   
    
    
    private void carregarGeral() {
    	//falta a fachada
		lbBalanco.setText(null);
		lbInvestido.setText(null);
		lbLucro.setText(null);
		lbPendentes.setText(null);
		lbPercas.setText(null);
		lbRetorno.setText(null);
		
		
    }
    
   
    
    
    
    private void carregarGrafico() {
    	XYChart.Series<String, Number> series = new XYChart.Series<>();
    	//faltaFachada
    	XYChart.Data <String, Number> balanco = new XYChart.Data<>();

    	XYChart.Data <String, Number> retorno = new XYChart.Data<>();
    	
    	XYChart.Data <String, Number> lucro = new XYChart.Data<>();
    
    	XYChart.Data <String, Number> investido = new XYChart.Data<>();
    	
    	XYChart.Data <String, Number> pendentes = new XYChart.Data<>();
    	
    	XYChart.Data <String, Number> percas = new XYChart.Data<>();
    	series.getData().add(percas);
    	series.getData().add(balanco);
    	series.getData().add(retorno);
    	series.getData().add(lucro);
    	series.getData().add(investido);
    	series.getData().add(pendentes);
    	//balanco.getData().add("Balanço",fachada.getBalanco);
    	//retorno.getData().add("Retorno",fachada.getRetorno);
    	//lucro.getData().add("Lucro",fachada.getLucro);
    	//investido.getData().add("Investido",fachada.getInvestido);
    	//pendentes.getData().add("Balanço",fachada.getBalanco);
    	grFinancas.getData().add(series);
    	
    }
    
    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		carregarGrafico();
		
	}

}
