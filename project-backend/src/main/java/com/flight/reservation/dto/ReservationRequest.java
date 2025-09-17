package com.flight.reservation.dto;

import com.flight.reservation.entity.Passager;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.UUID;

public class ReservationRequest {
    
    @NotNull
    private UUID volId;
    
    @Valid
    @NotNull
    private Passager passager;
    
    @NotNull
    @Positive
    private Integer nombrePlaces;
    
    // Constructeurs
    public ReservationRequest() {}
    
    public ReservationRequest(UUID volId, Passager passager, Integer nombrePlaces) {
        this.volId = volId;
        this.passager = passager;
        this.nombrePlaces = nombrePlaces;
    }
    
    // Getters et Setters
    public UUID getVolId() { return volId; }
    public void setVolId(UUID volId) { this.volId = volId; }
    
    public Passager getPassager() { return passager; }
    public void setPassager(Passager passager) { this.passager = passager; }
    
    public Integer getNombrePlaces() { return nombrePlaces; }
    public void setNombrePlaces(Integer nombrePlaces) { this.nombrePlaces = nombrePlaces; }
}