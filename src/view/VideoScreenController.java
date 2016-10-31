package view;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
import model.Content;
import application.SceneBuilder;
import extras.ContentSettings;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;

public class VideoScreenController {

	@FXML
	private Slider progress;

	@FXML
	private Slider volumeSlider;

	@FXML
	private MediaView mediaview;

	private MediaPlayer mediaPlayer;

	private Media media;
	
	private Duration duration;
	
	private Content cont;

	@FXML
	private Button play;

	@FXML
	private Label progressLabel;

	@FXML
	private Label nome;

	@FXML
	private Label descricao;

	@FXML
	private Label ano;

	@FXML
	private Label temporada;

	@FXML
	private Label episodio;

	@FXML
	private Label duracao;

	@FXML
	private Label categoria;

	@FXML
	private Label diretor;

	@FXML
	private Label atorprincipal;

	@FXML
	private Label faixaetaria;

	@FXML
	private void initialize() {
		media = ContentSettings.getMedia(cont);
		mediaPlayer = new MediaPlayer(media);
		mediaview.setMediaPlayer(mediaPlayer);
		initListener();
	}
	
	public static void setPath(String cont){
		
	}

	public VideoScreenController() {
	}


	public Slider getProgress() {
		return progress;
	}

	public void setProgress(Slider progress) {
		this.progress = progress;
	}

	public Media getMedia() {
		return media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}

	public Button getPlay() {
		return play;
	}

	public void setPlay(Button play) {
		this.play = play;
	}

	public Label getProgressLabel() {
		return progressLabel;
	}

	public void setProgressLabel(Label progressLabel) {
		this.progressLabel = progressLabel;
	}

	public Label getNome() {
		return nome;
	}

	public void setNome(Label nome) {
		this.nome = nome;
	}

	public Label getDescricao() {
		return descricao;
	}

	public void setDescricao(Label descricao) {
		this.descricao = descricao;
	}

	public Label getAno() {
		return ano;
	}

	public void setAno(Label ano) {
		this.ano = ano;
	}

	public Label getTemporada() {
		return temporada;
	}

	public void setTemporada(Label temporada) {
		this.temporada = temporada;
	}

	public Label getEpisodio() {
		return episodio;
	}

	public void setEpisodio(Label episodio) {
		this.episodio = episodio;
	}

	public Label getDuracao() {
		return duracao;
	}

	public void setDuracao(Label duracao) {
		this.duracao = duracao;
	}

	public Label getCategoria() {
		return categoria;
	}

	public void setCategoria(Label categoria) {
		this.categoria = categoria;
	}

	public Label getDiretor() {
		return diretor;
	}

	public void setDiretor(Label diretor) {
		this.diretor = diretor;
	}

	public Label getAtorprincipal() {
		return atorprincipal;
	}

	public void setAtorprincipal(Label atorprincipal) {
		this.atorprincipal = atorprincipal;
	}

	public Label getFaixaetaria() {
		return faixaetaria;
	}

	public void setFaixaetaria(Label faixaetaria) {
		this.faixaetaria = faixaetaria;
	}

	
	private void initListener() {
		mediaPlayer.currentTimeProperty().addListener(new InvalidationListener() {
			public void invalidated(Observable ov) {
				updateValues();
			}
		});

		mediaPlayer.setOnReady(new Runnable() {
			public void run() {
				duration = mediaPlayer.getMedia().getDuration();
				updateValues();
			}
		});

		progress.valueProperty().addListener(new InvalidationListener() {
			public void invalidated(Observable ov) {
				if (progress.isValueChanging()) {
					// multiply duration by percentage calculated by slider
					// position
					mediaPlayer.seek(duration.multiply(progress.getValue() / 100.0));
				}
			}
		});
		volumeSlider.valueProperty().addListener(new InvalidationListener() {
			public void invalidated(Observable ov) {
				if (volumeSlider.isValueChanging()) {
					mediaPlayer.setVolume(volumeSlider.getValue() / 100.0);
				}
			}
		});

	}

	@FXML
	private void handleMediaViewClick() {
		mediaPlayer.play();
	}

	@FXML
	private void handleContinue() {
		mediaPlayer.play();
	}

	@FXML
	private void handleStop() {
		mediaPlayer.stop();
	}

	@FXML
	private void handlePause() {
		mediaPlayer.pause();
	}

	@FXML
	public void handlerVoltar(){
		SceneBuilder.createHomePage();
	}
	
	@FXML
	private void handelSlider() {

	}

	protected void updateValues() {
		if (progressLabel != null && progress != null && volumeSlider != null) {
			Platform.runLater(new Runnable() {
				public void run() {
					Duration currentTime = mediaPlayer.getCurrentTime();
					progressLabel.setText(formatTime(currentTime, duration));
					progress.setDisable(duration.isUnknown());
					if (!progress.isDisabled() && duration.greaterThan(Duration.ZERO)
							&& !progress.isValueChanging()) {
						progress.setValue(currentTime.divide(duration.toMillis()).toMillis() * 100.0);
					}
					if (!volumeSlider.isValueChanging()) {
						volumeSlider.setValue((int) Math.round(mediaPlayer.getVolume() * 100));
					}
				}
			});
		}
	}

	private static String formatTime(Duration elapsed, Duration duration) {
		int intElapsed = (int) Math.floor(elapsed.toSeconds());
		int elapsedHours = intElapsed / (60 * 60);
		if (elapsedHours > 0) {
			intElapsed -= elapsedHours * 60 * 60;
		}
		int elapsedMinutes = intElapsed / 60;
		int elapsedSeconds = intElapsed - elapsedHours * 60 * 60 - elapsedMinutes * 60;

		if (duration.greaterThan(Duration.ZERO)) {
			int intDuration = (int) Math.floor(duration.toSeconds());
			int durationHours = intDuration / (60 * 60);
			if (durationHours > 0) {
				intDuration -= durationHours * 60 * 60;
			}
			int durationMinutes = intDuration / 60;
			int durationSeconds = intDuration - durationHours * 60 * 60 - durationMinutes * 60;
			if (durationHours > 0) {
				return String.format("%d:%02d:%02d/%d:%02d:%02d", elapsedHours, elapsedMinutes, elapsedSeconds,
						durationHours, durationMinutes, durationSeconds);
			} else {
				return String.format("%02d:%02d/%02d:%02d", elapsedMinutes, elapsedSeconds, durationMinutes,
						durationSeconds);
			}
		} else {
			if (elapsedHours > 0) {
				return String.format("%d:%02d:%02d", elapsedHours, elapsedMinutes, elapsedSeconds);
			} else {
				return String.format("%02d:%02d", elapsedMinutes, elapsedSeconds);
			}
		}
	}
}
