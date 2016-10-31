package view;

import application.SceneBuilder;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import model.User;
import model.dao.UserDao;

public class CadastroNerdController {

	@FXML
	TextField usuario;

	@FXML
	PasswordField senha;

	@FXML
	TextField idade;

	@FXML
	TextField nome;

	@FXML
	ChoiceBox cb = new ChoiceBox();

	@FXML
	public void initialize() {
		cb.setItems(FXCollections.observableArrayList("Admin", "User"));
	}

	@FXML
	public void handlercadastra() {
		User novo = new User();
		novo.setLogin(usuario.getText());
		novo.setSenha(senha.getText());
		novo.setIdade(Integer.parseInt(idade.getText()));
		novo.setNome(nome.getText());
		if(cb.getSelectionModel().getSelectedIndex() == 0)
		novo.setRole("admin");
		else
			novo.setRole("user");
		new UserDao().save(novo);

		SceneBuilder.createLogin();
	}

	@FXML
	public void handlervoltar() {
		SceneBuilder.createLogin();
	}

}
