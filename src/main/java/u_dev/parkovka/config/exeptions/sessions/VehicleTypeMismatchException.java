package u_dev.parkovka.config.exeptions.sessions;

import org.springframework.http.HttpStatus;
import u_dev.parkovka.config.exeptions.BusinessException;

public class VehicleTypeMismatchException extends BusinessException {
    public VehicleTypeMismatchException(String expectedType, String actualType) {
        super("Тип транспорта " + actualType + "  не подходит для места типа " + expectedType, "VEHICLE_TYPE_MISMATCH", HttpStatus.CONFLICT);
    }
}
