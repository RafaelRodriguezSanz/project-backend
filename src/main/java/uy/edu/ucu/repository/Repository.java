package uy.edu.ucu.repository;

import org.apache.commons.lang3.reflect.TypeUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

@org.springframework.stereotype.Repository
@SuperBuilder(toBuilder = true)
@AllArgsConstructor(onConstructor_={@Autowired})
@Getter
public abstract class Repository<
        DAO extends uy.edu.ucu.model.DAO.DAO<DO, PO, ID>,
        DTO extends uy.edu.ucu.dto.DTO,
        BO extends uy.edu.ucu.service.BO.BO<DO, DTO>,
        PO,
        DO extends uy.edu.ucu.repository.DO.DO,
        ID extends Serializable> implements IRepository<DAO, DTO, BO, PO, DO, ID> {

    private final Class<DO> doClass;
    private final Class<BO> boClass;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private DAO dao;

    @Override
    public BO create(final BO entity) {
        dao.create(entity.toDO(entity, getDOType()));
        return entity;
    }

    @Override
    @SuppressWarnings("unchecked")
    public BO read(final ID id) {
        return objectMapper.convertValue(dao.read(id), getBOType());
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<BO> read() {
        return objectMapper.convertValue(dao.read(), getBOListType());
    }

    @Override
    public BO update(final BO entity) {
        dao.update(objectMapper.convertValue(entity, getDOType()));
        return entity;
    }

    @Override
    public BO delete(final BO entity) {
        dao.delete(objectMapper.convertValue(entity, getDOType()));
        return entity;
    }


    @SuppressWarnings("unchecked")
    public Class<DO> getDOType() {
        ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
        Type[] types = parameterizedType.getActualTypeArguments();
        return (Class<DO>) types[4];
    }

    @SuppressWarnings("unchecked")
    public Class<BO> getBOType() {
        ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
        Type[] types = parameterizedType.getActualTypeArguments();
        return (Class<BO>) types[2];
    }

    @SuppressWarnings("unchecked")
    public Class<List<BO>> getBOListType() {
        Class<BO> boClass = getBOType();
        return (Class<List<BO>>) TypeUtils.parameterize(List.class, boClass).getRawType();
    }

}
