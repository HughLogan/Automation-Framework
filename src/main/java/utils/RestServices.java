package utils;


import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;

import java.io.IOException;



public class RestServices {

    public static void getUser()  {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "https://bookstore.toolsqa.com/BookStore/v1/Books";
        // Get the RequestSpecification of the request to be sent to the server.
        RequestSpecification httpRequest = RestAssured.given();
        // specify the method type (GET) and the parameters if any.
        //In this case the request does not take any parameters
      // Response response = httpRequest.queryParam("ISBN","9781449325862").get("/Book");
        Response resp1 = httpRequest.request(Method.GET,"");
        // Print the status and message body of the response received from the server
        System.out.println("Status received => " + resp1.getStatusLine());

        String jsonstr = resp1.asString();
        System.out.println(jsonstr);
        JsonPath js = new JsonPath(jsonstr);

        String arr = js.get("books[1].subTitle");

        Assert.assertEquals(arr,"A JavaScript and jQuery Developer's Guide","Failed");

        System.out.println("Response=>" + arr);
        }


    public static void postUser() throws IOException {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost("http://dummy.restapiexample.com/api/v1/create");
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            String json = "{\r\n" +
                    "  \"name\": \"tony\",\r\n" +
                    "  \"salary\": \"12388\",\r\n" +
                    "  \"age\": \"27\",\r\n" +
                    "}";
            StringEntity stringEntity = new StringEntity(json);
            httpPost.setEntity(stringEntity);

            System.out.println("Executing request " + httpPost.getRequestLine());

            ResponseHandler<String> responseHandler = response -> {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            };
            String responseBody = httpclient.execute(httpPost, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);

        }
    }


    public static void putUser() throws IOException {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpPut httpPut = new HttpPut("http://dummy.restapiexample.com/api/v1/update/1");
            httpPut.setHeader("Accept", "application/json");
            httpPut.setHeader("Content-type", "application/json");
            String json = "{\r\n" +   "  \"name\": \"Hello\",\r\n" +
                    "  \"salary\": \"123\",\r\n" +
                    "  \"age\": \"23\",\r\n" +
                    "}";
            StringEntity stringEntity = new StringEntity(json);
            httpPut.setEntity(stringEntity);

            System.out.println("Executing request " + httpPut.getRequestLine());

            ResponseHandler<String> responseHandler = response -> {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            };
            String responseBody = httpclient.execute(httpPut, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
        }
    }

    public static void deleteUser() throws IOException {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {

            HttpDelete httpDelete = new HttpDelete("http://dummy.restapiexample.com/api/v1/delete/68");
            System.out.println("Executing request " + httpDelete.getRequestLine());

            ResponseHandler<String> responseHandler = response -> {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            };
            String responseBody = httpclient.execute(httpDelete, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
        }
    }
}