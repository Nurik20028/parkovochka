package u_dev.parkovka.domain.parkingSpot;

import jakarta.persistence.*;

@Entity
@Table(name = "parking_spot")
public class ParkingSpot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "type")
    private ParkingSpotType parkingSpotType;

    @Column(name = "free")
    private Boolean free;

    public void setId(Integer id) {
        this.id = id;
    }

    public ParkingSpotType getParkingSpotType() {
        return parkingSpotType;
    }

    public Integer getId() {
        return id;
    }

    public void setParkingSpotType(ParkingSpotType parkingSpotType) {
        this.parkingSpotType = parkingSpotType;
    }

    public Boolean getFree() {
        return free;
    }

    public void setFree(Boolean free) {
        this.free = free;
    }
}
