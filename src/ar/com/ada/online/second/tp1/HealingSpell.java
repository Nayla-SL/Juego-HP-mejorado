package ar.com.ada.online.second.tp1;

public class HealingSpell extends Spell {
    private int lifeRecovered;


    //------------------------------------------------------------------------------------------------------------------
    // Constructor
    public HealingSpell(int id, String name, int magicEnergySpent, int lifeRecovered) {
        super(id, name, magicEnergySpent);
        this.lifeRecovered = lifeRecovered;
    }


    //------------------------------------------------------------------------------------------------------------------
    // Getters & Setters
    public int getLifeRecovered() {
        return lifeRecovered;
    }

    public void setLifeRecovered(int lifeRecovered) {
        this.lifeRecovered = lifeRecovered;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }


    //------------------------------------------------------------------------------------------------------------------
    //Override

    @Override
    public void setMagicEnergySpent(int magicEnergySpent) {
        super.setMagicEnergySpent(magicEnergySpent);
    }

    @Override
    public int getMagicEnergySpent() {
        return super.getMagicEnergySpent();
    }

    @Override
    public String toString() {
        return "Healing Spell: \t\t{id: " + id +
                "}\t {name: " + name +
                "}\t {life recovered: " + lifeRecovered +
                "}\t magic energy spent: " + magicEnergySpent + "}";
    }
}
