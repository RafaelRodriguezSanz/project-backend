package uy.edu.ucu.model.DAO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IDAO<
        DO extends uy.edu.ucu.repository.DO.DO,
        PO,
        ID>{
    DO create(DO entity);

    DO read(ID id);

    List<DO> read();

    DO update(DO entity);

    DO delete(DO entity);
}