package ar.com.ada.online.second.tp1;


public class Spell {

    protected int magicEnergySpent;
    protected int id;
    protected String name;

    // Constructor


    public Spell(int magicEnergySpent, int id, String name) {
        this.magicEnergySpent = magicEnergySpent;
        this.id = id;
        this.name = name;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Spell that = (Spell) obj;
        return magicEnergySpent == that.magicEnergySpent &&
                name == that.name && id == that.id;
    }


    @Override
    public String toString() {
        return  "{id: "+
                id + "}\t {name: " + name +
                "}\t {Magic energy spent: " + magicEnergySpent + "}\n"
                ;
    }


}

