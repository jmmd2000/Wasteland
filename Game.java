//ALL CODE CONTAINED IN THIS FILE WAS DEVELOPED BY 
//JAMES DOYLE
//19496366
//FOR CS210 FINAL PROJECT 2020 (17/1/2020)

package src;

import java.util.*;

public class Game {
    int startingFood = ranGen(3, 1);
    int startingWater = ranGen(3, 1);
    int startingMeds = ranGen(3, 1);
    Player p = new Player(startingFood, startingWater, startingMeds, 150, 200, 200, 200);
    Dog d = new Dog(" ", 100);

    ArrayList<Integer> completed = new ArrayList<Integer>();
    int dayCount = 1;
    boolean dog = false;
    boolean lastDay = false;
    boolean idol = false;

    public static void main(String[] args) throws Exception {
        System.out.println("\t*****************************************************************************");
        System.out.println("\t██     ██  █████  ███████ ████████ ███████ ██       █████  ███    ██ ██████  ");
        System.out.println("\t██     ██ ██   ██ ██         ██    ██      ██      ██   ██ ████   ██ ██   ██ ");
        System.out.println("\t██  █  ██ ███████ ███████    ██    █████   ██      ███████ ██ ██  ██ ██   ██ ");
        System.out.println("\t██ ███ ██ ██   ██      ██    ██    ██      ██      ██   ██ ██  ██ ██ ██   ██ ");
        System.out.println("\t ███ ███  ██   ██ ███████    ██    ███████ ███████ ██   ██ ██   ████ ██████  ");
        System.out.println("\t*****************************************************************************");
        System.out.println(" ");
        System.out.println("\tWelcome to The Wasteland, survivor");
        System.out.println(" ");
        System.out.println("\tYour goal is to make it to the safe zone, it's a long trek");
        System.out.println("\tBut it's dangerous out there, you'll face a new challenge everyday");
        System.out.println("\tMake your desicions wisely, they are literally life or death");
        System.out.println(" ");
        System.out.println("\tGood luck, you'll need it!");
        System.out.println(" ");
        System.out.println("\t*****************************************************************************");
        System.out.println(" ");

        Game g = new Game();
        g.ranChal();

    }

    // Random number generator used for calculating damage etc.
    // Takes in max and min and returns a value in that range
    public int ranGen(int max, int min) {

        int range = max - min + 1;

        int rand = (int) (Math.random() * range) + min;

        return rand;
    }

    // This decides which challenges you will face each day
    public void ranChal() {

        int gameLength = ranGen(7, 7);

        if (completed.size() == (gameLength - 1)) {
            lastDay = true;
        }
        // System.out.println("lastDay = " + lastDay);

        int rand = ranGen(7, 1);
        switch (rand) {

            // Pirahnas
            case 1:
                // Check the array of completed methods, if this challenge is there, pick
                // another
                // If not, do the challenge and add it to the array.
                if (completed.contains(1)) {
                    ranChal();
                } else {
                    completed.add(1);
                    pirahnas(p);
                    break;
                }

                // Bandits
            case 2:
                if (completed.contains(2)) {
                    ranChal();
                } else {
                    completed.add(2);
                    bandits(p);
                    break;
                }

                // Dog
            case 3:
                if (completed.contains(3)) {
                    ranChal();
                } else {
                    completed.add(3);
                    dog(p);
                    break;
                }

                // Ravine
            case 4:
                if (completed.contains(4)) {
                    ranChal();
                } else {
                    completed.add(4);
                    ravine(p);
                    break;
                }

                // Gamble
            case 5:
                if (completed.contains(5)) {
                    ranChal();
                } else {
                    completed.add(5);
                    gamble(p);
                    break;
                }

                // Idol
            case 6:
                if (completed.contains(6)) {
                    ranChal();
                } else {
                    completed.add(6);
                    idol(p);
                    break;
                }

                // Mutants
            case 7:
                if (completed.contains(7)) {
                    ranChal();
                } else {
                    completed.add(7);
                    mutant(p);
                    break;
                }

        }

    }

    // GAME OVER - for when you lose all your health
    public void death() {
        dayCount--;
        System.out.println(" ");
        System.out.println("\tSo you have died a horrible death...");
        System.out.println("\tYou lasted " + dayCount + " days...");
        System.out.println("\tTry better next time...");
        System.out.println(" ");
        System.out.println("\t*****************************************************************************");
        System.out.println("\t ██████   █████  ███    ███ ███████      ██████  ██    ██ ███████ ██████  ");
        System.out.println("\t██       ██   ██ ████  ████ ██          ██    ██ ██    ██ ██      ██   ██ ");
        System.out.println("\t██   ███ ███████ ██ ████ ██ █████       ██    ██ ██    ██ █████   ██████  ");
        System.out.println("\t██    ██ ██   ██ ██  ██  ██ ██          ██    ██  ██  ██  ██      ██   ██ ");
        System.out.println("\t ██████  ██   ██ ██      ██ ███████      ██████    ████   ███████ ██   ██ ");
        System.out.println("\t*****************************************************************************");
        System.exit(0);
    }

    public void finish() {
        System.out.println(" ");
        System.out.println("\tAfter days of walking and hazardous obstacles, you finally made it to the safe zone..");
        System.out.println("\tThe guards at the gates open up and you stumble through...");
        System.out.println("\tYou survived all " + dayCount + " days...");
        System.out.println(" ");
        System.out.println("\t*********************************************************");
        System.out.println("\t██    ██  ██████  ██    ██     ██     ██ ██ ███    ██ ██ ");
        System.out.println("\t ██  ██  ██    ██ ██    ██     ██     ██ ██ ████   ██ ██ ");
        System.out.println("\t  ████   ██    ██ ██    ██     ██  █  ██ ██ ██ ██  ██ ██ ");
        System.out.println("\t   ██    ██    ██ ██    ██     ██ ███ ██ ██ ██  ██ ██    ");
        System.out.println("\t   ██     ██████   ██████       ███ ███  ██ ██   ████ ██ ");
        System.out.println("\t*********************************************************");
        System.exit(0);
    }

    public void dogDeath(Dog d) {
        System.out.println(" ");
        System.out.println("\tThe stress was too much for " + d.name);
        System.out.println("\tYou lift his body over to a grassy hill under the shade of a tree.");
        System.out.println("\tYou lay him down gently to his final resting place.");
        System.out.println("\tYou give him one last head scratch and wipe a tear away.");
        System.out.println("\tHis efforts will not be forgotten");
        System.out.println(" ");
        return;
    }

    // This calculates the damage multiplier recieved
    // based on energy, hunger and thirst levels
    public double getMultiplier() {

        double multiplier = 0.0;
        int count = 0;

        // Energy multiplier
        if (p.energy < 75) {
            if (count < 3) {
                count++;
            }
        } else if (p.energy >= 75) {
            if (count > 0) {
                count--;
            }
        }

        // Thirst multiplier
        if (p.thirst < 75) {
            if (count < 3) {
                count++;
            }
        } else if (p.thirst >= 75) {
            if (count > 0) {
                count--;
            }
        }

        // Hunger multiplier
        if (p.hunger < 75) {
            if (count < 3) {
                count++;
            }
        } else if (p.hunger >= 75) {
            if (count > 0) {
                count--;
            }
        }

        if (count == 0) {
            multiplier = 1.0;
        } else if (count == 1) {
            multiplier = 1.1;
        } else if (count == 2) {
            multiplier = 1.3;
        } else if (count == 3) {
            multiplier = 1.5;
        }

        return multiplier;
    }

