package br.senai.sp.jandira.model;

public enum Periodo {

	MANHA("Manh�"), TARDE("Tarde"), NOITE("Noite"), SABADO("S�bado");

	private String descricao;

	//construtor em Enum deve ser privado, por ser lista que n�o pode ser modificada 
	private Periodo(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
