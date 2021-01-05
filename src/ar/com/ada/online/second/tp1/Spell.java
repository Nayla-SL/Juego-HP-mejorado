package ar.com.ada.online.second.tp1;


public class Spell {

    protected int magicEnergySpent;
    protected int id;
    protected String name;

    // Constructor

    public Spell(String name, int magicEnergySpent) {
        this.id = id;
        this.name = name;
        this.magicEnergySpent = magicEnergySpent;
    }

    public Spell() {

    }

    public Spell(int id, String name, int magicEnergySpent) {
        this.id = id;
        this.name = name;
        this.magicEnergySpent = magicEnergySpent;
    }


    //Getter & Setter


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMagicEnergySpent() {
        return magicEnergySpent;
    }

    public void setMagicEnergySpent(int magicEnergySpent) {
        this.magicEnergySpent = magicEnergySpent;
    }






    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Spell that = (Spell) obj;
        return magicEnergySpent == that.magicEnergySpent &&
                name.equals(that.name);
    }


    @Override
    public String toString() {
        return id + "\n\t name: " + name +
                "\n\t Magic energy spent: " + magicEnergySpent + "\n"
                ;
    }
}

