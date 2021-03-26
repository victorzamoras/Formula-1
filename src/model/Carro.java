package model;

public class Carro {
	
	private int id;
	private String equipe;
	private int mtempo = 650;
	
	public int getMtempo() {
		return mtempo;
	}
	public void setMtempo(int mtempo) {
		this.mtempo = mtempo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEquipe() {
		return equipe;
	}
	public void setEquipe(String equipe) {
		this.equipe = equipe;
	}
}
