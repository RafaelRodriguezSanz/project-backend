package uy.edu.ucu.model.DAO;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uy.edu.ucu.repository.DO.AgendaDiscountDO;
import uy.edu.ucu.model.PO.AgendaDiscountPO;
import java.util.UUID;

@Component
@Data
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class AgendaDiscountDAO extends DAO<AgendaDiscountDO, AgendaDiscountPO, UUID> {


}
