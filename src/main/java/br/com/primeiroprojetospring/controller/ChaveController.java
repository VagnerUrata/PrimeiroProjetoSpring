package br.com.primeiroprojetospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.primeiroprojetospring.domain.Chave;
import br.com.primeiroprojetospring.service.ChaveService;

@Controller
@RequestMapping("chave")
public class ChaveController {

	@Autowired
	private ChaveService chaveService;

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
