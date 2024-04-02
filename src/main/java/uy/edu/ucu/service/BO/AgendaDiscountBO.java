package uy.edu.ucu.service.BO;

import com.fasterxml.jackson.core.type.TypeReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import uy.edu.ucu.dto.AgendaDiscountDTO;
import uy.edu.ucu.repository.DO.AgendaDiscountDO;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder(toBuilder = true)
@AllArgsConstructor
public class AgendaDiscountBO extends AgendaDiscountDO implements BO<AgendaDiscountDO, AgendaDiscountDTO> {
    public AgendaDiscountDTO convertToDTO() {
        return toDTO(this, AgendaDiscountDTO.class);
    }

    public AgendaDiscountDO convertToDO() {
        return toDO(this, AgendaDiscountDO.class);
    }
}


