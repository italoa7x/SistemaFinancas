package dto;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import model.Status;


@Entity
@Table(name = "investimento")
public class InvestimentoDTO {
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	private double valor;
	private double margem;
	private String nome;
	
	@OneToMany(mappedBy =  "investimento",cascade = CascadeType.ALL,orphanRemoval = true)	
	private List<LucroDTO> lucro;
	
	
	@Temporal(TemporalType.DATE)
	private Date data_inicio;
	@Temporal(TemporalType.DATE)
	private Date data_fim;
	
	@Transient
	private List<InvestimentoDTO> todosInvetismento;
	
	@ManyToOne
	private MoedaDTO moeda;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private UsuarioDTO usuario;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	
	}
	
	
	
	


	public double getMargem() {
		return margem;
	}

	public void setMargem(double margem) {
		this.margem = margem;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public List<LucroDTO> getLucro() {
		return lucro;
	}

	public void setLucro(List<LucroDTO> lucro) {
		this.lucro = lucro;
	}

	public MoedaDTO getMoeda() {
		return moeda;
	}

	public MoedaDTO getMoedaDTO() {
		return moeda;
	}

	public void setMoeda(MoedaDTO moeda) {
		this.moeda = moeda;
	}

	public List<InvestimentoDTO> getTodosInvetismento() {
		return todosInvetismento;
	}

	public void setTodosInvetismento(List<InvestimentoDTO> todosInvetismento) {
		this.todosInvetismento = todosInvetismento;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	

	public Date getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(Date data_inicio) {
		this.data_inicio = data_inicio;
	}

	public Date getData_fim() {
		return data_fim;
	}

	public void setData_fim(Date data_fim) {
		this.data_fim = data_fim;
	}

}
