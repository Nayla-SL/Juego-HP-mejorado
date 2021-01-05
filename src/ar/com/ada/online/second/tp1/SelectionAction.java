package ar.com.ada.online.second.tp1;


import java.util.*;

public class SelectionAction {

    Map<Integer, Spell> attackingSpells;
    Map<Integer, Spell> healingSpells;
    Map<Integer, Spell> recoverySpells;

    // spells map
    public SelectionAction() {
        attackingSpells = new HashMap<>();
        healingSpells = new HashMap<>();
        recoverySpells = new HashMap<>();
        attackingSpells.put(1, new AttackSpell(1, "BOMBARDA MAXIMA", 5, 10));
        attackingSpells.put(2, new AttackSpell(2, "DESMAIUS", 10, 15));
        attackingSpells.put(3, new AttackSpell(3, "EXPULSO", 15, 20));
        attackingSpells.put(4, new AttackSpell(4, "LEVICORPUS", 5, 15));
        attackingSpells.put(5, new AttackSpell(5, "REDUCTO", 20, 15));
        attackingSpells.put(6, new AttackSpell(6, "CONFRINGO", 12, 17));
        attackingSpells.put(7, new AttackSpell(7, "GLACIUS", 10, 15));
        attackingSpells.put(8, new AttackSpell(8, "INCENDIO", 10, 15));
        attackingSpells.put(9, new AttackSpell(9, "AVADA KEDAVRA", 90, 100));
        attackingSpells.put(10, new AttackSpell(10, "CRUCIATUS", 70, 80));
        attackingSpells.put(11, new AttackSpell(11, "IMPERIUS", 80, 90));
        healingSpells.put(1, new HealingSpell(1, "ANAPNEO", 20, 20));
        healingSpells.put(2, new HealingSpell(2, "BRAQUIAM AMENDO", 17, 15));
        healingSpells.put(3, new HealingSpell(3, "EPISKEY", 10, 13));
        healingSpells.put(4, new HealingSpell(4, "OSSIO DISPERSIMUS", 20, 25));
        healingSpells.put(5, new HealingSpell(5, "REPARIFORS", 13, 21));
        healingSpells.put(6, new HealingSpell(6, "FÉRULA", 15, 15));
        healingSpells.put(7, new HealingSpell(7, "VULNERA SANENTUR", 16, 18));
        recoverySpells.put(1, new RecoverySpell(1, "RECUPERA", 8, 15));
    }

    public List<Spell> spellsSelection() {
        Scanner keyboard = new Scanner(System.in);
        int typeSpellInput;
        int spellInput;
        List<Spell> chosenSpells = new ArrayList<>();


        System.out.printf("\n ATTENTION!!! \n \n You can only choose six spells in total\n");

        for (int i = 0; i < 6; i++) {
            boolean aux = true;
            while (aux) {
                System.out.println("Choose:\n\t  1 - Attacking Spells \n\t 2 - Healing Spells \n\t 3 - Recovery Spells");
                typeSpellInput = keyboard.nextInt();
                switch (typeSpellInput) {
                    case 1: //attacking spells
                        choosingAttackingSpells(chosenSpells, typeSpellInput, keyboard, aux);
                        break;

                    case 2: //healing spells
                        choosingHealingSpells(chosenSpells, typeSpellInput, keyboard, aux);
                        break;

                    case 3: //recovery spells
                        choosingRecoverySpells(chosenSpells, typeSpellInput, keyboard, aux);
                        break;

                    default:
                        System.out.println("You must choose a valid option.");
                }
            }
        }
        return chosenSpells;
    }

    private void choosingRecoverySpells(List<Spell> chosenSpells, int typeSpellInput, Scanner keyboard, boolean aux) {
        System.out.println("Choose one of the following recovery spells:");
        showRecoverySpells();
        System.out.printf("\n\n Your choice: ");
        Integer spellInput = keyboard.nextInt();
        while (!checkValidInput(spellInput, typeSpellInput, chosenSpells)) {
            System.out.print("You must choose a valid option, choose again, or insert 0 to choose another type of spell. \n Your choice: ");
            spellInput = keyboard.nextInt();
            if (spellInput == 0) {
                aux = true;
            }
        }
        if (spellInput != 0) {
            chosenSpells.add(pickRecoverySpell(spellInput));
            aux = false;
        }
    }

    private void choosingHealingSpells(List<Spell> chosenSpells, int typeSpellInput, Scanner keyboard, boolean aux) {
        System.out.println("Choose one of the following healing spells:");
        showHealingSpells();
        System.out.println();
        System.out.print("Your choice: ");
        Integer spellInput = keyboard.nextInt();
        while (!checkValidInput(spellInput, typeSpellInput, chosenSpells)) {
            System.out.print("You must choose a valid option, choose again, or insert 0 to choose another type of spell. \n Your choice: ");
            spellInput = keyboard.nextInt();
            if (spellInput == 0) {
                aux = true;
            }
        }
        if (spellInput != 0) {
            chosenSpells.add(pickHealingSpell(spellInput));
            aux = false;
        }
    }

