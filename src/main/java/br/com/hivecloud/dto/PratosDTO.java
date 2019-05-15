package br.com.hivecloud.dto;

import java.math.BigDecimal;
import java.util.Arrays;

import javax.validation.constraints.NotNull;

import br.com.hivecloud.models.Pratos;

public class PratosDTO {


	@NotNull
	private String nome;

	private String[] acompanhamentos;

	@NotNull
	private BigDecimal preco;

	public PratosDTO() {

	}

	/**
	 * @param nome
	 * @param acompanhamentos
	 * @param preco
	 */
	public PratosDTO(@NotNull String nome, String[] acompanhamentos, @NotNull BigDecimal preco) {
		this.nome = nome;
		this.acompanhamentos = acompanhamentos;
		this.preco = preco;
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

	public Pratos converterParaObjeto() {
		return new Pratos(this.nome, this.acompanhamentos, this.preco);
	}

	@Override
	public String toString() {
		return "PratosDTO [nome=" + nome + ", acompanhamentos=" + Arrays.toString(acompanhamentos) + ", preco=" + preco
				+ "]";
	}
}
