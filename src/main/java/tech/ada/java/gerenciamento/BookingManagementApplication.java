package tech.ada.java.gerenciamento;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/*
 Bean = gerenciado pelo Spring, permiti a injeção de dependência do modelmapper em outra parte do nosso código
*/
@SpringBootApplication
public class BookingManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookingManagementApplication.class, args);
    }

}

