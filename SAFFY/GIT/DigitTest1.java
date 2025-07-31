public class DigitTest1 {

	public static void main(String[] args) {
        int tmp = 1;
        for (int i = 0; i < 5; i++){
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < i; j++){
                sb.append("   ");
            }
            for (int k = 0; k < 5-i; k++){
                sb.append(String.format("%3d", tmp));
                tmp += 1;
            }
            System.out.println(sb);
        }
	}
}
