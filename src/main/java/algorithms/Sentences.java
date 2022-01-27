package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Sentences {

    private List<String> sentences = new ArrayList<>();
    private String sentenceEnd = ".?!";

    public void addSentence(String sentence) {
        checkSentenceEnd(sentence);
        checkFirstLetterIsCapital(sentence);
        sentences.add(sentence);
    }

    private boolean checkFirstLetterIsCapital(String sentence) {
        if (sentence.toUpperCase().charAt(0) != sentence.charAt(0)) {
            throw new IllegalArgumentException("Sentence must start with capital!");
        }
        return true;
    }

    private boolean checkSentenceEnd(String sentence) {
        if (!sentenceEnd.contains(Character.toString(sentence.charAt(sentence.length() - 1)))) {
            throw new IllegalArgumentException("Sentence must end with ending mark!");
        }
        return true;
    }

    public String findLongestSentence() {
        checkIfListIsEmpty();
        String result = "";
        int lengthCounter = Integer.MIN_VALUE;
        for (String actual : sentences){
            if(actual.length() > lengthCounter){
                lengthCounter = actual.length();
                result = actual;
            }
        }
        return result;
    }

    private void checkIfListIsEmpty(){
        if(sentences.isEmpty()){
            throw new IllegalStateException("Listis Empty");
        }
    }

    public List<String> getSentences() {
        return new ArrayList<>(sentences);
    }



}
