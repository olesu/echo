package ok.sunde.echo;

import org.springframework.stereotype.Service;

@Service
class Echo {
    String say(String message) {
        return message;
    }
}
