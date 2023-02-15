package pruebas.Elementos;

import org.jbox2d.dynamics.Body;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import pruebas.Elementos.Entity;
import pruebas.Elementos.Game;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;

public class Platano extends Entity {

//	Vida vida;
	public static Body bodyF;
	public int score;
	public float x,y;
	Game game;
	
	
	public Platano(Game game, float posX, float posY) {		
		super(game);
		this.game=game;		
		x=posX;
		y=posY;
		fisica();
	}
	
	public void fisica() {
		        
		        BodyDef bd = new BodyDef();
		        bd.type = BodyType.STATIC;;
		        bd.position.set(x, y);
		        
		        PolygonShape box = new PolygonShape();
		        box.setAsBox(0.1f, 0.5f);
		        
		        // Create a fixture for ball
		        FixtureDef fd = new FixtureDef();
		        fd.shape = box;

		        
		        Body body = getGame().getWorld().getWorldF().createBody(bd);
		        body.createFixture(fd);
		        
//		        //Attach an image.
//		        ImageView iv = new ImageView();
//		        iv.setSmooth(true);
//		        //iv.setImage(new Image(Platano.class.getResourceAsStream("/imagen/Platano.png")));
//		        iv.setImage(new Image("/imagen/Platano.png"));
//		        getChildren().add(iv);
		    }
		
	public void render(GraphicsContext gc) {
//		gc.setFill(Color.YELLOW);		
//		gc.fillRect((double)x,(double) y,game.getWidth()/35 ,game.getHeight()/15);
		gc.drawImage(new Image("/imagen/Platano.png"), x, y);

	}
	
	
//	public void update(float timeDifference) {
//		x = bodyF.getPosition().x;
//		y = bodyF.getPosition().y;
//	}
	
//	public int sumarPuntos() {
//		
//		if(Vida.getVida()==3) {
//			return 50;
//		}
//		else {
//			Vida.setVida(0.5);
//			return 10;
//		}
//	}

	@Override
	public void update(float timeDifference) {
		// TODO Auto-generated method stub
		
	}
}