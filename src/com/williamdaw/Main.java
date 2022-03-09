package com.williamdaw;


import java.util.*;


public class Main {
    private static final ArrayList<ArrayList<String>> playerNameList = new ArrayList<>();
    private static final ArrayList<Player> playerList = new ArrayList<>();

    public static void winningCalculator(Player dealer, Deck cards) {
        ArrayList<Integer> scores = new ArrayList<>();
        for (Player player : playerList) {
            System.out.println(player.get_name() + " your score is " + player.get_score());
            scores.add(player.get_score());
        }
        int n = scores.size();
        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (scores.get((j - 1)) > scores.get(j)) {
                    //swap elements
                    temp = scores.get((j - 1));
                    scores.set((j - 1), scores.get(j));
                    scores.set(j, temp);
//                    scores.get(j-1) = scores.get(j);
//                    scores.get(j) = temp;
                }

            }
        }
        dealer.set_hand(cards.deal(2));
        System.out.println(dealer.get_name() + "'s cards are: ");
        dealer.CalculateScore();
        int win = 0;
        for (int i = 0; i < scores.size(); i++) {
            if (Objects.equals(playerNameList.get(i).get(1), Integer.toString(scores.get(scores.size() - 1)))) {
                win = i;
            }
        }

        if (scores.get((scores.size() - 1)) > dealer.get_score()) {

            System.out.println(playerNameList.get(win).get(0) + "wins! with a score of " + playerNameList.get(win).get(1) + " dealer scored: " + dealer.get_score());
        } else {
            System.out.println("Dealer wins, you didn't beat the dealer, dealer scored: " + dealer.get_score() + " " + playerNameList.get(win).get(0) + " scored: " + playerNameList.get(win).get(1));
        }
    }

    public static void main(String[] args) {
        //Initialisation.
        Deck cards = new Deck();
        String playerName;


        Scanner input = new Scanner(System.in);
        boolean valid = false;
        int numplayers = 0;
        while (!valid) {
            System.out.println("Enter how many players you want");
            numplayers = input.nextInt();
            if (numplayers > 10) {
                System.out.println("num of players to high");
            } else {
                valid = true;
            }

        }


        System.out.println("here we go");
        for (int i = 0; i < numplayers; i++) {
            System.out.println("Please enter you player name: ");
            playerName = input.nextLine();
            playerNameList.add(new ArrayList<>());
            playerNameList.get(i).add(playerName);

        }
        while (true) {

            System.out.println(playerNameList);
            for (int i = 0; i < numplayers; i++) {
                Player players = new Player((playerNameList.get(i).get(0)));
                playerList.add(players);
            }
            Player dealer = new Player("dealer");
            cards.shuffle();
            Player player;
            //Deal hand of 2 cards to player and show cards.
            for (int i = 0; i < numplayers; i++) {
                player = playerList.get(i);
                player.set_hand(cards.deal(2));
                System.out.println(player.get_name() + " your cards are: ");
                player.CalculateScore();
                playerNameList.add(new ArrayList<>());
                playerNameList.get(i).add(Integer.toString(player.get_score()));
                System.out.println("What would you like to do (S)tick or (D)eal another card? ");
                String player_choice = input.nextLine().toLowerCase(Locale.ROOT);
                while (true) {
                    if (player_choice.equals("s")) {
                        break;

                    } else if (player_choice.equals("d")) {
                        player.set_hand(cards.deal(1));
                        player.CalculateScore();
                        playerNameList.get(i).add(Integer.toString(player.get_score()));
                    }

                }
                // fix double print problem
                // check deal function
            }
            winningCalculator(dealer, cards);
            String ans;
            while (true) {
                System.out.println("would you like to continue playing y or n:");
                ans = input.toString();
                if (ans.toLowerCase(Locale.ROOT).equals("n")) {
                    break;

                } else if (ans.toLowerCase(Locale.ROOT).equals("y")) {
                    break;
                }

            }
            if (ans.equals("n")) {
                break;
            }
        }
    }
}