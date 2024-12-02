package com.exemplo.agenda.model;

import javax.persistence.*;
import java.util.List;

/**
 * Classe responsável por realizar as operações de CRUD usando EntityManager.
 */
public class ContatoModel {
	
	private EntityManagerFactory emf;
    private EntityManager em;

    /**
     * Construtor que recebe um EntityManager externo (para injeção de dependência ou uso direto).
     * @param em EntityManager fornecido para realizar operações.
     */
    public ContatoModel() {
    	emf = Persistence.createEntityManagerFactory("agendaPU");
        em = emf.createEntityManager();
    }

    /**
     * Método para adicionar um contato ao banco de dados.
     * @param contato Objeto Contato a ser adicionado.
     */
    public void adicionarContato(String nome, String telefone) {
    	Contato contato = new Contato();
    	contato.setNome(nome);
    	contato.setTelefone(telefone);
    	
        try {
            em.getTransaction().begin();
            em.persist(contato);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    /**
     * Método para atualizar um contato no banco de dados.
     * @param contato Objeto Contato com os dados atualizados.
     */
    public void atualizarContato(int id, String nome, String telefone) {
    	Contato contato = em.find(Contato.class, id);
    	if (contato != null) {
    		try {
	            em.getTransaction().begin();
	            contato.setNome(nome);
	            contato.setTelefone(telefone);
	            em.getTransaction().commit();
	        } catch (Exception e) {
	            em.getTransaction().rollback();
	            e.printStackTrace();
	    	}
        }
    }

    /**
     * Método para deletar um contato do banco de dados.
     * @param id ID do contato a ser deletado.
     */
    public void deletarContato(int id) {
    	Contato contato = em.find(Contato.class, id);
    	if (contato != null) {
    		try {
	            em.getTransaction().begin();
	            em.remove(contato);
	            em.getTransaction().commit();
	        } catch (Exception e) {
	            em.getTransaction().rollback();
	            e.printStackTrace();
	        }
        }
    }

    /**
     * Método para buscar um contato por ID.
     * @param id ID do contato a ser buscado.
     * @return Objeto Contato encontrado ou null se não existir.
     */
    public Contato buscarContatoPorId(int id) {
        return em.find(Contato.class, id);
    }

    /**
     * Método para listar todos os contatos do banco de dados.
     * @return Lista de objetos Contato.
     */
    public List<Contato> listarContatos() {
        try {
            return em.createQuery("FROM Contato", Contato.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
