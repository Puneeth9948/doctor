package Hospital.Doctor.repository;

import Hospital.Doctor.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface Repository extends JpaRepository<Doctor, Long> {

}