    private void choosingAttackingSpells(List<Spell> chosenSpells, int typeSpellInput, Scanner keyboard, boolean aux) {
        System.out.println("Choose one of the following attacking spells:");
        showAttackingSpells();
        System.out.println();
        System.out.print("Your choice: ");
        Integer spellInput = keyboard.nextInt();

        while (!checkValidInput(spellInput, typeSpellInput, chosenSpells)) {
            System.out.print("You must choose a valid option, choose again, or insert 0 to choose another type of spell. \n Your choice: ");
            spellInput = keyboard.nextInt();
            if (spellInput == 0) {
                aux = true;
            }
        }
        if (spellInput != 0) {
            chosenSpells.add(pickAttackingSpell(spellInput));
            aux = false;
        }

    }

    private Spell pickRecoverySpell(int id) {
        return recoverySpells.get(id);
    }

    private Spell pickHealingSpell(int id) {
        return healingSpells.get(id);
    }


    private void showRecoverySpells() {
        for (int i = 0; i < recoverySpells.size(); i++) {
            System.out.println(recoverySpells.get(i + 1));
        }
    }

    private void showHealingSpells() {
        for (int i = 0; i < healingSpells.size(); i++) {
            System.out.println(healingSpells.get(i + 1));
        }
    }

    public Spell pickAttackingSpell(Integer id) {
        return attackingSpells.get(id);
    }


    public void showAttackingSpells() {
        for (int i = 0; i < attackingSpells.size(); i++) {
            System.out.println(attackingSpells.get(i + 1));
        }
    }


    public boolean checkValidInput(int spellInput, int typeSpellInput, List<Spell> chosenSpells) {
        return (inAValidRange(spellInput, typeSpellInput) && !wasChosen(chosenSpells, spellInput, typeSpellInput));
    }

    public boolean wasChosen(List<Spell> chosenSpells, int spellInput, int typeSpellInput) {
        boolean auxInputs = false;
        if (typeSpellInput == 1) {
            for (int i = 0; i < chosenSpells.size(); i++) {
                if (chosenSpells.get(i) == attackingSpells.get(spellInput)) {
                    auxInputs = true;
                }
            }
        }
        if (typeSpellInput == 2) {
            for (int i = 0; i < chosenSpells.size(); i++) {
                if (chosenSpells.get(i) == healingSpells.get(spellInput)) {
                    auxInputs = true;
                }
            }
        }
        if (typeSpellInput == 3) {
            for (int i = 0; i < chosenSpells.size(); i++) {
                if (chosenSpells.get(i) == recoverySpells.get(spellInput)) {
                    auxInputs = true;
                }
            }
        }
        return auxInputs;
    }

    public boolean inAValidRange(int spellInput, int typeSpellInput) {
        boolean aux = false;
        if (typeSpellInput == 1 && spellInput >= 1 && spellInput <= 11)
            aux = true;
        if (typeSpellInput == 2 && spellInput >= 1 && spellInput <= 7)
            aux = true;
        if (typeSpellInput == 3 && spellInput == 1)
            aux = true;
        return aux;
    }


    public Character selectionPart() {
        Scanner keyboard = new Scanner(System.in);
        int option;
        boolean aux = true;
        while (aux) {
            aux = true;
            System.out.printf("Choose what type of character you want to be: \n\t 1 - Wizard \n\t 2 - Elf\n");
            System.out.print("Option: ");
            option = keyboard.nextInt();
            switch (option) {
                case 1:
                    aux = false;
                    return new Wizard();// devuelve el mago con todas las selecciones del jugador
                case 2:
                    aux = false;
                    return new Elf(); //devuelve el elfo con todas las selecciones del jugador
                default:
                    System.out.println("You must choose a valid option.");
            }
        }
        return null;
    }


    public static String locationSelection() {
        boolean aux = true;
        String auxLoc;
        Scanner keyboard = new Scanner(System.in);
        int option;
        do {
            System.out.println("Select a location: \n 1 - Hogwarts \n 2 - Diagon Alley \n 3 - Hogsmeade");
            System.out.print("Option: ");
            option = keyboard.nextInt();
            switch (option) {
                case 1:
                    aux = false;
                    auxLoc = "1 - Hogwarts";
                    break;
                case 2:
                    aux = false;
                    auxLoc = "2 - Diagon Alley";
                    break;
                case 3:
                    aux = false;
                    auxLoc = "3 - Hogsmeade";
                    break;
                default:
                    System.out.println("You must choose a valid option.");
                    auxLoc = null;
                    break;
            }
        } while (aux);

        return auxLoc;
    }
}