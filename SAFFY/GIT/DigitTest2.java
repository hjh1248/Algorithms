public class DigitTest2 {

	public static void main(String[] args) {
        int tmp = 1;
        for (int i = 0; i < 3; i++){
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < i; j++){
                sb.append("   ");
            }
            for (int k = 0; k < 5-2*i; k++){
                sb.append(String.format("%3d", tmp));
                tmp += 1;
            }
            for (int l = 0; l < i; l++){
                sb.append("   ");
            }
            System.out.println(sb);
        }
        for (int i = 0; i < 2; i++){
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 1-i; j++){
                sb.append("   ");
            }
            for (int k = 0; k < 3+2*i; k++){
                sb.append(String.format("%3d", tmp));
                tmp += 1;
            }
            for (int l = 0; l < 1-i; l++){
                sb.append("   ");
            }
            System.out.println(sb);
        }
	}
}
