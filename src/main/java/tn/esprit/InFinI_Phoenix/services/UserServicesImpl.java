package tn.esprit.InFinI_Phoenix.services;

import ch.qos.logback.core.net.SyslogOutputStream;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import tn.esprit.InFinI_Phoenix.entities.User;
import tn.esprit.InFinI_Phoenix.repositories.UserRepository;

import java.util.List;

@Service

public class UserServicesImpl implements IUserServices {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long idUser, User user) throws Exception , ChangeSetPersister.NotFoundException {
      if (userRepository.findById(idUser)==null){
          throw new Exception("user not found with id : "+idUser);
      }


       return userRepository.findById(idUser).map(utilisateur -> {

           utilisateur.setFirstName(user.getFirstName());
           utilisateur.setLastName(user.getLastName());
           utilisateur.setAddress(user.getAddress());
           utilisateur.setEmail(user.getEmail());
           utilisateur.setPassword(user.getPassword());
           utilisateur.setNumTel(user.getNumTel());
           utilisateur.setTypeRole(user.getTypeRole());
           return userRepository.save(utilisateur);
       }).orElseThrow(()->new ChangeSetPersister.NotFoundException());
    }

    @Override
    public User retrieveUser(Long idUser) throws Exception {
        if (userRepository.findById(idUser)==null){
            throw new Exception("user not found with id : "+idUser);
        }

        User user=userRepository.findById(idUser).get();
        return user;
    }

    @Override
    public String removeUser(Long idUser) throws Exception {
        if (userRepository.findById(idUser)==null){
            throw new Exception("user not found with id : "+idUser);
        }

        User user=userRepository.findById(idUser).get();
        userRepository.delete(user);
        return "user is deleted";

    }
}
