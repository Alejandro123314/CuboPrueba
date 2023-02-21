package pruebas.Elementos;

import java.util.Set;

import org.jbox2d.common.Vec2;

import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;

public class GamePrueba extends Game {

	private CuerpoPersonaje cp;
	private int i = 0;
	Game game;

	public GamePrueba(Canvas canvas) {
		super(canvas);
	}

	@Override
	protected void init() {

		cp = new CuerpoPersonaje(this, 120, 50);

		getEntities().addAll(cp, new Muro(this, 0, getHeight() - 20f, getWidth(), 2));

	}

	@Override
	protected void processInput(Set<KeyCode> input) {

		float x = 0f, y = 0f;	
		// System.out.println(input);

		if (input.contains(KeyCode.RIGHT)) {
			x = 100f;
		}
		if (input.contains(KeyCode.LEFT)) {
			x = -100f;
		}
		if (input.contains(KeyCode.UP)) {
			i++;
			System.out.println(i);
			if (i == 1) {
				y = -100f;
			}if(i == 60) {
				i = 0;
			}
			
		}
		if (input.contains(KeyCode.DOWN)) {
			y = 100f;
		}

		cp.move(new Vec2(x, y));

	}
}