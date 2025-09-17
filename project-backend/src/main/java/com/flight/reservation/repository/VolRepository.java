package com.flight.reservation.repository;

import com.flight.reservation.entity.Vol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.persistence.LockModeType;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface VolRepository extends JpaRepository<Vol, UUID>, JpaSpecificationExecutor<Vol> {
    
    @Lock(LockModeType.OPTIMISTIC)
    @Query("SELECT v FROM Vol v WHERE v.id = :id")
    Optional<Vol> findByIdWithOptimisticLock(@Param("id") UUID id);
    
    @Query("SELECT v.placesReservees FROM Vol v WHERE v.id = :id")
    Optional<Integer> findPlacesReserveesByVolId(@Param("id") UUID id);
}