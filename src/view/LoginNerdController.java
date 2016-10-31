package view;

import application.SceneBuilder;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.User;
import model.dao.UserDao;

public class LoginNerdController {

	@FXML
	TextField usuario;

	@FXML
	PasswordField senha;

	@FXML
	Button cadastrar;

	@FXML
	Button logar;

	@FXML
	public void handlerLogar() {
		User u = new UserDao().findUser(usuario.getText());
		if (u != null) {
			if (u.getSenha().equals(senha.getText())) {
				if (u.getRole().equals("admin")){
					SceneBuilder.createHomePageADM();
				}else
					SceneBuilder.createHomePage();
			}

		} else
			System.out.println("erro");
	}

	@FXML
	public void handlerCadastrar() {
		SceneBuilder.createCadastro();

	}
}
