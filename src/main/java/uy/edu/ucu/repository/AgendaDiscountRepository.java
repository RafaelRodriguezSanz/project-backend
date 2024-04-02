package uy.edu.ucu.repository;

import lombok.*;
import lombok.experimental.SuperBuilder;
import uy.edu.ucu.dto.AgendaDiscountDTO;
import uy.edu.ucu.model.DAO.AgendaDiscountDAO;
import uy.edu.ucu.model.PO.AgendaDiscountPO;
import uy.edu.ucu.repository.DO.AgendaDiscountDO;
import uy.edu.ucu.service.BO.AgendaDiscountBO;

import java.util.UUID;

@org.springframework.stereotype.Repository
@Data
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class AgendaDiscountRepository extends Repository<
        AgendaDiscountDAO,
        AgendaDiscountDTO,
        AgendaDiscountBO,
        AgendaDiscountPO,
        AgendaDiscountDO,
        UUID> {

}
