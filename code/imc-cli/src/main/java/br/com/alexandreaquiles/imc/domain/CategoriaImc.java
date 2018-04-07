package br.com.alexandreaquiles.imc.domain;

import java.util.Objects;
import java.util.function.Predicate;

public enum CategoriaImc {

	MAGREZA_GRAVE("Magreza grave", imc -> imc < 16),
	MAGREZA_MODERADA("Magreza moderada", imc -> imc >= 16 && imc < 17),
	MAGREZA_LEVE("Magreza leve", imc -> imc >= 17 && imc < 18.5),
	SAUDAVEL("Saudável", imc -> imc >= 18.5 && imc < 25),
	SOBREPESO("Sobrepeso", imc -> imc >= 25 && imc < 30),
	OBESIDADE("Obesidade Grau I", imc -> imc >= 30 && imc < 35),
	OBESIDADE_SEVERA("Obesidade Grau II (severa)", imc -> imc >= 35 && imc < 40),
	OBESIDADE_MORBIDA("Obesidade Grau III (mórbida)", imc -> imc >= 40);

	private String descricao;
	private Predicate<Double> logica;

	private CategoriaImc(String descricao, Predicate<Double> logica) {
		this.descricao = descricao;
		this.logica = logica;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static CategoriaImc categoriza(Double imc) {
		Objects.requireNonNull(imc, () -> "Não é possível categorizar um IMC nulo.");
		
		for (CategoriaImc categoria : values()) {
			if (categoria.logica.test(imc)) {
				return categoria;
			}
		}
		throw new ImcException("Erro ao categorizar IMC.");
	}
	
}
