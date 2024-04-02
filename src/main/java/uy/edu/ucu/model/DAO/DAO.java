package uy.edu.ucu.model.DAO;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.SuperBuilder;
import org.apache.commons.lang3.reflect.TypeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import uy.edu.ucu.repository.DO.AgendaDO;
import uy.edu.ucu.repository.DO.AgendaDiscountDO;
import uy.edu.ucu.repository.DO.DO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.UUID;

@Component
@SuperBuilder(toBuilder = true)
@AllArgsConstructor(onConstructor_={@Autowired})
public abstract class DAO<
        DO extends uy.edu.ucu.repository.DO.DO,
        PO,
        ID> implements IDAO<DO, PO, ID> {

    @PersistenceContext
    private final EntityManager entityManager;
    private static final Class<?> entityType;
    @Autowired
    private ObjectMapper objectMapper;

    static {
        entityType = getEntityType();
    }

    private final Class<PO> poClass;
    private final Class<DO> doClass;
    private final Class<List<PO>> poListClass;
    private final Class<List<DO>> doListClass;

    @SneakyThrows
    @Override
    @Transactional
    public DO create(final DO entity) {
        PO poEntity = objectMapper.convertValue(entity, getPOType());
        entityManager.persist(poEntity);
        return entity;
    }

    @Override
    @SuppressWarnings("unchecked")
    public DO read(final ID id) {
        return objectMapper.convertValue((PO) entityManager.find(entityType, id), getDOType());
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<DO> read() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<PO> cq = (CriteriaQuery<PO>) cb.createQuery(entityType);
        Root<PO> rootEntry = (Root<PO>) cq.from(entityType);
        CriteriaQuery<PO> all = cq.select(rootEntry);
        TypedQuery<PO> allQuery = entityManager.createQuery(all);
        return objectMapper.convertValue(allQuery.getResultList(), getDOListType());
    }
    
    @Override
    @Transactional
    public DO update(final DO entity) {
        entityManager.merge(objectMapper.convertValue(entity, getPOType()));
        return entity;
    }

    @Override
    @Transactional
    public DO delete(final DO entity) {
        entityManager.remove(objectMapper.convertValue(entity, getPOType()));
        return entity;
    }

    private static Class<?> getEntityType() {
        return (Class<?>) DAO.class.getTypeParameters()[1].getBounds()[0];
    }



    @SuppressWarnings("unchecked")
    public Class<DO> getDOType() {
        ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
        Type[] types = parameterizedType.getActualTypeArguments();
        return (Class<DO>) types[0];
    }

    @SuppressWarnings("unchecked")
    public Class<PO> getPOType() {
        ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
        Type[] types = parameterizedType.getActualTypeArguments();
        return (Class<PO>) types[1];
    }

    @SuppressWarnings("unchecked")
    public Class<List<PO>> getPOListType() {
        Class<PO> poClass = getPOType();
        return (Class<List<PO>>) TypeUtils.parameterize(List.class, poClass).getRawType();
    }

    @SuppressWarnings("unchecked")
    public Class<List<DO>> getDOListType() {
        Class<DO> doClass = getDOType();
        return (Class<List<DO>>) TypeUtils.parameterize(List.class, doClass).getRawType();
    }
}
