import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2672 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        
        ArrayList<double[]> list = new ArrayList<>();
        
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            double w = Double.parseDouble(st.nextToken());
            double h = Double.parseDouble(st.nextToken());
            
            list.add(new double[] {x, 0, y, y+h});
            list.add(new double[] {x, 1, y, y+h});

            answer += w*h;
        }
        list.sort((a, b) -> a[0]==b[0] ? Double.compare(a[1], b[1]) : Double.compare(a[0], b[0]));

        double prev = 0;
        double overlap = 0;
        ArrayList<double[]> yList = new ArrayList<>();
        for(double[] point : list){
            if(point[1]==0){
                yList.add(new double[] {point[2], point[3]});
                if(yList.size()>1){
                    int min = 0;
                    int max = 0;
                    for(double[] yPoint : yList){
                        int n = Math.max(min, yPoint[0]) - Math.min(max, yPoint[1]);
                        if(n>0) 
                    }
                }
            }
            
        }
        
        
    }
}
