package exercise_4_PlayersRanking;

import java.util.Random;

public class Player implements Comparable<Player>{
    private int id;
    private String name;
    private int points;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Player(String name, int points) {
        Random rand = new Random();
        this.name = name;
        this.points = points;

        this.id = rand.nextInt(0, 100);
    }

    @Override
    public int compareTo(Player other) {

        int result = Integer.compare(other.points, this.points);

        if(result != 0){
            return result;
        }

        return this.name.compareTo(other.name);
    }
}