    // This method allows the player to use items
    public void useItems(Player p) {

        int foodValue = 40;
        int waterValue = 40;
        int medsValue = 50;

        Scanner sc = new Scanner(System.in);

        System.out.println(" ");
        System.out.println("\t> Which item would you like to use?");
        System.out.println("\t• Food (1),");
        System.out.println("\t• Water (2)");
        System.out.println("\t• Meds (3)");
        System.out.println("\t• None, bring on the next challenge! (4)");
        System.out.println(" ");
        int itemChoice = sc.nextInt();

        if (itemChoice == 1) {
            // Food usage
            if (p.hunger < 200) {
                if (p.food >= 1) {
                    p.setHunger(foodValue);
                    System.out.println(" ");
                    System.out.println("\t> Ate 1 food item!");
                    System.out.println("\t> Player hunger level now at " + p.hunger + "/200!");
                    p.food--;
                    System.out.println("\t> " + p.food + " food item(s) left!");

                    useItems(p);
                } else if (p.food == 0) {
                    System.out.println(" ");
                    System.out.println("\t> You don't have enough food!");

                    useItems(p);
                }

            } else {
                System.out.println(" ");
                System.out.println("\t> You don't need to eat food!");

                useItems(p);
            }

            // Water usage
        } else if (itemChoice == 2) {
            if (p.thirst < 200) {
                if (p.water >= 1) {
                    p.setThirst(waterValue);
                    System.out.println(" ");
                    System.out.println("\t> Drank 1 water bottle!");
                    System.out.println("\t> Player thirst level now at " + p.thirst + "/200!");
                    p.water--;
                    System.out.println("\t> " + p.water + " water bottle(s) left!");

                    useItems(p);
                } else if (p.water == 0) {
                    System.out.println(" ");
                    System.out.println("\t> You don't have enough water bottles!");
                    useItems(p);
                }
            } else {
                System.out.println(" ");
                System.out.println("\t> You don't need to drink water!");

                useItems(p);
            }
            // Meds usage
        } else if (itemChoice == 3) {
            if (p.health < 150) {
                if (p.meds >= 1) {
                    p.setHealth(medsValue);
                    System.out.println(" ");
                    System.out.println("\t> Used 1 medicine kit!");
                    System.out.println("\t> Player health level now at " + p.health + "/150!");
                    p.meds--;
                    System.out.println("\t> " + p.meds + " medicine kit(s) left!");

                    useItems(p);
                } else if (p.meds == 0) {
                    System.out.println(" ");
                    System.out.println("\t> You don't have enough medicine kits!");
                    useItems(p);
                }
            } else {
                System.out.println(" ");
                System.out.println("\t> You don't need to heal!");

                useItems(p);
            }
        } else if (itemChoice == 4) {
            ranChal();
        }
    }

    // This method checks the health of the dog and
    // asks the player to heal the dog if they want to
    public void dogHealthCheck(Player p, Dog d) {
        if (d.health <= 40) {
            Scanner sc = new Scanner(System.in);

            int foodValue = 50;

            System.out.println(" ");
            System.out.println("\t> " + d.name + "'s health is low! (" + d.health + "/100)");
            System.out.println("\t> Use some food to heal him?");
            System.out.println("\tYes (1)");
            System.out.println("\tNo (2)");
            System.out.println(" ");
            int choice = sc.nextInt();

            if (choice == 1) {
                if (p.food >= 1) {
                    d.setDogHealth(foodValue);
                    p.food--;
                    System.out.println(" ");
                    System.out.println("\tGave " + d.name + " some food");
                    System.out.println("\t> " + d.name + "'s health level is now " + d.health + "/100");
                    System.out.println(" ");
                } else if (p.food < 1) {
                    System.out.println(" ");
                    System.out.println("\tNo food to give!");
                    System.out.println(" ");
                    return;
                }
            } else {
                return;
            }
        }
    }

    // Decides if you earn an extra food item
    // Input is the denominator of the fraction
    // that is the chance of it happening
    // i.e. put in 5 = 1/5 chance
    public boolean foodReward(int chan) {
        int min = 1;
        int range = chan - min + 1;
        int rand = (int) (Math.random() * range) + min;
        if (rand == 1) {
            return true;
        } else {
            return false;
        }
    }

    // Decides if you earn an extra water item
    // Input is the denominator of the fraction
    // that is the chance of it happening
    // i.e. put in 5 = 1/5 chance
    public boolean waterReward(int chan) {
        int min = 1;

        int range = chan - min + 1;
        int rand = (int) (Math.random() * range) + min;
        if (rand == 1) {
            return true;
        } else {
            return false;
        }
    }

    // Decides if you earn an extra med item
    // Input is the denominator of the fraction
    // that is the chance of it happening
    // i.e. put in 5 = 1/5 chance
    public boolean medsReward(int chan) {
        int min = 1;

        int range = chan - min + 1;
        int rand = (int) (Math.random() * range) + min;
        if (rand == 1) {
            return true;
        } else {
            return false;
        }
    }

