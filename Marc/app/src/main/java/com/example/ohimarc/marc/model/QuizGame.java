package com.example.ohimarc.marc.model;

import java.util.ArrayList;
import java.util.Random;

public class QuizGame extends Game {
    private Random rand = new Random();
    private int rigthAnswerIndex;

    public QuizGame(Deck deck){
        super(deck,"Quiz Game");
    }

    private int getRandomIndex(){
        return rand.nextInt(4) + 1;
    }

    public int getRandomFromList(ArrayList<String> list) {
        int random = rand.nextInt(list.size());
        return random;
    }

    /*
    front will always be the first element of the array
    the rest is answeralternatives.
    The correct answers index is being randomized every time you want a new card
     */
    @Override
    public String[] peekNextCard() {
        String[] cardWithAnswer = new String[5];
        ArrayList<String> answers = new ArrayList<>();
        rigthAnswerIndex = getRandomIndex();
        String front = cardCopies[nextCard][0];
        String rightAnswer = cardCopies[nextCard][1];
        cardWithAnswer[0] = front;
        cardWithAnswer[rigthAnswerIndex] = rightAnswer;
        for(int i = 0; i < cardCopies.length;i++){
            answers.add(cardCopies[i][1]);
        }
        answers.remove(nextCard);
        for(int i = 0; i<cardWithAnswer.length;i++){
            if(cardWithAnswer[i] == null){
                int index = getRandomFromList(answers);
                cardWithAnswer[i] = answers.get(index);
                answers.remove(index);
            }
        }
        return cardWithAnswer;
    }


}
