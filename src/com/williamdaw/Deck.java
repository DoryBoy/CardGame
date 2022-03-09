package com.williamdaw;

import java.util.*;

public class Deck {
    private Card[] cards = new Card[52];
    private String[] suits = {"Hearts", "Clubs", "Spades", "Diamonds"};
    private String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King","Ace"};
    private int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10,11};
    private Stack<Card> shuffled_deck = new Stack<Card>();

    public Deck() {
        int index = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                cards[index] = new Card(suits[i], ranks[j], values[j]);
                index++;
            }
        }
    }

    public void shuffle() {
        List<Card> cardList = Arrays.asList(cards);
        Collections.shuffle(cardList);
        cardList.toArray(cards);

        for (int i = 0; i < cards.length; i++) {
            shuffled_deck.push(cards[i]);
        }
    }

    public ArrayList<Card> deal(int num_cards)
    //ArrayList<Card> deal(int num_cards)
    {
        ArrayList<Card> hand = new ArrayList<>();
        for (int i = 0; i < num_cards; i++) {
            hand.add(shuffled_deck.pop());
        }
        return hand;
    }

}
