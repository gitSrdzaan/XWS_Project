package xws.microservis.advertservice.dto;

import java.util.ArrayList;

public class BundleDTO {

    private  Long id;
    private ArrayList<RentRequestDTO> rentRequestDTOS;

    public BundleDTO(Long id, ArrayList<RentRequestDTO> rentRequestDTOS) {
        this.id = id;
        this.rentRequestDTOS = rentRequestDTOS;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArrayList<RentRequestDTO> getRentRequestDTOS() {
        return rentRequestDTOS;
    }

    public void setRentRequestDTOS(ArrayList<RentRequestDTO> rentRequestDTOS) {
        this.rentRequestDTOS = rentRequestDTOS;
    }
}
