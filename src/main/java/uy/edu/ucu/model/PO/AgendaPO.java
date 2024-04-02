package uy.edu.ucu.model.PO;

import javax.persistence.*;
import java.util.UUID;
import lombok.*;
import uy.edu.ucu.model.objects.ColumnName;
import uy.edu.ucu.model.objects.SchemaName;
import uy.edu.ucu.model.objects.TableName;

import java.sql.Timestamp;

@Entity
@Table(name = TableName.AGENDA, schema = SchemaName.SALABLES)
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class AgendaPO {

    @Id
    @GeneratedValue
    @Column(name = ColumnName.ID)
    private UUID id;

    @Column(name = ColumnName.DATE)
    private Timestamp date;

    @Column(name = ColumnName.UNIT_COST)
    private long unitCost;

    @ManyToOne
    @JoinColumn(name = ColumnName.CURRENCY)
    private EnumCurrencyPO currency;

    @ManyToOne
    @JoinColumn(name = ColumnName.EVENT_NAME)
    private EventPO event;

    @ManyToOne
    @JoinColumn(name = ColumnName.PROVIDER_NAME)
    private ProviderPO provider;

    @Column(name = ColumnName.VARIATION, columnDefinition = "VARCHAR(255)")
    private String variation;


}
