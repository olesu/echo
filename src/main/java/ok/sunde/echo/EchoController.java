package ok.sunde.echo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class EchoController {
    private final Echo echo;

    EchoController(Echo echo) {
        assert echo != null;

        this.echo = echo;
    }

    @PostMapping(path = "/")
    String echo(@RequestBody String message) {
        return echo.say(message);
    }
}
