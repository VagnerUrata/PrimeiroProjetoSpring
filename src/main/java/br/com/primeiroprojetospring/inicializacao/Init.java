package br.com.primeiroprojetospring.inicializacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.primeiroprojetospring.domain.Acessorio;
import br.com.primeiroprojetospring.domain.Aluno;
import br.com.primeiroprojetospring.domain.Chave;
import br.com.primeiroprojetospring.domain.Documento;
import br.com.primeiroprojetospring.domain.Fabricante;
import br.com.primeiroprojetospring.domain.Professor;
import br.com.primeiroprojetospring.service.AcessorioService;
import br.com.primeiroprojetospring.service.AlunoService;
import br.com.primeiroprojetospring.service.ChaveService;
import br.com.primeiroprojetospring.service.DocumentoService;
import br.com.primeiroprojetospring.service.FabricanteService;
import br.com.primeiroprojetospring.service.ProfessorService;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private AlunoService alunoService;

	@Autowired
	private ProfessorService professorService;

	@Autowired
	private FabricanteService fabricanteService;

	@Autowired
	private ChaveService chaveService;

	@Autowired
	private AcessorioService acessorioService;

	@Autowired
	private DocumentoService documentoService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		Aluno aluno1 = new Aluno();
		aluno1.setNome("Paulo");
		alunoService.salvar(aluno1);

		Aluno aluno2 = new Aluno();
		aluno2.setNome("Roberta");
		alunoService.salvar(aluno2);

		Aluno aluno3 = new Aluno();
		aluno3.setNome("Paula");
		alunoService.salvar(aluno3);

		List<Aluno> listaAluno = alunoService.buscarTodosAlunos();

		for (Aluno aluno : listaAluno) {
			System.out.println(aluno.getNome());
		}

		Professor professor1 = new Professor();
		professor1.setNome("Kleber");
		professorService.salvar(professor1);

		Professor professor2 = new Professor();
		professor2.setNome("Laura");
		professorService.salvar(professor2);

		Professor professor3 = new Professor();
		professor3.setNome("Claudio");
		professorService.salvar(professor3);

		List<Professor> listaProfessor = professorService.buscarTodosProfessores();

		for (Professor professor : listaProfessor) {
			System.out.println(professor.getNome());
		}

		Chave chave1 = new Chave();
		chave1.setCodigo("15421");
		chaveService.salvar(chave1);

		Chave chave2 = new Chave();
		chave2.setCodigo("66564");
		chaveService.salvar(chave2);

		Chave chave3 = new Chave();
		chave3.setCodigo("33321");
		chaveService.salvar(chave3);

		Chave chave4 = new Chave();
		chave4.setCodigo("2333");
		chaveService.salvar(chave4);

		Fabricante f1 = new Fabricante();
		f1.setNome("FIAT");
		f1.setPais("ITALIA");
		fabricanteService.salvar(f1);

		Fabricante f2 = new Fabricante();
		f2.setNome("BMW");
		f2.setPais("ALEMANHA");
		fabricanteService.salvar(f2);

		Fabricante f3 = new Fabricante();
		f3.setNome("OPEL");
		f3.setPais("EUA");
		fabricanteService.salvar(f3);

		Documento doc1 = new Documento();
		doc1.setCodigo("1232");
		doc1.setNome("ABC");
		documentoService.salvar(doc1);

		Documento doc2 = new Documento();
		doc2.setCodigo("33321");
		doc2.setNome("ASS");
		documentoService.salvar(doc2);

		Documento doc3 = new Documento();
		doc3.setCodigo("3468");
		doc3.setNome("PPA");
		documentoService.salvar(doc3);

		Acessorio a1 = new Acessorio();
		a1.setNome("Teto Solar");
		acessorioService.salvar(a1);

		Acessorio a2 = new Acessorio();
		a2.setNome("Vidro Eletrico");
		acessorioService.salvar(a2);

		Acessorio a3 = new Acessorio();
		a3.setNome("Banco Couro");
		acessorioService.salvar(a3);

	}

}
