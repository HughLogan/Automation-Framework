package Utils;

import org.testng.annotations.Test;
import utils.RestServices;

import java.io.IOException;

import static org.testng.Assert.*;

public class RestServicesTest {

    @Test
    public void testGetUser() throws IOException {
        RestServices.getUser();
    }

    @Test
    public void testPostUser() throws IOException {
        RestServices.postUser();
    }

    @Test
    public void testPutUser() throws IOException {
        RestServices.putUser();
    }

    @Test
    public void testDeleteUser() throws IOException {
        RestServices.deleteUser();
    }
}