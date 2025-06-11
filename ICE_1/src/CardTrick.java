/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * 
 * Modifier: DIVYAKUMAR Patel
 * Student Number: 991775606
 * Date Modified: June 2, 2025
 */

import java.util.Scanner;

public class CardTrick {

    public static void main(String[] args) {
        Card[] magicHand = new Card[7];

        // Fill magic hand with random cards
        for (int i = 0; i < magicHand.length; i++) {
            Card card = new Card();
            card.setValue((int)(Math.random() * 13 + 1)); // card value from 1 to 13
            card.setSuit(Card.SUITS[(int)(Math.random() * Card.SUITS.length)]); // random suit
            magicHand[i] = card;
        }

        // Ask the user to pick a card
        Scanner input = new Scanner(System.in);
        System.out.println("Pick a card from the deck!");

        int userValue;
        while (true) {
            System.out.print("Enter the card value (1 to 13): ");
            userValue = input.nextInt();
            if (userValue >= 1 && userValue <= 13) break;
            System.out.println("Invalid input. Please enter a number from 1 to 13.");
        }

        input.nextLine(); // clear newline character

        String userSuit;
        while (true) {
            System.out.print("Enter the suit (Hearts, Diamonds, Spades, Clubs): ");
            userSuit = input.nextLine();
            boolean validSuit = false;
            for (String s : Card.SUITS) {
                if (s.equalsIgnoreCase(userSuit)) {
                    userSuit = s; // normalize case
                    validSuit = true;
                    break;
                }
            }
            if (validSuit) break;
            System.out.println("Invalid suit. Choose from: Hearts, Diamonds, Spades, Clubs.");
        }

        // Check if user's card is in the magic hand
        boolean found = false;
        for (Card c : magicHand) {
            if (c.getValue() == userValue && c.getSuit().equalsIgnoreCase(userSuit)) {
                found = true;
                break;
            }
        }

        // Show result
        System.out.println();
        if (found) {
            System.out.println("Congratulations! Your card is in the magic hand.");
        } else {
            System.out.println("Sorry! Your card was not found in the magic hand.");
        }

        // Display the full magic hand
        System.out.println("\nThe Magic Hand was:");
        for (Card c : magicHand) {
            System.out.println(" - " + c.getValue() + " of " + c.getSuit());
        }
    }
}