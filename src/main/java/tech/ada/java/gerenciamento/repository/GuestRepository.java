package tech.ada.java.gerenciamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.ada.java.gerenciamento.model.Guest;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}
