package uy.edu.ucu.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import uy.edu.ucu.repository.DO.AgendaDO;
import uy.edu.ucu.repository.DO.AgendaDiscountDO;
import uy.edu.ucu.repository.DO.DiscountDO;
import uy.edu.ucu.service.BO.AgendaDiscountBO;

import java.util.UUID;

@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class AgendaDiscountDTO implements DTO<AgendaDiscountBO> {
    private UUID id;
    private AgendaDO agenda;
    private DiscountDO discount;

    public AgendaDiscountBO convertToBO() {
        return toBO(this, AgendaDiscountBO.class);
    }

}
