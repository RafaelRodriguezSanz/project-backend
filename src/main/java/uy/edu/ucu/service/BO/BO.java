package uy.edu.ucu.service.BO;

import com.fasterxml.jackson.databind.ObjectMapper;

public interface BO<DO extends uy.edu.ucu.repository.DO.DO, DTO> {
    default DTO toDTO(Object source, Class<DTO> dtoType) {
        return new ObjectMapper().convertValue(source, dtoType);
    }

    default DO toDO(Object source, Class<DO> doType) {
        return new ObjectMapper().convertValue(source, doType);
    }
}