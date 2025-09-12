package leetCode;
/*EASY: Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n),
ans[i] is the number of 1's in the binary representation of i.*/
public class CountBits {

    public void countBits(int n){
        int[] ans = new int[n+1];
        for(int i = 0; i<= n; i++){
            ans[i] = Integer.bitCount(i);
            //System.out.println(ans[i]);
        }

    }

    public static void main(String[] args) {
        CountBits countBits = new CountBits();
        countBits.countBits(2);
    }

}
