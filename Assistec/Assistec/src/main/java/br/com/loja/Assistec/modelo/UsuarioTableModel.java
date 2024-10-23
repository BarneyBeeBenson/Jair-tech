package br.com.loja.Assistec.modelo;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class UsuarioTableModel  extends AbstractTableModel{

private static final String[] colunas  = { "ID", "Nome", "Telefone", "Login", "Perfil"};
private ArrayList<Usuario> usuariosList;
private static final long serialVersionUID = 1L;



public  UsuarioTableModel (ArrayList<Usuario> usuarios) {
	this.usuariosList = usuarios;
}
	
	@Override
	public int getRowCount() {
		
		return usuariosList.size();
	}

	@Override
	public int getColumnCount() {


		return colunas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Usuario usuario = usuariosList.get(rowIndex);
		if(columnIndex  == 0) {
			return usuario.getIduser();
		}else if(columnIndex == 1) {
			return usuario.getNome();
		}else if(columnIndex == 2) {
			return usuario.getFone();
		}else if(columnIndex == 1) {
			return usuario.getLogin();
		}else if(columnIndex == 1) {
			return usuario.getPerfil();
		}else {
			return null;
		}
		
	}
	
	public String getColunmName(int coluna){
		return colunas[coluna];
	}

}
