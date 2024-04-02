package uy.edu.ucu.repository.DO;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.UUIDDeserializer;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@Data
@NoArgsConstructor
public class AgendaDiscountDO extends DO {
    private UUID id;
    private AgendaDO agenda;
    private DiscountDO discount;
}


