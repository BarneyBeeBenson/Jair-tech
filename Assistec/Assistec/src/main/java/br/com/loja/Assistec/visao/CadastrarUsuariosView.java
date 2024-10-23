package br.com.loja.Assistec.visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextField;

import br.com.loja.Assistec.controle.UsuarioController;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class CadastrarUsuariosView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtNome;
	private JTextField txtFone;
	private JTextField txtLogin;
	private JPasswordField txtSenha;
	public JComboBox<String> cbPerfil;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarUsuariosView frame = new CadastrarUsuariosView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public CadastrarUsuariosView() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel painelCima = new JPanel();
		getContentPane().add(painelCima, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Cadastro Usuários");
		painelCima.add(lblNewLabel);
		
		JPanel painelCentro = new JPanel();
		getContentPane().add(painelCentro, BorderLayout.SOUTH);
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!"".equalsIgnoreCase(txtLogin.getText())&& !"".equalsIgnoreCase(new String(txtSenha.getPassword()))
						 ) {
					UsuarioController uc = new UsuarioController();
					String perfil = (String) cbPerfil.getSelectedItem();
					uc.salvar(txtNome.getText(), txtFone.getText(), txtLogin.getText(), 
							new String(txtSenha.getPassword()),perfil);
				}
			}
		});
		painelCentro.add(btnIncluir);
		
		JButton btnExcluir = new JButton("Excluit");
		painelCentro.add(btnExcluir);
		
		JButton btnFechar = new JButton("Vasco");
		painelCentro.add(btnFechar);
		
		JPanel painelBaixo = new JPanel();
		getContentPane().add(painelBaixo, BorderLayout.CENTER);
		painelBaixo.setLayout(new GridLayout(6, 2, 0, 0));
		
		JLabel lblNome = new JLabel("Nome");
		painelBaixo.add(lblNome);
		
		txtNome = new JTextField();
		painelBaixo.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblFone = new JLabel("Fone");
		painelBaixo.add(lblFone);
		
		txtFone = new JTextField();
		painelBaixo.add(txtFone);
		txtFone.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login");
		painelBaixo.add(lblLogin);
		
		txtLogin = new JTextField();
		painelBaixo.add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senhas");
		painelBaixo.add(lblSenha);
		
		txtSenha = new JPasswordField();
		painelBaixo.add(txtSenha);
		
		JLabel lblPerfil = new JLabel("Perfil");
		painelBaixo.add(lblPerfil);
		
		cbPerfil = new JComboBox();
		painelBaixo.add(cbPerfil);

	}

}
