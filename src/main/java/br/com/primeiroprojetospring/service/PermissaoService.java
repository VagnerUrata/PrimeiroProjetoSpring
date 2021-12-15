package br.com.primeiroprojetospring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.primeiroprojetospring.domain.Permissao;
import br.com.primeiroprojetospring.repository.PermissaoRepository;

@Service
public class PermissaoService {

	public static String INSERT;
	@Autowired
	private PermissaoRepository permissaoRepository;
	
	public Permissao salvar(Permissao permissao) {
		return permissaoRepository.save(permissao);
		
	}
}
