package dto;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "lucro")
public class LucroDTO {
	
	@ManyToOne(fetch = FetchType.EAGER)
	private InvestimentoDTO investimento;
	
	@Transient
	private ArrayList<LucroDTO> totalLucros;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double valor;
	@Temporal(TemporalType.DATE)
	private Date data;
	
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<LucroDTO> getTotalLucros() {
		return totalLucros;
	}
	public void setTotalLucros(ArrayList<LucroDTO> totalLucros) {
		this.totalLucros = totalLucros;
	}
	
	
	
	
}
