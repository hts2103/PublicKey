import java.util.Scanner;

public class PublicKey {
    public static void main(String[] args){
        int p, q, e, d, n, phai;
        long c, m;

        Scanner sc = new Scanner(System.in);

        System.out.println("���l�������Ă��������B");
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
        m = (long)Math.pow((double) c, (double) d) % n;//�����傫���Ȃ��int�^�ł͐������l�������Ȃ��B���ݏ�̒l����long�^�ɕϊ�

        System.out.printf("\n�v�Z���ʂ͈ȉ��̂悤�ɂȂ�܂����B\n");
        System.out.printf("���J���@(n, e) = (%d, %d)\n", n, e);
        System.out.printf("�閧���@(n, d) = (%d, %d)\n", n, d);
        System.out.printf("�Í����@C = %d\n", c);
        System.out.printf("���� M = %d\n", m);
    }

    //�ŏ����{���𓱏o
    public static int lcm(int a, int b){
        int temp;

        temp = a * b / gcm(a, b);

        return temp;
    }

    //���[�N���b�h�ݏ��@�ōő���񐔂𓱏o
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

    //�ł��������݂��ɑf�Ȑ����𓱏o
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