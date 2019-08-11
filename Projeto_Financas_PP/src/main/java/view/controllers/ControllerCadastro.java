package view.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import control.ControlerUsuario;
import dto.UsuarioDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerCadastro implements Initializable{

    @FXML
    private TextField txEmail;

    @FXML
    private PasswordField txSenha;

    @FXML
    private Button btCadastro;

    @FXML
    private TextField txNome;

    @FXML
    private TextField txCpf;

    @FXML
    private Button btRetornar;
    
    @FXML
    private TextField txTelefone;

    @FXML
    void lsCadastro(ActionEvent event) {
    	if(txNome.getText().isEmpty()||txCpf.getText().isEmpty()||txEmail.getText().isEmpty()||txSenha.getText().isEmpty()) {
    		Alert dialogoInfo = new Alert(Alert.AlertType.ERROR);
            dialogoInfo.setTitle("Erro no cadastro");
            dialogoInfo.setContentText("Preencha todos os campos!");
            dialogoInfo.showAndWait();
    	}
    	else {
    		ControlerUsuario con = new ControlerUsuario();
    		UsuarioDTO dto = new UsuarioDTO();
    		dto.setCpf(txCpf.getText());
    		dto.setNome(txNome.getText());
    		dto.setEmail(txEmail.getText());
    		dto.setSenha(txSenha.getText());
    		dto.setTelefone(txTelefone.getText());
    		try {
				con.salvar(dto);
			} catch (Exception e) {
				Alert dialogoInfo = new Alert(Alert.AlertType.ERROR);
	            dialogoInfo.setTitle("Erro no cadastro");
	            dialogoInfo.setContentText(e.getMessage());
	            dialogoInfo.showAndWait();
			}
    	}
    	retornar(event);
    	
    }

    @FXML
    void lsRetornar(ActionEvent event) {
    	retornar(event);
    }
    
    private void retornar(ActionEvent e) {
    	
		try {
			Node node = (Node) e.getSource();
		    Stage stage = (Stage) node.getScene().getWindow();
		    stage.close();
		    Scene scene;
			scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("/view/fxmls/TelaLogin.fxml")));
			stage.setScene(scene);
		    stage.show();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
    	
    }

	public void initialize(URL location, ResourceBundle resources) {
		String tx = new String("-fx-text-fill: lightgray; -fx-font-size: 12px;-fx-background-color:#14173d;");
		txEmail.setStyle(tx);
		txSenha.setStyle(tx);
		txCpf.setStyle(tx);
		txNome.setStyle(tx);
		txTelefone.setStyle(tx);
		
	}

}

