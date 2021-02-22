package demo14_homework2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PlaySimulator {
    public static void main(String[] args) {
        System.out.println("==============欢迎来到王者荣耀之打年兽文字模拟器=================");
        System.out.println("**创建您的角色**");
        PlayerInfo player=new PlayerInfo();
        Scanner input=new Scanner(System.in);
        System.out.println("请输入您创建英雄的名字：（1-50）");
        player.setPlayer(input.next());
        System.out.println("请输入您创建英雄的血量：（1-999）");
        player.setHp(input.nextInt());
        System.out.println("请输入您创建英雄的攻击力：（1-999）");
        player.setAtk(input.nextInt());
        System.out.println("请输入您创建英雄的防御力：（1-999）");
        player.setDef(input.nextInt());
        System.out.println("**您创建的全部角色信息如下**");
        System.out.println("|主角名称|"+player.getPlayer());
        System.out.println("|生命值|（1-999）"+player.getHp());
        System.out.println("|攻击力|（1-999）"+player.getAtk());
        System.out.println("|防御力|（1-999）"+player.getDef());
        System.out.println();
        System.out.println("**请选择您要挑战的年兽类型**");
        MonsterInfo monster1=new MonsterInfo("玛卡巴卡",500,250);
        MonsterInfo monster2=new MonsterInfo("鲁斯比斯",600,350);
        MonsterInfo monster3=new MonsterInfo("汤姆布利柏",700,450);
        MonsterInfo monster4=new MonsterInfo("丁丁车",888,520);
        System.out.println("1-玛卡巴卡  2-鲁斯比斯  3-汤姆布利柏 4-丁丁车 5-一对多年兽模式");
        int choose=input.nextInt();
        switch (choose){
            case 1:
                System.out.println("|怪兽名称|"+monster1.getMonster());
                System.out.println("|生命值|（1-999）"+monster1.getHp());
                System.out.println("|攻击力|（1-999）"+monster1.getAtk());
                attack(monster1,player);
                break;
            case 2:
                System.out.println("|怪兽名称|"+monster2.getMonster());
                System.out.println("|生命值|（1-999）"+monster2.getHp());
                System.out.println("|攻击力|（1-999）"+monster2.getAtk());
                attack(monster2,player);
                break;
            case 3:
                System.out.println("|怪兽名称|"+monster3.getMonster());
                System.out.println("|生命值|（1-999）"+monster3.getHp());
                System.out.println("|攻击力|（1-999）"+monster3.getAtk());
                attack(monster3,player);
                break;
            case 4:
                System.out.println("|怪兽名称|"+monster4.getMonster());
                System.out.println("|生命值|（1-999）"+monster4.getHp());
                System.out.println("|攻击力|（1-999）"+monster4.getAtk());
                attack(monster4,player);
                break;
            case 5:
                int counter=4;
                Random num=new Random();
                ArrayList<MonsterInfo> monsters=new ArrayList<>();
                monsters.add(monster1);
                monsters.add(monster2);
                monsters.add(monster3);
                monsters.add(monster4);
                for (int i = 0; i < monsters.size(); i++) {//arraylist里面怪兽内容
                    System.out.println(monsters.get(i).getMonster());
                }

                do {
                    System.out.println("请选择要发动攻击类型：1-随机攻击 2-指定攻击");
                    int choose2=input.nextInt();
                    if(choose2==1){
                        int number = num.nextInt(counter);//随机生成怪兽下标
                        MonsterInfo Monster = monsters.get(number);
                        System.out.println("=============="+player.getPlayer()+"发起攻击！==============");
                        multiAttack(Monster,player,monsters,number);
                    }
                    if(choose2==2){//通过名字指定攻击怪物
                        int number=-1;
                        System.out.println("请输入你要攻击的怪兽名称：");
                        String name=input.next();
                        for (int i = 0; i < monsters.size(); i++) {
                            if(name.equals(monsters.get(i).getMonster())){
                                number=i;
                                break;
                            }
                        }
                        if(number==-1){
                                System.out.println("该游戏模拟器中没有找到你想攻击的怪兽！");
                                System.exit(0);
                        }
                        MonsterInfo Monster = monsters.get(number);
                        System.out.println("=============="+player.getPlayer()+"发起攻击！==============");
                        multiAttack(Monster,player,monsters,number);
                    }
                    if(monsters.size()<counter){
                        counter=monsters.size();
                    }

                }while(monsters.size()!=0);
                System.out.println("你已击败所有怪物，恭喜你获得胜利！");
                System.exit(0);
            default:
                System.out.println("本款游戏模拟器暂时没有推出您想要挑战的年兽！");
        }




    }

    //一对一攻击模式
    public static void attack(MonsterInfo monster,PlayerInfo player){
        System.out.println("**战斗阶段**");
        int count=1;
        do {
            System.out.println("-----现在是第 " + count + " 回合-----");
            System.out.println("轮到英雄"+player.getPlayer()+"攻击");//英雄发动攻击
            System.out.println("英雄"+player.getPlayer()+"发动技能，对怪兽造成伤害"+player.getAtk());
            monster.setHp(monster.getHp()- player.getAtk());
            System.out.println("|怪兽|"+monster.getMonster()+
                    "|生命值|"+monster.getHp()+"|攻击力|"+monster.getAtk());
            if(monster.getHp()<=0){//通过血量，判断游戏是否结束
            System.out.println("怪兽已被击败，恭喜你获得胜利！");
            break;
            }
            System.out.println("轮到怪兽"+monster.getMonster()+"攻击");//怪兽发动攻击
            System.out.println("怪兽"+monster.getMonster()+"发动技能，对英雄造成伤害"+monster.getAtk());
            if(monster.getAtk()-player.getDef()<=0){//如果造成真伤小于等于0,就当作造成了1伤害
                player.setHp(player.getHp()-1);
            }
            else {
                player.setHp(player.getHp() - (monster.getAtk() - player.getDef()));
            }
            System.out.println("|英雄|"+player.getPlayer()+"|生命值|"+player.getHp()+"|攻击力|"
                    +player.getAtk()+"|防御力|"+player.getDef());
            if(player.getHp()<=0){
                System.out.println("您的英雄已被怪兽击败，挑战失败！");
                break;
            }
            count++;
        }while(true);
        System.out.println("================游戏结束==============");
    }

    //一对多攻击模式
    public static PlayerInfo multiAttack(MonsterInfo monsters, PlayerInfo player,
                                         ArrayList<MonsterInfo> monsterlist, int index){
        System.out.println("轮到英雄"+player.getPlayer()+"攻击");//英雄发动攻击
        System.out.println("英雄"+player.getPlayer()+"发动技能，对怪兽"+monsters.getMonster()+"造成伤害"+player.getAtk());
        monsters.setHp(monsters.getHp()- player.getAtk());
        System.out.println("|怪兽|"+monsters.getMonster()+
                "|生命值|"+monsters.getHp()+"|攻击力|"+monsters.getAtk());
        if(monsters.getHp()<=0){//通过血量，判断游戏是否结束
            System.out.println("怪兽"+monsters.getMonster()+"已被击败！");
            monsterlist.remove(index);
            return player;
        }
        System.out.println("轮到怪兽"+monsters.getMonster()+"攻击");//怪兽发动攻击
        System.out.println("怪兽"+monsters.getMonster()+"发动技能，对英雄造成伤害"+monsters.getAtk());
        if(monsters.getAtk()-player.getDef()<=0){//如果造成真伤小于等于0,就当作造成了1伤害
            player.setHp(player.getHp()-1);
        }
        else {
            player.setHp(player.getHp() - (monsters.getAtk() - player.getDef()));
        }
        System.out.println("|英雄|"+player.getPlayer()+"|生命值|"+player.getHp()+"|攻击力|"
                +player.getAtk()+"|防御力|"+player.getDef());
        if(player.getHp()<=0){
            System.out.println("您的英雄已被怪兽击败，挑战失败！");
            System.out.println("==================游戏结束===============");
            System.exit(0);
        }
        return player;
    }

}
