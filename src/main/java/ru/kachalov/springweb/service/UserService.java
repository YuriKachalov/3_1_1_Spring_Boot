package ru.kachalov.springweb.service;


import ru.kachalov.springweb.model.User;

import java.util.List;

public interface UserService {

    //удаляем user
    void deleteUser(int id);

    //изменять пользователя
    void saveUser(User user);

    List<User> listUsers();

    //получаем доступ по id
    User getUserId(Integer id);
}
