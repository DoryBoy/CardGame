package com.williamdaw;

import java.util.ArrayList;

public class Player {
    private String name;
    private int score;
    private ArrayList<Card> hand;

    public Player(String given_name) {
        name = given_name;
        score = 0;
        hand = null;
    }

    public void CalculateScore() {
        score = 0;
        for (int i = 0; i < hand.size(); i++) {
            score += hand.get(i).get_value();
            System.out.println(hand.get(i).get_rank() + " of " + hand.get(i).get_suit());
        }
        if (score > 21) {
            System.out.println("Bust! You lose, your score was " + score);
        }
    }

    public String get_name() {
        return name;
    }

    public int get_score() {
        return score;
    }

    public void set_hand(ArrayList<Card> dealt_hand) {
        hand = dealt_hand;
    }


}
