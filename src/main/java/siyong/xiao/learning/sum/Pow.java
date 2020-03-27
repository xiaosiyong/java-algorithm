package siyong.xiao.learning.sum;

/**
 * @Description
 * @Author iss
 * @Date 2019/10/22 10:14
 * @Version 1.0
 **/
public class Pow {

    /**
     * 求X的N次幂
     * @param x 底数X
     * @param n 幂
     * @return X的N次幂
     */
    public static long pow(int x,int n){
        if(n<=0){
            return 1;
        }
        if(n==1){
            return x;
        }
        if(n%2==0){//n为偶数
            return pow(x*x,n/2);
        }else{//n为奇数
            return pow(x*x,(n-1)/2)*x;
        }

    }
}
