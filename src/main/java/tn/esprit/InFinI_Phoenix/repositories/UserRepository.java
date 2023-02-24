package tn.esprit.InFinI_Phoenix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.InFinI_Phoenix.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}