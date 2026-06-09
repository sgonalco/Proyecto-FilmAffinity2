package es.uah.serverFilmAffinity2.controller;

import es.uah.serverFilmAffinity2.service.DirectorService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import es.uah.serverFilmAffinity2.model.Director;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/directores")
public class DirectorController {

    @Autowired
    private DirectorService directorService;

    @GetMapping // find all directores
    public ResponseEntity<?> getAll() {
        try{
            List<Director> directors = directorService.findAll();
            if(directors.isEmpty()) {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("El actor no existe en la base de datos");
            }
            return  ResponseEntity.ok(directors);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error ocurred" + e.getMessage());
        }
    }

    @GetMapping("/nombres/{nombre}")
    public ResponseEntity<?> getByName(@PathVariable String nombre) {
        try{
            Director director = directorService.findByNombre(nombre);
            if(director == null) {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("Director does not exist");
            }
            return  ResponseEntity.ok(director);
        }catch(Exception e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error ocurred" + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        try{
            Director director = directorService.findById(id);
            if(director == null) {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("Director does not exist");
            }
            return  ResponseEntity.ok(director);
        }catch(Exception e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error ocurred" + e.getMessage());
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<?> createDirector(@Valid @RequestBody Director director) {
        try{
            if(director == null) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body("Director data cannot be empty");
            }
            Director newDirector = directorService.save(director);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(newDirector);
        }catch(Exception e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error ocurred" + e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateDirector(@PathVariable Integer id, @Valid @RequestBody Director director) {
        try {
            Director updatedDirector = directorService.updateDirector(id, director);
            if(updatedDirector == null) {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("Director does not exist");
            }
            return ResponseEntity.ok(updatedDirector);
        }catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDirector(@PathVariable Integer id) {
        try{
            boolean deletedDirector = directorService.deleteById(id);
            if(!deletedDirector) {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("Director does not exist");
            }
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .body("Director has been deleted");
        }catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred: " + e.getMessage());
        }
    }
}

