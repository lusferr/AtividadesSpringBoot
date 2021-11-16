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

@Entity
@Table (name = "tb_usuario")
public class ModelUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_usuario;
	
	@NotBlank(message = "Este campo não pode ficar vazio.")
	@Size(min = 5, max = 80, message = "O nome deve ter no min 5 e no max 80 caracteres.")
	private String nome;
	
	@NotBlank(message = "Este campo não pode ficar vazio.")
	@Size(min = 5, max = 80, message = "O usuario deve ter no min 5 e no max 80 caracteres.")
	private String usuario;
	
	@NotBlank(message = "Este campo não pode ficar vazio.")
	@Size(min = 5, message = "A senha deve conter pelo menos uma letra e ter no min 5 caracteres.")
	private String senha;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<ModelProduto> produto;
	
	public ModelUsuario(long id, String nome, String usuario, String senha) {
		this.id_usuario = id;
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
	}

	public long getId_produto() {
		return id_usuario;
	}

	public void setId_produto(long id_produto) {
		this.id_usuario = id_produto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<ModelProduto> getProduto() {
		return produto;
	}

	public void setProduto(List<ModelProduto> produto) {
		this.produto = produto;
	}

	
}
