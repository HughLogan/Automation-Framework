package SampleJavaProg;

import utils.*;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;

public class Main1 {

    @Test
    private void RunPrivate() {
        AccessPrivate d = new AccessPrivate();

        // access the private variable using the getter and setter
        d.setName("Programiz");
        System.out.println(d.getName());
    }

    @Test
    public void reverse(){
        int i,j=0;
        String[] st = {"cadra","bggh","edd"};


        ArrayList<String> se = new ArrayList<>();

        for ( i=0; i<st.length; i++){
           // a[i]= st.charAt(i);
            se.add(st[i]);
        }
        se.sort(Collections.reverseOrder());

        for (String c: se ) {
           System.out.println(c);

        }


    }
    @Test
    public void repeat(){

        int i,j,count=0;
        String st = "caadra";


        for ( i=0; i<st.length(); i++){

            for(j=0;j<i;j++){
                if(st.charAt(i)==st.charAt(j))
                {
                    count++;
                }

            }
            if(count==1) {
                System.out.println(st.charAt(i));
                break;
            }
        }
        System.out.println("0");

    }
}
