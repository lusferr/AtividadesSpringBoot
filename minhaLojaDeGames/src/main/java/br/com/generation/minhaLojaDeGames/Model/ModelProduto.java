package br.com.generation.minhaLojaDeGames.Model;

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
@Table(name = "tb_produto")
public class ModelProduto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_produto;
	
	@NotBlank (message = "O valor não pode ser nulo")
	@Size (min = 1, max = 100, message = "Max de 100 caracteres")
	private String titulo;
	
	@NotBlank (message = "O valor não pode ser nulo")
	private double preco;
	
	//CHAVE ESTRANGEIRA
	@ManyToOne //N : 1
	@JsonIgnoreProperties("categoria") //ignora algumas propriedades e nao permite repeticao
	private ModelCategoria categoria;
	
	@ManyToOne
	@JsonIgnoreProperties("usuario")
	private ModelUsuario usuario;
	
	public ModelUsuario getUsuario() {
		return usuario;
	}
	public void setUsuario(ModelUsuario usuario) {
		this.usuario = usuario;
	}
	
	public ModelCategoria getCategoria() {
		return categoria;
	}
	public void setCategoria(ModelCategoria categoria) {
		this.categoria = categoria;
	}
	
	public long getId() {
		return id_produto;
	}
	public void setId(long id) {
		this.id_produto = id;
	}
	
	public String getNome() {
		return titulo;
	}
	public void setNome(String nome) {
		this.titulo = nome;
	}
	
	public double isPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}

}
