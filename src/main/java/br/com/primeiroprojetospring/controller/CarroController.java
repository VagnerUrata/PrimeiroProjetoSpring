package br.com.primeiroprojetospring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.primeiroprojetospring.domain.Carro;
import br.com.primeiroprojetospring.service.AcessorioService;
import br.com.primeiroprojetospring.service.CarroService;
import br.com.primeiroprojetospring.service.ChaveService;
import br.com.primeiroprojetospring.service.DocumentoService;
import br.com.primeiroprojetospring.service.FabricanteService;

@RestController
@RequestMapping("carro")
public class CarroController {

	@Autowired
	private CarroService carroService;

	@Autowired
	private ChaveService chaveService;

	@Autowired
	private DocumentoService documentoService;

	@Autowired
	private AcessorioService acessorioService;

	@Autowired
	private FabricanteService fabricanteService;

	@GetMapping("/listarCarros")
	public ModelAndView listaTodosCarros() {
		ModelAndView mView = new ModelAndView("carro/paginaListaCarros");
		mView.addObject("carros", carroService.buscarTodosCarros());
		return mView;

	}

	@GetMapping("/cadastrar")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ModelAndView cadastrarCarro() {
		ModelAndView mView = new ModelAndView("carro/cadastraCarro");
		mView.addObject("carro", new Carro());
		mView.addObject("chaves", chaveService.buscarTodasChaves());
		mView.addObject("documentos", documentoService.buscarTodosDocumentos());
		mView.addObject("acessorios", acessorioService.buscarTodosAcessorios());
		mView.addObject("fabricantes", fabricanteService.buscarTodosFabricantes());
		return mView;
	}

	@PostMapping("/salvar")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ModelAndView salvarCarro(Carro carro) {
		carroService.salvar(carro);
		return listaTodosCarros();

	}

	@GetMapping("/alterar/{id}")
	public ModelAndView alterarCarro(@PathVariable("id") Integer idCarro) {
		ModelAndView mView = new ModelAndView("carro/alteraCarro");
		mView.addObject("carro", carroService.buscarPorID(idCarro));
		mView.addObject("chaves", chaveService.buscarTodasChaves());
		mView.addObject("documentos", documentoService.buscarTodosDocumentos());
		mView.addObject("acessorios", acessorioService.buscarTodosAcessorios());
		mView.addObject("fabricantes", fabricanteService.buscarTodosFabricantes());
		return mView;

	}

	@PostMapping("/alterar")
	public ModelAndView alterar(Carro carroAlterado) {
		carroService.salvarAlteracao(carroAlterado);
		return listaTodosCarros();
	}

	@GetMapping("/excluir/{id}")
	public ModelAndView excluirChave(@PathVariable("id") Integer id) {
		carroService.excluir(id);
		return listaTodosCarros();
	}
	
	@GetMapping("/buscarCarrosComTetoSolar")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<Carro>> buscarCarrosComTetoSolar() {
		return ResponseEntity.ok().body(carroService.buscarCarrosComTetoSolar());
	}
}
