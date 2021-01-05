package ar.com.ada.online.second.tp1;

public class Wand {
    private int points;
    private String name;


    public Wand(int points, String name) {
        this.points = points;
        this.name = name;
    }

    public Wand(){}



    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return name + " that gives you +" + points + " attacking points";
    }
}
