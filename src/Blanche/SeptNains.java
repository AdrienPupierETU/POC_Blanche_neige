package Blanche;// -*- coding: utf-8 -*-

import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class SeptNains {
    public static void main(String[] args) {
        int nbNains = 7;
        String nom [] = {"Simplet", "Dormeur",  "Atchoum", "Joyeux", "Grincheux", "Prof", "Timide"};
        Nain nain [] = new Nain [nbNains];
        for(int i = 0; i < nbNains; i++) nain[i] = new Nain(nom[i]);
        for(int i = 0; i < nbNains; i++) nain[i].start();
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i=0; i < nbNains; i++){
            System.out.println("interupting : " +nom[i]);
            nain[i].interrupt();
        }
        for(int i = 0; i < nbNains; i++) {
            try { nain[i].join(); } catch (InterruptedException e) {e.printStackTrace();}	
        }
        System.out.println("Fin");
    }
}    



class Nain extends Thread {
    private static final BlancheNeige bn = new BlancheNeige();
    public Nain(String nom) {
        this.setName(nom);
    }
    public void run() {
        while (true) {
            bn.requérir();
            try {
                bn.accéder();
                System.out.println("\t\t" + getName() + " possède le privilège d'accès à Blanche-Neige.");
                sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("\t\t" + getName() + " Au revoir");
                return;
            }
            bn.relâcher();
        }


        // System.out.println(getName() + " a terminé!");
    }

}

/*
  $ make
  $ $ java SeptNains
	Simplet veut un accès exclusif à la ressource
		Simplet va accéder à la ressource.
	Grincheux veut un accès exclusif à la ressource
	Timide veut un accès exclusif à la ressource
	Joyeux veut un accès exclusif à la ressource
	Atchoum veut un accès exclusif à la ressource
	Dormeur veut un accès exclusif à la ressource
	Prof veut un accès exclusif à la ressource
		Simplet possède le privilège d'accès à Blanche-Neige.
			Simplet relâche la ressource.
	Simplet veut un accès exclusif à la ressource
		Simplet va accéder à la ressource.
		Simplet possède le privilège d'accès à Blanche-Neige.
			Simplet relâche la ressource.
	Simplet veut un accès exclusif à la ressource
		Simplet va accéder à la ressource.
		Simplet possède le privilège d'accès à Blanche-Neige.
			Simplet relâche la ressource.
	Simplet veut un accès exclusif à la ressource
		Simplet va accéder à la ressource.
		Simplet possède le privilège d'accès à Blanche-Neige.
			Simplet relâche la ressource.
	Simplet veut un accès exclusif à la ressource
		Simplet va accéder à la ressource.
		Simplet possède le privilège d'accès à Blanche-Neige.
			Simplet relâche la ressource.
	Simplet veut un accès exclusif à la ressource
		Simplet va accéder à la ressource.
		Simplet possède le privilège d'accès à Blanche-Neige.
			Simplet relâche la ressource.
	Simplet veut un accès exclusif à la ressource
		Simplet va accéder à la ressource.
		Simplet possède le privilège d'accès à Blanche-Neige.
			Simplet relâche la ressource.
	Simplet veut un accès exclusif à la ressource
		Simplet va accéder à la ressource.
		Simplet possède le privilège d'accès à Blanche-Neige.
			Simplet relâche la ressource.
	Simplet veut un accès exclusif à la ressource
		Simplet va accéder à la ressource.
		Simplet possède le privilège d'accès à Blanche-Neige.
        ...
*/
