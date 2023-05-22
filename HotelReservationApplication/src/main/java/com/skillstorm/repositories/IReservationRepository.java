package com.skillstorm.repositories;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.skillstorm.models.Reservation;
import com.skillstorm.models.Room;
import com.skillstorm.models.User;


@Repository
public interface IReservationRepository extends JpaRepository<Reservation, Long> {
	
	List<Reservation> findByUser_UserId(long userId);

	@Query("select r from Reservation r where r.room = :roomId and r.checkInDate >= :checkInDate and r.checkOutDate <= :checkOutDate")
	List<Reservation> findConflictingReservations(@Param("roomId")Room roomId, @Param("checkInDate") ZonedDateTime checkInDate, @Param("checkOutDate") ZonedDateTime checkOutDate);

	Optional<Reservation> findById(long id);

	Optional<Reservation> getReservationById(long id);
	
//  @Lock(LockModeType.PESSIMISTIC_WRITE)
//  @Query("select r from reservations r where r.reservation_id = :id")
//  Optional<Reservation> findByIdWithLock(@Param("id") Long id);

//	@Query("select r from reservations r where r.room_id = :roomId and r.check_in_date >= :checkInDate and r.check_out_date <= :checkOutDate")
//	List<Reservation> findConflictingReservations(@Param("roomId") Integer roomId, @Param("checkInDate") ZonedDateTime checkInDate, @Param("checkOutDate") ZonedDateTime checkOutDate);




}
