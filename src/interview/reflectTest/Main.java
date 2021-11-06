package interview.reflectTest;

class Base {
    int num = 1;
    static {
//        System.out.println("Base " + ++num);
    }
}

public class Main {
    public static void main(String[] args) {
        // 不会初始化静态块
        Class clazz1 = Base.class;
        System.out.println("------");
        // 会初始化
        try {
            Class clazz2 = Class.forName("interview.reflectTest.Base");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

//class Base { }
//class Derived extends Base { }
//
//public class Main {
//    public static void main(String[] args) {
//        Base base = new Derived();
//        if (base instanceof Derived) {
//            // 这里可以向下转换了
//            System.out.println("ok");
//        }
//        else {
//            System.out.println("not ok");
//        }
//    }
//}