    // Pirahnas method
    public void pirahnas(Player p) {
        // Challenge introduction
        System.out.println("\t*****");
        System.out.println("\tDAY " + dayCount);
        dayCount++;
        System.out.println("\t*****");
        System.out.println(
                "\t> You come across a river that appears to be calm, that is, until you notice the pirahnas!");
        if (dog) {
            System.out
                    .println("\t> " + d.name + " sniffs the water and jumps back when one jumps out and snaps at him.");
        }
        System.out.println(
                "\t> You have three choices, either dive in and swim for it, throw some food down stream to distract them, or find another way around.");
        System.out.println(" ");
        System.out.println("\t> What will you do?");
        System.out.println(" ");
        System.out.println("\t• Swim (1),");
        System.out.println("\t• throw food (2), or");
        System.out.println("\t• find another way (3)");
        System.out.println(" ");

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        // Damage multiplier
        double damageMultiplier = getMultiplier();

        // Damage calculations for option 1
        int healthLost1 = ranGen(7, 3);
        double healthLost1DM;
        if (dog) {
            healthLost1DM = (healthLost1 * damageMultiplier) * 0.8;
        } else {
            healthLost1DM = healthLost1 * damageMultiplier;
        }
        int energyLost1 = ranGen(6, 2);
        int thirstLost1 = ranGen(6, 3);
        int hungerLost1 = ranGen(6, 3);

        // Damage calculations for option 2
        int healthLost2 = ranGen(1, 0);
        double healthLost2DM;
        if (dog) {
            healthLost2DM = (healthLost2 * damageMultiplier) * 0.8;
        } else {
            healthLost2DM = healthLost2 * damageMultiplier;
        }
        int energyLost2 = ranGen(4, 3);
        int thirstLost2 = ranGen(4, 3);
        int hungerLost2 = ranGen(4, 2);
        int foodLost2 = ranGen(2, 1);

        // Damage calculations for option 3
        int energyLost3 = ranGen(8, 5);
        int thirstLost3 = ranGen(5, 3);
        int hungerLost3 = ranGen(5, 3);

        int elostFinal = 0;
        int helostFinal = 0;
        int tlostFinal = 0;
        int hulostFinal = 0;

        // FISH - CHOICE 1 - Swim for it
        if (choice == 1) {
            // DEATH
            if (p.health <= (healthLost1DM * 10)) {
                System.out.println(" ");
                System.out.println("\t> You dive in, the pirahnas start chomping and you die a slow painful death");
                System.out.println(" ");
                death();
                return;

            } else if (p.health > (healthLost1DM * 10)) {
                System.out.println(" ");
                System.out.println(
                        "\t> You dive in, the pirahnas start chomping but you narrowly make it across to the other side");
                System.out.println(" ");

                // Health loss applied
                p.health = p.health - (healthLost1DM * 10);
                helostFinal = (int) Math.round(healthLost1DM);

                // Energy loss applied
                if (p.energy < (energyLost1 * 10)) {
                    p.energy = 0;
                } else {
                    p.energy = p.energy - (energyLost1 * 10);
                }
                elostFinal = energyLost1 * 10;

                // Thirst applied
                if (p.thirst < (thirstLost1 * 10)) {
                    p.thirst = 0;
                } else {
                    p.thirst = p.thirst - (thirstLost1 * 10);
                }
                tlostFinal = thirstLost1 * 10;

                // Hunger applied
                if (p.hunger < (hungerLost1 * 10)) {
                    p.hunger = 0;
                } else {
                    p.hunger = p.hunger - (hungerLost1 * 10);
                }
                hulostFinal = hungerLost1 * 10;

                // Dog health loss applied
                if (d.health <= (healthLost1DM * 8)) {
                    d.health = 0;
                    dogDeath(d);
                } else {
                    d.health = d.health - (healthLost1DM * 8);
                }

                if (helostFinal > 0) {
                    System.out.println("\t» -" + helostFinal * 10 + " health!");
                }
                System.out.println("\t» -" + elostFinal + " energy!");
                System.out.println("\t» -" + tlostFinal + " thirst!");
                System.out.println("\t» -" + hulostFinal + " hunger!");

            }

            // FISH - CHOICE 2 - Throw food
        } else if (choice == 2) {
            if (p.food >= 1) {
                System.out.println(" ");
                System.out.println(
                        "\t> You throw some food into the water downstream and the school of pirahnas follows. You take this opportunity to make a break for the other bank.");
                System.out.println(" ");

                // Health loss applied
                p.health = p.health - (healthLost2DM * 10);
                helostFinal = (int) Math.round(healthLost2DM);

                // Energy loss applied
                if (p.energy < (energyLost2 * 10)) {
                    p.energy = 0;
                } else {
                    p.energy = p.energy - (energyLost2 * 10);
                }
                elostFinal = energyLost2 * 10;

                // Thirst applied
                if (p.thirst < (thirstLost2 * 10)) {
                    p.thirst = 0;
                } else {
                    p.thirst = p.thirst - (thirstLost2 * 10);
                }
                tlostFinal = thirstLost2 * 10;

                // Hunger applied
                if (p.hunger < (hungerLost2 * 10)) {
                    p.hunger = 0;
                } else {
                    p.hunger = p.hunger - (hungerLost2 * 10);
                }
                hulostFinal = hungerLost2 * 10;

                // Food loss applied
                p.food = p.food - (foodLost2);

                // Dog health loss applied
                if (d.health <= (healthLost2DM * 6)) {
                    d.health = 0;
                    dogDeath(d);
                } else {
                    d.health = d.health - (healthLost2DM * 6);
                }

                if (helostFinal > 0) {
                    System.out.println("\t» -" + helostFinal * 10 + " health!");
                }
                System.out.println("\t» -" + elostFinal + " energy!");
                System.out.println("\t» -" + tlostFinal + " thirst!");
                System.out.println("\t» -" + hulostFinal + " hunger!");
                System.out.println("\t» -" + foodLost2 + " food!");

            } else {
                System.out.println("\t> You check your backpack and realise you don't have enough food");
                int altChoice = ranGen(2, 1);
                if (altChoice == 1) {
                    // DEATH
                    if (p.health <= (healthLost1DM * 10)) {
                        System.out.println(" ");
                        System.out.println(
                                "\t> You dive in, the pirahnas start chomping and you die a slow painful death");
                        System.out.println(" ");
                        death();
                        return;

                    } else if (p.health > (healthLost1DM * 10)) {
                        System.out.println(" ");
                        System.out.println(
                                "\t> You dive in, the pirahnas start chomping but you narrowly make it across to the other side");
                        System.out.println(" ");

                        // Health loss applied
                        p.health = p.health - (healthLost1DM * 10);
                        helostFinal = (int) Math.round(healthLost1DM);

                        // Energy loss applied
                        if (p.energy < (energyLost1 * 10)) {
                            p.energy = 0;
                        } else {
                            p.energy = p.energy - (energyLost1 * 10);
                        }
                        elostFinal = energyLost1 * 10;

                        // Thirst applied
                        if (p.thirst < (thirstLost1 * 10)) {
                            p.thirst = 0;
                        } else {
                            p.thirst = p.thirst - (thirstLost1 * 10);
                        }
                        tlostFinal = thirstLost1 * 10;

                        // Hunger applied
                        if (p.hunger < (hungerLost1 * 10)) {
                            p.hunger = 0;
                        } else {
                            p.hunger = p.hunger - (hungerLost1 * 10);
                        }
                        hulostFinal = hungerLost1 * 10;

                        // Dog health loss applied
                        if (d.health <= (healthLost1DM * 8)) {
                            d.health = 0;
                            dogDeath(d);
                        } else {
                            d.health = d.health - (healthLost1DM * 8);
                        }

                        if (helostFinal > 0) {
                            System.out.println("\t» -" + helostFinal * 10 + " health!");
                        }
                        System.out.println("\t» -" + elostFinal + " energy!");
                        System.out.println("\t» -" + tlostFinal + " thirst!");
                        System.out.println("\t» -" + hulostFinal + " hunger!");

                    }
                } else {
                    System.out.println(" ");
                    System.out.println(
                            "\t> You decide to find another way around instead, you follow the course of the river for what seems like hours until you come across a fallen tree.");
                    System.out.println(
                            "\t> You carefully balance along it to the other riverbank and safely make your way across");
                    System.out.println(" ");

                    // Energy loss applied
                    if (p.energy < (energyLost3 * 10)) {
                        p.energy = 0;
                    } else {
                        p.energy = p.energy - (energyLost3 * 10);
                    }
                    elostFinal = energyLost3 * 10;

                    // Thirst applied
                    if (p.thirst < (thirstLost3 * 10)) {
                        p.thirst = 0;
                    } else {
                        p.thirst = p.thirst - (thirstLost3 * 10);
                    }
                    tlostFinal = thirstLost3 * 10;

                    // Hunger applied
                    if (p.hunger < (hungerLost3 * 10)) {
                        p.hunger = 0;
                    } else {
                        p.hunger = p.hunger - (hungerLost3 * 10);
                    }
                    hulostFinal = hungerLost3 * 10;

                    System.out.println("\t» -" + elostFinal + " energy!");
                    System.out.println("\t» -" + tlostFinal + " thirst!");
                    System.out.println("\t» -" + hulostFinal + " hunger!");
                }
            }

            // FISH - CHOICE 3 - Find another way
        } else if (choice == 3) {
            System.out.println(" ");
            System.out.println(
                    "\t> You decide to find another way around instead, you follow the course of the river for what seems like hours until you come across a fallen tree.");
            System.out.println(
                    "\t> You carefully balance along it to the other riverbank and safely make your way across");
            System.out.println(" ");

            // Energy loss applied
            if (p.energy < (energyLost3 * 10)) {
                p.energy = 0;
            } else {
                p.energy = p.energy - (energyLost3 * 10);
            }
            elostFinal = energyLost3 * 10;

            // Thirst applied
            if (p.thirst < (thirstLost3 * 10)) {
                p.thirst = 0;
            } else {
                p.thirst = p.thirst - (thirstLost3 * 10);
            }
            tlostFinal = thirstLost3 * 10;

            // Hunger applied
            if (p.hunger < (hungerLost3 * 10)) {
                p.hunger = 0;
            } else {
                p.hunger = p.hunger - (hungerLost3 * 10);
            }
            hulostFinal = hungerLost3 * 10;

            System.out.println("\t» -" + elostFinal + " energy!");
            System.out.println("\t» -" + tlostFinal + " thirst!");
            System.out.println("\t» -" + hulostFinal + " hunger!");
        }

        // Calculates if the player gets an item
        boolean foodReward = foodReward(5);
        boolean waterReward = waterReward(10);
        boolean medsReward = medsReward(20);

        if (foodReward) {
            p.food++;
            System.out.println("\t» Picked up 1 food!");
        }

        if (waterReward) {
            p.water++;
            System.out.println("\t» Picked up 1 water!");
        }

        if (medsReward) {
            p.meds++;
            System.out.println("\t» Picked up 1 med!");
        }

        // Player gets to "rest" between days (challenges)
        // So they regain a bit of energy
        int energyValue = 1;
        p.setEnergy((energyValue * 10));
        System.out.println("\t» Sleeping that night regained " + energyValue * 10 + " energy!");

        p.print();

        // Runs a dog health check
        if (dog) {
            dogHealthCheck(p, d);
        }

        if (lastDay) {
            finish();
        } else {
            // Ask the player if they want to use items
            System.out.println(" ");
            System.out.println("\t> Would you like to use some items to heal?");
            System.out.println("\t• Yes (1)");
            System.out.println("\t• No (2)");
            System.out.println(" ");
            int itemUsage = sc.nextInt();
            if (itemUsage == 1) {
                useItems(p);
            } else {
                ranChal();
            }
        }

    }

    // END OF PIRAHNA METHOD

