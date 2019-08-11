package view.controllers;
import javafx.fxml.Initializable;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import control.ControlRequest;
import control.ControlerMoeda;
import control.ValorControl;
import dto.MoedaDTO;
import dto.ValorDTO;
import iterator.Iterator;
import iterator.IteratorMoeda;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.chart.LineChart;

import javafx.scene.chart.XYChart;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import model.requisicoes.ITrequeste;
import model.requisicoes.RequisicaoDolar;

public class ControllerConsultas implements Initializable{
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
	private ControlRequest con = new ControlRequest();
	
	private static ScheduledExecutorService scheduledExecutorService;
	private Double num = new Double(0);
	
	@FXML
    private Pane pnlInvestimentos;
	
	@FXML
    private Label lbValor;
	
	@FXML
    private Label lbValorH;

    @FXML
    private ComboBox<MoedaDTO> cbInvestimento;

    @FXML
    private Button btConsultar;

    @FXML
    private Button btParar;

    @FXML
    private LineChart<String, Number> grConsulta;

    @FXML
    private ComboBox<MoedaDTO> cbMoeda;

    @FXML
    private Button btHistorico;

    @FXML
    private LineChart<String, Number> grHistorico;

    @FXML
    void lsParar(ActionEvent event) {
    	scheduledExecutorService.shutdownNow();
    }
    
    @FXML
    void lsHistorico(ActionEvent event) {
    	ValorControl con = new ValorControl();
    	try {
    		XYChart.Series<String, Number> series = new XYChart.Series<>();
    		ValorDTO dto = con.listarValores(cbMoeda.getSelectionModel().getSelectedItem());
			SimpleDateFormat formatador = new SimpleDateFormat();
    		for(ValorDTO valor:dto.getValoresCadastrados()) {
				series.getData().add(new XYChart.Data<>(formatador.format(valor.getData()), valor.getValor()));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    @FXML
    void lsConsultar(ActionEvent event) {
    	int var = 10;
    	if(scheduledExecutorService!=null) {
    	scheduledExecutorService.shutdownNow();
    	}
    	final XYChart.Series<String, Number> series = new XYChart.Series<>();
    	series.setName("Valor");
    	grConsulta.getData().add(series);
    	
    	
    	// setup a scheduled executor to periodically put data into the chart
        
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

        // put dummy data onto graph per second
        scheduledExecutorService.scheduleAtFixedRate(() -> {
			try {
				num = con.recuperarValor(cbInvestimento.getSelectionModel().getSelectedItem()).getValor();
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            // Update the chart
            Platform.runLater(() -> {
                // get current time
            Date now = new Date();
                // put random number with current time
              series.getData().add(new XYChart.Data<>(simpleDateFormat.format(now), num));
              lbValor.setText(String.valueOf(num));
              if (series.getData().size() > var)
                  series.getData().remove(0);
            });
        }, 0, 1, TimeUnit.SECONDS);
    }
    
    public void carregarCb(){
    	ControlerMoeda controler= new ControlerMoeda();
		try {
			MoedaDTO m = controler.listar();
			ObservableList <MoedaDTO> registro = FXCollections.observableArrayList();
			Iterator it = new IteratorMoeda(m.getTodasMoedas());
			while(it.hasNext()) {
				registro.add((MoedaDTO) it.next());
			}
			cbInvestimento.setItems(registro);
			cbMoeda.setItems(registro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    
    public void carregarGrafico(MoedaDTO moeda) {
    	ValorControl controler = new ValorControl();
    	
    }
    
    
	public static ScheduledExecutorService getScheduledExecutorService() {
		return scheduledExecutorService;
	}

	public static void setScheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
		ControllerConsultas.scheduledExecutorService = scheduledExecutorService;
	}

	public void initialize(URL location, ResourceBundle resources) {
		carregarCb();
		btParar.setVisible(false);
		
	}

}
