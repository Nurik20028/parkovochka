package u_dev.parkovka.config.exeptions.sessions;

import org.springframework.http.HttpStatus;
import u_dev.parkovka.config.exeptions.BusinessException;

public class SpotAlreadyOccupiedException extends BusinessException {
    public SpotAlreadyOccupiedException(Integer spotId) {
        super("Место " + spotId + " уже занято", "SPOT_ALREADY_OCCUPIED", HttpStatus.CONFLICT);
    }
}

