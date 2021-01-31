package Book_system;
import bookSystem_yuyu.Book;
import java.util.Scanner;

public class Book_menu {//一个类
    private Book[] book;//成员变量
//    public Hashtable<Integer,Book> booklist;//一个id对应一本书
    public Scanner put;
    public Book_menu() {
        book = new Book[100];
        put = new Scanner(System.in);
    }
    
    public void init() {
        Book book1 = new Book("《三国演义》", 01);
        Book book2 = new Book("《偷影子的人》", 02);
        Book book3 = new Book("《肖申克的救赎》", 03);
        book[0] = book1;
        book[1] = book2;
        book[2] = book3;
    }


    public void menu() {//界面选择
        System.out.println("-------欢迎进入图书管理系统--------");
        System.out.println("请根据提示选择:");
        System.out.println("1.增加图书\t\t2.删除图书\t\t3.借阅图书\n4.归还图书\t\t" + "0.退出系统");
        int choice = put.nextInt();
        switch (choice) {
            case 1:
                addBook();
                break;
            case 2:
                deleteBook();
                break;
            case 3:
                checkOutBook();
                break;
            case 4:
                returnBook();
                break;
            case 0:
                System.exit(0);
            default:
        }
    }


    public void addBook() {//增加
        String name;
        int id, price, i;//局部变量
        System.out.println("请输入书名，序号，作者");
        name = put.next();
        id = put.nextInt();
        Book add = new Book(name, id);
        for (i = 0; i < book.length; i++) {
            if (book[i] == null)
                break;
        }
        book[i] = add;
        System.out.println("添加成功\n");
    }

    public int find(int x) {
        int j;
        int n = put.nextInt();
        for (j = 0; j < book.length; j++) {
            if (book[j].getId() == n)
            {
                x = j;
                break;
            }
        }
        return x;
    }
    public void deleteBook() {//删除
        int x = 0;
        System.out.println("请输入删除的书籍序号");
        x = find(x);
        int begin = x, j, y, end, i;//y是x后空位的下标，x是要删除的图书的下标
        y = 0;
        for (j = 0; j < book.length; j++) {
            if (book[j] == null) {
                y = j;
            }
            break;
        }
        end = y - 1;
        for (i = begin; i < end; i++) {
            if (i == book.length - 1)
                book[i] = null;
            else
                book[i] = book[i + 1];
        }
        book[end] = null;
    }

    public void checkOutBook() {//借阅图书
        int x = 0;
        System.out.println("请输入借阅的书籍序号");
        x = find(x);

        book[x].setCount();//被借次数+1
        if (book[x].getStatc()) {
            book[x].setStatc(false);
            System.out.println("恭喜你成功借出");
        } else {
            System.out.println(book[x].getName() + "已借出！");
        }
    }

    public void returnBook() {//归还图书
        int x = 0;
        System.out.println("请输入归还的书籍序号");
        x = find(x);
        book[x].setStatc(true);
        System.out.println("恭喜你成功归还！");
    }
}

