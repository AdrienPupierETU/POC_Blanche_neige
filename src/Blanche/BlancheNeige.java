package Blanche;

import java.util.concurrent.ConcurrentLinkedQueue;

public class BlancheNeige {
    private volatile boolean libre = true;        // Initialement, Blanche-Neige est libre.
    private ConcurrentLinkedQueue<Thread> file_attente= new ConcurrentLinkedQueue<>();
    public synchronized void requérir () {
        System.out.println("\t" + Thread.currentThread().getName()
                + " veut un accès exclusif à la ressource");
        file_attente.add(Thread.currentThread());
    }

    public synchronized void accéder () {
        while( ! libre || !Thread.currentThread().equals(file_attente.element())) { // Le nain s'endort sur l'objet bn
            try { wait(); } catch (InterruptedException e) {e.printStackTrace();}
        }
        libre = false;
        System.out.println("\t\t" + Thread.currentThread().getName()
                + " va accéder à la ressource.");
    }

    public synchronized void relâcher () {
        System.out.println("\t\t" + Thread.currentThread().getName()
                + " relâche la ressource.");
        libre = true;
        file_attente.remove();
        notifyAll();
    }
}