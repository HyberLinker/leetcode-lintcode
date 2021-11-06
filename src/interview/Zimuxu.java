package interview;

import java.util.*;

public class Zimuxu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        List<String> result = new ArrayList<>();
        String r = help1(s.toLowerCase());
        System.out.println(Math.pow(10,9));
    }

    public static void help(String s, int start, List<String> result, StringBuilder com){
//        if (com.length() == s.length()){
//            if (isLegal()){
//                result.add(new String(com));
//            }
//            return;
//        }

        for (int i = start; i < s.length(); i++) {
            com.append(s.charAt(i));
            help(s, start+1, result, com);
            com.deleteCharAt(com.length()-1);
        }
    }

    public static String help1(String s){
        String com = "";
        Map<Character, Integer> map= new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char curt = s.charAt(i);
            if (!map.containsKey(curt)){
                map.put(curt, i);
                com += curt;
            }else{
                int index = com.indexOf(String.valueOf(curt));
                char neighbor = com.charAt(index+1);
                if (curt > neighbor){
                    com = com.substring(0, index) + com.substring(index+1, com.length()) + curt;
                    map.put(curt, i);
                }else {
                    com += curt;
                }
            }
        }
        return com;
    }
}
