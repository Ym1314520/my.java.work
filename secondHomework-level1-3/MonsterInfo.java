package demo14_homework2;

public class MonsterInfo {
    private String monster;
    private int hp;
    private int atk;

    public MonsterInfo() {
    }

    public MonsterInfo(String monster, int hp, int atk) {
        this.monster = monster;
        this.hp = hp;
        this.atk = atk;
    }

    public String getMonster() {
        return monster;
    }

    public void setMonster(String monster) {
        this.monster = monster;
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
}
