package model;
public class Animal {
	private int id;
	private String nome;
	private String especie;
	private String raca;
	private int idade;
	private String sexo;
	private double peso;
	private String foto;
	private int proprietarioId;

	public Animal() {
	}

	public Animal(int id, String nome, String especie, String raca, int idade, String sexo, double peso, String foto,
			int proprietarioId) {
		this.id = id;
		this.nome = nome;
		this.especie = especie;
		this.raca = raca;
		this.idade = idade;
		this.sexo = sexo;
		this.peso = peso;
		this.foto = foto;
		this.proprietarioId = proprietarioId;
	}

	public Animal(int id) {
		this.id = id;
	}

	// Getters e Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public int getProprietarioId() {
		return proprietarioId;
	}

	public void setProprietarioId(int proprietarioId) {
		this.proprietarioId = proprietarioId;
	}
}
