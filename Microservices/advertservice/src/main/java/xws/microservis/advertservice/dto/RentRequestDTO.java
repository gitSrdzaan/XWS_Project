package xws.microservis.advertservice.dto;

import xws.microservis.advertservice.model.RentRequest;
import xws.microservis.advertservice.model.RentRequestStatus;

import java.util.Date;

public class RentRequestDTO {

    private Long id;
    private Long rentAdvert_id;
    private Long sender_id;
    private Long bundle_id;
    private Date reservationStart;
    private Date reservationEnd;
    private RentRequestStatus status;

    public RentRequestDTO(Long id, Long rentAdvert_id, Long sender_id, Long bundle_id, Date reservationStart, Date reservationEnd, RentRequestStatus status) {
        this.id = id;
        this.rentAdvert_id = rentAdvert_id;
        this.sender_id = sender_id;
        this.bundle_id = bundle_id;
        this.reservationStart = reservationStart;
        this.reservationEnd = reservationEnd;
        this.status = status;
    }

    public RentRequestDTO(RentRequest request){
        this.id = request.getId();
        this.rentAdvert_id = request.getRentAdvert().getId();
        this.sender_id = request.getAdvertSender().getId();
        this.bundle_id = request.getRentRequestBundle().getId();
        this.reservationStart = request.getReservationStart();
        this.reservationEnd = request.getReservationEnd();
        this.status = request.getStatus();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRentAdvert_id() {
        return rentAdvert_id;
    }

    public void setRentAdvert_id(Long rentAdvert_id) {
        this.rentAdvert_id = rentAdvert_id;
    }

    public Long getSender_id() {
        return sender_id;
    }

    public void setSender_id(Long sender_id) {
        this.sender_id = sender_id;
    }

    public Long getBundle_id() {
        return bundle_id;
    }

    public void setBundle_id(Long bundle_id) {
        this.bundle_id = bundle_id;
    }

    public Date getReservationStart() {
        return reservationStart;
    }

    public void setReservationStart(Date reservationStart) {
        this.reservationStart = reservationStart;
    }

    public Date getReservationEnd() {
        return reservationEnd;
    }

    public void setReservationEnd(Date reservationEnd) {
        this.reservationEnd = reservationEnd;
    }

    public RentRequestStatus getStatus() {
        return status;
    }

    public void setStatus(RentRequestStatus status) {
        this.status = status;
    }
}
