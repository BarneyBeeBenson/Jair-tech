package br.com.Jairtech.controller;

import javax.swing.JOptionPane;

import br.com.loja.Jairtech.view.LoginView;

public class LoginController {
	private LoginView view;
	private UsuarioModel model;
	
	public LoginController(LoginView view) {
		this.view= view;
		this.model = new UsuarioModel();
		if(model.conexao != null){
			System.out.println("Sim");
		} else {
			System.out.println("nÂo");
		}
		this.view.btnLogin.addActionListener(e -> logar());
	}

	private Object logar() {
		String login = view.textUsuario1.getText();
		String senha = new String(view.textSenha.getPassword());
		String perfil = model.autenticar(login,senha);
		
		if(perfil != null) {
			
		}else {
			JOptionPane.showMessageDialog(null, "Login ou senha inválidos");
		}
		return null;
	}

}


