

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

public class Main {

	public static void main(String[] args) {
		
		
		EntityManager em = Persistence.createEntityManagerFactory("20170524_unit").createEntityManager();
		em.getTransaction().begin();
//		Inserção simples de um registro de PROJETO e PESSOA e DOCUMENTO e ATIVIDADE
		
		//List<Documento> documentos = new ArrayList<>();
		Documento documento = new Documento();
		documento.setNumero("1001");
		documento.setTipo("CPP");
		//documentos.add(documento);
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Pessoa1");
		pessoa.setMatricula("MAT01");
		pessoa.setNascimento(new Date());
		pessoa.setRamal("C31");
		pessoa.setSexo('M');
		pessoa.setTelefone("99998819");
		pessoa.setDocumento(documento);
		em.persist(pessoa);
		em.flush();
		
		Projeto projeto = new Projeto();
		projeto.setNome("Projeto 1");
		projeto.setNumero(100);
		projeto.setOrcamento(100.0001f);
		projeto.setDuracao(100);
		projeto.setInicio(new Date());
		projeto.setPessoa(pessoa);
		em.persist(projeto);
		em.flush();
		
		Etapa etapa = new Etapa();
		etapa.setNome("Etapa01");
		etapa.setInicioPrevisto(new Date());
		etapa.setTerminoPrevisto(new Date());
		etapa.setProjeto(projeto);
		em.persist(etapa);
		em.flush();
		
		Atividade atividade = new Atividade();
		atividade.setNome("Atividade01");
		atividade.setInicioPrevisto(new Date());
		atividade.setTerminoPrevisto(new Date());
		atividade.setDuracao(100);
		atividade.setEtapa(etapa);
		List<Pessoa> pessoas = new ArrayList<>();
		pessoas.add(pessoa);
		atividade.setPessoas(pessoas);
		em.persist(atividade);
		em.flush(); 

		em.getTransaction().commit();
		em.close();
		
		
		EntityManager em2 = Persistence.createEntityManagerFactory("20170524_unit").createEntityManager();	
//		Busca do registro inserido
		TypedQuery<Projeto> query2 = em2.createQuery("select p from Projeto p where p.numero = 100", Projeto.class);
		List<Projeto> projetos = query2.getResultList();
		System.out.println(projetos);
		em2.close();
		
//		EntityManager em3 = Persistence.createEntityManagerFactory("20170524_unit").createEntityManager();	
////		Busca do registro inserido e alterando valor
//		em3.getTransaction().begin();
//		TypedQuery<Projeto> query3 = em3.createQuery("select p from Projeto p ", Projeto.class);
//		List<Projeto> projetos3 = query3.getResultList();
//		Projeto projeto = projetos.get(0);
//		projeto.setNome("NomeAlterado");
//		em3.merge(projeto);
//		em3.getTransaction().commit();
//		em3.close();
		
//		EntityManager em4 = Persistence.createEntityManagerFactory("20170524_unit").createEntityManager();	
////		Busca do registro e deletado este
//		em4.getTransaction().begin();
//		TypedQuery<Pessoa> query4 = em4.createQuery("select p from Pessoa p ", Pessoa.class);
//		List<Pessoa> pessoas4 = query4.getResultList();
//		em4.remove(pessoas4.get(0));
//		em4.getTransaction().commit();
//		em4.close();
	}

}
