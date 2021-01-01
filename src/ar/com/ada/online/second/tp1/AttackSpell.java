package ar.com.ada.online.second.tp1;

public class AttackSpell extends Spell {
    private int damageMade;

    // Constructor
    public AttackSpell(int id, String name, int magicEnergySpent, int damageMade) {
        super(id, name, magicEnergySpent);
        this.damageMade = damageMade;
    }


    //Getter & Setter
    public int getDamageMade() {
        return damageMade;
    }

    public void setDamageMade(int damageMade) {
        this.damageMade = damageMade;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }

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
        return  id +
                "\n\t name: " + name +
                "\n\t damage made: " + damageMade +
                "\n\t magic energy spent: " + magicEnergySpent + "\n";
    }
}


