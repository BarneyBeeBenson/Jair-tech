package br.com.loja.Assistec.controle;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.loja.Assistec.modelo.Usuario;
import br.com.loja.Assistec.modelo.UsuarioDAO;

public class UsuarioController {

	public UsuarioController() {
		
	}

	public ArrayList<Usuario> listarUsuarios() throws SQLException {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.selecionarUsuarios();
		

	}
	public void salvar (String nome, String fone, String login, String senha, String perfil) {
		Usuario usu = new Usuario();
		usu.setNome(nome);
		usu.setFone(fone);
		usu.setLogin(login);
		usu.setSenha(senha);
		usu.setPerfil(perfil);
	}

}
