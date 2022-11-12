import java.util.Scanner;

public class PublicKey {
    public static void main(String[] args){
        int p, q, e, d, n, phai;
        long c, m;

        Scanner sc = new Scanner(System.in);

        System.out.println("数値を代入してください。");
        System.out.print("p = ");
        p = sc.nextInt();
        System.out.print("q = ");
        q = sc.nextInt();
        System.out.print("m = ");
        m = sc.nextInt();
        sc.close();

        n = p * q;
        phai = lcm(p - 1, q - 1);
        e = eachSo(phai);
        d = godo(phai, e);
        c = (long)Math.pow((double) m, (double) e) % n;
        m = (long)Math.pow((double) c, (double) d) % n;//数が大きくなるとint型では正しい値が得られない。→累乗の値だけlong型に変換

        System.out.printf("\n計算結果は以下のようになりました。\n");
        System.out.printf("公開鍵　(n, e) = (%d, %d)\n", n, e);
        System.out.printf("秘密鍵　(n, d) = (%d, %d)\n", n, d);
        System.out.printf("暗号文　C = %d\n", c);
        System.out.printf("平文 M = %d\n", m);
    }

    //最小公倍数を導出
    public static int lcm(int a, int b){
        int temp;

        temp = a * b / gcm(a, b);

        return temp;
    }

    //ユークリッド互除法で最大公約数を導出
    public static int gcm(int a, int b){
        int temp;
        
        if(a - b < 0){
            temp = a;
            a = b;
            b = temp;
        }

        while(a % b != 0){
            temp = a % b;
            a = b;
            b = temp;
        }

        return b;
    }

    //最も小さい互いに素な整数を導出
    public static int eachSo(int a){
        int i = 2;

        while(gcm(a, i) != 1){
            i++;
        }
        
        return i;
    }

    public static int godo(int a, int b){
        int temp = b;

        while(!(temp % a == 1 && temp % b == 0)){
            temp = temp + b; 
        }

        return temp / b;
    }
}