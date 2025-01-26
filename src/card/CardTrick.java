/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

import java.util.Random;
import java.util.Scanner;

/**
 *A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards 
 * for the match to the user's card. To be used as starting code in ICE 1.
 * Author: srinivsi // Professor
 * Modified by: Sejalpreet Kaur
 * Student ID: 991778026
 * Date: January 26, 2025
 */
public class CardTrick {
    
    public static void main(String[] args) {
        Card[] magicHand = new Card[7]; // Create an array for "hand" of 7 cards
        Random rand = new Random();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        //  Fill the magic hand with random cards
        
        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(rand.nextInt(13) + 1); // Card value: 1-13
            c.setSuit(suits[rand.nextInt(4)]); // Random suit
            magicHand[i] = c; // Add card to magic hand
        }
        
        // Ask the user for their card value and suit
        Scanner scanner = new Scanner(System.in);
        System.out.print("Pick your card value (1-13): ");
        int userValue = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Pick your card suit (Hearts, Diamonds, Clubs, Spades) or index (0-3): ");
        String userSuitInput = scanner.nextLine();
        String userSuit;
        
        // Check if the input is a number (index)
        try {
            int suitIndex = Integer.parseInt(userSuitInput);
            userSuit = suits[suitIndex]; // Convert index to suit name
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            userSuit = userSuitInput; // Use input as a suit name directly 
        }
        
        // Create user's card
        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(userSuit);

        // Check if the user's card is in the magic hand
        boolean isCardFound = false;
        for (Card card : magicHand) {
            if (card.getValue() == userCard.getValue() && card.getSuit().equalsIgnoreCase(userCard.getSuit())) {
                isCardFound = true;
                break;
            }
        }
        
        // Display result
        if (isCardFound) {
            System.out.println("Your card was found in the magic hand!");
        } else {
            System.out.println("Your card was not found.");
        }
        
        // Close the Scanner
        scanner.close();
    }
}