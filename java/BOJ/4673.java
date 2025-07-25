import java.io.IOException;

class Main4673 {
    public static void main(String[] args) throws IOException {
        A: for(int i=1; i<=10000; i++){
            int x;

            if(i<=36){
                x = i;
            }
            else x = 36;
            
            for(int j=i-x; j<i; j++){
                if(j<10){
                    if(j+j==i) continue A;
                }
                else if(j<100){
                    if(j+j%10+j/10==i) continue A;
                }
                else if(j<1000){
                    if(j+j%10+j/10%10+j/100%10==i) continue A;
                }
                else if(j<10000){
                    if(j+j%10+j/10%10+j/100%10+j/1000%10==i) continue A;
                }
            }
            System.out.println(i);
        }
    }
}