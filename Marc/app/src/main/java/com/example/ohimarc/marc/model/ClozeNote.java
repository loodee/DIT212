package com.example.ohimarc.marc.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ClozeNote extends Note {

    String text;

    public ClozeNote(String text){
        this.text = text;
    }

    @Override
    public void generateCards() {
        String[] words = text.split(" ");

        HashMap<String, List<Integer>> map = new HashMap<>();

        //Find deletions
        for (int i = 0; i < words.length; i++) {

            //Regex to look for the special cloze syntax
            if(words[i].matches("\\Q[[\\E(.*)\\Q::\\E(.*)\\Q]]\\E")){
                //Get the key
                String key = words[i].substring(2, words[i].indexOf("::"));

                //Find what to replace index with
                String removal = words[i].substring(words[i].indexOf("::")+2, words[i].indexOf("]]"));

                //Replace
                words[i] = removal;

                //Add mapping
                if(map.get(key) == null) {
                    map.put(key, new ArrayList<Integer>());
                }
                map.get(key).add(i);
            }
        }

        cards = new Card[map.keySet().size()];
        int cardIndex = 0;

        //Make the output order more predictable, easier to test
        List<String> sortedKeys = new ArrayList<>(map.keySet());
        java.util.Collections.sort(sortedKeys);

        System.out.println(sortedKeys);

        //Enumerate the deletions
        for (String key : sortedKeys) {
            //Add a card for each deletion index
            cards[cardIndex] = new Card(ArrayToCloze(words, map.get(key)), ArrayToString(words));
            cardIndex++;
        }

    }

    /**
     * Given an array of strings and a list of indexes to be censured removes a string where the
     * specified words are censured with "[..]"
     * */
    private String ArrayToCloze(String[] words, List<Integer> indexes) {
        String[] localWords = words.clone();

        for (Integer index : indexes) {
            localWords[index] = "[..]";
        }

        return ArrayToString(localWords);
    }

    /**
     * Given an array of Strings, returns a String with the words concatenated with spaced in between
     * */
    private String ArrayToString(String[] words) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            builder.append(words[i]);
            if(i != words.length-1){
                builder.append(" ");
            }
        }

        return builder.toString();
    }

    @Override
    String[][] getCardInfo() {
        return new String[0][];
    }
}
