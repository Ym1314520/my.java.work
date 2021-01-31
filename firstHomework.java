package homework;

import java.util.Scanner;

public class firstHomework {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要输入的数字个数：");
        int size;
        size=sc.nextInt();
        int[]number=new int[100];
        System.out.println("请输入一串数字：");
        for(int i=0;i<size;i++) {
            number[i]=sc.nextInt();
        }
        sorted(number,size);
        System.out.println("排序后的结果为：");
        for (int i = 0; i <size; i++) {
            System.out.print(number[i] + "\t");
        }
        System.out.println("\n");
        int size2;
        System.out.println("请输入你要再输入的数字个数：");
        size2=sc.nextInt();
        int []number2=new int[100];
        System.out.println("请输入另一串数字：");
        for(int i=0;i<size2;i++) {
            number2[i]=sc.nextInt();
        }
        allsorted(number2,number,size,size2);
        System.out.println("合并后的结果为：");
        for (int i = 0; i <size+size2; i++) {
            System.out.print(number[i]+"\t");
        }


    }

    public static void sorted(int []number, int size){
        for(int i=0;i<size;i++) {
            for(int j=0;j<size-i-1;j++){
                if(number[j]>number[j+1]){
                    int temp;
                    temp=number[j];
                    number[j]=number[j+1];
                    number[j+1]=temp;
                }
            }
        }

    }

    public static void allsorted(int []number2,int []number,int size,int size2){
        int i,j,k;
        for( i=0;i<size2;i++){
            for ( j = 0; j <size; j++) {
                if(number[j]>number2[i]){
                    for ( k = size-1; k>=j ; k--) {
                        number[k+1]=number[k];
                    }
                    break;
                }
            }
            size++;
            number[j]=number2[i];
//            System.out.println("这次排序后的结果：");
//            for (int l = 0; l <size; l++) {
//                System.out.print(number[l]+"\t");
//            }

        }
    }
}