package uy.edu.ucu.dto;

import com.fasterxml.jackson.databind.ObjectMapper;

public interface DTO<BO> {
    default BO toBO(Object source, Class<BO> boType) {
        return new ObjectMapper().convertValue(source, boType);
    }

}
