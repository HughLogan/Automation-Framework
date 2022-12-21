package TestInherit;

import inheritance.A;
import inheritance.B;
import org.testng.annotations.Test;

public class Innherittest {

    @Test
    public void testinh(){
//        B a = new B();
//        a.katch();
//        a.katch(10);

        A b = new B();
        b.run();

    }


}
