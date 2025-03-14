package ru.kachalov.springweb.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.kachalov.springweb.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
