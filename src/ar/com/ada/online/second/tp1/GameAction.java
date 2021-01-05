package ar.com.ada.online.second.tp1;

import java.util.Scanner;

public class GameAction {

    SelectionAction selectionAction = new SelectionAction();

    public Character startPlayer1() {
        System.out.println("Player 1, you choose:");
        Character player1 = selectionAction.selectionPart();
        System.out.println("Player 1 information: \n" + player1);
        return player1;

    }

    public Character startPlayer2 () {
        System.out.println("Player 2, you choose:");
        Character player2 = selectionAction.selectionPart();
        System.out.println("Player 2 information: \n" + player2);
        return player2;
    }

    public void gamePlay(Character player1, Character player2) {
       while (player1.isAlive() || player2.isAlive()) {
           Scanner keyboard = new Scanner(System.in);
           castSpell(player1, player2, keyboard);
           changeLocation(player1, keyboard);
           characterStatus(player1);
           castSpell(player2, player1, keyboard);
           changeLocation(player2, keyboard);
           characterStatus(player2);
       }
       winner(player1, player2);
    }

    private void winner(Character player1, Character player2) {
        if (player1.isAlive()){
            System.out.println("Congratulations! " + player1.getName() + ", you won!!");
        } else  {
            System.out.println("Congratulations! " + player2.getName() + ", you won!!");
        }
    }


    private void changeLocation(Character userPlaying, Scanner keyboard) {
        int changeLocationUserInput;
        System.out.printf("Do you want to change your location? \n\t 1 - Yes \n\t 2 - No \n Your choice: ");
        changeLocationUserInput = keyboard.nextInt();
        boolean aux = true;
        while (aux) {
            switch (changeLocationUserInput) {
                case 1:
                    userPlaying.setLocation(SelectionAction.locationSelection());
                    aux = false;
                case 2:
                    aux = true;
                default:
                    aux = true;
            }


        }
    }

    private void castSpell(Character userPlaying, Character otherPlayer, Scanner keyboard) {

        int typeSpellSelected;
        while (userPlaying.isAlive()) {
            boolean aux = true;
            System.out.print("What do you want to do? \n\t 1 - Attack \n\t 2 - Heal \n\t 3 - Recover Magic Energy");
            typeSpellSelected = keyboard.nextInt();
            while (aux) {
                switch (typeSpellSelected) {
                    case 1:
                        throwAttackSpell(userPlaying, otherPlayer, keyboard);
                        aux = false;
                    case 2:
                        throwHealingSpell(userPlaying, keyboard);
                        aux = false;
                    case 3:
                        throwRecoverySpell(userPlaying, keyboard);
                        aux = false;
                    default:
                        System.out.println("You must choose a valid option.");
                }
            }
        }
    }

    private void throwRecoverySpell(Character userPlaying, Scanner keyboard) {
        int spellSelected;
        System.out.println("Choose one of the following spells:");
        for (int i = 0; i < 6; i++) {
            if (userPlaying.getSpells(i) instanceof RecoverySpell) {
                System.out.println(userPlaying.getSpells(i));
            }
        }
        System.out.print("Your choice: ");
        spellSelected = keyboard.nextInt() - 1;
        RecoverySpell recoverySpell = (RecoverySpell) userPlaying.spells.get(spellSelected);
        if (isMagicEnergyEnough(recoverySpell, userPlaying)) {

            System.out.println("You added " + recoverySpell.getEnergyRecovered() +
                    "points to your magic energy. \n Now you have " + userPlaying.getMagicEnergy() + " magic energy points.");
        }
    }

    private void throwHealingSpell(Character userPlaying, Scanner keyboard) {
        int spellSelected;
        System.out.println("Choose one of the following spells:");
        for (int i = 0; i < 6; i++) {
            if (userPlaying.getSpells(i) instanceof HealingSpell) {
                System.out.println(userPlaying.getSpells(i));
            }
        }
        System.out.print("Your choice: ");
        spellSelected = keyboard.nextInt() - 1;
        HealingSpell healingSpell = (HealingSpell) userPlaying.spells.get(spellSelected);
        if (isMagicEnergyEnough(healingSpell, userPlaying)) {
            userPlaying.setLifeSpan(userPlaying.getLifeSpan() + healingSpell.getLifeRecovered());
            System.out.println("You added " + healingSpell.getLifeRecovered() +
                    "points to your life span. \n Now you have " + userPlaying.getLifeSpan() + " life points.");
        }
    }

    private void throwAttackSpell(Character userPlaying, Character otherPlayer, Scanner keyboard) {
        int spellSelected;
        System.out.println("Choose one of the following spells:");
        for (int i = 0; i < 6; i++) {
            if (userPlaying.getSpells(i) instanceof AttackSpell) {
                System.out.println(userPlaying.getSpells(i));
            }
        }
        String locationOpponent;
        System.out.print("Your choice: ");
        spellSelected = keyboard.nextInt() - 1;
        AttackSpell attackSpell = (AttackSpell) userPlaying.spells.get(spellSelected);
        if (isMagicEnergyEnough(attackSpell, userPlaying)) {
            System.out.println("Choose the location you want to throw the spell to: ");
            locationOpponent = SelectionAction.locationSelection();
            if (locationOpponent == otherPlayer.getLocation()) {
                otherPlayer.setLifeSpan(otherPlayer.getLifeSpan() - attackSpell.getDamageMade());
                System.out.println("Great! You hit your target.");
            } else {
                System.out.println("Sorry, you didn't hit your target, better luck next time!");
            }
        }
    }

    private boolean isMagicEnergyEnough(Spell spell, Character userPlaying) {
        boolean auxME = true;
        if (userPlaying.getMagicEnergy() < spell.getMagicEnergySpent()) {
            System.out.printf("You don't have enough magic energy to throw this spell. " +
                    "\n\t+10 points of magic energy will be added to your status and you will lose this turn.");
            userPlaying.setMagicEnergy(userPlaying.getMagicEnergy() + 10);
            auxME = false;
        } else {
            userPlaying.setMagicEnergy(userPlaying.getMagicEnergy() - spell.getMagicEnergySpent());
            auxME = true;
        }
        return auxME;
    }

    public String characterStatus(Character userPlaying) {
        String output = String.format(
                "Here's your status: \n\t Name: %d \n\t Location: %s \n\t Life span: %d \n\t Magic energy: %d \n",
                userPlaying.getName(),
                userPlaying.getLocation(),
                userPlaying.getLifeSpan(),
                userPlaying.getMagicEnergy());
        return output;
    }
}



