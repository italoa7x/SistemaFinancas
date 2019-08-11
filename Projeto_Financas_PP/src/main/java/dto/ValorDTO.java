package dto;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "valor")
public class ValorDTO {

	@Transient
	private ArrayList<ValorDTO> valoresCadastrados;
	
	private double valor;

	@OneToOne
	private MoedaDTO moeda;

	@Temporal(TemporalType.DATE)
	private Date data;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public MoedaDTO getMoeda() {
		return moeda;
	}

	public void setMoeda(MoedaDTO moeda) {
		this.moeda = moeda;
	}

	public ArrayList<ValorDTO> getValoresCadastrados() {
		return valoresCadastrados;
	}

	public void setValoresCadastrados(ArrayList<ValorDTO> valoresCadastrados) {
		this.valoresCadastrados = valoresCadastrados;
	}

	
}