    // Bandits method
    public void bandits(Player p) {
        // Challenge Introduction
        System.out.println("\t*****");
        System.out.println("\tDAY " + dayCount);
        dayCount++;
        System.out.println("\t*****");
        System.out.println("\t> Moving through a wooded area you are ambushed by a group of bandits.");
        System.out.println("\t\"Woah hold up there buddy, where do you think you're headed?\"");
        System.out.println("\t\"You got two options, either hand over everything you got, or die..\"");
        if (dog) {
            System.out.println("\t> " + d.name + " stands between you and the bandits and starts to growl..");
        }
        System.out.println(" ");
        System.out.println("\t> What will you do?");
        System.out.println(" ");
        System.out.println("\t• Give them everything (1) or");
        System.out.println("\t• fight (2)");
        System.out.println(" ");

        int initialFood = p.food;
        int initialWater = p.water;
        int initialMeds = p.meds;

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        // Damage multiplier
        double damageMultiplier = getMultiplier();

        // Damage calculations for option 2
        int healthLost1 = ranGen(10, 3);
        double healthLost1DM;
        if (dog) {
            healthLost1DM = (healthLost1 * damageMultiplier) * 0.8;
        } else {
            healthLost1DM = healthLost1 * damageMultiplier;
        }
        int energyLost1 = ranGen(14, 7);
        int thirstLost1 = ranGen(6, 3);
        int hungerLost1 = ranGen(6, 3);

        int elostFinal = 0;
        int helostFinal = 0;
        int tlostFinal = 0;
        int hulostFinal = 0;

        // BANDITS - CHOICE 1
        if (choice == 1) {

            System.out.println(" ");
            System.out.println("\t> You decide to hand everything over");
            System.out.println("\t\"Wise choice, be on your way soldier...\"");
            System.out.println(" ");

            p.food = 0;
            p.water = 0;
            p.meds = 0;

            System.out.println("\t» -" + initialFood + " food!");
            System.out.println("\t» -" + initialWater + " water!");
            System.out.println("\t» -" + initialMeds + " medicine kit(s)!");
        }

        // BANDITS - CHOICE 2
        else {
            System.out.println(" ");
            System.out.println("\t> You decide to fight");
            System.out.println("\t\"So you WANT to die do ya?\"");
            System.out.println(" ");

            // DEATH
            if (p.health <= (healthLost1DM * 10)) {
                System.out.println(" ");
                System.out.println("\t> The fight did NOT go your way...");
                System.out.println("\t\"You got what you deserved, take everything he has boys.\"");
                System.out.println(" ");
                death();
                return;

            } else if (p.health > (healthLost1DM * 10)) {
                System.out.println(" ");
                System.out.println(
                        "\t> You make light work of the team, none are left breathing by the time you are done with them...");
                System.out.println("\t> You start looting their bodies...");
                System.out.println(" ");

                // Health loss applied
                p.health = p.health - (healthLost1DM * 10);
                helostFinal = (int) Math.round(healthLost1DM);

                // Energy loss applied
                if (p.energy < (energyLost1 * 10)) {
                    p.energy = 0;
                } else {
                    p.energy = p.energy - (energyLost1 * 10);
                }
                elostFinal = hungerLost1 * 10;

                // Thirst applied
                if (p.thirst < (thirstLost1 * 10)) {
                    p.thirst = 0;
                } else {
                    p.thirst = p.thirst - (thirstLost1 * 10);
                }
                tlostFinal = hungerLost1 * 10;

                // Hunger applied
                if (p.hunger < (hungerLost1 * 10)) {
                    p.hunger = 0;
                } else {
                    p.hunger = p.hunger - (hungerLost1 * 10);
                }
                hulostFinal = hungerLost1 * 10;

                // Dog health loss applied
                if (d.health <= (healthLost1DM * 8)) {
                    d.health = 0;
                    dogDeath(d);
                } else {
                    d.health = d.health - (healthLost1DM * 8);
                }

                if (helostFinal > 0) {
                    System.out.println("\t» -" + helostFinal * 10 + " health!");
                }
                System.out.println("\t» -" + elostFinal + " energy!");
                System.out.println("\t» -" + tlostFinal + " thirst!");
                System.out.println("\t» -" + hulostFinal + " hunger!");

                // Calculates if the player gets an item
                boolean foodReward = foodReward(1);
                boolean waterReward = waterReward(1);
                boolean medsReward = medsReward(1);

                // Since the rewards are guranteed this
                // Calculates how many you get
                int foodAmount = ranGen(2, 1);
                int waterAmount = ranGen(2, 1);
                int medsAmount = ranGen(2, 1);

                if (foodReward) {
                    p.food = p.food + foodAmount;
                    System.out.println("\t» Looted " + foodAmount + " food!");
                }

                if (waterReward) {
                    p.water = p.water + waterAmount;
                    System.out.println("\t» Looted " + waterAmount + " water!");
                }

                if (medsReward) {
                    p.meds = p.meds + medsAmount;
                    System.out.println("\t» Looted " + medsAmount + " meds!");
                }
            }

        }

        // Player gets to "rest" between days (challenges)
        // So they regain a bit of energy
        int energyValue = 1;
        p.setEnergy((energyValue * 10));
        System.out.println("\t» Sleeping that night regained " + energyValue * 10 + " energy!");

        p.print();

        // Runs a dog health check
        if (dog) {
            dogHealthCheck(p, d);
        }

        if (lastDay) {
            finish();
        } else {
            // Ask the player if they want to use items
            System.out.println(" ");
            System.out.println("\t> Would you like to use some items to heal?");
            System.out.println("\t• Yes (1)");
            System.out.println("\t• No (2)");
            System.out.println(" ");
            int itemUsage = sc.nextInt();
            if (itemUsage == 1) {
                useItems(p);
            } else {
                ranChal();
            }
        }

    }

    // END OF BANDITS METHOD

    // Dog encounter method
    public void dog(Player p) {
        System.out.println("\t*****");
        System.out.println("\tDAY " + dayCount);
        dayCount++;
        System.out.println("\t*****");
        System.out.println("\t> You come across a mean-looking stray dog, he appears to be hurt");
        System.out.println(
                "\t> You want to help him but at the same time, if you make a wrong move you could get seriously hurt..");
        System.out.println("\t");
        System.out.println("\t> What will you do?");
        System.out.println(" ");
        System.out.println("\t• Walk swiftly in the opposite direction (1) or");
        System.out.println("\t• Attempt to help him with food and medicine (2)");
        System.out.println(" ");

        Scanner sc = new Scanner(System.in);
        Scanner scName = new Scanner(System.in);
        int choice = sc.nextInt();

        // Damage multiplier
        double damageMultiplier = getMultiplier();

        // Damage calculations for option 2
        int healthLost1 = ranGen(1, 1);
        double healthLost1DM = healthLost1 * damageMultiplier;
        int energyLost1 = ranGen(5, 2);

        int elostFinal = 0;
        int helostFinal = 0;

        // Dont help the dog - CHOICE 1 - Dog
        if (choice == 1) {

            System.out.println(" ");
            System.out.println("\t> You quickly turn around and begin walking");
            System.out.println("\t> He could have been a good ally but he could also have turned vicious");
            System.out.println("\t> Besides, it would have been one more mouth to feed!");
            System.out.println(" ");

        }

        // Try to help - CHOICE 2 - Dog
        else {
            if (p.food == 0) {
                System.out.println(" ");
                System.out.println("\t> You start approaching the dog and then realise you have no food to give");
                System.out.println("\t> The dog also realises this and lunges at you, biting your hand");
                System.out.println(" ");

                // DEATH
                if (p.health <= (healthLost1DM * 10)) {
                    System.out.println(" ");
                    System.out.println("\t> You were already so weak and this was the final straw");
                    System.out.println("\t> You lay on your back as you slowly bleed out...");
                    System.out.println(" ");
                    death();
                    return;

                } else if (p.health > (healthLost1DM * 10)) {
                    System.out.println(" ");
                    System.out.println("\t> You recoil from the bite and start to run away");
                    System.out.println("\t> You stop once you are far, far away and safe once more.");
                    System.out.println(" ");

                    // Health loss applied
                    p.health = p.health - (healthLost1DM * 10);
                    helostFinal = (int) Math.round(healthLost1DM);

                    // Energy loss applied
                    if (p.energy < (energyLost1 * 10)) {
                        p.energy = 0;
                    } else {
                        p.energy = p.energy - (energyLost1 * 10);
                    }
                    elostFinal = energyLost1 * 10;

                    if (helostFinal > 0) {
                        System.out.println("\t» -" + helostFinal * 10 + " health!");
                    }
                    System.out.println("\t» -" + elostFinal + " energy!");

                }
            } else if (p.food >= 1) {
                System.out.println(" ");
                System.out.println("\t> You start approaching the dog with a piece of food in your hand");
                System.out.println("\t> He cautiously approaches you and takes the food.");
                System.out.println(
                        "\t> He lies down on the ground while he eats and you use a medicine kit to patch up his wounds");
                System.out.println("\t> You have befriended him! He will reduce all incoming damage by 20%!");
                System.out.println("\t> But he will need food to survive!");
                System.out.println("\t> What will you name him?");
                System.out.println(" ");
                String name = scName.nextLine();

                d.setDogName(name);

                System.out.println(" ");
                System.out.println("\t> " + d.name + ", you are proud of that one!");
                System.out.println(" ");
                System.out.println("\t» -1 food");
                System.out.println("\t» -1 medicine kit");
                dog = true;
                p.food--;
                p.meds--;
            }

        }

        // Player gets to "rest" between days (challenges)
        // So they regain a bit of energy
        int energyValue = 1;
        p.setEnergy((energyValue * 10));
        System.out.println("\t» Sleeping that night regained " + energyValue * 10 + " energy!");

        p.print();

        if (lastDay) {
            finish();
        } else {
            // Ask the player if they want to use items
            System.out.println(" ");
            System.out.println("\t> Would you like to use some items to heal?");
            System.out.println("\t• Yes (1)");
            System.out.println("\t• No (2)");
            System.out.println(" ");
            int itemUsage = sc.nextInt();
            if (itemUsage == 1) {
                useItems(p);
            } else {
                ranChal();
            }
        }
    }

