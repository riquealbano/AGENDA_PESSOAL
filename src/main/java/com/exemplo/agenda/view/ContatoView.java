package com.exemplo.agenda.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Classe responsável pela interface gráfica do sistema de contatos usando layout absoluto.
 */
public class ContatoView extends JFrame {

    private JTextField txtNome; // Campo de texto para o nome do contato
    private JTextField txtTelefone; // Campo de texto para o telefone do contato
    private JButton btnAdicionar; // Botão para adicionar um novo contato
    private JButton btnAtualizar; // Botão para atualizar um contato existente
    private JButton btnDeletar; // Botão para deletar um contato
    private JButton btnListar; // Botão para listar todos os contatos
    private JTable tabelaContatos; // Tabela para exibir os contatos
    private DefaultTableModel model; // Modelo da tabela

    /**
     * Construtor da classe ContatoView.
     * Configura os componentes da interface gráfica e organiza os elementos na janela.
     */
    public ContatoView() {
        setTitle("Agenda de Contatos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(null); // Definindo layout absoluto

        // Label e campo de texto para Nome
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(20, 20, 100, 25);
        add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(80, 20, 200, 25);
        add(txtNome);

        // Label e campo de texto para Telefone
        JLabel lblTelefone = new JLabel("Telefone:");
        lblTelefone.setBounds(20, 60, 100, 25);
        add(lblTelefone);

        txtTelefone = new JTextField();
        txtTelefone.setBounds(80, 60, 200, 25);
        add(txtTelefone);

        // Botões (Adicionar, Atualizar, Deletar, Listar)
        btnAdicionar = new JButton("Adicionar");
        btnAdicionar.setBounds(300, 20, 100, 25);
        add(btnAdicionar);

        btnAtualizar = new JButton("Atualizar");
        btnAtualizar.setBounds(410, 20, 100, 25);
        add(btnAtualizar);

        btnDeletar = new JButton("Deletar");
        btnDeletar.setBounds(300, 60, 100, 25);
        add(btnDeletar);

        btnListar = new JButton("Listar");
        btnListar.setBounds(410, 60, 100, 25);
        add(btnListar);

        // Tabela para listar os contatos
        tabelaContatos = new JTable();
        model = new DefaultTableModel(new Object[]{"ID", "Nome", "Telefone"}, 0);
        tabelaContatos.setModel(model);
        JScrollPane scrollPane = new JScrollPane(tabelaContatos);
        scrollPane.setBounds(20, 100, 540, 200);
        add(scrollPane);
    }

    /**
     * Obtém o campo de texto para o nome do contato.
     * 
     * @return O componente JTextField correspondente ao nome.
     */
    public JTextField getTxtNome() {
        return txtNome;
    }

    /**
     * Obtém o campo de texto para o telefone do contato.
     * 
     * @return O componente JTextField correspondente ao telefone.
     */
    public JTextField getTxtTelefone() {
        return txtTelefone;
    }

    /**
     * Obtém o botão para adicionar um novo contato.
     * 
     * @return O componente JButton para adicionar.
     */
    public JButton getBtnAdicionar() {
        return btnAdicionar;
    }

    /**
     * Obtém o botão para atualizar um contato existente.
     * 
     * @return O componente JButton para atualizar.
     */
    public JButton getBtnAtualizar() {
        return btnAtualizar;
    }

    /**
     * Obtém o botão para deletar um contato.
     * 
     * @return O componente JButton para deletar.
     */
    public JButton getBtnDeletar() {
        return btnDeletar;
    }

    /**
     * Obtém o botão para listar todos os contatos.
     * 
     * @return O componente JButton para listar.
     */
    public JButton getBtnListar() {
        return btnListar;
    }

    /**
     * Obtém a tabela que exibe os contatos.
     * 
     * @return O componente JTable que exibe os contatos.
     */
    public JTable getTabelaContatos() {
        return tabelaContatos;
    }

    /**
     * Obtém o modelo da tabela de contatos.
     * 
     * @return O DefaultTableModel utilizado pela tabela.
     */
    public DefaultTableModel getModel() {
        return model;
    }
}
