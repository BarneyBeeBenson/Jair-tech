package br.com.Jairtech.controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.loja.Jairtech.view.LoginView;

public class LoginController {
	private LoginView view;
	private LoginDAO model;
	
	public LoginController() {
		
	}
	
	public Boolean verificarBancoOnline() throws SQLException {
		LoginDAO dao = new LoginDAO();
		return dao.bancoOnline();
		
	}

	

}


