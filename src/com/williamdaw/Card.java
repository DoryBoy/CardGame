package com.williamdaw;

public class Card {
    private String suit;
    private String rank;
    private int value;

    public Card(String given_suit, String given_rank, int given_value) {
        suit = given_suit;
        rank = given_rank;
        value = given_value;
    }

    public String get_suit() {
        return suit;
    }

    public String get_rank() {
        return rank;
    }

    public int get_value() {
        return value;
    }
}
