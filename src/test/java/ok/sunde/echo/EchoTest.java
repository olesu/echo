package ok.sunde.echo;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class EchoTest {
    private Echo echo;

    @Before
    public void setUp() {
        echo = new Echo();
    }

    @Test
    public void itEchoes() {
        assertEchoAnswers("echo", "echo");
        assertEchoAnswers("echo echo", "echo echo");
    }

    private void assertEchoAnswers(String message, String answer) {
        assertThat(echo.say(message), equalTo(answer));
    }
}
