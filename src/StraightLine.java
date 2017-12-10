import java.util.ArrayList;
import java.util.HashMap;

public class StraightLine {
	public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
	    HashMap<Integer,HashMap<Integer,Integer>> map = 
	    new HashMap<Integer,HashMap<Integer,Integer>>();
	    int result = 0;
	    for(int i=0;i<a.size();i++){
	        int overlap = 0;
	        int max = 0;
	        for(int j=i+1;j<a.size();j++){
	            int x = a.get(j) - a.get(i);
	            int y = b.get(j) - b.get(i);
	            if(x==0 && y==0){
	                overlap++;
	                continue;
	            }
	            int gcd = generate(x,y);
	            if(gcd!=0){
	                x = x/gcd;
	                y = y/gcd;
	            }
	            if(map.containsKey(x)){
	                if(map.get(x).containsKey(y)){
	                    map.get(x).put(y,map.get(x).get(y)+1);
	                }
	                else{
	                    map.get(x).put(y,1);
	                }
	            }
	            else{
	                HashMap<Integer,Integer> m = new HashMap<Integer,Integer>();
	                m.put(y,1);
	                map.put(x,m);
	            }
	            max = Math.max(max,map.get(x).get(y));
	        }
	        result = Math.max(result, max+overlap+1);
	         map.clear();
	    }
	    return result;
	}
	private int generate(int a, int b){
	    if(b==0){
	        return a;
	    }
	    return generate(b,a%b);
	}
}
