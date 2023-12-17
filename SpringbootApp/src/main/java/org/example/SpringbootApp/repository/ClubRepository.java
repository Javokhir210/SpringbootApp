package org.example.SpringbootApp.repository;
import org.example.SpringbootApp.models.Clubs;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClubRepository extends JpaRepository <Clubs, Long>{
    Optional<Clubs> findByTitle(String url);
}
