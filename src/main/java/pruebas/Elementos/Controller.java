package pruebas.Elementos;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.jbox2d.common.Vec2;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

public class Controller implements Initializable {

	boolean derecha, izquierda, arriba, abajo;
	int x,y;

	// logic

	private GamePrueba game;

	// view

	@FXML
	private BorderPane view;

	@FXML
	private Canvas canvas;

	public Controller() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/GameView.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		game = new GamePrueba(canvas);
		// game.fpsProperty().addListener((o, ov, nv) -> System.out.println(nv +
		// "fps"));
		game.start();
		gestionEventos();

	}

	public BorderPane getView() {
		return view;
	}

	private void gestionEventos() {
		/* implementar para pruebas con el mapa */

		canvas.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent evento) {
				switch (evento.getCode().toString()) {
				case "RIGHT":
					derecha = true;
					x = 120;
					mover();
					break;
				case "LEFT":
					izquierda = true;
					x = -120;
					mover();
					break;
				case "UP":
					arriba = true;
					y = -120;
					mover();
					break;
				case "DOWN":
					abajo = true;
					y = 120;
					mover();
					break;
				}

			}
		});

		canvas.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent evento) {
				switch (evento.getCode().toString()) {
				case "RIGHT":
					derecha = false;
					x = 0;
					parar();
					break;
				case "LEFT":
					izquierda = false;
					x = 0;
					parar();
					break;
				case "UP":
					arriba = false;
					y = 0;
					parar();
					break;
				case "DOWN":
					abajo = false;
					y = 0;
					parar();
					break;
				}
			}
		});

	}

	public void mover() {


		if (derecha) {		
//			float desiredVel =  new Vec2(x,y);
			game.getCp().getBodyF().applyLinearImpulse(new Vec2(x,y), new Vec2(game.getCp().getBodyF().getWorldCenter()));	
			//game.getWorld().getWorldF().setGravity(new Vec2(0.1f, 10f));
		}

		if (izquierda) {
			game.getCp().getBodyF().applyLinearImpulse(new Vec2(x,y), new Vec2(game.getCp().getBodyF().getWorldCenter()));
			//game.getWorld().getWorldF().setGravity(new Vec2(-0.1f, 10f));
		}

		if (arriba) {
			game.getCp().getBodyF().applyLinearImpulse(new Vec2(x,y), new Vec2(game.getCp().getBodyF().getWorldCenter()));
			//game.getWorld().getWorldF().setGravity(new Vec2(0f, -10f));
		}
		
		if (abajo) {
			game.getCp().getBodyF().applyLinearImpulse(new Vec2(x,y), new Vec2(game.getCp().getBodyF().getWorldCenter()));
			game.getWorld().getWorldF().setGravity(new Vec2(0f, 15f));
		}
		

	}

	public void parar() {
//		game.getCp().getBodyF().setLinearVelocity(new Vec2(0.0f,1f));
//		game.getCp().getBodyF().setAngularVelocity(-0.01f);
		game.getCp().getBodyF().applyLinearImpulse(new Vec2(0,0), new Vec2(game.getCp().x,game.getCp().y));
		System.out.println(game.getCp().getBodyF().getLinearVelocity());
		game.getWorld().getWorldF().setGravity(new Vec2(0f, 0.1f));
	}
}
