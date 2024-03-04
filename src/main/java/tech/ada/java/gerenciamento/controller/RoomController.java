package tech.ada.java.gerenciamento.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.ada.java.gerenciamento.dto.RoomDTO;
import tech.ada.java.gerenciamento.model.Room;
import tech.ada.java.gerenciamento.model.UpdatingRoomRequest;
import tech.ada.java.gerenciamento.repository.RoomRepository;

import java.util.List;
import java.util.Optional;

//Todo:
// Delete, Patch e return do Put -ROOM e Guest
// Get by filters.
@RestController("/rooms")
public class RoomController {
    private final RoomRepository roomRepository;
    private final ModelMapper modelMapper;
    @Autowired
    public RoomController(RoomRepository roomRepository, ModelMapper modelMapper) {
        this.roomRepository = roomRepository;
        this.modelMapper = modelMapper;
    }

    /*Creating request*/
    @PostMapping("/rooms")
    public ResponseEntity<Room> addingRooms(@RequestBody RoomDTO request){
        Room convertedRoom = modelMapper.map(request, Room.class); //converting a request to entity
        Room newRoom = roomRepository.save(convertedRoom); // saving entity to repository
        return ResponseEntity.status(HttpStatus.CREATED).body(newRoom); //returning status 201 (on body) w/ 'newRoom' created by repository
    }

    /*Getting ALL*/
    @GetMapping("/rooms")  //Get -Unico que nao usa @RequestBody
    public List<Room> gettingAll() {
        List<Room> RoomList = roomRepository.findAll();
        return RoomList;
    }

    /*Updating ALL info.*/
    @PutMapping("/rooms/{id}")
    public ResponseEntity<Room> updatingAll
    (@PathVariable Long id, @RequestBody UpdatingRoomRequest request) throws Exception {
        Optional<Room> optionalRoom = roomRepository.findById(id);

        if (optionalRoom.isPresent()) {
            Room existingRoom = optionalRoom.get();

            existingRoom.setAvailable(request.available());
            existingRoom.setName(request.name());
            existingRoom.setPrice(request.price());

            Room saveRoom = roomRepository.save(existingRoom);

            return ResponseEntity.ok(saveRoom);
        }
        return null ; //Eu não quis implementar o "Else"git
    }
}
