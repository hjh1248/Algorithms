import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main17945 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        //근의공식: (-a +- sqrt(a*a-b))
        int n = a*a-b;
        double doublesqrt = Math.sqrt(n);
        int sqrt = (int)Math.sqrt(n);
        if (sqrt == doublesqrt) {
            if(sqrt==0){
                System.out.println(-a);
            }
            else{
                int x1 = -a + sqrt;
                int x2 = -a - sqrt;
                if(x1>x2) System.out.println(x2 + " " + x1);
                if(x1<x2) System.out.println(x1 + " " + x2);
            }
        }
    }
}