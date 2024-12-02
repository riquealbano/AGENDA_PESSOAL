package com.exemplo.agenda.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe que representa um contato na agenda.
 * Contém os atributos ID, Nome e Telefone, além de seus métodos de acesso (getters e setters).
 */
@Entity
@Table(name="contatos")

public class Contato {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Identificador único do contato
    private String nome; // Nome do contato
    private String telefone; // Telefone do contato

    /**
     * Obtém o identificador único do contato.
     * 
     * @return O ID do contato.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador único do contato.
     * 
     * @param id O novo ID do contato.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém o nome do contato.
     * 
     * @return O nome do contato.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do contato.
     * 
     * @param nome O novo nome do contato.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o telefone do contato.
     * 
     * @return O telefone do contato.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o telefone do contato.
     * 
     * @param telefone O novo telefone do contato.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
