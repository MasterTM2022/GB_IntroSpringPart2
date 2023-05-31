package ru.gb.perov.IntroSpringPart2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.perov.IntroSpringPart2.Data.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername (String username);
}