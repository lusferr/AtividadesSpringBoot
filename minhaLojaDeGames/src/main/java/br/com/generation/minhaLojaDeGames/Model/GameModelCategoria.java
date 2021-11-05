package br.com.generation.minhaLojaDeGames.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//Modela as informacoes do banco de dados

@Entity
@Table(name = "tb_categoria")
public class GameModelCategoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_categoria;
	
	@NotBlank (message = "O valor não pode ser nulo")
	@Size (min = 1, max = 50, message = "Max de 50 caracteres")
	private String genero;
	
	@NotBlank
	@Size (min = 1, max = 20, message = "Max de 50 caracteres")
	private String plataforma;
	
	@NotBlank
	@Size (min = 1, max = 50, message = "Max de 50 caracteres")
	private String condicao;
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("categoria")
    private List<GameModelProduto> produto;
	
	public List<GameModelProduto> getProduto() {
		return produto;
	}

	public void setProduto(List<GameModelProduto> produto) {
		this.produto = produto;
	}

	public long getId() {
		return id_categoria;
	}

	public void setId(long id) {
		this.id_categoria = id;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getCondicao() {
		return condicao;
	}

	public void setCondicao(String condicao) {
		this.condicao = condicao;
	}

}
