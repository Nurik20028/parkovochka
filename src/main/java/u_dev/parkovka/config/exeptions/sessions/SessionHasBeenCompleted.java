package u_dev.parkovka.config.exeptions.sessions;

import org.springframework.http.HttpStatus;
import u_dev.parkovka.config.exeptions.BusinessException;

public class SessionHasBeenCompleted extends BusinessException {
    public SessionHasBeenCompleted(String id, String date) {
        super("Сессия: " + id + " была завершена в: "+ date, "SESSION_HAS_BEEN_COMPLEATED", HttpStatus.CONFLICT);
    }
}
