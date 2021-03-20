package homework3;
/*
MyArrayList集合可实现功能：
add（E e）
get(int index)
set(int index,E e)
delete(int index)
find(int index)
print()
 */

public class MyArrayList<T> {
    private int pos=0;
    private int size=2;//元素个数
    private Object[] data=new Object[size];

    public MyArrayList() {
    }

    public MyArrayList(int size, Object[] data) {
        this.size = size;
        this.data = data;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Object[] getData() {
        return data;
    }

    public void setData(Object[] data) {
        this.data = data;
    }

    public void expanse(){
        //判断当前数组元素个数是否超过容量,超过容量就进行扩容
        if(pos>size-1){
            size=size+1;
            Object []newArray=new Object[size];
            for (int i = 0; i < data.length; i++) {
                newArray[i]=data[i];
            }
            setData(newArray);
        }
    }

    public void add(T t){
        expanse();
        if(t!=null){
            data[pos]=t;
            pos++;
        }
    }

    public void delete(int index){
        for (int i =index; i <data.length-1; i++) {
            data[i]=data[i+1];
        }
        pos--;
    }

    public int size(){
        return data.length;
    }

    public T get(int index){
        int i=index;
        return (T)data[i];
    }
    public void set(int index,T t){
        int flag=index;
        data[flag]=t;
    }

    public void find(int index){
        for (int i = 0; i < data.length; i++) {
            if(i==index){
                System.out.println(data[i]);
                break;
            }
        }
    }
    public void print(){
        System.out.print("[");
        for (int i = 0; i < data.length; i++) {
            if (i== data.length-1){
                System.out.print(data[data.length-1]);
                System.out.print("]");
            }
            else {
                System.out.print(data[i] + ",");
            }
        }
        System.out.println("");
    }

}