    // END OF DOG METHOD

    // RAVINE method
    public void ravine(Player p) {
        // Challenge introduction
        System.out.println("\t*****");
        System.out.println("\tDAY " + dayCount);
        dayCount++;
        System.out.println("\t*****");
        System.out.println("\t> You stumble upon a huge rip in the ground...a ravine.");
        System.out.println("\t> You look over the edge and instantly get dizzy..");
        if (dog) {
            System.out.println("\t> " + d.name + " peeks over the edge..");
        }
        System.out.println(" ");
        System.out.println("\t> You have two choices, either try and make a jump for it or find another way around.");
        System.out.println(" ");
        System.out.println("\t> What will you do?");
        System.out.println(" ");
        System.out.println("\t• Jump (1) or");
        System.out.println("\t• find another way (2)");
        System.out.println(" ");

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        // Damage multiplier
        double damageMultiplier = getMultiplier();

        // Damage calculations for option 1
        int healthLost1 = ranGen(4, 1);
        double healthLost1DM;
        if (dog) {
            healthLost1DM = (healthLost1 * damageMultiplier) * 0.8;
        } else {
            healthLost1DM = healthLost1 * damageMultiplier;
        }
        int energyLost1 = ranGen(5, 3);
        int thirstLost1 = ranGen(4, 3);
        int hungerLost1 = ranGen(4, 2);

        // Damage calculations for option 2
        int energyLost2 = ranGen(6, 4);
        int thirstLost2 = ranGen(5, 4);
        int hungerLost2 = ranGen(5, 4);

        int elostFinal = 0;
        int helostFinal = 0;
        int tlostFinal = 0;
        int hulostFinal = 0;

        // RAVINE - CHOICE 1 - Jump
        if (choice == 1) {
            // DEATH
            if (p.energy <= 70) {
                System.out.println(" ");
                System.out.println(
                        "\t> You begin running towards the gap, but your legs just don't feel fast enough...you don't feel like you have enough energy...");
                System.out.println("\t> Your feet leave the ground and you are floating midair...");
                System.out.println("\t> You slam into the other side and fall for what seems like an eternity...");
                System.out.println("\t> You hit the ground below and take your last breaths...");
                System.out.println(" ");
                death();
                return;

            } else if (p.energy > 70) {
                System.out.println(" ");
                System.out.println("\t> You begin running towards the gap, and suddenly your feet leave the ground...");
                System.out.println("\t> You seem to be floating midair...");
                System.out.println("\t> You barely land on the other side and collapse in a heap of nerves...");
                System.out.println("\t> You lie down on the ground and take what could have been your last breaths...");
                System.out.println(" ");

                // Health loss applied
                p.health = p.health - (healthLost1DM * 10);
                helostFinal = (int) Math.round(healthLost1DM);

                // Energy loss applied
                if (p.energy < (energyLost1 * 10)) {
                    p.energy = 0;
                } else {
                    p.energy = p.energy - (energyLost1 * 10);
                }
                elostFinal = energyLost1 * 10;

                // Thirst applied
                if (p.thirst < (thirstLost1 * 10)) {
                    p.thirst = 0;
                } else {
                    p.thirst = p.thirst - (thirstLost1 * 10);
                }
                tlostFinal = thirstLost1 * 10;

                // Hunger applied
                if (p.hunger < (hungerLost1 * 10)) {
                    p.hunger = 0;
                } else {
                    p.hunger = p.hunger - (hungerLost1 * 10);
                }
                hulostFinal = hungerLost1 * 10;

                // Dog health loss applied
                if (d.health <= (healthLost1DM * 8)) {
                    d.health = 0;
                    dogDeath(d);
                } else {
                    d.health = d.health - (healthLost1DM * 8);
                }

                if (helostFinal > 0) {
                    System.out.println("\t» -" + helostFinal * 10 + " health!");
                }
                System.out.println("\t» -" + elostFinal + " energy!");
                System.out.println("\t» -" + tlostFinal + " thirst!");
                System.out.println("\t» -" + hulostFinal + " hunger!");

            }

            // Ravine - CHOICE 2 - Find another way
        } else if (choice == 2) {
            System.out.println(" ");
            System.out.println(
                    "\t> You decide to find another way around instead, you look up and down the ravine and spot a fallen tree spanning the gap.");
            System.out.println(
                    "\t> You carefully balance along it to the other side of the ravine and safely make your way across");
            System.out.println(" ");

            // Energy loss applied
            if (p.energy < (energyLost2 * 10)) {
                p.energy = 0;
            } else {
                p.energy = p.energy - (energyLost2 * 10);
            }
            elostFinal = energyLost2 * 10;

            // Thirst applied
            if (p.thirst < (thirstLost2 * 10)) {
                p.thirst = 0;
            } else {
                p.thirst = p.thirst - (thirstLost2 * 10);
            }
            tlostFinal = thirstLost2 * 10;

            // Hunger applied
            if (p.hunger < (hungerLost2 * 10)) {
                p.hunger = 0;
            } else {
                p.hunger = p.hunger - (hungerLost2 * 10);
            }
            hulostFinal = hungerLost2 * 10;

            System.out.println("\t» -" + elostFinal + " energy!");
            System.out.println("\t» -" + tlostFinal + " thirst!");
            System.out.println("\t» -" + hulostFinal + " hunger!");
        }

        // Calculates if the player gets an item
        boolean foodReward = foodReward(20);
        boolean waterReward = waterReward(20);
        boolean medsReward = medsReward(20);

        if (foodReward) {
            p.food++;
            System.out.println("\t» Picked up 1 food!");
        }

        if (waterReward) {
            p.water++;
            System.out.println("\t» Picked up 1 water!");
        }

        if (medsReward) {
            p.meds++;
            System.out.println("\t» Picked up 1 med!");
        }

        // Player gets to "rest" between days (challenges)
        // So they regain a bit of energy
        int energyValue = 1;
        p.setEnergy((energyValue * 10));
        System.out.println("\t» Sleeping that night regained " + energyValue * 10 + " energy!");

        p.print();

        // Runs a dog health check
        if (dog) {
            dogHealthCheck(p, d);
        }

        if (lastDay) {
            finish();
        } else {
            // Ask the player if they want to use items
            System.out.println(" ");
            System.out.println("\t> Would you like to use some items to heal?");
            System.out.println("\t• Yes (1)");
            System.out.println("\t• No (2)");
            System.out.println(" ");
            int itemUsage = sc.nextInt();
            if (itemUsage == 1) {
                useItems(p);
            } else {
                ranChal();
            }
        }

    }

