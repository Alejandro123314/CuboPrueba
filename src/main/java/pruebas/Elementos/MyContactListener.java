package pruebas.Elementos;

import org.jbox2d.callbacks.ContactImpulse;
import org.jbox2d.callbacks.ContactListener;
import org.jbox2d.collision.Manifold;
import org.jbox2d.dynamics.contacts.Contact;

public class MyContactListener implements ContactListener {

    // This method gets called when two physics objects start to touch each other
    public void beginContact(Contact contact) {
        // Check if the first body involved in the contact is the ball
        if (contact.getFixtureA().getBody().getUserData() == "CuerpoPersonaje") {
            // Check if the second body involved in the contact is the wall
            if (contact.getFixtureB().getBody().getUserData() == "Muro") {
                // The ball has collided with the wall!
                System.out.println("Ball has collided with the wall!");
            }
        }
    }

    // Other methods in the ContactListener interface
    public void endContact(Contact contact) {}
    public void preSolve(Contact contact, Manifold oldManifold) {}
    public void postSolve(Contact contact, ContactImpulse impulse) {}
}
