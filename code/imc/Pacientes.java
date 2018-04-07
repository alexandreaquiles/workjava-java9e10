public class Pacientes {

	public static List<Paciente> todos() {

		return List.of(
			new Paciente("Júlia", 60.0, 1.80),
			new Paciente("Gabriel", 78.0, 1.86),
			new Paciente("Davi", 120.0, 1.92),
			new Paciente("Miguel", 77.0, 1.96)
		);

	}

	public static Map<CategoriaImc, List<Paciente>> pacientesPorCategoria() {
		return Map.of(
			CategoriaImc.SAUDAVEL, List.of(new Paciente("Júlia", 60.0, 1.80), new Paciente("Gabriel", 78.0, 1.86), new Paciente("Miguel", 77.0, 1.96)),
			CategoriaImc.SOBREPESO, List.of(new Paciente("Davi", 120.0, 1.92))
		);
	} 

}
