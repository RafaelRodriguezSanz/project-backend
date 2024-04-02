package uy.edu.ucu.model.PO;

import javax.persistence.*;
import java.util.UUID;
import lombok.*;
import uy.edu.ucu.model.objects.ColumnName;
import uy.edu.ucu.model.objects.SchemaName;
import uy.edu.ucu.model.objects.TableName;

@Entity
@Table(name = TableName.DISCOUNT, schema = SchemaName.DISCOUNTS)
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class DiscountPO {

    @Id
    @GeneratedValue
    @Column(name = ColumnName.ID)
    private UUID id;

    @Column(name = ColumnName.DISCOUNT_AMOUNT)
    private long discountAmount;

    @ManyToOne
    @JoinColumn(name = ColumnName.TYPE_ID)
    private EnumDiscountTypePO discountType;

}
