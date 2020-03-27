package siyong.xiao.learning.max;

/**
 * @Description
 * @Author iss
 * @Date 2019/10/22 10:13
 * @Version 1.0
 **/
public class Gcd {
    /**
     * 求M和N的最大公约数
     * @param m
     * @param n
     * @return
     */
    public static int gcd(int m,int n){
        int temp=0;
        if(m>n){
            while (n>0){
                temp=m%n;
                m=n;
                n=temp;
            }
            return m;
        }else{
            while (m>0){
                temp=n%m;
                n=m;
                m=temp;
            }
            return n;
        }
    }
}
