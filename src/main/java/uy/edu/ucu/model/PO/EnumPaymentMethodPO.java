package uy.edu.ucu.model.PO;

import javax.persistence.*;
import lombok.*;
import uy.edu.ucu.model.objects.ColumnName;
import uy.edu.ucu.model.objects.SchemaName;
import uy.edu.ucu.model.objects.TableName;

@Entity
@Table(name = TableName.ENUM_PAYMENT_METHOD, schema = SchemaName.PAYMENTS)
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class EnumPaymentMethodPO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = ColumnName.ID)
    private int id;

    @Column(name = ColumnName.PAYMENT_METHOD_TYPE)
    private String paymentMethodType;


}
