package ok.sunde.echo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EchoController.class)
public class EchoControllerTest {
    private static final String MESSAGE = "echo";
    private static final String PATH = "/";

    @Autowired
    private MockMvc mvc;

    @MockBean
    private Echo echo;

    @Test
    public void itEchoes() throws Exception {
        assert echo != null;

        mvc.perform(post(PATH).content(MESSAGE))
            .andExpect(status().isOk());

        verify(echo).say(eq(MESSAGE));
    }
}
