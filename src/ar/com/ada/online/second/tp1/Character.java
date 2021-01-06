package ar.com.ada.online.second.tp1;

import java.util.List;
import java.util.Objects;

public abstract class Character {
    protected String name;
    protected String location;
    protected Integer lifeSpan = 100;
    protected Integer magicEnergy = 100;
    protected String typeOfCharacter;
    protected List<Spell> spells;

    //------------------------------------------------------------------------------------------------------------------

    //constructor
    public Character() {
    }

    //------------------------------------------------------------------------------------------------------------------
    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getLifeSpan() {
        return lifeSpan;
    }

    public void setLifeSpan(Integer lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    public Integer getMagicEnergy() {
        return magicEnergy;
    }

    public void setMagicEnergy(Integer magicEnergy) {
        this.magicEnergy = magicEnergy;
    }

    public String getTypeOfCharacter() {
        return typeOfCharacter;
    }

    public void setTypeOfCharacter(String typeOfCharacter) {
        this.typeOfCharacter = typeOfCharacter;
    }

    public List<Spell> getSpells(int i) {
        return spells;
    }

    public void setSpells(List<Spell> spells) {
        this.spells = spells;
    }

    //------------------------------------------------------------------------------------------------------------------
    //methods

    public boolean isAlive() {
        boolean alive;
        if (lifeSpan <= 0) {
            alive = false;
        } else {
            alive = true;
        }
        return alive;
    }

    public abstract void configSpells ();


//------------------------------------------------------------------------------------------------------------------

    // Overrides

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Character that = (Character) obj;
        return location == that.location &&
                name.equals(that.name) &&
                lifeSpan.equals(that.lifeSpan) &&
                magicEnergy.equals(that.magicEnergy) &&
                typeOfCharacter.equals(that.typeOfCharacter) &&
                spells.equals(that.spells);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location, lifeSpan, magicEnergy, typeOfCharacter, spells);
    }

    @Override
    public String toString() {

        String output = String.format(
                "\n Type of Character: %s \n Name: %s \n Location: %s \n Life span: %d \n Magic energy: %d \n Spells: \n",
                typeOfCharacter,
                name,
                location,
                lifeSpan,
                magicEnergy);
        String spellsTxt = "\n\t";
        for (int i = 0; i < spells.size(); i++) {
            spellsTxt = "\t" + spellsTxt + spells.get(i).toString() + "\n";
        }
        output = output + spellsTxt;
        return output;
    }



}

