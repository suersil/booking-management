package tech.ada.java.gerenciamento.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.ada.java.gerenciamento.dto.GuestDTO;
import tech.ada.java.gerenciamento.model.Guest;
import tech.ada.java.gerenciamento.model.UpdatingGuestRequest;
import tech.ada.java.gerenciamento.repository.GuestRepository;

import java.util.List;
import java.util.Optional;
@RestController("/guests")
public class GuestController {
    private final GuestRepository guestRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public GuestController(GuestRepository guestRepository, ModelMapper modelMapper) {
        this.guestRepository = guestRepository;
        this.modelMapper = modelMapper;
    }

    /*Creating request*/
    @PostMapping ("/guests")
    public ResponseEntity<Guest> addingGuests(@RequestBody GuestDTO request){
        Guest convertedGuest = modelMapper.map(request, Guest.class); //converting a request to entity
        Guest newGuest = guestRepository.save(convertedGuest); // saving entity to repository
        return ResponseEntity.status(HttpStatus.CREATED).body(newGuest); //returning status 201 (on body) w/ 'newGuest' created by repository
    }

    /*Getting ALL*/
    @GetMapping("/guests")  //Unico que nao usa @RequestBody
    public List<Guest> gettingAll() {
        List<Guest> GuestList = guestRepository.findAll();
        return GuestList;
    }

    /*Updating ALL info.*/
    @PutMapping("/guests/{id}")
    public ResponseEntity<Guest> updatingAll
    (@PathVariable Long id, @RequestBody UpdatingGuestRequest request) throws Exception {
        Optional<Guest> optionalGuest = guestRepository.findById(id);
        // Buscar pelo metodo findById(Java) que retorna um Optional<Guest> pois o mesmo pode nao existir no banco

        // Verificamos se existe valor dentro do Optional
        if (optionalGuest.isPresent()) { /// Se existir vamos fazer o get() para tirar o valor de dentro do optional
            Guest existingGuest = optionalGuest.get();

            existingGuest.setName(request.name());
            existingGuest.setEmail(request.email());
            existingGuest.setPhoneNumber(request.phoneNumber());

            Guest saveGuest = guestRepository.save(existingGuest);

            return ResponseEntity.ok(saveGuest);
        }
        return null ; //Eu não quis implementar o "Else"

    }
}



