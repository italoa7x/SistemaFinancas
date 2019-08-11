package view.controllers;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import control.ControlerInvestimento;
import control.ControlerMoeda;
import dto.InvestimentoDTO;
import dto.MoedaDTO;
import dto.UsuarioDTO;
import dto.ValorDTO;
import iterator.Iterator;
import iterator.IteratorInvestimento;
import iterator.IteratorMoeda;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.ComboBox;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.Status;



public class ControllerHome implements Initializable {

	private UsuarioDTO dto;
	
	
	
	@FXML
	private Label lbUsuario;

	@FXML
	private Button btFinancas;

	@FXML
	private Button btInvestimentos;

	@FXML
	private Button btMetas;

	@FXML
	private Button btConsultas;

	

	@FXML
	private Button btDeslogar;

	@FXML
	private Pane pnlHome;

	@FXML
	private Pane pnlFinancas;

	@FXML
	private Pane pnlGraficos;

	@FXML
	private Pane pnlPerfil;

	@FXML
	private Pane pnlMetas;

	@FXML
	private Pane pnlInvestimentos;

	@FXML
	private ComboBox<MoedaDTO> cbTtipo;

	
	
	@FXML
    private TextField txNome;

	@FXML
	private TextField txValor;

	@FXML
	private Button btCadastro;

	@FXML
	private VBox pnItems111;

	@FXML
	private TextField txPesquisaG;
	 
	 @FXML
	 private BarChart<String, Number> grLucro;

	
	@FXML
	private Pane pnlConsultas;
	
	

	@FXML
	void handleClicks(ActionEvent event) {
		if (event.getSource() == btFinancas) {
			try {
				Pane pane = FXMLLoader.load(getClass().getResource("/view/fxmls/Financas.fxml"));
				pnlFinancas.getChildren().add(pane);
				pnlFinancas.toFront();
				if(ControllerConsultas.getScheduledExecutorService()!=null)
					ControllerConsultas.getScheduledExecutorService().shutdown();
			} catch (IOException e4) {
				// TODO Auto-generated catch block
				e4.printStackTrace();
			}
		} else if (event.getSource() == btMetas) {
			try {
				if(ControllerConsultas.getScheduledExecutorService()!=null)
					ControllerConsultas.getScheduledExecutorService().shutdown();
				Pane pane = FXMLLoader.load(getClass().getResource("/view/fxmls/Metas.fxml"));
				pnlMetas.getChildren().add(pane);
				pnlMetas.toFront();
			} catch (IOException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
		} else if (event.getSource() == btConsultas) {
			try {
				if(ControllerConsultas.getScheduledExecutorService()!=null)
					ControllerConsultas.getScheduledExecutorService().shutdown();
				Pane pane = FXMLLoader.load(getClass().getResource("/view/fxmls/Consultas.fxml"));
				pnlConsultas.getChildren().add(pane);
				pnlConsultas.toFront();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		} 
		else if (event.getSource() == btInvestimentos) {
			if(ControllerConsultas.getScheduledExecutorService()!=null)
			ControllerConsultas.getScheduledExecutorService().shutdown();
			pnlInvestimentos.toFront();
		}
		else if (event.getSource() == btDeslogar) {
			if(ControllerConsultas.getScheduledExecutorService()!=null)
				ControllerConsultas.getScheduledExecutorService().shutdown();
			System.exit(0);
		}
	}
	
	
	
	@FXML
    void lsCadastrar(ActionEvent event) {
		if(txNome.getText().isEmpty()||txValor.getText().isEmpty()||cbTtipo.getSelectionModel().getSelectedItem()==null) {
    		Alert dialogoInfo = new Alert(Alert.AlertType.ERROR);
            dialogoInfo.setTitle("Erro no cadastro");
            dialogoInfo.setContentText("Preencha todos os campos!");
            dialogoInfo.showAndWait();
		}
        else {
            
            try {
			ControlerInvestimento controler = new ControlerInvestimento();
			InvestimentoDTO iv = new InvestimentoDTO();
			iv.setData_inicio(new Date());
			iv.setMoeda(cbTtipo.getSelectionModel().getSelectedItem());
			iv.setNome(txNome.getText());
			iv.setStatus(Status.Ativo);
			iv.setUsuario(dto);
			iv.setValor(Double.parseDouble(txValor.getText()));
			controler.salvar(iv);
			limparCampos();
			Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            dialogoInfo.setTitle("Cadastro Concluido");
            dialogoInfo.setContentText("Investimento Cadastrado com Sucesso");
            dialogoInfo.showAndWait();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        }
    }
	public void limparCampos() {
		txNome.clear();
		txValor.clear();
	}
	
	
	
	
	public void carregarTabela() {
		
		ControlerInvestimento con = new ControlerInvestimento();
		InvestimentoDTO investimentos = new InvestimentoDTO();
		try {
			investimentos = con.listar();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		pnItems111.getChildren().clear();
		Iterator it = new IteratorInvestimento (investimentos.getTodosInvetismento());
		if(!investimentos.getTodosInvetismento().isEmpty()) {
			Node[] nodes = new Node[investimentos.getTodosInvetismento().size()];
			int i = 0;
			while(it.hasNext()) {
				it.next();
				try {

	                final int j = i;
	                FXMLLoader fxmlLoader = new FXMLLoader();
	                nodes[i] = fxmlLoader.load(getClass().getResource("/view/fxmls/Item.fxml").openStream());
	                ControllerItem controller = (ControllerItem) fxmlLoader.getController(); 
	                controller.setCon(this);
	                controller.carregar(investimentos.getTodosInvetismento().get(i));

	                //give the items some effect

	                nodes[i].setOnMouseEntered(event -> {
	                    nodes[j].setStyle("-fx-background-color : #0A0E3F");
	                });
	                nodes[i].setOnMouseExited(event -> {
	                    nodes[j].setStyle("-fx-background-color : #02030A");
	                });
	                pnItems111.getChildren().add(nodes[i]);
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
			}
			
		}
	}

	public void carregarGraficos() {
		XYChart.Series<String, Number> series = new XYChart.Series<>();
		grLucro.getData().add(series);
		series.getData().add(new XYChart.Data<>("Julho",100));
		
		
	}
	
	public void carregarCb() {
		ControlerMoeda controler= new ControlerMoeda();
		try {
			MoedaDTO m = controler.listar();
			ObservableList <MoedaDTO> registro = FXCollections.observableArrayList();
			Iterator it = new IteratorMoeda(m.getTodasMoedas());
			while(it.hasNext()) {
				registro.add((MoedaDTO) it.next());
			}
			cbTtipo.setItems(registro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
		
	
	
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		carregarTabela();
		carregarCb();
		carregarGraficos();
	}



	public UsuarioDTO getDto() {
		return dto;
	}



	public void setDto(UsuarioDTO dto) {
		this.dto = dto;
	}

	
	
}
