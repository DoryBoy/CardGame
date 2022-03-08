package com.williamdaw;


import java.util.*;


public class Main {
    private static ArrayList<ArrayList<String>> playerNameList = new ArrayList<>();
    private static ArrayList<Player> playerList = new ArrayList<>();
    public static void winningCalulator(Player dealer,Deck cards){
        ArrayList<Integer> scores = new ArrayList<>();
        for (int i = 0; i < playerList.size(); i++) {
           Player player = playerList.get(i);
            System.out.println(player.get_name() + " your score is " + player.get_score());
            scores.add(player.get_score());
        }
        int n = scores.size();
        //iterate over the array comparing adjacent elements
        int temp = 0;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(scores.get((j-1)) > scores.get(j)){
                    //swap elements
                    temp = scores.get((j-1));
                    scores.set((j-1), scores.get(j));
                    scores.set(j,temp);
//                    scores.get(j-1) = scores.get(j);
//                    scores.get(j) = temp;
                }

            }
        }
        dealer.set_hand(cards.deal(2));
        System.out.println(dealer.get_name() + "'s cards are: ");
        dealer.CalculateScore();
    }
    public static void main(String[] args) {
        //Initialisation.
        Deck cards = new Deck();
        String playerName;


        Scanner input = new Scanner(System.in);

        for (int i = 0; i < 2; i++) {
            System.out.println("Please enter you player name: ");
            playerName = input.nextLine();
            playerNameList.add(new ArrayList<String>());
            playerNameList.get(i).add(playerName);

        }
        System.out.println(playerNameList);
        for (int i = 0; i < 2; i++) {
            Player players = new Player((playerNameList.get(i).get(0)));
            playerList.add(players);
        }
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
            System.out.println("What would you like to do (S)tick or (D)eal another card? ");
            String player_choice = input.nextLine().toLowerCase(Locale.ROOT);
            boolean play = true;
            while (play){
                if (player_choice.equals("s")) {
                    break;

                } else if (player_choice.equals("d")) {
                    player.set_hand(cards.deal(1));
                    player.CalculateScore();
                    playerNameList.get(i).add(Integer.toString(player.get_score()));
                }

            }
            winningCalulator(dealer,cards);


            //Deal hand of 2 cards to dealer and show cards.
           {


                if (player.get_score() > dealer.get_score()) {
                    System.out.println(player.get_name() + "wins! with a score of " + player.get_score() + " dealer scored: " + dealer.get_score());
                } else {
                    System.out.println("Dealer wins, you didn't beat the dealer, dealer scored: " + dealer.get_score() + " player scored: " + player.get_score());
                }
            }
        }


    }
}