package br.com.primeiroprojetospring.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import br.com.primeiroprojetospring.domain.Carro;
import br.com.primeiroprojetospring.domain.QCarro;

@Repository
public class CarroDAO {

	@Autowired
	private EntityManager em;

	private QCarro carro = QCarro.carro;
//  privateQFabricante fabricante = Qfabricante.fabricante;

	private final String TETO_SOLAR = "Teto solar";

	public List<Carro> buscarCarroPorIdFabricante(Integer idFabricante) {

// new JPAQueryFactory(em).selectFrom(carro).innerJoin(carro.fabricanteCarro, fabricante).where(fabricante.id.eq(idFabricante));

		return new JPAQueryFactory(em).selectFrom(carro).where(carro.fabricanteCarro.id.eq(idFabricante)).fetch();
	}

	public List<Carro> buscarCarroPorIdChave(Integer idChave) {
		return new JPAQueryFactory(em).selectFrom(carro).where(carro.chaveCarro.id.eq(idChave)).fetch();
	}

	public List<Carro> buscarCarrosComTetoSolar() {
		return new JPAQueryFactory(em).selectFrom(carro).where(carro.acessorios.any().nome.equalsIgnoreCase(TETO_SOLAR))
				.fetch();
	}
}
