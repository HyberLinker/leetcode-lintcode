package pers.james.dfs;

import java.util.*;

public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, Set<String>> neighbors = new HashMap<>();
        Map<String, Integer> distances = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        if (!wordList.contains(endWord)) return result;

        //bfs中如果传入的arraylist：wordList,就会超时
        //传入hashset：dict，就不会超时
        Set<String> dict = new HashSet<>();
        for (String word:wordList
             ) {
            dict.add(word);
        }
        dict.add(beginWord);

        bfs(beginWord, endWord, dict, neighbors, distances);


        List<String> path = new ArrayList<String>();
        path.add(beginWord);
        dfs(beginWord, endWord, neighbors, distances, result, path);

        return result;

    }

    public void dfs(String begin, String end, Map<String, Set<String>> neighbors, Map<String, Integer> distances,
                    List<List<String>> result, List<String> path){

        if (begin.equals(end)){
            result.add(new ArrayList<String>(path));
            return;
        }

        for (String next:neighbors.get(begin)
             ) {
            if (distances.containsKey(next) && distances.get(begin) == distances.get(next) + 1){
                path.add(next);
                dfs(next, end, neighbors, distances, result, path);
                path.remove(path.size()-1);
            }
        }
    }

    public void bfs(String begin, String end, Set<String> wordList, Map<String, Set<String>> neighbors,
                    Map<String, Integer> distances){
        for (String word:wordList
             ) {
            neighbors.put(word, new HashSet<String>());
        }

        distances.put(end, 0);
        Queue<String> queue = new LinkedList<>();
        queue.offer(end);

        while (!queue.isEmpty()){
            String cur = queue.poll();
            List<String> cur_neighbors = getNeighbors(cur, wordList);
            for (String n:cur_neighbors
                 ) {
                // 添加到neighbor中，完善邻居的列表。（这样neighbors可以是List）
                //也可以使用neighbors.get(cur).add(n), 这样neighbors必须是set用于去重（特别巧）
                neighbors.get(n).add(cur);
                if (!distances.containsKey(n)){
                    distances.put(n, distances.get(cur)+1);
                    queue.offer(n);
                }
            }
        }
    }

    public List<String> getNeighbors(String w, Set<String> wordList){
        List<String> neighbors = new ArrayList<>();
        for (int i = 0; i < w.length(); i++) {
            for (char j = 'a'; j <= 'z'; j++) {
                if (w.charAt(i) != j){
                    String neighbor = w.substring(0, i) + j + w.substring(i+1);
                    if (wordList.contains(neighbor)) neighbors.add(neighbor);
                }
            }
        }
        return neighbors;
    }

//    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//        List<List<String>> ladders = new ArrayList<List<String>>();
//        Map<String, List<String>> map = new HashMap<String, List<String>>();
//        Map<String, Integer> distance = new HashMap<String, Integer>();
//        if (!wordList.contains(endWord)) return ladders;
//        wordList.add(beginWord);
////        wordList.add(endWord);
//        Set<String> dict = new HashSet<>();
//        for (String word:wordList
//             ) {
//            dict.add(word);
//        }
//
//        bfs(map, distance, endWord, beginWord, dict);
//
//        List<String> path = new ArrayList<String>();
//
//        dfs(ladders, path, beginWord, endWord, distance, map);
//
//        return ladders;
//    }
//
//    void dfs(List<List<String>> ladders, List<String> path, String crt,
//             String end, Map<String, Integer> distance,
//             Map<String, List<String>> map) {
//        path.add(crt);
//        if (crt.equals(end)) {
//            ladders.add(new ArrayList<String>(path));
//        } else {
//            for (String next : map.get(crt)) {
//                if (distance.containsKey(next) && distance.get(crt) == distance.get(next) + 1) {
//                    dfs(ladders, path, next, end, distance, map);
//                }
//            }
//        }
//        path.remove(path.size() - 1);
//    }
//
//    void bfs(Map<String, List<String>> map, Map<String, Integer> distance,
//             String start, String end, Set<String> dict) {
//        Queue<String> q = new LinkedList<String>();
//        q.offer(start);
//        distance.put(start, 0);
//        for (String s : dict) {
//            map.put(s, new ArrayList<String>());
//        }
//
//        while (!q.isEmpty()) {
//            String crt = q.poll();
//
//            List<String> nextList = expand(crt, dict);
//            for (String next : nextList) {
//                map.get(next).add(crt);
//                if (!distance.containsKey(next)) {
//                    distance.put(next, distance.get(crt) + 1);
//                    q.offer(next);
//                }
//            }
//        }
//    }
//
//    List<String> expand(String crt, Set<String> dict) {
//        List<String> expansion = new ArrayList<String>();
//
//        for (int i = 0; i < crt.length(); i++) {
//            for (char ch = 'a'; ch <= 'z'; ch++) {
//                if (ch != crt.charAt(i)) {
//                    String expanded = crt.substring(0, i) + ch
//                            + crt.substring(i + 1);
//                    if (dict.contains(expanded)) {
//                        expansion.add(expanded);
//                    }
//                }
//            }
//        }
//
//        return expansion;
//    }

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

        WordLadderII w = new WordLadderII();
        List<List<String>> result = w.findLadders(beginWord, endWord, wordList);
        for (List<String> l:result
             ) {
            for (String word:l
                 ) {
                System.out.print(word+"-");
            }
            System.out.println();
        }
    }
}


