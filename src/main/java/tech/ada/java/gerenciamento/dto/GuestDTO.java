package tech.ada.java.gerenciamento.dto;

import lombok.Getter;
import lombok.Setter;
import tech.ada.java.gerenciamento.model.Guest;

/*
DTO = Objeto de Transferência de Dados (Data transfer object design pattern),
é um padrão de arquitetura de objetos que agregam e encapsulam dados para transferência.
 Filtrador, para proteção de dados.
*/
@Getter
public class GuestDTO {

    private String name;
    private String email;
    private String phoneNumber;

    public Guest toEntity(){
        return new Guest (name, email, phoneNumber);
    }
}
