package tn.univ.usermicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.univ.usermicroservice.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
