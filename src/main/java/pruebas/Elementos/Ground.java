package pruebas.Elementos;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.FixtureDef;

import jfxwithjbox2d.Utils;

public class Ground {

	public static void addGround(float width, float height){
	    PolygonShape ps = new PolygonShape();
	    ps.setAsBox(width,height);
	        
	    FixtureDef fd = new FixtureDef();
	    fd.shape = ps;

	    BodyDef bd = new BodyDef();
	    bd.position= new Vec2(0.0f,-10f);

	    Utils.world.createBody(bd).createFixture(fd);
	}
	
}
