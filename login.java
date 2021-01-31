package login_system;

import Book_system.Book_menu;

import java.util.Scanner;

public class login {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String n = null;
        Book_menu manager = new Book_menu();
        manager.init();
        do {//控制是否退出
            manager.menu();
            System.out.println("回主菜单？y(是)/其他(结束)");
            n = input.next();
        }while ("y".equals(n));
    }
}
