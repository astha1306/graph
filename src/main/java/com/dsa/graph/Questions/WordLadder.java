package com.dsa.graph.Questions;

import java.util.*;

public class WordLadder {

    public static class Pair{
        String word;
        int dist;

        public Pair(String word, int dist) {
            this.word = word;
            this.dist = dist;
        }
    }

    public static int wordLadder(String beginWord, String endWord, List<String> wordList) {

        Set<String> set = new HashSet<>(wordList);
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(beginWord, 1));
        set.remove(beginWord);

        int ans = 0;



        while (!queue.isEmpty()) {
            String word = queue.peek().word;
            int dist = queue.peek().dist;
            queue.poll();
            if(word.equals(endWord)) return dist;

            for (int i =0; i<word.length(); i++) {
                for(char ch = 'a'; ch <= 'z'; ch++) {
                    char[] replaceCharArray = word.toCharArray();
                    replaceCharArray[i] = ch;
                    String replaceWord = new String(replaceCharArray);
                    //if exists in set
                    if(set.contains(replaceWord)) {
                        set.remove(replaceWord);
                        queue.offer(new Pair(replaceWord, dist+1));
                    }
                }
            }
        }
        return 0;
    }
}
