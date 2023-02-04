package pruebas.aparte;

import org.jbox2d.collision.broadphase.BroadPhaseStrategy;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.World;
import org.jbox2d.pooling.IWorldPool;

public class Gravity {

	public void enableGravedad() {
		
		Vec2 gravity = new Vec2(0.0f, -10.0f);
		boolean doSleep = true;
		World world = new World(gravity);
//		World world = new World(gravity, IWorldPool);
//		World world = new World(gravity,IWorldPool,BroadPhaseStrategy); 
	}
	
}