    // END OF RAVINE METHOD

    // GAMBLE method
    public void gamble(Player p) {
        // Challenge introduction
        System.out.println("\t*****");
        System.out.println("\tDAY " + dayCount);
        dayCount++;
        System.out.println("\t*****");
        System.out.println("\t> As you walk along a dusty old road you see a shack over the hill");
        System.out.println("\t> As you approach you can see an old man out front in a rocking chair");
        System.out.println("\t\"Oh hi there, won't you play a game with me? You can bet what you like...\"");
        if (dog) {
            System.out.println("\t> He pats" + d.name + " on the head..");
        }
        System.out.println(" ");
        System.out.println("\t> You have two choices, either play the game and gamble, or walk away");
        System.out.println(" ");
        System.out.println("\t> What will you do?");
        System.out.println(" ");
        System.out.println("\t• Gamble (1) or");
        System.out.println("\t• walk away (2)");
        System.out.println(" ");

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        if ((p.meds + p.food + p.water) > 0) {
            // Gambling - CHOICE 1 - Bet
            if (choice == 1) {
                System.out.println(" ");
                System.out.println("\t> You decide to gamble");
                System.out.println("\t\"Oh fantastic!\"");
                int itemChoice = gambleItemChoice(p);

                // FOOD GAMBLED
                if (itemChoice == 1) {
                    if (p.food >= 1) {
                        gambleFood(p);
                    } else {
                        System.out.println(" ");
                        System.out.println("\t\"There is NO way you got that many mister!\"");
                        System.out.println(" ");
                        gambleItemChoice(p);
                    }
                }

                // WATER GAMBLED
                else if (itemChoice == 2) {
                    if (p.water >= 1) {
                        gambleWater(p);
                    } else {
                        System.out.println(" ");
                        System.out.println("\t\"There is NO way you got that many mister!\"");
                        System.out.println(" ");
                        gambleItemChoice(p);
                    }
                }

                // MEDS GAMBLED
                else if (itemChoice == 3) {
                    if (p.meds >= 1) {
                        gambleMeds(p);
                    } else {
                        System.out.println(" ");
                        System.out.println("\t\"There is NO way you got that many mister!\"");
                        System.out.println(" ");
                        gambleItemChoice(p);
                    }

                }

                // Gambling - CHOICE 2 - Walk away
            } else if (choice == 2) {
                System.out.println(" ");
                System.out.println("\t\"Aww that's a shame! If you change your mind you know where I am!\"");
                System.out.println(" ");
            }
        } else {
            System.out.println(" ");
            System.out.println("\t> You look in your backpack and realise you have nothing to gamble with...");
            System.out.println("\t\"Aww that's a shame! If you come across any items you know where I am!\"");
            System.out.println(" ");
        }

        // Calculates if the player gets an item
        boolean foodReward = foodReward(25);
        boolean waterReward = waterReward(25);
        boolean medsReward = medsReward(20);

        if (foodReward) {
            p.food++;
            System.out.println("\t» Picked up 1 food!");
        }

        if (waterReward) {
            p.water++;
            System.out.println("\t» Picked up 1 water!");
        }

        if (medsReward) {
            p.meds++;
            System.out.println("\t» Picked up 1 med!");
        }
        // Player gets to "rest" between days (challenges)
        // So they regain a bit of energy
        int energyValue = 1;
        p.setEnergy((energyValue * 10));
        System.out.println("\t» Sleeping that night regained " + energyValue * 10 + " energy!");

        p.print();

        // Runs a dog health check
        if (dog) {
            dogHealthCheck(p, d);
        }

        if (lastDay) {
            finish();
        } else {
            // Ask the player if they want to use items
            System.out.println(" ");
            System.out.println("\t> Would you like to use some items to heal?");
            System.out.println("\t• Yes (1)");
            System.out.println("\t• No (2)");
            System.out.println(" ");
            int itemUsage = sc.nextInt();
            if (itemUsage == 1) {
                useItems(p);
            } else {
                ranChal();
            }
        }

    }

