package xws.microservice.auth.service;


import xws.microservice.auth.dto.UserDTO;
import xws.microservice.auth.dto.UserPageDTO;
import xws.microservice.auth.model.User;
import xws.microservice.auth.exceptions.*;

import java.io.IOException;

public interface UserService {

    UserDTO convertToDTO(User user) throws ConversionFailedError;

    User convertToModel(UserDTO userDTO) throws ConversionFailedError;

    UserDTO add(UserDTO userDTO) throws DuplicateEntity, InvalidEmailOrPasswordError, ConversionFailedError, IOException;

    UserDTO getOne(Long id) throws EntityNotFound, ConversionFailedError;

    UserPageDTO getAll(Integer pageNo, String sortKey) throws ConversionFailedError;

    UserDTO update(Long id, UserDTO userDTO) throws EntityNotFound, ConversionFailedError, IOException;

    UserDTO activateOrDeactivate(Long id) throws EntityNotFound, ConversionFailedError, IOException;

    UserDTO delete(Long id) throws EntityNotFound, ConversionFailedError, IOException;

    UserDTO createAgent(UserDTO agent) throws DuplicateEntity, ConversionFailedError, IOException;
}
