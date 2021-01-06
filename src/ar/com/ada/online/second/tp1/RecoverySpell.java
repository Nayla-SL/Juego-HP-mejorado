package ar.com.ada.online.second.tp1;

public class RecoverySpell extends Spell {
    private int energyRecovered;

    // Constructor
    public RecoverySpell(int id, String name, int magicEnergySpent, int energyRecovered) {
        super(id, name, magicEnergySpent);
        this.energyRecovered = energyRecovered;
    }

//------------------------------------------------------------------------------------------------------------------

    //Getters & Setters
    public int getEnergyRecovered() {
        return energyRecovered;
    }

    public void setEnergyRecovered(int energyRecovered) {
        this.energyRecovered = energyRecovered;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }

    //------------------------------------------------------------------------------------------------------------------
    //Overrides
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
        return "Recovery Spell: \t{id: "+  id +
                "}\t {name: " + name +
                "}\t {energy recovered: " + energyRecovered +
                "}\t {magic energy spent: " + magicEnergySpent + "}";
    }
}

