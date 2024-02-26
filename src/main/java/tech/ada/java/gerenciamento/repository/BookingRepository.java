package tech.ada.java.gerenciamento.repository;

import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import tech.ada.java.gerenciamento.model.Booking;



public interface BookingRepository extends JpaRepository<Booking, Long> {
}
