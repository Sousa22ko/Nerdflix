package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Content {

	@Id
	private int id;
	
	private String nome;
	private int faixaEtaria;
	private String categoria;
	private String ator;
	private String diretor;
	private String imagepath;
	private String videopath;
	private int temporadas;
	private String descricao;

	public Content() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getFaixaEtaria() {
		return faixaEtaria;
	}

	public void setFaixaEtaria(int faixaEtaria) {
		this.faixaEtaria = faixaEtaria;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getAtor() {
		return ator;
	}

	public void setAtor(String ator) {
		this.ator = ator;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public int getTemporadas() {
		return temporadas;
	}

	public void setTemporadas(int temporadas) {
		this.temporadas = temporadas;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getVideopath() {
		return videopath;
	}

	public void setVideopath(String videopath) {
		this.videopath = videopath;
	}

}
