package com.williamdaw;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Card {
    private String suit;
    private String rank;
    private Integer value;


    public Card(String suit, String rank, int value) {

    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        Map<String, Integer>royals = new HashMap<>();
        royals.put("q",10);
        royals.put("k",10);
        royals.put("j",10);
        royals.put("a",11);
        Pattern pattern = Pattern.compile("[2-9]");
        Matcher matcher = pattern.matcher(rank);
        if(matcher.find()){
            return rank;
        }
        else {
              value= royals.get(rank);
              return value;
        }




    }

    public int getValue() {
        return value;
    }

}
