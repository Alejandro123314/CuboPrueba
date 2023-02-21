package pruebas.Elementos;

import org.jbox2d.callbacks.ContactImpulse;
import org.jbox2d.callbacks.ContactListener;
import org.jbox2d.collision.Manifold;
import org.jbox2d.dynamics.Fixture;
import org.jbox2d.dynamics.contacts.Contact;

//Esta clase se encargara de la gestion de las colisiones
public class UtilContactListener {
public static ContactListener getContactListener(){
 ContactListener contactListener = new ContactListener()    {
             // Se llama cuando comienza el contacto entre los objetos
     public void beginContact(Contact contact){

         // Cogemos los dos objetos que estan colisionando
         final Fixture x1 = contact.getFixtureA();
         final Fixture x2 = contact.getFixtureB();
                 // Ahora sacamos el valor del "Data" de cada objeto para gestionar que ocurrira al colisionar, por ejemplo si colisionas con una estrella la cogera, recordad que el valor del data lo deberemos haber metido al inicializar el objeto
         if (userDataX1.getValue().equals("jugador") && x2.getBody().getUserData().equals("suelo")){            
           doLevelUp();
         }            
     }
     
     public void endContact(Contact contact){
     
         final Fixture x1 = contact.getFixtureA();
         final Fixture x2 = contact.getFixtureB();
         // Hacer lo que queramos hacer al finalizar el contacto
     }

     public void preSolve(Contact contact, Manifold oldManifold)
     {
    	 
     }

     public void postSolve(Contact contact, ContactImpulse impulse)
     {
     }

 };
 return contactListener;
}
}
