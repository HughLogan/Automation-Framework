package Utils;

import io.restassured.RestAssured;
import utils.RestServices;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicReference;

import static org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RestServicesTest {

    private HttpServer server;
    private AtomicReference<String> requestMethod;
    private String previousBooksUrl;
    private String previousEmployeeApiUrl;
    private String previousRestAssuredBaseUri;

    @BeforeMethod
    public void startServer() throws IOException {
        previousBooksUrl = System.getProperty("rest.services.booksUrl");
        previousEmployeeApiUrl = System.getProperty("rest.services.employeeApiUrl");
        previousRestAssuredBaseUri = RestAssured.baseURI;
        requestMethod = new AtomicReference<>();
        server = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
        server.createContext("/", exchange -> {
            requestMethod.set(exchange.getRequestMethod());
            byte[] response = ("GET".equals(exchange.getRequestMethod())
                    ? "{\"books\":[{\"subTitle\":\"unused\"},{\"subTitle\":\"A JavaScript and jQuery Developer's Guide\"}]}"
                    : "{}").getBytes(StandardCharsets.UTF_8);
            exchange.sendResponseHeaders(200, response.length);
            try (OutputStream output = exchange.getResponseBody()) {
                output.write(response);
            }
        });
        server.start();
        String baseUrl = "http://127.0.0.1:" + server.getAddress().getPort();
        System.setProperty("rest.services.booksUrl", baseUrl);
        System.setProperty("rest.services.employeeApiUrl", baseUrl);
    }

    @AfterMethod
    public void stopServer() {
        server.stop(0);
        restoreProperty("rest.services.booksUrl", previousBooksUrl);
        restoreProperty("rest.services.employeeApiUrl", previousEmployeeApiUrl);
        RestAssured.baseURI = previousRestAssuredBaseUri;
    }

    private void restoreProperty(String name, String value) {
        if (value == null) {
            System.clearProperty(name);
        } else {
            System.setProperty(name, value);
        }
    }

    @Test
    public void testGetUser() throws IOException {
        RestServices.getUser();
        assertEquals(requestMethod.get(), "GET");
    }

    @Test
    public void testPostUser() throws IOException {
        RestServices.postUser();
        assertEquals(requestMethod.get(), "POST");
    }

    @Test
    public void testPutUser() throws IOException {
        RestServices.putUser();
        assertEquals(requestMethod.get(), "PUT");
    }

    @Test
    public void testDeleteUser() throws IOException {
        RestServices.deleteUser();
        assertEquals(requestMethod.get(), "DELETE");
    }
}