import java.util.HashMap;

public class ZeroSum {
	public int[] lszero(int[] A) {
        HashMap<Integer,Integer> numSum = new HashMap<Integer,Integer>();
        int sum = 0;
        int maxLength = 0;
        int start = 0;
        int end = 0;
        for(int i=0;i<A.length;i++){
            sum = sum+A[i];
            if(A[i]==0 && maxLength==0){
                maxLength = 1;
                start = i;
                end = i;
            }
            if(sum == 0){
                maxLength = i+1;
                start = 0;
                end = i;
            }
            if(numSum.get(sum)!=null){
                if(maxLength<(i-numSum.get(sum))){
                   maxLength = Math.max(maxLength, i-numSum.get(sum));
                   start = numSum.get(sum)+1;
                   end = i;
                }
            }
            else{
                numSum.put(sum,i);
            }
        }
        int[] arr = new int[maxLength];
        for(int i=0;i<maxLength;i++){
            if(start<=end){
                arr[i] = A[start];
                start++;
            }
            
        }
        return arr;
	}
}
