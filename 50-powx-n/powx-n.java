class Solution {
    public double myPow(double x, int n) {
        long N=n;
        while(N<0){
            x=1/x;
            N=-N;
        }
        double result=1;
        double currentResult=x;

        for(long i=N;i>0;i=i/2){
            if((i%2)==1){
                result=result*currentResult;
            }
            currentResult=currentResult*currentResult;
        }

        return result;
    }
}