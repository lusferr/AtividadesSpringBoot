package br.com.generation.farmaciaGen.model;

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

@Entity
@Table(name = "tb_categoria")
public class ModelCategoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_categoria;
	
	@NotBlank(message = "Não pode ficar em branco")
	@Size (min = 1, max = 50, message = "Máx de 50 caracteres")
	private String tarja;
	
	//Se é Gel, consumo oral, spray, liquido, etc.
	@NotBlank(message = "Não pode ficar em branco")
	@Size (min = 1, max = 50, message = "Máx de 50 caracteres")
	private String tipoDeUso;
	
	//Dores no estômago, anti-inflamatorio, anti-biotico
	@NotBlank(message = "Não pode ficar em branco")
	@Size (min = 1, max = 50, message = "Máx de 50 caracteres")
	private String descricao;
	
	//criando chave estrangeira
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("categoria")
	private List<ModelProduto> produto;

	public long getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(long id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getTarja() {
		return tarja;
	}

	public void setTarja(String tarja) {
		this.tarja = tarja;
	}

	public String getTipoDeUso() {
		return tipoDeUso;
	}

	public void setTipoDeUso(String tipoDeUso) {
		this.tipoDeUso = tipoDeUso;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<ModelProduto> getProduto() {
		return produto;
	}

	public void setProduto(List<ModelProduto> produto) {
		this.produto = produto;
	}

	
}
