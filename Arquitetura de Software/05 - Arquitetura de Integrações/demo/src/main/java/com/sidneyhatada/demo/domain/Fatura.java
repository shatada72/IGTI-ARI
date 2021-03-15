package com.sidneyhatada.demo.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Fatura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_instalacao")
	private Instalacao instalacao;

	private String codigo;
	private Date dataLeitura;
	private Date dataVencimento;
	private int numeroLeitura;
	private double valorConta;

	protected Fatura() {

	}

	public Fatura(String codigo, Date dataLeitura, Date dataVencimento, int numeroLeitura, double valorConta) {
		super();
		this.codigo = codigo;
		this.dataLeitura = dataLeitura;
		this.dataVencimento = dataVencimento;
		this.numeroLeitura = numeroLeitura;
		this.valorConta = valorConta;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Instalacao getInstalacao() {
		return instalacao;
	}

	public void setInstalacao(Instalacao instalacao) {
		this.instalacao = instalacao;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getDataLeitura() {
		return dataLeitura;
	}

	public void setDataLeitura(Date dataLeitura) {
		this.dataLeitura = dataLeitura;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public int getNumeroLeitura() {
		return numeroLeitura;
	}

	public void setNumeroLeitura(int numeroLeitura) {
		this.numeroLeitura = numeroLeitura;
	}

	public double getValorConta() {
		return valorConta;
	}

	public void setValorConta(double valorConta) {
		this.valorConta = valorConta;
	}

	@Override
	public String toString() {
		return "Fatura [id=" + id + ", instalacao=" + instalacao + ", codigo=" + codigo + ", dataLeitura=" + dataLeitura
				+ ", dataVencimento=" + dataVencimento + ", numeroLeitura=" + numeroLeitura + ", valorConta="
				+ valorConta + "]";
	}

	


}