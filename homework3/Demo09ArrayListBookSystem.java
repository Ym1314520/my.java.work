package homework3;
import homework3.MyArrayList;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

public class Demo09ArrayListBookSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyArrayList<String> booklist = new MyArrayList<>();
        MyArrayList<Integer> booknumber=new MyArrayList<>();

        do {
            System.out.println();
            System.out.println("=================欢迎来到余余爱摸鱼图书管理系统===================");
            System.out.println("请输入你的选择");
            System.out.println("1.添加图书 2.删除图书 3.遍历书架 4.查找图书 5.借阅图书 6.归还图书 0.退出");
            int ch=sc.nextInt();
            switch (ch){
                case 1:
                    addBook(booklist,sc,booknumber);
                    break;
                case 2:
                    deleteBook(booklist,sc,booknumber);
                    break;
                case 3:
                    watchBook(booklist,sc,booknumber);
                    break;
                case 4:
                    findBook(booklist,sc,booknumber);
                    break;
                case 5:
                    borrowBook(booklist,sc,booknumber);
                    break;
                case 6:
                    returnBook(booklist,sc,booknumber);
                    break;
                case 0:
                    System.out.println("谢谢你使用余余爱摸鱼的图书管理系统！我们会继续改进的！");
                    exit(0);
                    break;
                default:
                    System.out.println("没有你想要的功能，谢谢！");
                    break;
            }

        } while (true);
    }
    public static void addBook(MyArrayList<String> booklist, Scanner sc, MyArrayList<Integer> booknumber){
        System.out.println("请问你要添加多少本图书?");
        int number=sc.nextInt();
        for (int i = 0; i <number; i++) {
            System.out.println("输入你想添加的第"+(i+1)+"本书的名字：");
            String name = sc.next();
            booklist.add(name);
            System.out.println("输入你想添加的第"+(i+1)+"本书的剩余本数：");
            int bookn=sc.nextInt();
            booknumber.add(bookn);
            System.out.println("恭喜你，添加成功！");
        }
        System.out.println("全部添加完成！");
    }
    public static void deleteBook(MyArrayList<String> booklist, Scanner sc, MyArrayList<Integer> booknumber){
        System.out.println("请输入你要删除的图书的本数");
        int numbers=sc.nextInt();

        int i;
        for (int k = 1; k <= numbers; k++) {
            System.out.println("请输入你要删除的图书名");
            String bookName=sc.next();
            for (i = 0; i < booklist.size(); i++) {
                if (bookName.equals(booklist.get(i))) {
                    break;
                }
            }
            if(i==booklist.size()){
                System.out.println("余余爱摸余的书架上没有这本书，无法完成删除！");
            }
            else {
                booklist.delete(i);
                booknumber.delete(i);
                System.out.println("已成功删除!");
            }
        }

        System.out.println("删除成功！");

    }
    public static void watchBook(MyArrayList<String> booklist, Scanner sc, MyArrayList<Integer> booknumber){
        System.out.println("======欢迎查看余余爱摸鱼的书架======");
        for (int i = 0; i < booklist.size(); i++) {
            System.out.print(booklist.get(i)+" "+booknumber.get(i)+"本"+"\t");
            if((i+1)%4==0){
                System.out.println();
            }
        }
    }

    public static void borrowBook(MyArrayList<String> booklist, Scanner sc, MyArrayList<Integer> booknumber){
        int i=findBook(booklist,sc,booknumber);
        int number=booknumber.get(i);
        number--;
        booknumber.set(i,number);
        System.out.println("已成功借到一本图书！");
    }

    public static void returnBook(MyArrayList<String> booklist, Scanner sc, MyArrayList<Integer> booknumber){
        int i=findBook(booklist,sc,booknumber);
        int number=booknumber.get(i);
        number++;
        booknumber.set(i,number);
        System.out.println("已成功归还一本图书！");
    }
    public static int findBook(MyArrayList<String> booklist, Scanner sc, MyArrayList<Integer> booknumber){
        System.out.println("请输入你想找的图书的名字");
        String findName=sc.next();
        int i;
        for (i = 0; i < booklist.size(); i++) {
            if(findName.equals(booklist.get(i))){
                break;
            }
        }
        if(i==booklist.size()){
            System.out.println("余余爱摸鱼的书架上没有这本图书！");
            return -1;
        }
        else {
            System.out.println("已找到这本图书："+booklist.get(i)+" "+booknumber.get(i)+"本");
            return i;//要找的图书在ArrayList集合中的index
        }
    }
}
