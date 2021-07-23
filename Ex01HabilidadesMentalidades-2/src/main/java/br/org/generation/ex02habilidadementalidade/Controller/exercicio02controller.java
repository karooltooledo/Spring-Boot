package br.org.generation.ex02habilidadementalidade.Controller;

	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	@RestController
	@RequestMapping("/aprendizagem")
	public class exercicio02controller {
		
			@GetMapping
			public String aprendizagem() {
				return "Busco me desenvolver mais no Spring Boot, para em breve iniciar a montagem do meu blog pessoal.";
			}
	
}
