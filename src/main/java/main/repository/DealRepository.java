package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import main.model.Deal;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins = "http://localhost:4200")

public interface DealRepository extends JpaRepository<Deal, Long> {
}
