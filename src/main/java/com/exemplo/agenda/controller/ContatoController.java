package com.exemplo.agenda.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import com.exemplo.agenda.model.Contato;
import com.exemplo.agenda.model.ContatoModel;
import com.exemplo.agenda.view.ContatoView;

/**
 * Classe responsável por controlar a interação entre a View e o Model.
 * Gerencia as ações dos botões e manipula os dados relacionados aos contatos.
 */
public class ContatoController {

    /** A interface gráfica (View) associada ao controle. */
    private ContatoView view;

    /** O modelo (Model) responsável pelas operações com dados. */
    private ContatoModel model;

    /**
     * Construtor da classe ContatoController.
     * Inicializa as referências para a View e o Model e configura os eventos.
     *
     * @param view A interface gráfica que será controlada.
     * @param model O modelo responsável pelos dados dos contatos.
     */
    public ContatoController(ContatoView view, ContatoModel model) {
        this.view = view;
        this.model = model;
        inicializarAcoes();
    }

    /**
     * Método que configura os listeners para os botões na interface gráfica.
     */
    private void inicializarAcoes() {

        // Listener para o botão de adicionar
        /**
         * Configura a ação para o botão "Adicionar".
         * Valida os campos de entrada e adiciona um novo contato.
         */
        view.getBtnAdicionar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = view.getTxtNome().getText();
                String telefone = view.getTxtTelefone().getText();

                if (nome.isEmpty() || telefone.isEmpty()) {
                    JOptionPane.showMessageDialog(view, "Nome e telefone não podem estar vazios!");
                    return;
                }

                model.adicionarContato(nome, telefone);
                JOptionPane.showMessageDialog(view, "Contato adicionado com sucesso!");
            }
        });

        // Listener para o botão de atualizar
        /**
         * Configura a ação para o botão "Atualizar".
         * Atualiza os dados de um contato selecionado na tabela.
         */
        view.getBtnAtualizar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = view.getTabelaContatos().getSelectedRow();

                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(view, "Selecione um contato para atualizar.");
                    return;
                }

                int id = Integer.parseInt(view.getModel().getValueAt(selectedRow, 0).toString());
                String nome = view.getTxtNome().getText();
                String telefone = view.getTxtTelefone().getText();

                if (nome.isEmpty() || telefone.isEmpty()) {
                    JOptionPane.showMessageDialog(view, "Nome e telefone não podem estar vazios!");
                    return;
                }

                model.atualizarContato(id, nome, telefone);
                JOptionPane.showMessageDialog(view, "Contato atualizado com sucesso!");
            }
        });

        // Listener para o botão de deletar
        /**
         * Configura a ação para o botão "Deletar".
         * Remove o contato selecionado da tabela e do banco de dados.
         */
        view.getBtnDeletar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = view.getTabelaContatos().getSelectedRow();

                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(view, "Selecione um contato para deletar.");
                    return;
                }

                int id = Integer.parseInt(view.getModel().getValueAt(selectedRow, 0).toString());
                model.deletarContato(id);
                JOptionPane.showMessageDialog(view, "Contato deletado com sucesso!");
            }
        });

        // Listener para o botão de listar
        /**
         * Configura a ação para o botão "Listar".
         * Atualiza a tabela com todos os contatos disponíveis.
         */
        view.getBtnListar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Contato> contatos = model.listarContatos();

                // Limpa a tabela antes de adicionar os novos dados
                view.getModel().setRowCount(0);

                // Adiciona os contatos na tabela
                for (Contato contato : contatos) {
                    view.getModel().addRow(new Object[] {
                        contato.getId(),
                        contato.getNome(),
                        contato.getTelefone()
                    });
                }
            }
        });
    }
}
