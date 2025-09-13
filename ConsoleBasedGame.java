import java.util.Scanner;
import java.util.Random;

public class ConsoleBasedGame {

   
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        
        boolean leave= false;
        int choice, times = 0;
        String choice2;
        
        System.out.println("-+-+-+-+-+-+-+-+-+-+");
        System.out.println("COLTCOBRA'S FUNHOUSE");
        System.out.println("-+-+-+-+-+-+-+-+-+-+");
        
        System.out.println("\nYou walk up and down the stalls to choose a game to play.");
        
        while (leave == false) {
            System.out.println("\n1. Guess the mine");
            System.out.println("2. High-low");
            System.out.println("3. Monster");
            System.out.println("4. Slot machine");
            System.out.println("5. Graveyard");

            System.out.print("\nPick a game: ");
            choice = kb.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    guessTheMine();
                    break;

                case 2:
                    highLow();
                    break;

                case 3:
                    monster();
                    break;

                case 4:
                    slotMachine();
                    break;

                case 5:
                    times++;
                    graveyard(times);
                    break;

                default:
                    System.out.println("You forgot what you are thinking just a moment ago.");
            }
            
            System.out.print("\nDo you want to leave COLTCOBRA'S FUNHOUSE? ");
            choice2 = kb.next();
            
            if (choice2.equals("yes") || choice2.equals("Yes") || choice2.equals("YES") || choice2.equals("Y") || choice2.equals("y")) {
                leave = true;
            }
        }
        
        System.out.println("\nYou leave COLTCOBRA'S FUNHOUSE.");
        
    }
    
    public static void guessTheMine() {
        Scanner kb = new Scanner(System.in);
        Random r = new Random();
        
        System.out.println("-+-+-+-+-+-+-+");
        System.out.println("GUESS THE MINE");
        System.out.println("-+-+-+-+-+-+-+");
        
        System.out.println("\nIn a 4x4 grid, there is one mine per horizontal row. You have 10 guesses to find all the mines.");
        System.out.println("If you find all 4 mines in ten or less guesses, you win. If not, you lose.");
        
        int mineRow[] = {0, 1, 2, 3};
        int mineCol[] = new int[4];
        
        for (int i = 0; i < mineRow.length; i++) {
            mineCol[i] = r.nextInt(4);
        }
        
        int guesses = 10, remaining = 4, rowInput, colInput;
        boolean repeat;
        
        char grid[][] = new char[4][4];
        
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                grid[row][col] = '-';
            }
        }
        
        while (guesses > 0 && remaining != 0) {
            repeat = true;
            
            System.out.println("\n\t0\t1\t2\t3");
            System.out.println("0\t" + grid[0][0] + "\t" + grid[0][1] + "\t" + grid[0][2] + "\t" + grid[0][3]);
            System.out.println("1\t" + grid[1][0] + "\t" + grid[1][1] + "\t" + grid[1][2] + "\t" + grid[1][3]);
            System.out.println("2\t" + grid[2][0] + "\t" + grid[2][1] + "\t" + grid[2][2] + "\t" + grid[2][3]);
            System.out.println("3\t" + grid[3][0] + "\t" + grid[3][1] + "\t" + grid[3][2] + "\t" + grid[3][3]);
            
            System.out.println("\nGuess where the mines are...");
            System.out.println("You have " + guesses + " guesses left.");
            
            while (repeat == true) { //The program will ask the user to keep guessing if they make a repeated guess.
                System.out.print("\nRow (0-3): ");
                rowInput = kb.nextInt();
                System.out.print("Column (0-3): ");
                colInput = kb.nextInt();
                
                if (grid[rowInput][colInput] != '-') { //This means if the spot is 'X' or 'O', meaning that it has already been guessed.
                    System.out.println("\nYou have already gussed this spot. Try again!");
                } else if ((rowInput == mineRow[0] && colInput == mineCol[0]) || (rowInput == mineRow[1] && colInput == mineCol[1]) || (rowInput == mineRow[2] && colInput == mineCol[2]) || (rowInput == mineRow[3] && colInput == mineCol[3])) {
                    grid[rowInput][colInput] = 'X'; //Reveals an 'X' if user guesses correctly.
                    System.out.println("\nCorrect!");
                    
                    repeat = false;
                    remaining--;
                } else {
                    grid[rowInput][colInput] = 'O'; //Reveals an 'O' if the user guesses incorrectly.
                    System.out.println("\nIncorrect!");
                    
                    repeat = false;
                }
            }

            guesses--;
        }
        
        System.out.println("\n\t0\t1\t2\t3");
        System.out.println("0\t" + grid[0][0] + "\t" + grid[0][1] + "\t" + grid[0][2] + "\t" + grid[0][3]);
        System.out.println("1\t" + grid[1][0] + "\t" + grid[1][1] + "\t" + grid[1][2] + "\t" + grid[1][3]);
        System.out.println("2\t" + grid[2][0] + "\t" + grid[2][1] + "\t" + grid[2][2] + "\t" + grid[2][3]);
        System.out.println("3\t" + grid[3][0] + "\t" + grid[3][1] + "\t" + grid[3][2] + "\t" + grid[3][3]);
        
        if (remaining == 0) {
            System.out.println("\nYou have found all the mines! YOU WIN!");
            System.out.println("You have " + guesses + " unused guesses. Good job!");
        } else {
            System.out.println("\nYou have ran out of guesses! YOU LOSE!");
        }
    }
    
    public static void highLow() {
        Scanner kb = new Scanner(System.in);
        Random r = new Random();
        
        boolean leave = false;
        String choice;
        int first, second;
        
        System.out.println("-+-+-+-+");
        System.out.println("HIGH-LOW");
        System.out.println("-+-+-+-+");
        
        System.out.println("\nThere are two random numbers between 1-100.");
        System.out.println("You will be shown the first number, and you need to guess if the second number is higher, lower, or equal.");
        
        while (leave == false) {
            first = r.nextInt(100) + 1;
            second = r.nextInt(100) + 1;
            
            System.out.println("\nThe first number is " + first + ".");
            System.out.println("If you think the second number is higher, type 1.");
            System.out.println("If you think the second number is lower, type 2.");
            System.out.println("If you think the second number is equal, type 3.");

            int gameInput = kb.nextInt();

            if (first < second && gameInput == 1) {
                System.out.println("\nThe second number is " + second + ". You are correct!");
            } else if (first < second && gameInput != 1) {
                System.out.println("\nThe second number is " + second + " . You are incorrect.");
            } else if (first > second && gameInput == 2) {
                System.out.println("\nThe second number is " + second + ". You are correct!");
            } else if (first > second && gameInput != 2) {
                System.out.println("\nThe second number is " + second + " . You are incorrect.");
            } else if (first == second && gameInput == 3) {
                System.out.println("\nThe second number is " + second + ". You are correct!");
            } else if (first == second && gameInput != 3) {
                System.out.println("\nThe second number is " + second + " . You are incorrect.");
            }
            
            System.out.print("\nDo you want to exit High-low? ");
            choice = kb.next();
            
            if (choice.equals("yes") || choice.equals("Yes") || choice.equals("YES") || choice.equals("Y") || choice.equals("y")) {
                leave = true;
            }
        }
    }
    
    public static void monster() {
        Scanner kb = new Scanner(System.in);
        Random r = new Random(); 
        
        System.out.println("-+-+-+-");
        System.out.println("MONSTER");
        System.out.println("-+-+-+-");
        
        int playerDmg, playerHP, playerAcc;
        int monsterDmg, monsterHP;
        
        System.out.println("\nA horrendous monster awaits you. Choose your weapon.");
        System.out.println("\n1. Sword        2. Poleaxe      3. Toy gun");
        System.out.println("Damage: 10      Damage: 20      Damage: 7");
        System.out.println("Accuracy: 90%   Accuracy: 75%   Accuracy: 100%");
        
        int weapon = kb.nextInt();
        playerHP = 100;
        monsterHP = 200;
        
        switch (weapon) {
            case 1:
                System.out.println("\nYou chose a sword. Shiny.");
                playerDmg = 10;
                playerAcc = 90;
                break;
            case 2:
                System.out.println("\nYou chose a poleaxe. Heavy and long.");
                playerDmg = 20;
                playerAcc = 75;
                break;
            case 3:
                System.out.println("\nYou chose a toy gun. For children 3 and above.");
                playerDmg = 7;
                playerAcc = 100;
                break;
            default:
                System.out.println("\nYou gave a stupid answer and will be punished to using only your fists.");
                playerDmg = 5;
                playerAcc = 100;
        }
        
        System.out.println("\nThe monster deals 10 damage per hit and is 80% accurate but has twice your health. Get ready, hero.");
        
	int turn = 1;

	while (playerHP > 0 && monsterHP > 0) {
		System.out.println("\nTurn " + turn);
        
        	int test1 = r.nextInt(100) + 1;
        	if (test1 > 20) {
            		monsterDmg = 10;
        	} else {
            		monsterDmg = 0;
        	}
        
        	int test2 = r.nextInt(100) + 1;
        	if (playerAcc == 90 && test2 > 10) {
            		monsterHP = monsterHP - playerDmg;
            		System.out.println("\nYou dealt " + playerDmg + " damage to the monster.");
        	} else if (playerAcc == 90 && test2 <= 10) {
            		System.out.println("\nYou missed the monster.");
        	} else if (playerAcc == 75 && test2 > 25) {
            		monsterHP = monsterHP - playerDmg;
            		System.out.println("\nYou dealt " + playerDmg + " damage to the monster.");
        	} else if (playerAcc == 75 && test2 <= 25) {
            		System.out.println("\nYou missed the monster.");
        	} else if (playerAcc == 100) {
            		monsterHP = monsterHP - playerDmg;
            		System.out.println("\nYou dealt " + playerDmg + " damage to the monster.");
        	}
        
        	playerHP = playerHP - monsterDmg;
        	System.out.println("The monster dealt " + monsterDmg + " damage to you.");
        
        	System.out.println("Your health: " + playerHP + "/100");
        	System.out.println("Monster's health: " + monsterHP + "/200");

		turn++;
        }
        
        int death;
        
        if (playerHP == 0 && monsterHP == 0) {
            System.out.println("\nIt's a tie.");
            System.out.println("Both the monster and you collapse to the ground, dead.");
        } else if (playerHP == 0) {
            System.out.println("\nYou lost.");
            death = r.nextInt(6) + 1;
            switch (death) {
                case 1:
                    System.out.println("The monster swipes downwards at your head. You are shredded to pieces.");
                    break;
                case 2:
                    System.out.println("The monster roars. You faint in fear.");
                    break;
                case 3:
                    System.out.println("The monster devours you.");
                    break;
                case 4:
                    System.out.println("You drop your weapon in terror, unable to continue the fight.");
                    break;
                case 5:
                    System.out.println("You fail to notice the banana peel on the ground. You slipped and banged your head against a rock.");
                    break;
                case 6:
                    System.out.println("You died.");
                    break;
            }
        } else if (monsterHP == 0) {
            System.out.println("\nYou won.");
        }
    }
    
    public static void slotMachine() {
        Scanner kb = new Scanner(System.in);
        Random r = new Random();
        
        System.out.println("-+-+-+-+-+-+");
        System.out.println("SLOT MACHINE");
        System.out.println("-+-+-+-+-+-+");
        
        System.out.println("\nWelcome to the slot machine. Each pull costs 1 token. You get 20 tokens if all three numbers are the same. If not, you get nothing.");
        System.out.println("You automatically lose if you run out of tokens.");
        System.out.println("\n1. Pull machine");
        System.out.println("2. Leave");
        
        int choice = kb.nextInt();
        
        int token = 20;
        int num1, num2, num3;
        
        while (choice == 1 && token > 0) {
            num1 = r.nextInt(3) + 1;
            num2 = r.nextInt(3) + 1;
            num3 = r.nextInt(3) + 1;
            
            System.out.println("\n[" + num1 + "]  [" + num2 + "]  [" + num3 + "]");
            
            if (num1 == num2 && num2 == num3) {
                token = token + 20;
                System.out.println("You have earned 20 tokens! You now have " + token + " tokens.");
                System.out.println("\n1. Pull machine");
                System.out.println("2. Leave");
                choice = kb.nextInt();
            } else {
                token--;
                System.out.println("You have lost 1 token! You now have " + token + " tokens.");
                System.out.println("\n1. Pull machine");
                System.out.println("2. Leave");
                choice = kb.nextInt();
            }
        }
        
        if (choice == 2) {
            System.out.println("\nYou ended with " + token + " tokens. See you next time!");
        } else if (token == 0) {
            System.out.println("\nYou ran out of tokens! See you next time!");
        }
    }
    
    public static void graveyard(int n) {
        Scanner kb = new Scanner(System.in);
        
        boolean defeated = false, dagger = false;
        int choice;
        
        System.out.println("-+-+-+-+-");
        System.out.println("GRAVEYARD");
        System.out.println("-+-+-+-+-");
        
        System.out.println("\nTimes entered the graveyard: " + n);
        
        if (n == 1) {
            System.out.println("\nYou walk through the graveyard, glancing at tombstones and listening to the dead chatter. The sky darkens and the clouds thicken.");
            
            System.out.println("\nA ghost materializes in front of you. What do you do?");
        } else {
            System.out.println("\nYou re-enter the graveyard, determined not to screw up.");
            
            System.out.println("\nThe same ghost materializes in front of you, scowling. What do you do?");
        }
        
        System.out.println("1. Approach");
        System.out.println("2. Approach and fight");
        System.out.println("3. Ignore");
        
        System.out.print("\nPick an action: ");
        choice = kb.nextInt();
        
        switch (choice) {
            case 1:
                System.out.println("\nYou walk up to the ghost. It seems to smile and hands you a dagger, which solidifies as it touches your palm.");
                dagger = true;
                break;
                
            case 2:
                System.out.println("\nYou throw yourself at the ghost, yet you pass through the image and crash to the ground.");
                System.out.println("The next thing you know, you are teleported out of the graveyard.");
                defeated = true;
                break;
                
            default:
                System.out.println("\nYou ignore the ghost and keep moving. It mutters something under its breath and vanishes in the corner of your eye.");
        }
        
        if (defeated == false) {
            System.out.println("\nYou see a hooded figure fifty metres ahead. As you approach, you realize that it resembles a medieval plague doctor.");
            System.out.println("It does not wear a top hat and its mask seems to be bonded with its face. Perhaps it is its face.");
            
            System.out.println("\n\"I am the cure,\" it says in a mechanical, metallic voice. It outstretches its gloved hand and begins walking towards you, slowly.");
            
            System.out.println("1. Shake his hand");
            System.out.println("2. Fight");
            System.out.println("3. Run");
            
            System.out.print("\nPick an action: ");
            choice = kb.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("\nAs soon you touch its hand, you faint. When you open your eyes, you are outside the graveyard.");
                    defeated = true;
                    break;
                    
                case 2:
                    System.out.println("\n\"Is that a wise decision?\" It snarls at you, dodging your punch. As quick as a flash, it pulls out a syringe and injects it in your shoulder.");
                    System.out.println("Your vision blurs as you feel a burning pain spreading from the point of injection. When you open your eyes, you are outside the graveyard.");
                    defeated = true;
                    break;
                    
                default:
                    System.out.println("\nYou run as fast as you can, leaping over tombstones and ducking under dead trees.");
            }
            
            if (defeated == false) {
                if (n == 1) {
                    System.out.println("\nA large ghost is sitting atop a cracked gravestone. Dozens of daggers are floating and swirling around it, as if they have a mind of their own.");
                    System.out.println("The ghost sees you. \"I am Dreadlord, master of daggers,\" it says. \"I sent my servant to find a lost dagger, but he has not returned. Do you happen to have my dagger?\""); 
                } else {
                    System.out.println("\nDreadlord appears in front of you. \"So, do you have my dagger now?\"");
                }

                if (dagger == true) {
                    System.out.println("1. Attack Dreadlord with your dagger");
                    System.out.println("2. Shake your head");
                    System.out.println("3. Hand over your dagger");
                    
                    System.out.print("\nPick an action: ");
                    choice = kb.nextInt();
                    
                    switch (choice) {
                        case 1:
                            System.out.println("\nYou whip out the dagger and lunge at Dreadlord. \"That dagger...\" Dreadlord blocked your thrust and threw two dozens of daggers at you.");
                            System.out.println("\"...is mine,\" Dreadlord finishes as you take your last breath, your body penetrated by multiple blades.");
                            break;
                            
                        case 2:
                            System.out.println("\nYou shake your head. \"I know you are hiding something,\" Dreadlord glares at you.");
                            System.out.println("An invisible force yanks the dagger out of your pocket. You run away in shame.");
                            break;
                            
                        default:
                            System.out.println("\nYou hand over the dagger another ghost gave you previously. \"Ah, there it is,\" Dreadlord inspects the blade.");
                            System.out.println("\"Who gave you this? A ghost?\" Dreadlord asks. You nod. Dreadlord shrugs and gestures at you to move along.");
                    }
                } else {
                    System.out.println("1. Attack Dreadlord with your bare fists");
                    System.out.println("2. Shake your head");
                    
                    System.out.print("\nPick an action: ");
                    choice = kb.nextInt();
                    
                    switch (choice) {
                        case 1:
                            System.out.println("\nA dagger cuts through the air and lodges on your forehead. \"Nice try,\" Dreadlord sneers as you die.");
                            break;
                            
                        default:
                            System.out.println("\nDreadlord frowns and gestures at you to move along.");
                    }
                }
            }
        }
    }

}
