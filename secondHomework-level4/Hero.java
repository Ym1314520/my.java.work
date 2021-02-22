package demo15_interfaceuse;

public class Hero implements Atk{
    private String name;
    private int hp;
    private int atk;
    private int def;
    private int counter=0;
    private Monster monster;

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hero() {
    }

    public Hero(int hp, int atk, int def) {
        this.hp = hp;
        this.atk = atk;
        this.def = def;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

//英雄发起攻击！
    public void attack(){
        setCounter(++counter);
        System.out.println("---------------第"+getCounter()+"回合----------------");
        monster.hurtMonster(this);
    }

    @Override
    public void getAtk() {
        System.out.println("英雄受到攻击！");
        this.hp=getHp()-(monster.getAtk()-def);
        setHp(this.hp);
        System.out.println("|英雄名字|"+this.getName());
        System.out.println("|英雄剩余血量|"+this.hp);
        System.out.println("|英雄攻击力|"+this.atk);
        System.out.println("|英雄防御力|"+this.def);
        if(this.hp>0){

            attack();
        }
        else{
            System.out.println("英雄已被击败！挑战失败！");
            System.out.println("========游戏结束========");
            System.exit(0);
        }
    }

    @Override
    public int realHurt() {
        return this.atk;
    }
}
