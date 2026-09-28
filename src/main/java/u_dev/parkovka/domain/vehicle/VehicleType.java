package u_dev.parkovka.domain.vehicle;

import java.math.BigDecimal;

public enum VehicleType {
    CAR(new BigDecimal(1.5)),
    MOTORCYCLE(new BigDecimal(0.9)),
    TRUCK(new BigDecimal(2));

    private final BigDecimal price;

    VehicleType(BigDecimal price){
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
