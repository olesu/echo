package ok.sunde.echo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static java.lang.String.format;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpStatus.OK;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class EchoApplicationTests {
    private static final String MESSAGE = "echo";

    @LocalServerPort
    private int port;
    private RestTemplate restTemplate;
    private HttpEntity<String> httpEntity;

    @Before
    public void setUp() {
        restTemplate = new RestTemplate();
        httpEntity = new HttpEntity<>(MESSAGE, new HttpHeaders());
    }

    @Test
    public void echoesInput() {
        try {
            ResponseEntity<String> response = doPost();
            assertThat(response.getStatusCode(), equalTo(OK));
            assertThat(response.getBody(), equalTo(MESSAGE));
        } catch (HttpClientErrorException e) {
            fail(e.getStatusCode() + " " + e.getStatusText());
        }
    }

    private ResponseEntity<String> doPost() {
        return restTemplate.exchange(url(), POST, httpEntity, String.class);
    }

    private String url() {
        return format("http://localhost:%d/", port);
    }

}
