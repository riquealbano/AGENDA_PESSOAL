package com.exemplo.agenda;

import javax.swing.SwingUtilities;

import com.exemplo.agenda.controller.ContatoController;
import com.exemplo.agenda.model.ContatoModel;
import com.exemplo.agenda.view.ContatoView;

/**
 * Classe principal que inicializaa aplicação Agenda de Contatos.
 * Responsável por criar as instâncias dos componentes MVC e inicair a interface
 * 
 * @author Henrique Albano
 * @version 1.0
 */

public class AgendaContatos {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			ContatoView view = new ContatoView();
			ContatoModel model = new ContatoModel();
			new ContatoController(view, model);
			
			view.setVisible(true);
		});
	}
}
