


import java.util.ArrayList;

/**
 * Created by Aria on 30/04/2017.
 */
public class MergeStrings {
    public static void main(String[] args) {
        isMerged("uro", "gled", "gulerod");
    }
    public static void isMerged(String a, String b, String c){
        int xlength = a.length();
        int ylength = b.length();
        char x[] = a.toCharArray();
        char y[] = b.toCharArray();
        char z[] = c.toCharArray();
        System.out.println(z.length);

        boolean[][] table = new boolean[xlength+1][ylength+1];
        table[0][0] = true;
        for(int i = 1; i<=xlength;i++){
            if(x[i-1] == z[i-1]){
                table[i][0] = true;
            }
        }
        for(int j = 1; j<=ylength;j++){
            if(y[j-1] == z[j-1]){
                table[0][j] = true;
            }
        }
        for(int i = 1; i<=xlength;i++){
            for(int j = 1; j<=ylength;j++){
                if(z[i+j - 1]  == x[i - 1]){
                    System.out.println(z[i + j - 1] + " or " + x[i -1]);
                    table[i][j] = table[i][j] || table[i-1][j];
                }
                if(z[i+j - 1]  == y[j -1]){
                    System.out.println(z[i + j - 1] + " and " + y[j -1]);
                    table[i][j] = table[i][j] || table[i][j-1];
                }

            }
        }
        for(int i = 0; i<=xlength;i++) {
            for (int j = 0; j <= ylength; j++) {
                System.out.println(table[i][j] + " x" + i + "y" + j );
            }
        }
        System.out.println(table[xlength][ylength]);
    }
}
