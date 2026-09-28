package u_dev.parkovka.dto.request.vehicle;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import u_dev.parkovka.domain.vehicle.VehicleType;

public class CreateVehicleRequest {
    @NotNull(message = "тип машины обязательна")
    private VehicleType type;
    @NotBlank(message = "номер машины обязателен")
    private String number;
    @NotBlank(message = "Бренд тоже нужен")
    private String brand;

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
