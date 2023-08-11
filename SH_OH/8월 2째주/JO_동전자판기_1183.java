import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int w, sum;
    static int[] coins = new int[6];
    static int[] spend = new int[6];
    static int[] res = new int[6];
    static int value[] = new int[] { 500, 100, 50, 10, 5, 1 };
    static int remain;


    public static void main(String[] args) throws IOException{


        w = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 6; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
            sum += coins[i]* value[i];
        }

        sum -= w;

        for (int i = 0 ; i < 6 ; i ++) {
            spend[i] = sum / value[i];
            sum = sum % value[i];
            res[i] = coins[i] - spend[i];
            remain += res[i];
        }

        System.out.println(remain);

        for (int i = 0 ; i < 6 ; i ++) {
            System.out.print(res[i]+ " ");
        }

    }

}
