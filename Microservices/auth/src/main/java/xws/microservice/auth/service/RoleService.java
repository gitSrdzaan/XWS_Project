package xws.microservice.auth.service;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xws.microservice.auth.dto.RoleDTO;
import xws.microservice.auth.exceptions.ConversionFailedError;
import xws.microservice.auth.model.Role;
import xws.microservice.auth.repository.RoleRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    DozerBeanMapper mapper;

    public RoleDTO convertToDTO(Role role) throws ConversionFailedError {
        try {
            return mapper.map(role, RoleDTO.class);
        } catch (Exception e) {
            throw new ConversionFailedError("Internal server error");
        }
    }

    public Role convertToModel(RoleDTO roleDTO) throws ConversionFailedError {
        try {
            return mapper.map(roleDTO, Role.class);
        } catch (Exception e) {
            throw new ConversionFailedError("Internal server error");
        }
    }

    public List<RoleDTO> getAll() throws ConversionFailedError {

        List<Role> roles = roleRepository.findAll();

        List<RoleDTO> rolesDTO = new ArrayList<RoleDTO>();

        for (Role role : roles) {
            rolesDTO.add(convertToDTO(role));
        }

        return rolesDTO;
    }
}
