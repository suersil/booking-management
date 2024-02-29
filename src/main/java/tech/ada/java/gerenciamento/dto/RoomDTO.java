package tech.ada.java.gerenciamento.dto;

import lombok.Getter;
import lombok.Setter;
import tech.ada.java.gerenciamento.model.Guest;
import tech.ada.java.gerenciamento.model.Room;

@Getter
@Setter
public class RoomDTO {

    private Boolean available;
    private String name;
    private Double price;

    public Room toEntity(){
        return new Room (available, name, price);
    }
}
