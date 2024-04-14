import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

public class Main {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Integer> collatzsequence = new ArrayList<>();
    public static void main(String[] args) {
        int startingnumber = 0, steps, feature;
        System.out.println("Welcome to the Collatz Conjecture.");
        System.out.println("Enter the digit of the feature to proceed: ");
        System.out.println();

        System.out.println("(1) Simulation");
        System.out.println("(2) Reversed Traversal");
        System.out.print("Input: ");
        feature = input.nextInt();

        boolean check = true;
        if(feature == 1) {
            System.out.println("The Collatz Conundrum | Simulation");
            System.out.println("====================================");
            while(check) {
                System.out.print("Input a positive integer: ");
                startingnumber = input.nextInt();

                if (startingnumber > 0) {
                    System.out.println("Proceeding...");
                    check = false;
                }
                else
                    System.out.println("Invalid number. Please try again. ");
            }
            steps = 0;
            System.out.println();

            System.out.println("| Step | Current Number ");
            System.out.println("=================================");
            Collatz(startingnumber, steps);
            System.out.println("Collatz sequence: " + collatzsequence);
        }
        
        else if (feature == 2) {
            startingnumber = 1;
            steps = 0;
            System.out.println("The Collatz Conundrum | Reverse Traversal");
            System.out.println("====================================");
            System.out.println("Instructions: \nTo this date, the end result of every Collatz conjecture problem is 1.");
            System.out.println("Theoretically, you can then find any integer through reversing Collatz's conjecture.");
            System.out.println("Type 1 to assume the next number is odd, and 2 to assume the next number is even.");
            System.out.println("Type 3 to end the program.");
            System.out.println("====================================");

            CollatzGraph(startingnumber, steps);
            Collections.reverse(collatzsequence);
            System.out.println("Collatz sequence: " + collatzsequence);
            System.out.println("You can run the program again to check using the simulator.");
            System.out.println("It is to be noted, however, that the simulator finds the most optimal path possible.");
            System.out.println("Hence, your answer can be steps off.");

            System.out.println();
            System.out.println("To better improve your answer, think of the Collatz Conjecture somewhat like the Sieve of Erasthenes.");
            System.out.println("You'll have to \"jump\" between prime number multiples in order to move through without going past.");
            System.out.println("As an example, run the number 7 on the simulator. ");
            System.out.println("You'll observe it \"jumping\" from the prime number multiples of 5, 13, 11, and finally to 7.");

        }
    }

    static void Collatz(int currentnumber, int steps){
        if(currentnumber!=1){
            if(currentnumber%2 == 0)
            {
                currentnumber/=2;
                System.out.println("| " + ++steps + " | " + currentnumber + " ");
                collatzsequence.add(currentnumber);
                Collatz(currentnumber, steps);
            }
            else if(currentnumber%2 == 1)
            {
                currentnumber*=3;
                currentnumber+=1;
                System.out.println("| " + ++steps + " | " + currentnumber + " ");
                collatzsequence.add(currentnumber);
                Collatz(currentnumber, steps);
            }
        }
        else if(currentnumber==1){
            System.out.println();
            System.out.println("Final number = " + currentnumber);
            System.out.println("Steps taken: " + steps);
        }
    }

    static void CollatzGraph(int currentnumber, int steps){
        int nextnumber;
            System.out.println();
            System.out.println("Current number: " + currentnumber + ".");
            System.out.println("Current step: " + steps + ".");
            System.out.print("Odd (1), Even, (2) or End (3)? : ");
            int nextstep = input.nextInt();
            if (nextstep == 1) {
                nextnumber = currentnumber;
                nextnumber = nextnumber - 1;
                nextnumber = nextnumber / 3;
                if(nextnumber%2 == 0 || currentnumber == 4 || currentnumber % 2 == 1 || nextnumber == 1){
                    System.out.println("Invalid: the number after " + currentnumber + " cannot be odd.");

                    CollatzGraph(currentnumber, steps);
                }
                collatzsequence.add(currentnumber);
                CollatzGraph(nextnumber, ++steps);
            }
            if (nextstep == 2) {
                collatzsequence.add(currentnumber);
                currentnumber *= 2;
                CollatzGraph(currentnumber, ++steps);
            }
            if (nextstep == 3) {
                collatzsequence.add(currentnumber);
                System.out.println();
                System.out.println("Total steps: " + steps);
                return;
            }
        }
    }