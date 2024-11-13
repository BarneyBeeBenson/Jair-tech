package br.com.loja.assistec.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import br.com.loja.assistec.model.Usuario;
import br.com.loja.assistec.view.ListarUsuariosView;

public class ListarUsuariosController {
	private ListarUsuariosView listarView;
	
	public ListarUsuariosController() {
		listarView = new ListarUsuariosView();
		listarView.setLocationRelativeTo(null);
		listarView.setVisible(true);
		
		confiurarListeners();
		carregarUsuarios();
		
	}

	private void carregarUsuarios() {
		// TODO Auto-generated method stub
		
	}

	private void confiurarListeners() {
		listarView.addListarUsuariosListener(new ListarUsuariosListener());
		listarView.addWindowListener(new JanelaAberturaListener());
		
	}
	
	private class ListarUsuariosListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String comando = e.getActionCommand();
			switch (comando) {
			case "BotaoCadastrarAction":
				abrirCadastroUsuario(null);
				break;
			case "BotaoFecharAction":
				listarView.dispose();
				break;
				default:
					break;
			}
			
		}
		
	}
	
	public void abrirCadastroUsuario (Usuario usuarioSelecionado) {
		//new CadastroUsuarioController(this, usuarioSelecionado);
		
	}
	
	private class JanelaAberturaListener extends WindowAdapter{
		public void windowOpened(WindowEvent e) {
			carregarUsuarios();
		}
	}
	
	

}
