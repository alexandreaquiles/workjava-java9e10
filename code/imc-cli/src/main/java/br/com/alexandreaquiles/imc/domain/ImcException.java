package br.com.alexandreaquiles.imc.domain;

public class ImcException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ImcException(String mensagem) {
		super(mensagem);
	}
}
