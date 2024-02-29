package tech.ada.java.gerenciamento.model;

import java.util.Objects;

public record UpdatingAllRequest(
    String name,
    String email,
    String phoneNumber
    ){

    public UpdatingAllRequest(String name, String email, String phoneNumber){
        this.name = Objects.requireNonNull(name, "Name is required.");
        this.email = Objects.requireNonNull(email, "Email is required.");
        this.phoneNumber = Objects.requireNonNull(phoneNumber, "Phone number is required.");
    }
}
