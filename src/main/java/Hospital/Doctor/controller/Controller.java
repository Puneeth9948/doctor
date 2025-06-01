package Hospital.Doctor.controller;

import Hospital.Doctor.entity.Doctor;
import Hospital.Doctor.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
@CrossOrigin(origins = "*")
public class Controller {
    @Autowired
    private Repository repository;

    @GetMapping("/all")
    public List<Doctor> getAll() { return repository.findAll(); }
    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping("/add")
    public Doctor create(@RequestBody Doctor doctor) { return repository.save(doctor); }
    @PutMapping("/{id}")
    public ResponseEntity<Doctor> update(@PathVariable Long id, @RequestBody Doctor doctor) {
        return repository.findById(id).map(d -> {
            d.setName(doctor.getName());
            d.setSpecialty(doctor.getSpecialty());
            d.setAvailabilityStatus(doctor.getAvailabilityStatus());
            return ResponseEntity.ok(repository.save(d));
        }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) { repository.deleteById(id); }
}
