package uy.edu.ucu.model.PO;

import javax.persistence.*;
import lombok.*;
import uy.edu.ucu.model.objects.ColumnName;
import uy.edu.ucu.model.objects.SchemaName;
import uy.edu.ucu.model.objects.TableName;

@Entity
@Table(name = TableName.ENUM_DISCOUNT_TYPE, schema = SchemaName.DISCOUNTS)
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class EnumDiscountTypePO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = ColumnName.ID)
    private int id;

    @Column(name = ColumnName.DISCOUNT_TYPE)
    private String discountType;


}
