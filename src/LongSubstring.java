
public class LongSubstring {
	public int lengthOfLongestSubstring(String A) {
        int numofChars = 256;
        int n = A.length();
        int currLength = 1;
        int maxLength = 1;
        int index = 0;
        int[] visited = new int[numofChars];
        for(int i=0;i<numofChars;i++){
            visited[i] = -1;
        }
        visited[A.charAt(0)] = 0;
        for(int i=1;i<n;i++){
            index = visited[A.charAt(i)];
            if(index == -1 || i-currLength > index){
                currLength++;
            }
            else{
                if(currLength>maxLength){
                    maxLength = currLength;
                }
                currLength = i-index;
            }
            visited[A.charAt(i)] = i;
        }
        if(currLength > maxLength){
            maxLength = currLength;
        }
        return maxLength;
    }
}
