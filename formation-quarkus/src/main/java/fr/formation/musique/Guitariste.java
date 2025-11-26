package fr.formation.musique;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class Guitariste {

    @Inject
    private Guitare guitare;

    public void jouer() {
        System.out.println("Le guitariste joue : " + guitare);
    }

    @Override
    public String toString() {
        return "guitariste !!";
    }

}
