import java.io.*;
import java.util.*;

class Main2477 {

	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int K = Integer.parseInt(br.readLine());
	    int[][] arr = new int[6][2];
	    for(int i=0; i<6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
	    	for(int j=0; j<2; j++) {
	    		arr[i][j] = Integer.parseInt(st.nextToken());
	    	}
	    }
	    
	    int maxX = 0;
	    int maxY = 0;
	    int minX = 0;
	    int minY = 0;
	    int maxXi = 0;
	    int maxYi = 0;
	    int newXi;
	    int newYi;
	    
	    for(int i=0; i<6; i++) {
	    	if(arr[i][0]==1 || arr[i][0]==2) {
	    		if(arr[i][1]>maxX) {
	    			maxXi = i;
	    			maxX = arr[i][1];
	    		}
	    	}
	    	else {
	    		if(arr[i][1]>maxY) {
	    			maxYi = i;
	    			maxY = arr[i][1];
	    		}
	    	}
	    }
	    
	    newXi = maxXi-1;
	    if(newXi==(-1)) newXi = 5;
	    if(newXi!=maxYi) minY = maxY-arr[newXi][1];
	    newYi = maxYi-1;
	    if(newYi==(-1)) newYi = 5;
	    if(newYi!=maxXi) minX = maxX-arr[newYi][1];
	    newXi = maxXi+1;
	    if(newXi==(6)) newXi = 0;
	    if(newXi!=maxYi) minY = maxY-arr[newXi][1];
	    newYi = maxYi+1;
	    if(newYi==(6)) newYi = 0;
	    if(newYi!=maxXi) minX = maxX-arr[newYi][1];
	    
	    System.out.println((maxX * maxY - minX * minY)*K);
	}
}