package pers.james.bfs;

import java.util.*;

public class CourseScheduleIII {
    public int scheduleCourse(int[][] courses) {
        int num = courses.length;
        List<List<List<Integer>>> result = new ArrayList<>();

        combination(courses, 0, new HashSet<Integer>(), new ArrayList<List<Integer>>(), result);
        for (List<List<Integer>> com:result
             ) {
            for (List<Integer> course:com
                 ) {
                System.out.print(course.get(0).toString()+"-"+course.get(1).toString()+" ");
            }
            System.out.println();
        }
        return 0;
    }

    public void combination(int[][] courses, int index, Set<Integer> set, List<List<Integer>> com, List<List<List<Integer>>> result ){
        if (com.size() != 0 && !isValid(com)) {
            List<Integer> currentCom = com.get(com.size()-1);
            com.remove(com.size()-1);
            result.add(new ArrayList<List<Integer>>(com));
            com.add(currentCom);
            return;
        }

        if (com.size() == courses.length && isValid(com)){
            result.add(new ArrayList<List<Integer>>(com));
            return;
        }

        for (int i = index; i < courses.length; i++) {
            if (set.contains(i)) continue;

            set.add(i);
            com.add(Arrays.asList(courses[i][0], courses[i][1]));
            combination(courses, index, set, com, result);
            com.remove(com.size()-1);
            set.remove(i);
        }
    }

    public boolean isValid(List<List<Integer>> com){
        int start = 1;
        for (List<Integer> l:com
             ) {
            int duration = l.get(0);
            int close = l.get(1);
            if (start > close) return false;
            start += duration;
            if (start - 1 > close) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        CourseScheduleIII c = new CourseScheduleIII();
//        int[][] courses = new int[4][2];
//
//        courses[0][0] = 100;
//        courses[0][1] = 200;
//        courses[1][0] = 200;
//        courses[1][1] = 1300;
//        courses[2][0] = 1000;
//        courses[2][1] = 1250;
//        courses[3][0] = 2000;
//        courses[3][1] = 3200;
        int[][] courses = {{914,9927},{333,712},{163,5455},{835,5040},{905,8433},{417,8249},{921,9553},
                {913,7394},{303,7525},{582,8658},{86,957},{40,9152},{600,6941},{466,5775},{718,8485},
                {34,3903},{380,9996},{316,7755}};

        c.scheduleCourse(courses);
    }
}

//public class CourseScheduleIII {
//    public int scheduleCourse(int[][] courses) {
//        int num = courses.length;
//        List<Integer> result = new ArrayList<>();
//        combination(courses, 0, new HashSet<Integer>(), new ArrayList<List<Integer>>(), result);
//        return result.get(0);
//    }
//
//    public void combination(int[][] courses, int index, Set<Integer> set, List<List<Integer>> com, List<Integer> result ){
//        if (com.size() != 0 && !isValid(com)) {
//            int courseNum = com.size() - 1;
//            if (result.size() == 0) result.add(courseNum);
//            else {
//                if (courseNum > result.get(0)){
//                    result.set(0, courseNum);
//                }
//            }
//            return;
//        }
//
//        if (com.size() == courses.length && isValid(com)){
//            int courseNum = com.size();
//            if (result.size() == 0) result.add(courseNum);
//            else {
//                if (courseNum > result.get(0)){
//                    result.set(0, courseNum);
//                }
//            }
//            return;
//        }
//
//        for (int i = index; i < courses.length; i++) {
//            if (set.contains(i)) continue;
//
//            set.add(i);
//            com.add(Arrays.asList(courses[i][0], courses[i][1]));
//            combination(courses, index, set, com, result);
//            com.remove(com.size()-1);
//            set.remove(i);
//        }
//    }
//
//    public boolean isValid(List<List<Integer>> com){
//        int start = 1;
//        for (List<Integer> l:com
//                ) {
//            int duration = l.get(0);
//            int close = l.get(1);
//            if (start > close) return false;
//            start += duration;
//            if (start-1 > close) return false;
//        }
//        return true;
//    }
//
//    public static void main(String[] args) {
//        CourseScheduleIII c = new CourseScheduleIII();
//        int[][] courses = {{914,9927},{333,712},{163,5455},{835,5040},{905,8433},{417,8249},{921,9553},
//                {913,7394},{303,7525},{582,8658},{86,957},{40,9152},{600,6941},{466,5775},{718,8485},
//                {34,3903},{380,9996},{316,7755}};
//
//        System.out.println(c.scheduleCourse(courses));
//
//    }
//}
