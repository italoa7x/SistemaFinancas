package view.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import control.ControlerMeta;
import dto.MetaDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.Status;

public class ControllerMetas implements Initializable {
	private ControllerHome con;

	@FXML
	private Pane pnlInvestimentos;

	@FXML
	private ProgressIndicator pgMetas;

	@FXML
	private Label lbConcluido;

	@FXML
	private Label lbConcluir;

	@FXML
	private Label lbValor;

	@FXML
	private Label lbCancelados;

	@FXML
	private Label lbTotal;

	@FXML
	private VBox pnItems111;

	@FXML
	private TextField txPesquisa;

	@FXML
	private TextField txNome;

	@FXML
	private TextField txDescricao;

	@FXML
	private TextField txValor11;

	@FXML
	private Button btCadastro;

	@FXML
	void lsCadastrar(ActionEvent event) {
		MetaDTO meta = new MetaDTO();
		if (txNome.getText().isEmpty() || txDescricao.getText().isEmpty() || txValor11.getText().isEmpty()) {
			Alert dialogoInfo = new Alert(Alert.AlertType.ERROR);
			dialogoInfo.setTitle("Erro no cadastro");
			dialogoInfo.setContentText("Preencha todos os campos!");
			dialogoInfo.showAndWait();
		} else {

			meta.setNome(txNome.getText());
			java.sql.Date dataSql = new java.sql.Date(new Date().getTime());
			meta.setData_inicio(dataSql);
			meta.setDescricao(txDescricao.getText());
			meta.setStatus(Status.Ativo);
			meta.setValor(Double.parseDouble(txValor11.getText()));
			meta.setUsuario(con.getDto());

			ControlerMeta con = new ControlerMeta();
			try {
				con.salvar(meta);
				limparCampos();
				Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
				dialogoInfo.setTitle("Cadastro de Cliente");
				dialogoInfo.setContentText("Cadastro Concluido!");
				dialogoInfo.showAndWait();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private void limparCampos() {
		txDescricao.clear();
		txNome.clear();
		txPesquisa.clear();
		txValor11.clear();
	}

	public void carregarTabela() {
		ControlerMeta controler = new ControlerMeta();
		MetaDTO metas = new MetaDTO();
		try {
			metas = controler.listar();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		pnItems111.getChildren().clear();
		if (!metas.getTodasMetas().isEmpty()) {
			Node[] nodes = new Node[metas.getTodasMetas().size()];
			for (int i = 0; i < nodes.length; i++) {
				try {

					final int j = i;
					FXMLLoader fxmlLoader = new FXMLLoader();
					nodes[i] = fxmlLoader.load(getClass().getResource("/view/fxmls/ItemM.fxml").openStream());
					ControllerItemM controller = (ControllerItemM) fxmlLoader.getController();
					controller.setCon(this);
					controller.carregar(metas.getTodasMetas().get(i));

					// give the items some effect

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

	public void carregarLb() {
		ControlerMeta controler = new ControlerMeta();
		try {
			MetaDTO metas = controler.listar();
			int finalizadas = controler.metasFinalizadas();
			int total = 0;
			int faltando = 0;
			for (MetaDTO m:metas.getTodasMetas()) {
				if(m.getStatus()==Status.Ativo) {
					faltando++;
				}
				total++;
			}
			lbConcluido.setText(String.valueOf(finalizadas));
			lbTotal.setText(String.valueOf(total));
			lbConcluir.setText(String.valueOf(faltando));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void initialize(URL location, ResourceBundle resources) {
		ControlerMeta controler = new ControlerMeta();
		try {
			int atual = controler.metasFinalizadas();
			int total = controler.listar().getTodasMetas().size();
			if (atual > 0) {
				double porcentagem = (atual * 100) / total;
				pgMetas = new ProgressIndicator(porcentagem);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ControllerHome getCon() {
		return con;
	}

	public void setCon(ControllerHome con) {
		this.con = con;
	}

}
