package view;

import application.SceneBuilder;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import model.Content;
import model.User;
import model.dao.ContentDao;
import model.dao.UserDao;

public class CadastroNewContentController {

	@FXML
	TextField nome;

	@FXML
	TextField atorP;

	@FXML
	TextField diretor;

	@FXML
	TextField faixaEt;

	@FXML
	TextField caminho;

	

	@FXML
	public void handlercadastra() {
		Content novo = new Content();
		novo.setNome(nome.getText());
		novo.setAtor(atorP.getText());
		novo.setDiretor(diretor.getText());
		novo.setFaixaEtaria(Integer.parseInt(faixaEt.getText()));
		novo.setVideopath(caminho.getText());
		new ContentDao().save(novo);

		SceneBuilder.createHomePageADM();
	}

	@FXML
	public void handlervoltar() {
		SceneBuilder.createHomePageADM();
	}

}
