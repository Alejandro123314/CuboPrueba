package pruebas.Elementos;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.FixtureDef;

import jfxwithjbox2d.Utils;

public class Walls {
	
	public static void addWall(float posX, float posY, float width, float height){
		
	    PolygonShape ps = new PolygonShape();
	    ps.setAsBox(width,height);
	        
	    FixtureDef fd = new FixtureDef();
	    fd.shape = ps;
	    fd.density = 1.0f;
	    fd.friction = 0.3f;    

	    BodyDef bd = new BodyDef();
	    bd.position.set(posX, posY);
	        
	    Utils.world.createBody(bd).createFixture(fd);
	}
}
