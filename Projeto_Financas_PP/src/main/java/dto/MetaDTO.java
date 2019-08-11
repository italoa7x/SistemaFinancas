package dto;

import java.util.Date;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import model.Status;

@Entity
@Table(name = "meta")
public class MetaDTO {
	@Temporal(TemporalType.DATE)
	private Date data_inicio;
	@Temporal(TemporalType.DATE)
	private Date data_fim;
	@Enumerated(EnumType.STRING)
	private Status status;
	
	private String descricao;
	
	private String nome;
	
	private double valor;
	
	@Transient
	private ArrayList<MetaDTO> todasMetas;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	
	@OneToOne()
	private UsuarioDTO usuario;
	
	
	

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<MetaDTO> getTodasMetas() {
		return todasMetas;
	}

	public void setTodasMetas(ArrayList<MetaDTO> todasMetas) {
		this.todasMetas = todasMetas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(Date date) {
		this.data_inicio = date;
	}

	public Date getData_fim() {
		return data_fim;
	}

	public void setData_fim(Date data_fim) {
		this.data_fim = data_fim;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	
}
