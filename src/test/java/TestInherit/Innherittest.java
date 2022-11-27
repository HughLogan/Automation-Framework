package TestInherit;

import inheritance.A;
import inheritance.B;
import org.testng.annotations.Test;

public class Innherittest {

    @Test
    public void testinh(){
        B a = new B();
        a.thro();
        a.katch();
        a.run();
    }


}
