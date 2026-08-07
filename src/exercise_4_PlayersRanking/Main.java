package exercise_4_PlayersRanking;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args){
        ArrayList<Player> players = new ArrayList<>();

        Player p1 = new Player("Davi", 100);
        Player p2 = new Player("Joyce", 125);
        Player p3 = new Player("Pedro", 100);

        players.add(p1);
        players.add(p2);
        players.add(p3);

        System.out.println("\nAntes");
        for (Player p : players){
            System.out.println("\nNome: " + p.getName() + "\n Pontos: " +  p.getPoints());
        }

        Collections.sort(players);

        System.out.println("\nDepois");

        for (Player p : players){
            System.out.println("\nNome: " + p.getName() + "\n Pontos: " +  p.getPoints());
        }


    }
}

//4. Ranking de jogadores
//
//Ordene jogadores por pontuação e desempate por nome.
//Use: Comparator, Comparable, Collections.