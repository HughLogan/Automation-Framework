package handlers;

import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;

import static org.testng.Assert.*;

public class ExceptionHandlerTest {

    @Test
    public void testExceptionIndex() {
        ExceptionHandler.ExceptionIndex(4, 6, 100);// size of the array is 4(index < 4)
    }


    @Test
    public void testExceptionArithmetic() {
        ExceptionHandler.ExceptionArithmetic(10, 0); // exp: random/value
    }

    @Test
    public void testExceptionIndexMessage() throws ArrayIndexOutOfBoundsException {
        System.out.println(ExceptionHandler.ExceptionIndexMessage(4, 6, 300)); // size of the array is 4(index < 4)
    }

    @Test
    public void testUserExceptionMessage() throws IOException {
//        ExceptionHandler.UserExceptionMessage();
    }

    @Test
    public void testExceptionMessage() throws IOException {
        ExceptionHandler.ExceptionMessage();
    }

    @Test
    public void testExceptionURL() throws MalformedURLException {
        ExceptionHandler.ExceptionURL("https://mvnrepository.com/"); // pass valid URL
    }

    @Test
    public void testExceptionURLFinal() throws MalformedURLException {
        ExceptionHandler.ExceptionURLFinal("https://mvnrepository.com/"); // pass valid URL
    }

    @Test
    public void testExceptionURLPass() {
        ExceptionHandler.ExceptionURLPass("https://mvnrepository.com/"); // Pass valid URL, Executes and Skips Exception
    }
}