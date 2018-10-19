package com.example.ohimarc.marc.model;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Victor Johansson (Vroxie on github)
 *
 * This class sets up the rules for a Quiz gamemode i.e generate answeralternatives
 * Checks is an answers is correct and saves it etc.
 */
public class QuizGame extends Game {

    private final Random rand = new Random();
    private int rigthAnswerIndex;

    public QuizGame(Deck deck) {
        super(deck, "Quiz Game");
    }

    /**
     * This is to generate a random a index for a correct answer
     * In a array which will contain question + 4 answers
     *
     * @return a random integer between 1-4
     */
    private int getRandomIndex() {
        return rand.nextInt(4) + 1;
    }

    /**
     * Get a random answer from a the reamining answers that has not been used yet
     *
     * @param list a list of the reamaining answers
     * @return a random index of a answer that should be used
     */
    private int getRandomFromList(ArrayList<String> list) {
        return rand.nextInt(list.size());
    }

    /**
     * Decides if a answer is correct or not
     *
     * @param index which answer that were given,(the index of the answer array)
     * @return true if index is the index where the correct answer is lying, false otherwise
     */
    public boolean isCorrect(int index) {
        return index == rigthAnswerIndex;
    }

    /**
     * Stores the answer to a particular question to know how many correct answers you got and also
     * which questions you did answer correct or incorrect
     *
     * @param index which answer that were given,(the index of the answer array)
     */
    public void sendAnswer(int index) {
        boolean correct = isCorrect(index);
        questionAnswer(getNextCard(), correct);
    }


    /**
     * front will always be the first element of the array
     * the rest is answeralternatives.
     * The correct answers index is being randomized every time you want a new card
     */
    @Override
    public String[] peekNextCard() {
        if (getNextCard() < cardCopies.length) {
            String[] cardWithAnswer = new String[5];
            ArrayList<String> answers = new ArrayList<>();
            rigthAnswerIndex = getRandomIndex();
            String front = cardCopies[getNextCard()][0];
            String rightAnswer = cardCopies[getNextCard()][1];
            cardWithAnswer[0] = front;
            cardWithAnswer[rigthAnswerIndex] = rightAnswer;
            for (String[] cardCopy : cardCopies) {
                answers.add(cardCopy[1]);
            }
            answers.remove(getNextCard());
            for (int i = 0; i < cardWithAnswer.length; i++) {
                if (cardWithAnswer[i] == null) {
                    int index = getRandomFromList(answers);
                    cardWithAnswer[i] = answers.get(index);
                    answers.remove(index);
                }
            }
            return cardWithAnswer;
        } else {
            return null;
        }
    }


}
