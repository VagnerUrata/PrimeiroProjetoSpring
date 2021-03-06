package br.com.primeiroprojetospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.primeiroprojetospring.domain.Professor;
import br.com.primeiroprojetospring.service.ProfessorService;

@Controller
@RequestMapping("professor")
public class ProfessorController {

	@Autowired
	private ProfessorService professorService;

	@GetMapping("/listarProfessores")
	public ModelAndView listaTodosProfessores() {
		ModelAndView mView = new ModelAndView("professor/paginaListaProfessores");
		mView.addObject("professores", professorService.buscarTodosProfessores());
		return mView;

	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrarProfessor() {
		ModelAndView mView = new ModelAndView("professor/cadastraProfessor");
		mView.addObject("professor", new Professor());
		return mView;
	}

	@PostMapping("/salvar")
	public ModelAndView salvarProfessor(Professor professor) {
		professorService.salvar(professor);
		return listaTodosProfessores();
	}

	@GetMapping("/alterar/{id}")
	public ModelAndView alterarProfessor(@PathVariable("id") Integer idProfessor) {
		ModelAndView mView = new ModelAndView("professor/alteraProfessor");
		mView.addObject("professor", professorService.buscarPorID(idProfessor));
		return mView;

	}

	@PostMapping("/alterar")
	public ModelAndView alterar(Professor professorAlterado) {
		professorService.salvarAlteracao(professorAlterado);
		return listaTodosProfessores();
	}

	@GetMapping("/excluir/{id}")
	public ModelAndView excluirProfessor(@PathVariable("id") Integer id) {
		professorService.excluir(id);
		return listaTodosProfessores();
	}
}
