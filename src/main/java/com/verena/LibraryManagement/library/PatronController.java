package com.verena.LibraryManagement.library;

import com.verena.LibraryManagement.patron.Patron;
import com.verena.LibraryManagement.patron.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/library/patron")
public class PatronController {
    private final PatronService patronService;

    @Autowired
    public PatronController(PatronService patronService) {
        this.patronService = patronService;
    }

    @GetMapping
    public List<Patron> getPatrons(){
        return patronService.getPatrons();
    }

    @GetMapping(path = "{patronId}")
    public Optional<Patron> getBookById(@PathVariable("patronId") Long patronId){
        return patronService.getPatronById(patronId);
    }

    @PostMapping
    public ResponseEntity<String> addNewPatron(@RequestBody Patron patron){
        patronService.addNewPatron(patron);
        return ResponseEntity.status(HttpStatus.CREATED).body("Patron with id "+ patron.getPatronid() + " and name " + patron.getName() + " is a new member of the Library");
    }

    @DeleteMapping(path = "{patronId}")
    public ResponseEntity<String> deleteBook(@PathVariable("patronId") Long patronId){

        patronService.deletePatron(patronId);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patron with id "+ patronId +" is no longer a member of the Library");
    }

    @PutMapping(path = "{patronId}")
    public ResponseEntity<String> updatePatron(
            @PathVariable("patronId") Long patronId,
            @RequestParam(required = false) String name
    ){

        patronService.updatePatron(patronId,name);
        return ResponseEntity.status(HttpStatus.FOUND).body("Patron with id "+ patronId +" was updated to "+name );
    }

}
