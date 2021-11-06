package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MultiInput {
    public void setInput(){
        Scanner input = new Scanner(System.in);
        int nodeNum = Integer.parseInt(input.next());
//        int edgesNum = Integer.valueOf(input.nextLine().replace(" ", ""));
        int edgesNum = Integer.valueOf(input.next());
//        int tem = Integer.valueOf(input.next());
//        System.out.println("tem: " + tem);
        input.nextLine();

//        int tem = nodeNum+edgesNum;
//        System.out.println("temp: ");
        List<String> edges = new ArrayList<>();

        for(int i = 0; i < edgesNum; i++){

            String[] edge = input.nextLine().replace("/n", "").split(" ");

            edges.add(edge[0]+"-"+edge[1]);
        }
        int cutNum = input.nextInt();
        System.out.println("Nodes_Num: " + String.valueOf(nodeNum));
        System.out.println("Edges_Num: "+String.valueOf(edgesNum));
        for (int i = 0; i < edges.size(); i++) {
            System.out.println("Edge: " + edges.get(i));
        }
        System.out.println("CutNum: "+cutNum);

    }

    public static void main(String[] args) {
        Cache<String> c = new Cache<>();
        c.setValue("hello");
        String v = c.getValue();
        System.out.println(v);

    }

    public static class Cache<T> {
        T value;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

    }

}
