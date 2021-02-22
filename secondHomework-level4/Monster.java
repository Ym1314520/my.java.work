package demo15_interfaceuse;

public class Monster {
    private String name;
    private int hp;
    private int atk;
    private int def;

    public Monster() {
    }

    public Monster(int hp, int atk, int def) {
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

    public int getAtk() {
        return atk;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void hurtMonster(Atk hero){
        System.out.println("怪兽受到伤害！");
        this.hp=hp-(hero.realHurt()-def);
        setHp(this.hp);
        System.out.println("|怪兽名字|"+this.getName());
        System.out.println("|怪兽剩余血量|"+this.hp);
        System.out.println("|怪兽攻击力|"+this.atk);
        System.out.println("|怪兽防御力|"+this.def);
        if(this.hp>0){
            hero.getAtk();
        }
        else {
            System.out.println("怪兽已被击败！挑战成功！");
            System.out.println("========游戏结束========");
            System.exit(0);
        }
    }

}
