package bookSystem_yuyu;

public class Book {
    private String name;//书名
    private int id;//序列号
    private boolean statc = true;//借阅状态ture在馆，false借出
    private int count;//被借次数
    public int getCount() {
        return count;
    }

    public void setCount() {
        this.count++;
    }

    public boolean getStatc() {
        return statc;
    }

    public void setStatc(boolean statc) {
        this.statc = statc;
    }

    public Book(String name, int id) {//构造函数
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
