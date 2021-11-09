package br.com.generation.farmaciaGen.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produtos")
public class ModelProduto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_produto;
	
	@NotBlank(message = "Não pode ficar em branco")
	@Size (min = 1, max = 50, message = "Máx de 50 caracteres")
	private String nome;
	
	@NotBlank(message = "Não pode ficar em branco")
	private double preco;
	
	//Chave estrangeira
	@ManyToOne
	@JsonIgnoreProperties("categoria")
	private ModelCategoria categoria;

	public ModelCategoria getCategoria() {
		return categoria;
	}

	public void setCategoria(ModelCategoria categoria) {
		this.categoria = categoria;
	}

	public long getId_produto() {
		return id_produto;
	}

	public void setId_produto(long id_produto) {
		this.id_produto = id_produto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
}
