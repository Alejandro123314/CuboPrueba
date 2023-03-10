package pruebas.Elementos;

import java.util.Set;

import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.contacts.Contact;

import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;

public class GamePrueba extends Game {

	private MyContactListener mcl;
	private Muro m;
	private CuerpoPersonaje cp;
	Game game;
	boolean isJump;
	Vec2 vector;
	public GamePrueba(Canvas canvas) {
		super(canvas);
	}

	@Override
	protected void init() {

		cp = new CuerpoPersonaje(this, 120, 50);

		getEntities().addAll(cp, new Muro(this, 0, getHeight() - 20f, getWidth(), 2));

		this.getPhysics().getWorld().setContactListener(new MyContactListener() {

			@Override
			public void beginContact(Contact contact) {

				Object userDataA = contact.getFixtureA().getBody().getUserData();
				Object userDataB = contact.getFixtureB().getBody().getUserData();

				if (userDataA instanceof CuerpoPersonaje && userDataB instanceof Muro) {
					CuerpoPersonaje personaje = (CuerpoPersonaje) userDataA;
					Muro muro = (Muro) userDataB;
					isJump = true;
					System.out.println();
				} else if (userDataB instanceof CuerpoPersonaje && userDataA instanceof Muro) {
					CuerpoPersonaje personaje = (CuerpoPersonaje) userDataB;
					Muro muro = (Muro) userDataA;
					isJump = true;
				}
			}
		});
	}

	public void fuerzaGravedad(float x) {
		float jumpStartTime = System.nanoTime() / 1000000000f;
		final float JUMP_IMPULSE = 100f;
		final float JUMP_FORCE = 20f;
		final float MAX_JUMP_DURATION = 0.3f;

		float jumpDuration = System.nanoTime() / 1000000000f - jumpStartTime;
		if (jumpDuration < MAX_JUMP_DURATION) {
			float jumpForce = JUMP_FORCE * (1 - jumpDuration / MAX_JUMP_DURATION);
			vector = new Vec2(x, jumpForce);
			cp.body.applyForceToCenter(vector);
		}
	}

	public void impulsoVertical(float x, float y) {
		vector = new Vec2(x, y);
		cp.body.applyForceToCenter(vector);
	}

	@Override
	protected void processInput(Set<KeyCode> input) {
		
		float x = 0f, y = 0f;

		if (input.contains(KeyCode.RIGHT)) {
			x += 100f;
		}
		if (input.contains(KeyCode.LEFT)) {
			x -= 100f;
		}
		if ((input.contains(KeyCode.UP) || input.contains(KeyCode.SPACE)) && isJump) {
			y -= 100f;
			isJump = false;
		}
		if (input.contains(KeyCode.DOWN)) {
			y += 100f;
		}
		if (input.contains(KeyCode.RIGHT) || input.contains(KeyCode.LEFT)) {
			if(!((input.contains(KeyCode.UP) || input.contains(KeyCode.SPACE) && isJump) || input.contains(KeyCode.DOWN))) {
			fuerzaGravedad(x);
			}
		}
		if ((input.contains(KeyCode.UP) || input.contains(KeyCode.SPACE) && isJump) || input.contains(KeyCode.DOWN)) {
			impulsoVertical(x, y);
		}
	}
}
