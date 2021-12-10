package br.com.primeiroprojetospring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import br.com.primeiroprojetospring.domain.Chave;
import br.com.primeiroprojetospring.service.ChaveService;

@Controller
@RequestMapping("chave")
public class ChaveController {

	// ff18af66c2d97ab42ad2308d7f884cd6ee3f1bb2
	@Autowired
	private ChaveService chaveService;

	@GetMapping("find/{id}")
	public ResponseEntity<Chave> find(@PathVariable("id") Integer id) {
		return ResponseEntity.ok().body(chaveService.buscarChaveID(id));
	}

	@PostMapping("cadastrarChave")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Chave> cadastrarChaveAPI(@RequestBody Chave chave) {
		return ResponseEntity.ok().body(chaveService.salvar(chave));
	}

	@GetMapping("/todasChave")
	public ResponseEntity<List<Chave>> devolverTodosChave() {
		return ResponseEntity.ok().body(chaveService.buscarTodasChaves());
	}

	@PutMapping("/alteraChave")
	public ResponseEntity<Chave> alteraChave(@RequestBody Chave chave) {
		Chave novoChave = chaveService.salvar(chave);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoChave);
	}

	@GetMapping("/listarChaves")
	public ModelAndView listaTodasChaves() {
		ModelAndView mView = new ModelAndView("chave/paginaListaChaves");
		mView.addObject("chaves", chaveService.buscarTodasChaves());
		return mView;

	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrarChave() {
		ModelAndView mView = new ModelAndView("chave/cadastraChave");
		mView.addObject("chave", new Chave());
		return mView;
	}

	@PostMapping("/salvar")
	public ModelAndView salvarChave(Chave chave) {
		chaveService.salvar(chave);
		return listaTodasChaves();

	}

	@GetMapping("/alterar/{id}")
	public ModelAndView alterarChave(@PathVariable("id") Integer idChave) {
		ModelAndView mView = new ModelAndView("chave/alteraChave");
		mView.addObject("chave", chaveService.buscarChaveID(idChave));
		return mView;

	}

	@PostMapping("/alterar")
	public ModelAndView alterar(Chave chaveAlterada) {
		chaveService.salvarAlteracao(chaveAlterada);
		return listaTodasChaves();
	}

	@GetMapping("/excluir/{id}")
	public ModelAndView excluirChave(@PathVariable("id") Integer id) {
		chaveService.excluir(id);
		return listaTodasChaves();
	}
}
