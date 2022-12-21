package SampleJavaProg;

public class CountChar {

    private static int i, j;
    private static int[] count =  new int[256];
    private static String big;

    public static void main(String args[]) {
        big = "Interstellar Cooper";

        int len = big.length();

        for (i = 0; i < len; i++) {
            count[(int) big.charAt(i)] += 1;
        }

        System.out.println();

        for(j=0;j<256;j++){
            if(count[j]!=0 && count[j]!=1 ){
                System.out.print((char)j +"-- "+count[j]);
            }
        }
    }
}
