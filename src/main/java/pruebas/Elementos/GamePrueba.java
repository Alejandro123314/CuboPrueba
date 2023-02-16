package pruebas.Elementos;

import java.util.Set;

import org.jbox2d.common.Vec2;

import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;

public class GamePrueba extends Game {

	CuerpoPersonaje cp = new CuerpoPersonaje(this, 120, 50);

	public GamePrueba(Canvas canvas) {
		super(canvas);
	}

	@Override
	protected void init() {

		getEntities().addAll(new CuerpoPersonaje(this, 120, 50), new Muro(this, 0, getHeight() - 20f, getWidth(), 2));

	}

	@Override
	protected void processInput(Set<KeyCode> input) {

		float x = 0f, y = 0f;
		
		System.out.println(input);

		if (input.contains(KeyCode.RIGHT)) {
			x = 100f;			
		}
		if (input.contains(KeyCode.LEFT)) {
			x = -100f;
		}
		if (input.contains(KeyCode.UP)) {
			y = -100f;
		}
		if (input.contains(KeyCode.DOWN)) {
			y = 100f;
		}

		Vec2 move = new Vec2(x, y);
		System.out.println(move);
		
		cp.getBodyF().applyLinearImpulse(move, cp.getBodyF().getWorldCenter());

	}
}