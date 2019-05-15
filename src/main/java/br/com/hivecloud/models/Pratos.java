package br.com.hivecloud.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.hivecloud.dto.PratosDTO;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="pratos")
public class Pratos {

	@Id
	@Column(name="nome", nullable = false)
	@NotNull
	@ApiModelProperty(notes = "Nome do prato", required = true)
	private String nome;

	@Column(name="acompanhamento")
	@ApiModelProperty(notes = "Lista de guarnições que acompanhamentos do prato", required = true)
	private String[] acompanhamentos;

	@Column(name="preco",nullable = false)
	@NotNull
	@ApiModelProperty(notes = "Preço final do prato", required = true)
	private BigDecimal preco;

	public Pratos() {
	}

	/**
	 * @param nome
	 * @param acompanhamentos
	 * @param preco
	 */
	public Pratos(@NotNull String nome, String[] acompanhamentos, @NotNull BigDecimal preco) {
		this.nome = nome;
		this.acompanhamentos = acompanhamentos;
		this.preco = preco;
	}

	public PratosDTO converterParaDTO() {
		return new PratosDTO(this.nome, this.acompanhamentos, this.preco);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String[] getAcompanhamentos() {
		return acompanhamentos;
	}

	public void setAcompanhamentos(String[] acompanhamentos) {
		this.acompanhamentos = acompanhamentos;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
}