package br.org.generation.lojagames.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.lojagames.model.Produtos;
import br.org.generation.lojagames.repository.ProdutosRepository;

	
	@RestController
	@RequestMapping("/produtos")
	@CrossOrigin(origins="*", allowedHeaders="*")
	public class ProdutosController {
		
		@Autowired
		private ProdutosRepository produtosRepository;
		
		@GetMapping
		private ResponseEntity<List<Produtos>> getAll() {
			return ResponseEntity.ok(produtosRepository.findAll());
		}
		
		@GetMapping("/{id}")
		private ResponseEntity<Produtos> getById(@PathVariable long id) {
			return produtosRepository.findById(id)
					.map(resp -> ResponseEntity.ok(resp))
					.orElse(ResponseEntity.notFound().build());
		}
	
		@GetMapping("/nome/{nome}")
		private ResponseEntity<List<Produtos>> getByNome(@PathVariable String nome) {
			return ResponseEntity.ok(produtosRepository.findAllByDescricaoContainingIgnoreCase(nome));	
		}

		@GetMapping("/descricao/{descricao}")
		private ResponseEntity<List<Produtos>> getByDescricao(@PathVariable String descricao) {
			return ResponseEntity.ok(produtosRepository.findAllByDescricaoContainingIgnoreCase(descricao));	
		}
		@GetMapping("/preco/{preco}")
		private ResponseEntity<List<Produtos>> getByPreco(@PathVariable String preco) {
			return ResponseEntity.ok(produtosRepository.findAllByDescricaoContainingIgnoreCase(preco));	
		}

		@PostMapping
	 	public ResponseEntity<Produtos> post(@RequestBody Produtos descricao) {
			return ResponseEntity.status(HttpStatus.CREATED).body(produtosRepository.save(descricao));
		}
		//Alterar Postagem
		@PutMapping	
	 	public ResponseEntity<Produtos> put(@RequestBody Produtos descricao) {
			return ResponseEntity.status(HttpStatus.OK).body(produtosRepository.save(descricao));
		}
		//Deletar Postagem
		@DeleteMapping("/{id}")
		public void getId(@PathVariable long id) {
			produtosRepository.deleteById(id);
		}
}