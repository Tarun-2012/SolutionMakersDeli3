/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deliverable3;

import deliverable3.Wargame.Card;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author admin
 */
public class Game {
     public static void main(String[] args) {
        // Create a deck of cards
        List<Card> deck = new ArrayList<>();
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                deck.add(new Card(rank, suit));
            }
        }
        // Shuffle the deck
        Collections.shuffle(deck);

        // Divide the deck into two hands
        List<Card> hand1 = new ArrayList<>(deck.subList(0, deck.size() / 2));
        List<Card> hand2 = new ArrayList<>(deck.subList(deck.size() / 2, deck.size()));

        // Play the game
        int round = 1;
        while (round<11) {
            System.out.println("Round " + round + ":");
            Card card1 = hand1.remove(0);
            Card card2 = hand2.remove(0);
            System.out.println("Player 1 plays " + card1);
            System.out.println("Player 2 plays " + card2);
            if (card1.getRank().ordinal() > card2.getRank().ordinal()) {
                System.out.println("Player 1 wins the round!");
                hand1.add(card1);
                hand1.add(card2);
            } else if (card2.getRank().ordinal() > card1.getRank().ordinal()) {
                System.out.println("Player 2 wins the round!");
                hand2.add(card2);
                hand2.add(card1);
            // } else {
            //     System.out.println("It's a tie!");
            //     hand1.add(card1);
            //     hand2.add(card2);
            //     // System.out.println("War!");
            //     // List<Card> prizeCards = new ArrayList<>();
            //     // prizeCards.add(card1);
            //     // prizeCards.add(card2);
            //     // // playWar(prizeCards);
            // }
        } else {
            System.out.println("It's a tie!");
            List<Card> warCards1 = new ArrayList<>();
            List<Card> warCards2 = new ArrayList<>();
            warCards1.add(card1);
            warCards2.add(card2);
            // Each player puts down three cards face down
            for (int i = 0; i < 3; i++) {
                if (!hand1.isEmpty() && !hand2.isEmpty()) {
                    Card warCard1 = hand1.remove(0);
                    Card warCard2 = hand2.remove(0);
                    System.out.println("Player 1 puts down a card face down.");
                    System.out.println("Player 2 puts down a card face down.");
                    warCards1.add(warCard1);
                    warCards2.add(warCard2);
                } else {
                    // If a player runs out of cards during war, the other player wins
                    if (hand1.isEmpty()) {
                        System.out.println("Player 2 wins the game!");
                    } else {
                        System.out.println("Player 1 wins the game!");
                    }
                    return;
                }
            }
            // Each player reveals their fourth card
            Card warCard1 = hand1.remove(0);
            Card warCard2 = hand2.remove(0);
            System.out.println("Player 1 reveals " + warCard1);
            System.out.println("Player 2 reveals " + warCard2);
            warCards1.add(warCard1);
            warCards2.add(warCard2);
            // Compare the ranks of the fourth cards
            if (warCard1.getRank().ordinal() > warCard2.getRank().ordinal()) {
                System.out.println("Player 1 wins the war!");
                hand1.addAll(warCards1);
                hand1.addAll(warCards2);
            } else if (warCard2.getRank().ordinal() > warCard1.getRank().ordinal()) {
                System.out.println("Player 2 wins the war!");
                hand2.addAll(warCards2);
                hand2.addAll(warCards1);
            } else {
                // If there is another tie during war, the process repeats
                System.out.println("Another tie!");
                hand1.addAll(warCards1);
                hand2.addAll(warCards2);
                playRound(hand1, hand2, round + 1);
            }
        }
        
            round++;
        }

        // Determine the winner
        if (hand1.size() > hand2.size()) {
            System.out.println("Player 1 wins the game!");
        } else {
            System.out.println("Player 2 wins the game!");
        }
    }
     
     private static void playRound(List<Wargame.Card> hand1, List<Wargame.Card> hand2, int i) {
    }
     
   
}

