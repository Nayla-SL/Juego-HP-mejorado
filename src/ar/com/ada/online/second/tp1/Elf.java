package ar.com.ada.online.second.tp1;

import java.util.Objects;
import java.util.Scanner;

public class Elf extends Character {
    protected boolean freeElf;

    SelectionAction selectionAction = new SelectionAction();

    //the player chooses each attribute to start the game
    public Elf() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Choose and type your name: ");
        this.setName(keyboard.next());
        this.setLocation(selectionAction.locationSelection());
        System.out.println("");
        this.setTypeOfCharacter("Elf");
        this.setSpells(selectionAction.spellsSelection());
        this.isFree();
        if (this.isFreeElf())
            System.out.println("You are a free elf");
        else
            System.out.println("You are a house-elf");

        this.configSpells();

    }

    public boolean isFreeElf() {
        return freeElf;
    }


    //if the player has chosen more than 3 attacking spells, it becomes a free elf, if not, it becomes a house elf.
    public void isFree() {
        int counterAttackSpells = 0;
        for (int i = 0; i < this.spells.size(); i++) {
            if (this.spells.get(i) instanceof AttackSpell)
                counterAttackSpells++;
        }
        freeElf = (counterAttackSpells > 3);
    }
    //-----------------------------------------------------------------------------------------------------------------

    //configures every spell taking into account the type of elf the player is (according to how many attacking spells the player has chosen)
    public void freeElfSpellsConfig() {
        for (int i = 0; i < this.spells.size(); i++) {
            if (this.spells.get(i) instanceof AttackSpell) {
                AttackSpell attackSpell = (AttackSpell) this.spells.get(i);
                attackSpell.setDamageMade(attackSpell.getDamageMade() + 5);
                if (attackSpell.getDamageMade() > 100 )
                {attackSpell.setDamageMade(100);}
            }
            if (this.spells.get(i) instanceof HealingSpell) {
                HealingSpell healingSpell = (HealingSpell) this.spells.get(i);
                healingSpell.setLifeRecovered(healingSpell.getLifeRecovered() + 5);
            }
            if (this.spells.get(i) instanceof RecoverySpell) {
                RecoverySpell recoverySpell = (RecoverySpell) this.spells.get(i);
                recoverySpell.setEnergyRecovered(recoverySpell.getEnergyRecovered() + 5);
            }
        }
    }

    public void houseElfSpellsConfig() {
        for (int i = 0; i < this.spells.size(); i++) {
            if (this.spells.get(i) instanceof HealingSpell) {
                HealingSpell healingSpell = (HealingSpell) this.spells.get(i);
                healingSpell.setLifeRecovered(healingSpell.getLifeRecovered() + 10);
            }
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    // Overrides

    @Override
    public void configSpells() {
        if (freeElf) {
            freeElfSpellsConfig();
        } else {
            houseElfSpellsConfig();

        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Elf that = (Elf) obj;
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
                "\n Type of Character: %s \n Name: %s \n Location: %s \n Life span: %d \n Magic energy: %d \n Are you a free elf? %s \n Spells:",
                typeOfCharacter,
                name,
                location,
                lifeSpan,
                magicEnergy,
                freeElf);
        String spellsTxt = "\n";
        for (int i = 0; i < spells.size(); i++) {
            spellsTxt = spellsTxt + spells.get(i).toString() + "\n";
        }
        output = output + spellsTxt;
        return output;

    }


}
