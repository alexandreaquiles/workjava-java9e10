public class Paciente {

	private String nome;
	private double pesoEmKg;
	private double alturaEmMetros;
	
	public Paciente(String nome, double pesoEmKg, double alturaEmMetros) {
		this.nome = nome;
		this.pesoEmKg = pesoEmKg;
		this.alturaEmMetros = alturaEmMetros;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPesoEmKg() {
		return pesoEmKg;
	}

	public void setPesoEmKg(double pesoEmKg) {
		this.pesoEmKg = pesoEmKg;
	}

	public double getAlturaEmMetros() {
		return alturaEmMetros;
	}

	public void setAlturaEmMetros(double alturaEmMetros) {
		this.alturaEmMetros = alturaEmMetros;
	}
	
	public double getImc() {
		return pesoEmKg / (alturaEmMetros * alturaEmMetros);
	}

	@Override
	public String toString() {
		return this.nome + ":" + this.pesoEmKg + "kg/" + this.alturaEmMetros + "m";
	}

}
