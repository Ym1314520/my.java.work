package homework3;

public class Tester {
    public static void main(String[] args) {
        MyArrayList<String> list=new MyArrayList<>();
        list.add("zhuzhu");
        list.add("mama");
        list.add("baba");
        list.print();
        list.delete(1);
        list.print();
        list.add("babababab");
        list.print();
        list.find(2);
        list.set(1,"neinei");
        list.print();

    }
}
