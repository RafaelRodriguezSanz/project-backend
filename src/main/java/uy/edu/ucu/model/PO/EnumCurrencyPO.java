package uy.edu.ucu.model.PO;

import javax.persistence.*;
import lombok.*;
import uy.edu.ucu.model.objects.ColumnName;
import uy.edu.ucu.model.objects.SchemaName;
import uy.edu.ucu.model.objects.TableName;

@Entity
@Table(name = TableName.ENUM_CURRENCY, schema = SchemaName.DISCOUNTS)
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class EnumCurrencyPO {

    @Id
    @Column(name = ColumnName.CURRENCY)
    private String currency;

    @Column(name = ColumnName.SYMBOL)
    private String symbol;


}