    public int gambleItemChoice(Player p) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\t\"Now what are we playing for?\"");
        System.out.println(" ");
        System.out.println("\t• Food (1) (You have " + p.food + "),");
        System.out.println("\t• water (2) (You have " + p.water + ") or");
        System.out.println("\t• medicine kits (3) (You have " + p.meds + ")");
        System.out.println(" ");
        int itemChoice = sc.nextInt();
        return itemChoice;
    }

    public void gambleMeds(Player p) {

        Scanner sc = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("\t\"How many medicine kits would you like to bet?\"");
        System.out.println(" ");
        int betAmount = sc.nextInt();
        // 20% chance of winning
        int odds = ranGen(5, 1);

        if (betAmount > p.meds) {
            System.out.println(" ");
            System.out.println("\t\"Oh come on now, you don't have that many!\"");
            System.out.println(" ");
            gambleMeds(p);
        } else {
            System.out.println(" ");
            System.out.println("\t\"Great! I'll flip three coins, you're heads I'm tails!\"");
            System.out.println("\t> He flips the coins and they come up...");
            System.out.println(" ");

            if (odds == 1) {
                System.out.println("\tHeads");
                System.out.println("\tHeads");
                System.out.println("\tTails");
                System.out.println(" ");
                System.out.println("\t\"DING DING DING! WE HAVE A WINNER!\"");
                System.out.println("\t\"Well I am a man of my word, here you go!\"");
                System.out.println("\t> He slides over " + betAmount + " medicine kit(s)");
                System.out.println(" ");
                p.meds = p.meds + betAmount;
            } else if (odds >= 2) {
                System.out.println("\tHeads");
                System.out.println("\tTails");
                System.out.println("\tTails");
                System.out.println(" ");
                System.out.println("\t\"Aww sorry man! Better luck next time!\"");
                System.out.println("\t> He grabs the medicine kit(s) off the table");
                System.out.println(" ");
                p.meds = p.meds - betAmount;
            }

        }

    }

    public void gambleWater(Player p) {

        Scanner sc = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("\t\"How many water bottles would you like to bet?\"");
        System.out.println(" ");
        int betAmount = sc.nextInt();
        // 50% chance of winning
        int odds = ranGen(2, 1);

        if (betAmount > p.water) {
            System.out.println(" ");
            System.out.println("\t\"Oh come on now, you don't have that many!\"");
            System.out.println(" ");
            gambleWater(p);
        } else {

            System.out.println(" ");
            System.out.println("\t\"Great! I'll flip three coins, you're heads I'm tails!\"");
            System.out.println("\t> He flips the coins and they come up...");
            System.out.println(" ");

            if (odds == 1) {
                System.out.println("\tHeads");
                System.out.println("\tHeads");
                System.out.println("\tTails");
                System.out.println(" ");
                System.out.println("\t\"DING DING DING! WE HAVE A WINNER!\"");
                System.out.println("\t\"Well I am a man of my word, here you go!\"");
                System.out.println("\t> He slides over " + betAmount + " water bottle(s)");
                System.out.println(" ");
                p.water = p.water + betAmount;
            } else if (odds == 2) {
                System.out.println("\tHeads");
                System.out.println("\tTails");
                System.out.println("\tTails");
                System.out.println(" ");
                System.out.println("\t\"Aww sorry man! Better luck next time!\"");
                System.out.println("\t> He grabs the water off the table");
                System.out.println(" ");
                p.water = p.water - betAmount;
            }
        }
    }

    public void gambleFood(Player p) {

        Scanner sc = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("\t\"How many food items would you like to bet? You can't bet more than you have!\"");
        System.out.println(" ");
        int betAmount = sc.nextInt();
        // 66% chance of winning
        int odds = ranGen(3, 1);

        if (betAmount > p.food) {
            System.out.println(" ");
            System.out.println("\t\"Oh come on now, you don't have that many!\"");
            System.out.println(" ");
            gambleFood(p);
        } else {
            System.out.println(" ");
            System.out.println("\t\"Great! I'll flip three coins, you're heads I'm tails!\"");
            System.out.println("\t> He flips the coins and they come up...");
            System.out.println(" ");

            if (odds >= 2) {
                System.out.println("\tHeads");
                System.out.println("\tHeads");
                System.out.println("\tTails");
                System.out.println(" ");
                System.out.println("\t\"DING DING DING! WE HAVE A WINNER!\"");
                System.out.println("\t\"Well I am a man of my word, here you go!\"");
                System.out.println("\t> He slides over " + betAmount + " food item(s)");
                System.out.println(" ");
                p.food = p.food + betAmount;
            } else if (odds == 1) {
                System.out.println("\tHeads");
                System.out.println("\tTails");
                System.out.println("\tTails");
                System.out.println(" ");
                System.out.println("\t\"Aww sorry man! Better luck next time!\"");
                System.out.println("\t> He grabs the food off the table");
                System.out.println(" ");
                p.food = p.food - betAmount;
            }
        }
    }

    // END OF GAMBLE METHOD

    // IDOL METHOD
    public void idol(Player p) {
        // Challenge introduction
        System.out.println("\t*****");
        System.out.println("\tDAY " + dayCount);
        dayCount++;
        System.out.println("\t*****");
        System.out.println("\t> As you are hiking through a jungle you spot what appears to be a ruined temple.");
        System.out.println(
                "\t> In the middle of the temple is an open area and a stone podium, on top of which is a gold idol.");
        System.out.println(
                "\t> But surrounding the podium are very loose looking floor panels that could collapse at any moment.");
        if (dog) {
            System.out.println("\t> " + d.name + " looks up at you, scared..");
        }
        System.out.println(" ");
        System.out.println("\t> You have two choices, either try and make your way to the idol or walk away.");
        System.out.println(" ");
        System.out.println("\t> What will you do?");
        System.out.println(" ");
        System.out.println("\t• Get the idol (1) or");
        System.out.println("\t• walk away (2)");
        System.out.println(" ");

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        // Damage multiplier
        double damageMultiplier = getMultiplier();

        // Damage calculations
        int healthLost1 = 1;
        double healthLost1DM;
        if (dog) {
            healthLost1DM = (healthLost1 * damageMultiplier) * 0.8;
        } else {
            healthLost1DM = healthLost1 * damageMultiplier;
        }
        int energyLost1 = ranGen(7, 4);
        int thirstLost1 = ranGen(6, 3);
        int hungerLost1 = ranGen(5, 3);

        int elostFinal;
        int helostFinal;
        int tlostFinal;
        int hulostFinal;

        int fallCount = 0;

        // Idol - CHOICE 1 - Get the idol
        if (choice == 1) {
            System.out.println(" ");
            System.out.println("\t> You decide to try and get the idol.");
            System.out.println(
                    "\t> As you approach the temple you realise you will have to be very careful with your footing...");
            System.out.println("\t> Between gaps in the floor you can see that the pit below has no end...");
            System.out.println("\t> You come to the first row of floor tiles, which way do you go?");
            System.out.println(" ");
            System.out.println("\t• Left(1),");
            System.out.println("\t• Middle (2) or");
            System.out.println("\t• Right (3)");
            System.out.println(" ");

            // Jump 1
            int choice1 = sc.nextInt();
            int safeSpot1 = ranGen(2, 1);

            if (choice1 == safeSpot1) {
                System.out.println(" ");
                System.out.println(
                        "\t> You jump and luckily land on the correct panel, the other two fall away into the void...");
                System.out.println(" ");
            } else {
                System.out.println(" ");
                System.out.println("\t> You jump and land on one of the panels...but it falls beneath your feet...");
                System.out.println(
                        "\t> Luckily you grab on to another panel that is more secure and you pull yourself up...");
                System.out.println(" ");
                fallCount++;
            }

            // Jump 2
            System.out.println("\t> You must jump again, which way do you go?");
            System.out.println(" ");
            System.out.println("\t• Left(1),");
            System.out.println("\t• Middle (2) or");
            System.out.println("\t• Right (3)");
            System.out.println(" ");

            int choice2 = sc.nextInt();
            int safeSpot2 = ranGen(2, 1);
            if (choice2 == safeSpot2) {
                System.out.println(" ");
                System.out.println(
                        "\t> You jump again and land on a sturdy panel, the other two fall away into nothingness...");
                System.out.println(" ");
            } else {
                System.out.println(" ");
                System.out.println("\t> You jump again and land on a weak panel and it falls through...");
                System.out.println("\t> You dive from that panel onto a stronger one just in time...");
                System.out.println(" ");
                fallCount++;
            }

            // Jump 3
            System.out.println("\t> One more jump to go, which way do you go?");
            System.out.println(" ");
            System.out.println("\t• Left(1),");
            System.out.println("\t• Middle (2) or");
            System.out.println("\t• Right (3)");
            System.out.println(" ");

            int choice3 = sc.nextInt();
            int safeSpot3 = ranGen(2, 1);
            if (choice3 == safeSpot3) {
                System.out.println(" ");
                System.out.println("\t> You jump once more and make it safely across...");
                System.out.println(" ");
                // Death
            } else if (fallCount > 1) {
                System.out.println(" ");
                System.out.println(
                        "\t> You leap onto the final panel and it appears to be sturdy...but it then starts to crack...");
                System.out.println("\t> You try to move but you are already falling...");
                System.out.println("\t> You finally find out what's at the bottom of the pit...");
                System.out.println(" ");
                death();
                return;
            } else {
                System.out.println(" ");
                System.out.println("\t> You leap onto the final panel and it crumbles beneath your feet...");
                System.out.println("\t> You grab onto a vine and hoist yourself up just in time...");
                System.out.println(" ");
                fallCount++;
            }

            System.out.println(" ");
            System.out.println(
                    "\t> You step up to the podium, grab the idol and race out of the temple before any kind of giant, rolling boulder can crush you...");
            System.out.println(
                    "\t> You don't know what you could use this idol for, but it's better to be safe than sorry...");
            System.out.println(" ");
            idol = true;

            // Health loss applied
            healthLost1DM = healthLost1DM * (fallCount * 10);
            p.health = p.health - healthLost1DM;
            helostFinal = (int) Math.round(healthLost1DM);

            // Energy loss applied
            if (p.energy < (energyLost1 * 10)) {
                p.energy = 0;
            } else {
                p.energy = p.energy - (energyLost1 * 10);
            }
            elostFinal = energyLost1 * 10;

            // Thirst applied
            if (p.thirst < (thirstLost1 * 10)) {
                p.thirst = 0;
            } else {
                p.thirst = p.thirst - (thirstLost1 * 10);
            }
            tlostFinal = thirstLost1 * 10;

            // Hunger applied
            if (p.hunger < (hungerLost1 * 10)) {
                p.hunger = 0;
            } else {
                p.hunger = p.hunger - (hungerLost1 * 10);
            }
            hulostFinal = hungerLost1 * 10;

            if (helostFinal > 0) {
                System.out.println("\t» -" + helostFinal * 10 + " health!");
            }

            System.out.println("\t» -" + elostFinal + " energy!");
            System.out.println("\t» -" + tlostFinal + " thirst!");
            System.out.println("\t» -" + hulostFinal + " hunger!");

            // Idol - CHOICE 2 - Walk away
        } else if (choice == 2) {
            System.out.println(" ");
            System.out.println("\t> You decide to leave it alone..");
            System.out.println("\t> Besides...what would you even need it for?");
            System.out.println(" ");
        }

        // Calculates if the player gets an item
        boolean foodReward = foodReward(20);
        boolean waterReward = waterReward(20);
        boolean medsReward = medsReward(20);

        if (foodReward) {
            p.food++;
            System.out.println("\t» Picked up 1 food!");
        }

        if (waterReward) {
            p.water++;
            System.out.println("\t» Picked up 1 water!");
        }

        if (medsReward) {
            p.meds++;
            System.out.println("\t» Picked up 1 med!");
        }

        // Player gets to "rest" between days (challenges)
        // So they regain a bit of energy
        int energyValue = 1;
        p.setEnergy((energyValue * 10));
        System.out.println("\t» Sleeping that night regained " + energyValue * 10 + " energy!");

        p.print();

        // Runs a dog health check
        if (dog) {
            dogHealthCheck(p, d);
        }

        if (lastDay) {
            finish();
        } else {
            // Ask the player if they want to use items
            System.out.println(" ");
            System.out.println("\t> Would you like to use some items to heal?");
            System.out.println("\t• Yes (1)");
            System.out.println("\t• No (2)");
            System.out.println(" ");
            int itemUsage = sc.nextInt();
            if (itemUsage == 1) {
                useItems(p);
            } else {
                ranChal();
            }
        }

    }

    // END OF IDOL METHOD

    // MUTANT METHOD
    public void mutant(Player p) {
        // Challenge introduction
        System.out.println("\t*****");
        System.out.println("\tDAY " + dayCount);
        dayCount++;
        System.out.println("\t*****");
        System.out.println(
                "\t> You stumble upon what seems to be an abandoned scrapyard and from outside you hear voices and a lot of clanging...");
        System.out.println(
                "\t> Before you can react, a group of mutants bursts out the front gates, looking for a fight...");
        if (dog) {
            System.out.println("\t> " + d.name + " starts barking and snarling at them...");
        }
        System.out.println("\t> You have no choice but to fight...");
        System.out.println(" ");
        System.out.println(" ");

        Scanner sc = new Scanner(System.in);

        // Damage calculations
        int energyLost1 = ranGen(15, 9);
        int thirstLost1 = ranGen(15, 9);
        int hungerLost1 = ranGen(15, 9);

        int elostFinal;
        int tlostFinal;
        int hulostFinal;

        // Mutants - Fight
        if (idol) {
            System.out.println(" ");
            System.out.println("\t> The mutants come at you swinging their clubs...");
            System.out.println("\t> You drop your bag and the idol falls out...");
            System.out
                    .println("\t> The mutants see it and gasp, before dropping to their knees and worshipping you...");

            System.out.println("\t\"He is the Chosen One...\"");

            System.out.println("\t> You raise the idol above your head and they all bow...");
            System.out.println("\t> One of them approaches and gives you some items...");
            System.out.println("\t> You slowly back away and turn to start running...");
            System.out.println("\t> That was a close call...");
            System.out.println(" ");
            p.food++;
            System.out.println("\t» Given 1 food!");
            p.water++;
            System.out.println("\t» Given 1 water bottle!");
            p.meds++;
            System.out.println("\t» Given 1 medicine kit!");
            System.out.println(" ");
        } else {
            System.out.println(" ");
            System.out.println("\t> The mutants come at you swinging their clubs...");
            if (dog) {
                System.out.println("\t> " + d.name + " bites one of their arms and gets swung to the ground...");
            }
            System.out.println("\t> You manage to take three of them out but you are getting badly hurt...");
            System.out.println("\t> You grab your bag and sprint away...");
            System.out.println("\t> You run until you can't run anymore and you are finally safe...");
            System.out.println("\t> You collapse on the ground and pass out...");
            System.out.println(" ");

            // Health loss applied
            double tempHealth = p.health;
            p.health = 10.0;
            tempHealth = tempHealth - p.health;

            // Energy loss applied
            if (p.energy < (energyLost1 * 10)) {
                p.energy = 0;
            } else {
                p.energy = p.energy - (energyLost1 * 10);
            }
            elostFinal = energyLost1 * 10;

            // Thirst applied
            if (p.thirst < (thirstLost1 * 10)) {
                p.thirst = 0;
            } else {
                p.thirst = p.thirst - (thirstLost1 * 10);
            }
            tlostFinal = thirstLost1 * 10;

            // Hunger applied
            if (p.hunger < (hungerLost1 * 10)) {
                p.hunger = 0;
            } else {
                p.hunger = p.hunger - (hungerLost1 * 10);
            }
            hulostFinal = hungerLost1 * 10;

            System.out.println("\t» -" + tempHealth + " health!");
            System.out.println("\t» -" + elostFinal + " energy!");
            System.out.println("\t» -" + tlostFinal + " thirst!");
            System.out.println("\t» -" + hulostFinal + " hunger!");
        }

        // Calculates if the player gets an item
        boolean foodReward = foodReward(20);
        boolean waterReward = waterReward(20);
        boolean medsReward = medsReward(20);

        if (foodReward) {
            p.food++;
            System.out.println("\t» Picked up 1 food!");
        }

        if (waterReward) {
            p.water++;
            System.out.println("\t» Picked up 1 water!");
        }

        if (medsReward) {
            p.meds++;
            System.out.println("\t» Picked up 1 med!");
        }

        // Player gets to "rest" between days (challenges)
        // So they regain a bit of energy
        int energyValue = 1;
        p.setEnergy((energyValue * 10));
        System.out.println("\t» Sleeping that night regained " + energyValue * 10 + " energy!");

        p.print();

        // Runs a dog health check
        if (dog) {
            dogHealthCheck(p, d);
        }

        if (lastDay) {
            finish();
        } else {
            // Ask the player if they want to use items
            System.out.println(" ");
            System.out.println("\t> Would you like to use some items to heal?");
            System.out.println("\t• Yes (1)");
            System.out.println("\t• No (2)");
            System.out.println(" ");
            int itemUsage = sc.nextInt();
            if (itemUsage == 1) {
                useItems(p);
            } else {
                ranChal();
            }
        }

    }

    // END OF MUTANT METHOD
}
// END OF GAME CLASS

