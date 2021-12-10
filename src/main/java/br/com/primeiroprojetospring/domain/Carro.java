package br.com.primeiroprojetospring.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Carro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2662717734922024420L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "MODELO_CARRO")
	private String modelo;

	@OneToOne
	@JoinColumn(name = "ID_CHAVE")
	private Chave chaveCarro;

	@OneToOne
	@JoinColumn(name = "ID_DOCUMENTO")
	private Documento documentoCarro;

	@ManyToOne
	@JoinColumn(name = "ID_FABRICANTE")
	private Fabricante fabricanteCarro;

	@ManyToMany
	@JoinTable(name = "REL_CARRO_ACESSORIO", joinColumns = { @JoinColumn(name = "ID_CARRO") }, inverseJoinColumns = {
			@JoinColumn(name = "ID_ACESSORIO") })
	private List<Acessorio> acessorios;

	public List<Acessorio> getAcessorios() {
		return acessorios;
	}

}
