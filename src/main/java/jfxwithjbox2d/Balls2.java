package jfxwithjbox2d;

	import javafx.scene.Parent;
	import javafx.scene.image.Image;
	import javafx.scene.image.ImageView;
	import org.jbox2d.collision.shapes.CircleShape;
	import org.jbox2d.dynamics.Body;
	import org.jbox2d.dynamics.BodyDef;
	import org.jbox2d.dynamics.BodyType;
	import org.jbox2d.dynamics.FixtureDef;

	/**
	 *
	 * @author dilip
	 */
	public class Balls2 extends Parent{

	    
	    //X and Y position of the ball in JBox2D world
	    private float posX;
	    private float posY;
	    
	    //Ball radius in pixels
	    private int radius;
	    
	    public Balls2(float posX, float posY, int radius){
	        this.posX = posX;
	        this.posY = posY;
	        this.radius = radius;
	        create();
	    }

	    
	    private void create(){
	        
	        /**
	         * Set ball position on JavaFX scene. We need to convert JBox2D coordinates 
	         * to JavaFX coordinates which are in pixels.
	         */
	        this.setLayoutX(Utils.toPixelPosX(posX)); 
	        this.setLayoutY(Utils.toPixelPosY(posY));
	        
	        //Create an JBox2D body defination for ball.
	        BodyDef bd = new BodyDef();
	        bd.type = BodyType.DYNAMIC;;
	        bd.position.set(posX, posY);
	        
	        CircleShape cs = new CircleShape();
	        cs.m_radius = radius * 0.1f;  //We need to convert radius to JBox2D equivalent
	        
	        // Create a fixture for ball
	        FixtureDef fd = new FixtureDef();
	        fd.shape = cs;
	        fd.density = 0.5f;
	        fd.friction = 0.3f;        
	        fd.restitution = 0.5f;

	        /**
	        * Virtual invisible JBox2D body of ball. Bodies have velocity and position. 
	        * Forces, torques, and impulses can be applied to these bodies.
	        */
	        Body body = Utils.world.createBody(bd);
	        body.createFixture(fd);
	        this.setUserData(body);

	        //Attach an image.
	        ImageView iv = new ImageView();
	        iv.setSmooth(true);
	        iv.setImage(new Image(Ball.class.getResourceAsStream("images/ball.png")));
	        getChildren().add(iv);
	    }
	}