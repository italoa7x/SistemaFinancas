package view.controllers;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Optional;
import java.util.ResourceBundle;

import control.ControlerInvestimento;
import dto.InvestimentoDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import model.Status;

public class ControllerItem implements Initializable{

	private ControllerHome con;
	
	private InvestimentoDTO dto;
	
    @FXML
    private HBox itemC;

    @FXML
    private Label lbNome;

    @FXML
    private Label lbDataI;

    @FXML
    private Label lbDataF;

    @FXML
    private Label lbValor;

    @FXML
    private Label lbLucro;

    @FXML
    private Label lbMargem;
    
    @FXML
    private Label lbStatus;

    @FXML
    private Button btStatus;

    @FXML
    void lsExcluir(ActionEvent event) {

    	try {
    		ControlerInvestimento controler = new ControlerInvestimento();
    		controler.excluir(dto);
			con.carregarTabela();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    	
    
    
    
    @FXML
    void lsFinalizar(ActionEvent event) {
    	Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    	alert.setTitle("Confirmação");
    	alert.setHeaderText("Deseja mesmo Finalizar o Investimento?");
    	alert.setResizable(false);
    	Optional<ButtonType> result = alert.showAndWait();
    	if(result.get() == ButtonType.OK) {
    		
    	
    	ControlerInvestimento controler = new ControlerInvestimento();
    	try {
			dto.setStatus(Status.Finalizado);
    		controler.atualizar(dto);
			con.carregarTabela();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
    	con.carregarTabela();}
    }
    
    
    public void carregar (InvestimentoDTO i) {
    	dto=i;
    	SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
    	lbNome.setText(dto.getNome());
    	lbDataI.setText(s.format(dto.getData_inicio()));
    	if(dto.getData_fim()!=null) {
    		lbDataF.setText(s.format(dto.getData_fim()));
    	}
    	else {
    		lbDataF.setText(" ");
    	}
    	lbLucro.setText(String.valueOf(dto.getLucro().get(0).getValor()));
    	lbMargem.setText(String.valueOf(dto.getMargem()));
    	lbValor.setText(String.valueOf(dto.getValor()));
    	lbStatus.setText(dto.getStatus().name());
    }

    

	public ControllerHome getCon() {
		return con;
	}





	public void setCon(ControllerHome con) {
		this.con = con;
	}





	public void initialize(URL location, ResourceBundle resources) {
		
		
	}

}
