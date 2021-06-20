package service_testing;


import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class XmlServiceTest {
    private static final String SAMPLE_URL = "https://en.wikipedia.org/wiki/Hokusai";

    @Test
    public void testHttpClientGetStatus() throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpResponse response = client.execute(new HttpGet(SAMPLE_URL));
        int statusCode = response.getStatusLine().getStatusCode();

        assertEquals("Status code is not OK - HTTP200", HttpStatus.SC_OK, statusCode);
    }
}
