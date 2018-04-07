package br.com.alexandreaquiles.imc.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CategoriaImcTest {

	/*
	OBESIDADE_SEVERA("Obesidade Grau II (severa)", imc -> imc >= 35 && imc < 40),
	OBESIDADE_MORBIDA("Obesidade Grau III (mórbida)", imc -> imc > 40);
	*/
	
	@Test
	public void magrezaGrave() {
		assertEquals(CategoriaImc.MAGREZA_GRAVE, CategoriaImc.categoriza(15.0));
	}

	@Test
	public void magrezaModerada() {
		assertEquals(CategoriaImc.MAGREZA_MODERADA, CategoriaImc.categoriza(16.0));
	}

	@Test
	public void aindaMagrezaModerada() {
		assertEquals(CategoriaImc.MAGREZA_MODERADA, CategoriaImc.categoriza(16.9));
	}

	@Test
	public void magrezaLeve() {
		assertEquals(CategoriaImc.MAGREZA_LEVE, CategoriaImc.categoriza(17.0));
	}

	@Test
	public void aindaMagrezaLeve() {
		assertEquals(CategoriaImc.MAGREZA_LEVE, CategoriaImc.categoriza(18.4));
	}

	@Test
	public void saudavel() {
		assertEquals(CategoriaImc.SAUDAVEL, CategoriaImc.categoriza(18.5));
	}

	@Test
	public void aindaSaudavel() {
		assertEquals(CategoriaImc.SAUDAVEL, CategoriaImc.categoriza(24.9));
	}

	@Test
	public void sobrepeso() {
		assertEquals(CategoriaImc.SOBREPESO, CategoriaImc.categoriza(25.0));
	}

	@Test
	public void aindaSobrepeso() {
		assertEquals(CategoriaImc.SOBREPESO, CategoriaImc.categoriza(29.9));
	}

	@Test
	public void obesidade() {
		assertEquals(CategoriaImc.OBESIDADE, CategoriaImc.categoriza(30.0));
	}

	@Test
	public void aindaObesidade() {
		assertEquals(CategoriaImc.OBESIDADE, CategoriaImc.categoriza(34.9));
	}

	@Test
	public void obesidadeSevera() {
		assertEquals(CategoriaImc.OBESIDADE_SEVERA, CategoriaImc.categoriza(35.0));
	}

	@Test
	public void aindaObesidadeSevera() {
		assertEquals(CategoriaImc.OBESIDADE_SEVERA, CategoriaImc.categoriza(39.9));
	}

	@Test
	public void obesidadeMorbida() {
		assertEquals(CategoriaImc.OBESIDADE_MORBIDA, CategoriaImc.categoriza(40.0));
	}

	@Test
	public void aindaObesidadeMorbida() {
		assertEquals(CategoriaImc.OBESIDADE_MORBIDA, CategoriaImc.categoriza(50.0));
	}

}
