package br.senai.sp.jandira.model;

public enum Periodo {

	MANHA("Manhã"), TARDE("Tarde"), NOITE("Noite"), SABADO("Sábado");

	private String descricao;

	//construtor em Enum deve ser privado, por ser lista que não pode ser modificada 
	private Periodo(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
