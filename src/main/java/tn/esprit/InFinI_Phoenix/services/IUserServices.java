package tn.esprit.InFinI_Phoenix.services;

import tn.esprit.InFinI_Phoenix.entities.User;

import java.util.List;

public interface IUserServices {
    List<User> retrieveAllUsers();
    User addUser(User user);
    User updateUser (Long idUser, User user) throws Exception;
    User retrieveUser(Long idUser) throws Exception;
    String removeUser(Long idUser) throws Exception;
}