// Player Class
class Player {
    // Attributes
    // Item numbers
    int food;
    int water;
    int meds;
    // Player Stats
    double health;
    double energy;
    double thirst;
    double hunger;

    // Default Constructor
    public Player() {
        food = 0;
        water = 0;
        meds = 0;
        health = 200;
        energy = 200;
        thirst = 200;
        hunger = 200;
    }

    public Player(int f, int w, int m, int he, int e, int t, int hu) {
        food = f;
        water = w;
        meds = m;
        health = he;
        energy = e;
        thirst = t;
        hunger = hu;
    }

    public void setHealth(int value) {
        if ((health + value) > 150) {
            health = 150;
        } else {
            health = health + value;
        }

    }

    public void setHunger(int value) {
        if ((hunger + value) > 200) {
            hunger = 200;
        } else {
            hunger = hunger + value;
        }

    }

    public void setThirst(int value) {
        if ((thirst + value) > 200) {
            thirst = 200;
        } else {
            thirst = thirst + value;
        }

    }

    public void setEnergy(int value) {
        if ((energy + value) > 200) {
            energy = 200;
        } else {
            energy = energy + value;
        }

    }

    public void print() {
        String stats = "\n\t--------------";
        stats += "\n\tPlayer Stats";
        stats += "\n\t--------------";
        stats += "\n\tYou have:";
        stats += "\n\t" + food + " food,";
        stats += "\n\t" + water + " water,";
        stats += "\n\t" + meds + " meds";
        stats += "\n\tYour vitals are:";
        stats += "\n\tHealth: " + health + "/150";
        stats += "\n\tEnergy: " + energy + "/200";
        stats += "\n\tThirst: " + thirst + "/200";
        stats += "\n\tHunger: " + hunger + "/200";
        stats += "\n\t--------------";
        System.out.println(stats);
    }
}

// END OF PLAYER CLASS

// DOG CLASS
class Dog {
    // Attributes
    double health;
    String name;

    // Default Constructor
    public Dog() {
        name = " ";
        health = 100;
    }

    public Dog(String dogName, double dogHealth) {
        name = dogName;
        health = dogHealth;

    }

    public void setDogHealth(int value) {
        if ((health + value) > 100) {
            health = 100;
        } else {
            health = health + value;
        }

    }

    public void setDogName(String dogName) {
        name = dogName;
    }
}
