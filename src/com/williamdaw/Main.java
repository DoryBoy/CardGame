package com.williamdaw;


import java.util.*;


public class Main {

    public static void main(String[] args) {
        //Initialisation.
        Deck cards = new Deck();
        String playerName;
        ArrayList<ArrayList<String>> playerNameList = new ArrayList<>();
        ArrayList<Player> playerList = new ArrayList<>();

        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 2; i++) {
            System.out.println("Please enter you player name: ");
            playerName = input.nextLine();
            playerNameList.add(new ArrayList<String>());
            playerNameList.get(i).add(playerName);

        }
        System.out.println(playerNameList);
        //Create player objects
        Player player1 = new Player((playerNameList.get(0).get(0)));
        Player player2 = new Player(playerNameList.get(1).get(0));
        playerList.add(player1);
        playerList.add(player2);
        Player dealer = new Player("dealer");
        cards.shuffle();
        Player player;
        //Deal hand of 2 cards to player and show cards.
        for (int i = 0; i < 2; i++) {
            player = playerList.get(i);
            player.set_hand(cards.deal(2));
            System.out.println(player.get_name() + " your cards are: ");
            player.CalculateScore();

            playerNameList.add(new ArrayList<String>());
            playerNameList.get(i).add(Integer.toString(player.get_score()));
        boolean play = true;
        while (play) {
            for (int j = 0; j < playerList.size(); j++) {

            }
            System.out.println("What would you like to do (S)tick or (D)eal another card? ");
            String player_choice = input.nextLine().toLowerCase(Locale.ROOT);
            if (player_choice.equals("s")) {
                play = false;
                System.out.println(player.get_name() + " your score is " + player.get_score());
                //Deal hand of 2 cards to dealer and show cards.
                dealer.set_hand(cards.deal(2));
                System.out.println(dealer.get_name() + "'s cards are: ");
                dealer.CalculateScore();
                if (player.get_score() > dealer.get_score()) {
                    System.out.println(player.get_name() + "wins! with a score of " + player.get_score() + " dealer scored: " + dealer.get_score());
                } else {
                    System.out.println("Dealer wins, you didn't beat the dealer, dealer scored: " + dealer.get_score() + " player scored: " + player.get_score());
                }
            } else if (player_choice.equals("d")) {
                player.set_hand(cards.deal(1));
                player.CalculateScore();
            }
            }
        }


    }
}