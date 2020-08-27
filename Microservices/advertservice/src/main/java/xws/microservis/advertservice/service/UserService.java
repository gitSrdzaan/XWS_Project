package xws.microservis.advertservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xws.microservis.advertservice.model.User;
import xws.microservis.advertservice.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User findUser(Long id) {

        return repository.findById(id).orElse(null);
    }
}
