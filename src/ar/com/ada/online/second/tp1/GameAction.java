package ar.com.ada.online.second.tp1;

import java.util.Scanner;

public class GameAction {

    SelectionAction selectionAction = new SelectionAction();

    //-----------------------------------------------------------------------------------------------------------------

    //player 1 starts and chooses their attributes and spells
    public Character startPlayer1() {
        System.out.println("Player 1, you choose:");
        Character player1 = selectionAction.selectionPart();
        System.out.println("Player 1 information: \n" + player1);
        return player1;

    }

    //player 2 starts and chooses their attributes and spells
    public Character startPlayer2() {
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Player 2, you choose:");
        Character player2 = selectionAction.selectionPart();
        System.out.println("Player 2 information: \n" + player2);
        System.out.println("-----------------------------------------------------------------------------------------");
        return player2;
    }

//-----------------------------------------------------------------------------------------------------------------

    //the game starts, each player will choose what spell of their list they want to use - the spell will influence their attributes accordingly
    public void gamePlay(Character player1, Character player2) {

        Scanner keyboard = new Scanner(System.in);

        while (player1.isAlive() && player2.isAlive()) {
            System.out.println("Player 1, you play:");
            castSpell(player1, player2, keyboard);
            if (player2.isAlive()) {
                changeLocation(player1, keyboard);
                System.out.println(playerCurrentStatus(player1));
            }
                System.out.println("Player 2, you play:");
                castSpell(player2, player1, keyboard);
                if (player1.isAlive()) {
                    changeLocation(player2, keyboard);
                    System.out.println(playerCurrentStatus(player2));
                }
            }
        
        winner(player1, player2);
    }

    // shows who the winner is, the one that is left alive.
    private void winner(Character player1, Character player2) {
        if (player1.isAlive()) {
            System.out.println("Congratulations! " + player1.getName() + ", you won!!");
        } else {
            System.out.println("Congratulations! " + player2.getName() + ", you won!!");
        }
    }

    // asks the player if they want to change the location at the end of each turn
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
                    break;
                case 2:
                    aux = false;
                    break;
                default:
                    System.out.println("You must choose a valid option. Choose again: ");
                    aux = true;
                    break;
            }
        }
    }

    //lets the player choose which of their - previously chosen spells - wants to use in this turn.
    private void castSpell(Character userPlaying, Character otherPlayer, Scanner keyboard) {

        int typeSpellSelected;
        boolean aux = true;
        System.out.print("What do you want to do? \n\t 1 - Attack \n\t 2 - Heal \n\t 3 - Recover Magic Energy\n Your choice: ");
        typeSpellSelected = keyboard.nextInt();
        while (aux) {
            switch (typeSpellSelected) {
                case 1:
                    // throws an attacking spell to the opponent - if it hits them it will lower the life span of the opponent
                    throwAttackSpell(userPlaying, otherPlayer, keyboard);
                    aux = false;
                    break;
                case 2:
                    // adds points to the player's life span
                    throwHealingSpell(userPlaying, keyboard);
                    aux = false;
                    break;
                case 3:
                    // adds points to the player's magic energy status
                    throwRecoverySpell(userPlaying, keyboard);
                    aux = false;
                    break;
                default:
                    System.out.println("You must choose a valid option.");
                    break;
            }
        }
    }

//-----------------------------------------------------------------------------------------------------------------

    // adds points to the player's magic energy status
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

    // adds points to the player's life span
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

    // throws an attacking spell to the opponent - if it hits them it will lower the life span of the opponent
    private void throwAttackSpell(Character userPlaying, Character otherPlayer, Scanner keyboard) {
        int spellSelected;
        System.out.println("Choose one of the following spells:");
        for (int i = 0; i < 6; i++) {
            if (userPlaying.spells.get(i) instanceof AttackSpell) {
                System.out.println(userPlaying.spells.get(i));
            }
        }
        System.out.print("Your choice: ");
        spellSelected = keyboard.nextInt();

        for (int i = 0; i < userPlaying.spells.size(); i++) {
            Spell spellUsed = userPlaying.spells.get(i);
            if (spellUsed.getId() == spellSelected && spellUsed instanceof AttackSpell) {
                AttackSpell attackSpell = (AttackSpell) spellUsed;
                if (isMagicEnergyEnough(attackSpell, userPlaying)) {

                    //ask the player for the location of the opponent - if it matches the location it will hurt the opponent
                    System.out.println("Choose the location you want to throw the spell to: ");
                    String locationOpponent = SelectionAction.locationSelection();
                    if (locationOpponent == otherPlayer.getLocation()) {
                        otherPlayer.setLifeSpan(otherPlayer.getLifeSpan() - attackSpell.getDamageMade());
                        System.out.println("Great! You hit your target.");
                    }
                } else {
                    System.out.println("Sorry, you didn't hit your target, better luck next time!");
                }
            }
        }
    }


    //-----------------------------------------------------------------------------------------------------------------

    //checks if the player's magic energy is enough to throw the chosen spell
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

    //shows the current status to the player at the end of the turn
    public String playerCurrentStatus(Character userPlaying) {
        String output = String.format(
                "Here's your status: \n\t Name: %s \n\t Location: %s \n\t Life span: %d \n\t Magic energy: %d \n",
                userPlaying.getName(),
                userPlaying.getLocation(),
                userPlaying.getLifeSpan(),
                userPlaying.getMagicEnergy());
        return output;
    }
}



