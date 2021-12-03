package br.com.primeiroprojetospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.primeiroprojetospring.domain.Carro;
import br.com.primeiroprojetospring.service.AcessorioService;
import br.com.primeiroprojetospring.service.CarroService;
import br.com.primeiroprojetospring.service.ChaveService;
import br.com.primeiroprojetospring.service.DocumentoService;

@Controller
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

	@GetMapping("/listarCarros")
	public ModelAndView listaTodosCarros() {
		ModelAndView mView = new ModelAndView("carro/paginaListaCarros");
		mView.addObject("carros", carroService.buscarTodosCarros());
		return mView;

	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrarCarro() {
		ModelAndView mView = new ModelAndView("carro/cadastraCarro");
		mView.addObject("carro", new Carro());
		mView.addObject("chaves", chaveService.buscarTodasChaves());
		mView.addObject("documentos", documentoService.buscarTodosDocumentos());
		mView.addObject("acessorios", acessorioService.buscarTodosAcessorios());
		return mView;
	}

	@PostMapping("/salvar")
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
}
