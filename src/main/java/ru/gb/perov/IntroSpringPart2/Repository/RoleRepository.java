package ru.gb.perov.IntroSpringPart2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.perov.IntroSpringPart2.Data.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

        Optional<Role> findByName (String name);
}
