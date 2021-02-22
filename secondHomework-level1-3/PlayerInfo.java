package demo14_homework2;

public class PlayerInfo {
    private String player;//玩家名称
    private int hp;//生命值
    private int atk;//攻击力
    private int def;//防御力

    public PlayerInfo() {
    }

    public PlayerInfo(String player, int hp, int atk, int def) {
        this.player = player;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
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
}
