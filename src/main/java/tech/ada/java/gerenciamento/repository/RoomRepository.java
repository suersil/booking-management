package tech.ada.java.gerenciamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.ada.java.gerenciamento.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
