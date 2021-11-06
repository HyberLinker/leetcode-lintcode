package pers.james.dfs;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>();
        for (String w:wordList
             ) {
            words.add(w);
        }

        if (!words.contains(endWord)) return 0;
        words.add(beginWord);
//        Map<String, HashSet<String>> neighbors = findNeighbors(words);
        int result = 1;
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        queue.offer(beginWord);
        set.add(beginWord);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur_word = queue.poll();
//                if (neighbors.get(cur_word).size() == 0){
//                    continue;
//                }
                for (String n:getNextWords(cur_word, words)
                        ) {
                    if (set.contains(n)){
                        continue;
                    }
                    if (!n.equals(endWord)){
                        queue.offer(n);
                        set.add(n);
                    }else {
                        result += 1;
                        return result;
                    }
                }
            }

            result++;
        }
        return 0;
    }
    public Map<String, HashSet<String>> findNeighbors(Set<String> words){
        Map<String, HashSet<String>> neighbors = new HashMap<>();
        for (String word:words
             ) {
            neighbors.put(word, new HashSet<String>());
        }
        for (String word:words
             ) {
            for (int i = 0; i < word.length(); i++) {
                for (char j = 'a'; j <= 'z'; j++) {
                    String potential_neighbor = replace(word, i, j);
                    if (!word.equals(potential_neighbor) && words.contains(potential_neighbor)){
                        neighbors.get(word).add(potential_neighbor);
                    }
                }
            }
        }
        return neighbors;
    }

    public String replace(String w, int i, char c){
        char[] cc = w.toCharArray();
        cc[i] = c;
        return new String(cc);
    }
    public List<String> getNextWords(String word, Set<String> words){
        List<String> nextWords = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            for (char j = 'a'; j <= 'z'; j++) {
                String potentialNextWord = replace(word, i, j);
                if (!potentialNextWord.equals(word) && words.contains(potentialNextWord)){
                    nextWords.add(potentialNextWord);
                }
            }
        }
        return nextWords;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
//        wordList.add("cog");
        WordLadder wl = new WordLadder();
//        wl.ladderLength(beginWord, endWord, wordList);

    }
}
