package com.verena.LibraryManagement.patron;

import com.verena.LibraryManagement.book.Book;
import com.verena.LibraryManagement.book.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PatronService {
    private final PatronRepository patronRepository;

    @Autowired
    public PatronService(PatronRepository patronRepository) {
        this.patronRepository = patronRepository;
    }

    public List<Patron> getPatrons(){
        return patronRepository.findAll();
    }

    public Optional<Patron> getPatronById(Long patronId){
        boolean exists = patronRepository.existsById(patronId);
        if(!exists){
            throw new IllegalStateException("Patron with id " + patronId + " does not exist");
        }
        return patronRepository.findById(patronId);
    }

    public void addNewPatron(Patron patron){
        Optional<Patron> patronOptional = patronRepository.findPatronByName(patron.getName());
        if(patronOptional.isPresent()){
            throw new IllegalStateException("Patron " + patron.getName() + " is already a member of the library");
        }
        patronRepository.save(patron);
    }

    public void deletePatron(Long patronId){
        boolean exists = patronRepository.existsById(patronId);
        if(!exists){
            throw new IllegalStateException("Patron with id " + patronId + " does not exist");
        }
        patronRepository.deleteById(patronId);
    }

    @Transactional
    public void updatePatron(Long patronId,String name){
        Patron patron = patronRepository.findById(patronId).orElseThrow(() -> new IllegalStateException("Patron with id" + patronId + "does not exist"));
        if(name != null && !name.isEmpty() && !Objects.equals(patron.getName(),name)){
            patron.setName(name);
        }
        patronRepository.save(patron);
    }
}
