package uy.edu.ucu.service;

import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uy.edu.ucu.dto.AgendaDiscountDTO;
import uy.edu.ucu.model.DAO.AgendaDiscountDAO;
import uy.edu.ucu.model.PO.AgendaDiscountPO;
import uy.edu.ucu.repository.AgendaDiscountRepository;
import uy.edu.ucu.repository.DO.AgendaDiscountDO;
import uy.edu.ucu.service.BO.AgendaDiscountBO;

import java.util.UUID;

@Service
@SuperBuilder(toBuilder = true)
public class AgendaDiscountService {

    @Autowired
    private final AgendaDiscountRepository agendaDiscountRepository;

    public AgendaDiscountBO getAgendaDiscount(final UUID id){
        return agendaDiscountRepository.read(id);
    }

    public AgendaDiscountBO createAgendaDiscount(final AgendaDiscountDTO agendaDiscountDTO){
        return agendaDiscountRepository.create(agendaDiscountDTO.convertToBO());
    }

}