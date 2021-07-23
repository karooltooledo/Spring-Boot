package br.org.generation.ex01habilidadementalidade.Controller;

	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	@RestController
	@RequestMapping("/habilidadesmentalidades")
	public class exercicio01controller {
		
			@GetMapping
			public String habilidadesmentalidades() {
				return "Mentalidade Utilizada: Persistência." + "\nHabilidade Utilizada: Atenção aos detalhes.";
			}
}
