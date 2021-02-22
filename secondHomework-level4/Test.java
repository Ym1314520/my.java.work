package demo15_interfaceuse;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println("=========欢迎来到简易版打怪兽模拟器=========");
        Hero hero = new Hero();
        Monster monster=new Monster();
        hero.setMonster(monster);
        Scanner input=new Scanner(System.in);
        System.out.println("**请输入创建的英雄名字**");
        hero.setName(input.next());
        System.out.println("**请输入创建的英雄血量**");
        hero.setHp(input.nextInt());
        System.out.println("**请输入创建的英雄攻击力（1-999）**");
        hero.setAtk(input.nextInt());
        System.out.println("**请输入创建的英雄防御力（1-999）**");
        hero.setDef(input.nextInt());
        System.out.println("**请输入创建的怪兽名字**");
        monster.setName(input.next());
        System.out.println("**请输入创建的怪兽血量**");
        monster.setHp(input.nextInt());
        System.out.println("**请输入创建的怪兽攻击力（1-999）**");
        monster.setAtk(input.nextInt());
        System.out.println("**请输入创建的怪兽防御力（1-999）**");
        monster.setDef(input.nextInt());
        hero.attack();
    }
}