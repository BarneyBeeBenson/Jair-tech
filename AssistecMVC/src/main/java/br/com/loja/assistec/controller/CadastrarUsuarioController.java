package br.com.loja.assistec.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.loja.assistec.model.Usuario;
import br.com.loja.assistec.model.UsuarioDAO;
import br.com.loja.assistec.view.CadastrarUsuariosView;
import br.com.loja.assistec.view.MensagemView;

public class CadastrarUsuarioController {
	private CadastrarUsuariosView cadastrarView;
	private ListarUsuarioController listarController;
	private Usuario usuarioSelecionado;
	
	public CadastrarUsuarioController(
			ListarUsuarioController listarUsuariosController,
			Usuario user) {
		this.usuarioSelecionado = user;
		this.listarController = listarUsuariosController;
		cadastrarView = new CadastrarUsuariosView(user);
		cadastrarView.setLocationRelativeTo(null);
		cadastrarView.setVisible(true);
		configurarListeners();
	}

	private void configurarListeners() {
		cadastrarView.addCadastrarUsuariosListener(new CadastrarUsuariosListener());
		cadastrarView.addWindowListener(new WindowAdapter(){
			
			@Override
			public void windowOpened(WindowEvent e) {
				if(usuarioSelecionado != null) {
					cadastrarView.preencherCampos(usuarioSelecionado);;
					cadastrarView.habilitarBotaoExcluir(true);
				}
			}
			
		});
	}
	
	private class CadastrarUsuariosListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			switch(e.getActionCommand()) {
			case "BotaoFecharAction":
				cadastrarView.dispose();
				break;
			case "BotaoExcluirAction":
				Excluir();
				break;
			case "BotaoIncluirAction":
				try {
					NovoOuAlterar();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			default:
				break;
			}
		}

		private void NovoOuAlterar() throws SQLException {
			String perfil = (String) cadastrarView.getPerfilSelecionado();
			if(usuarioSelecionado == null) {
				salvar(cadastrarView.getNome(), cadastrarView.getFone(), cadastrarView.getLogin(), cadastrarView.getSenha(), perfil);
				new MensagemView("Registro Inserido com sucesso", 3);
			}else {
				alterar(usuarioSelecionado.getIduser(), cadastrarView.getNome(), cadastrarView.getFone(), cadastrarView.getLogin(), 
						cadastrarView.getSenha(), perfil);
			}
		
			cadastrarView.dispose();
			atualizarListaUsuarios();
		}
		
		private void alterar (long iduser, String nome, String fone, String login, String senha, String perfil) throws SQLException {
			Usuario usuario= new Usuario(iduser, nome, fone, login, senha, perfil);
			new UsuarioDAO().salvar(usuario);
		}
		
		private void salvar(String nome, String fone, String login, String senha, String perfil) throws SQLException {
			Usuario usuario = new Usuario(nome, fone, login, senha, perfil);
			new UsuarioDAO().salvar(usuario);
		}
		
	}
	
	private void Excluir() {
		MensagemView mv = new MensagemView("Tem certeza que qeur excluir?");
		int confirmacao = mv.getResposta();
		if(confirmacao == 1) {
			try {
				excluir(usuarioSelecionado.getIduser());
				cadastrarView.dispose();
				atualizarListaUsuarios();
				new MensagemView("Usuario excluido", 3);
			} catch (SQLException e) {
				new MensagemView("Erro ao excluir o usuario", 0);
				e.printStackTrace();
			}
		}
	}

	private void atualizarListaUsuarios() throws SQLException {
		ArrayList<Usuario> novosUsuarios = listarController.listarUsuarios();
		listarController.atualizarTabela(novosUsuarios);
	}

	private void excluir(long iduser) throws SQLException {
		new UsuarioDAO().excluir(iduser);
	}

}
