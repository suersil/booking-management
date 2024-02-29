package tech.ada.java.gerenciamento.model;

import java.util.Objects;

public record UpdatingRoomRequest(
        Boolean available,
        String name,
        Float price) {
    public UpdatingRoomRequest(Boolean available, String name, Float price){
        this.available = Objects.requireNonNull(available, "Status is required.");
        this.name = Objects.requireNonNull(name, "Name  is required.");
        this.price = Objects.requireNonNull(price, "Price is required.");
    }
}
