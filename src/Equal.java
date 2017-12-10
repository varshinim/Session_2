import java.util.ArrayList;
import java.util.HashMap;

public class Equal {
	public int[] equal(int[] A){
		HashMap<Integer,ArrayList<Integer>> pair = new HashMap<Integer,ArrayList<Integer>>();
		ArrayList<Integer> result;
		int sum = 0;
        for(int i=0;i<A.length-1;i++){
            for(int j=i+1;j<A.length;j++){
                sum = A[i]+A[j];
                if(!pair.containsKey(sum)){
                	result = new ArrayList<Integer>();
                    result.add(i);
                    result.add(j);
                    pair.put(sum, result);
                }
                else{
                    result = pair.get(sum);
                    if (result.get(0) >= i || result.get(1) == i || result.get(1) == j){
	                		continue;
	                	} else {
	                		 result.add(i);
	                         result.add(j);
	                	}
                    pair.put(sum, result);
                }
            }
        }
        
        int[] ans = null;
        for(Integer i : pair.keySet()){
            result = pair.get(i);
            if(result.size()>=4){
            	if (ans == null){
            		ans = new int[4];
            		for(int j=0;j<4;j++)
            			ans[j] = result.get(j);
            	} else {
            	    for(int j=0;j<4;j++){
            	    	if (ans[j] > result.get(j)){
            	    		for(int k=0;k<4;k++)
                    			ans[k] = result.get(k);
            	    	} else if (ans[j] == result.get(j)){
            	    		continue;
            	    	} else {
            	    		break;
            	    	}
            	    }
            	    
            	}    
            }
        }
        return ans;
	}
}
