package uy.edu.ucu.model.PO;

import javax.persistence.*;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.UUIDDeserializer;
import com.fasterxml.jackson.databind.ser.std.UUIDSerializer;
import lombok.*;
import uy.edu.ucu.model.objects.ColumnName;
import uy.edu.ucu.model.objects.SchemaName;
import uy.edu.ucu.model.objects.TableName;

import java.util.UUID;

@Entity
@Table(name = TableName.AGENDA_DISCOUNT, schema = SchemaName.DISCOUNTS)
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class AgendaDiscountPO extends PO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = ColumnName.ID)
    private UUID id;

    //@ManyToOne
    //@JoinColumn(name = ColumnName.AGENDA_DISCOUNT_ID)
    //private AgendaPO agenda;

    //@ManyToOne
    //@JoinColumn(name = ColumnName.DISCOUNT_ID)
    //private DiscountPO discount;


}
