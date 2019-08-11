package view.controllers;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Optional;
import java.util.ResourceBundle;

import control.ControlerMeta;
import dto.MetaDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ControllerItemM implements Initializable{

	private ControllerMetas con;
	private MetaDTO dto;
	
    
	@FXML
    private HBox itemC;

    @FXML
    private Label lbNome;

    @FXML
    private Label lbDescricao;

    @FXML
    private Label lbData;

    @FXML
    private Label lbValor;

    @FXML
    private Label lbStatus;
    
    @FXML
    private Button btStatus;

    @FXML
    void lsExcluir(ActionEvent event) {
    	Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    	alert.setTitle("Confirmação");
    	alert.setHeaderText("Deseja mesmo Excluir o Investimento.");
    	alert.setResizable(false);
    	alert.setContentText("Select okay or cancel this alert.");
    	Optional<ButtonType> result = alert.showAndWait();
    	if(result.get() == ButtonType.OK) {
    	
    	ControlerMeta c = new ControlerMeta();
    	try {
			c.excluir(dto);
			con.carregarTabela();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
    	
    }
    
    
    public void carregar (MetaDTO i) {
    	dto=i;
    	SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
    	lbNome.setText(dto.getNome());
    	lbDescricao.setText(dto.getDescricao());
    	lbData.setText(s.format(dto.getData_inicio()));
    	lbValor.setText(String.valueOf(dto.getValor()));
    	lbStatus.setText(dto.getStatus().name());
    	
    }

    
    
    public ControllerMetas getCon() {
		return con;
	}

	public void setCon(ControllerMetas con) {
		this.con = con;
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
