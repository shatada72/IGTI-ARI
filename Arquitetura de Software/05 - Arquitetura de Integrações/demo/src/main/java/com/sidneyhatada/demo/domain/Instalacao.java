package com.sidneyhatada.demo.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Instalacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_endereco")
	private Endereco enderecoInstalacao;

	//@JsonIgnore
	@JsonBackReference
	@OneToMany(mappedBy = "instalacao", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Fatura> listaFatura = new ArrayList<Fatura>();

	private String codigo;
	private Date dataInstalacao;

	protected Instalacao() {

	}

	public Instalacao(String codigo, Date dataInstalacao) {
		super();
		this.codigo = codigo;
		this.dataInstalacao = dataInstalacao;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Endereco getEnderecoInstalacao() {
		return enderecoInstalacao;
	}

	public void setEnderecoInstalacao(Endereco enderecoInstalacao) {
		this.enderecoInstalacao = enderecoInstalacao;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getDataInstalacao() {
		return dataInstalacao;
	}

	public void setDataInstalacao(Date dataInstalacao) {
		this.dataInstalacao = dataInstalacao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Fatura> getListaFatura() {
		return listaFatura;
	}

	public void setListaFatura(List<Fatura> listaFatura) {
		this.listaFatura = listaFatura;
	}

	@Override
	public String toString() {
		return "Instalacao [id=" + id + ", cliente=" + cliente + ", enderecoInstalacao=" + enderecoInstalacao
				+ ", listaFatura=" + listaFatura + ", codigo=" + codigo + ", dataInstalacao=" + dataInstalacao + "]";
	}

}