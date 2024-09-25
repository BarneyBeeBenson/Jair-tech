package br.com.loja.Jairtech;

import br.com.Jairtech.controller.LoginController;
import br.com.loja.Jairtech.view.LoginView;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
    	LoginView view = new LoginView();
    	@SuppressWarnings("unused")
    	LoginController controller = new LoginController(view);
    	view.setVisible(true);
    	
        
    }
}
