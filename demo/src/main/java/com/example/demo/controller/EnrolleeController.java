package com.example.demo.controller;

import com.example.demo.model.Enrollee;
import com.example.demo.repository.EnrolleeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*") // To relax the same origin policy.
@RequestMapping("/api/v1")
public class EnrolleeController {

    @Autowired
    private EnrolleeRepository enrolleeRepository;

    // This request will get the list of all enrollees.
    @GetMapping(path = "/enrollees")
    public List<Enrollee> getAllEnrollees() {
        List<Enrollee> enrollee = new ArrayList<>();

        enrolleeRepository.findAll().forEach(enrollee::add);
        return enrollee;
    }

    // This request will get an enrollee by their id.
    @GetMapping(path = "/enrollees/enrollee/{id}")
    public ResponseEntity<Enrollee> getEnrolleesById(@PathVariable("id") Integer id) {
        Optional<Enrollee> _enrollee = enrolleeRepository.findById(id);

        if(_enrollee.isPresent()) {
            Enrollee enrollee = _enrollee.get();
            return new ResponseEntity<>(enrollee, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // This request will get the list of all enrollees based on status.
    @GetMapping(path = "/enrollees/{status}")
    public List<Enrollee> getAllEnrollees(@PathVariable("status") boolean status) {
        List<Enrollee> enrollee = new ArrayList<>();

        enrolleeRepository.findByActivation_status(status).forEach(enrollee::add);
        return enrollee;
    }

    // This request will create a new enrollee.
    @PostMapping(path = "/enrollees/create")
    public Enrollee postEnrollee(@RequestBody Enrollee enrollee) {
        Enrollee _enrollee = enrolleeRepository.save(enrollee);
        return _enrollee;
    }

    // This request will update the enrollee activation status.
    @PutMapping(path = "/enrollees/{id}")
    public ResponseEntity<Enrollee> updateEnrolleeActivationStatus(@PathVariable("id") Integer enrolleeID, @RequestBody Enrollee enrollee) {
        Optional<Enrollee> optionalEnrollee = enrolleeRepository.findById(enrolleeID);

        if(optionalEnrollee.isPresent()) {
            Enrollee _enrollee = optionalEnrollee.get();
            _enrollee.setName(enrollee.getName());
            _enrollee.setActivation_status(enrollee.isActivation_status());
            return new ResponseEntity<>(enrolleeRepository.save(_enrollee), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // This request will delete the enrollee if specified the id.
    @DeleteMapping("/enrollees/{id}")
    public ResponseEntity<String> removeEnrollee(@PathVariable("id") Integer id) {
        Optional<Enrollee> OptionalEnrollee = enrolleeRepository.findById(id);

        if(OptionalEnrollee.isPresent()) {
            enrolleeRepository.deleteById(id);

            return new ResponseEntity<>("Enrollee has been removed", HttpStatus.OK);
        }

        return new ResponseEntity<>("Enrollee Id not found", HttpStatus.NOT_FOUND);
    }

    // This request will delete all the enrollees.
    @DeleteMapping("/enrollees/delete")
    public ResponseEntity<String> removeAllEnrollees() {
        enrolleeRepository.deleteAll();
        return new ResponseEntity<>("All Enrollees are removed"
        , HttpStatus.OK);
    }

}
