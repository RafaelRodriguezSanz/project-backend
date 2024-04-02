package uy.edu.ucu.model.PO;

import javax.persistence.*;

import lombok.*;
import uy.edu.ucu.model.objects.ColumnName;
import uy.edu.ucu.model.objects.SchemaName;
import uy.edu.ucu.model.objects.TableName;

@Entity
@Table(name = TableName.PRODUCT, schema = SchemaName.SALABLES)
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class ProductPO {

    @Id
    @Column(name = ColumnName.NAME)
    private String name;

    @ManyToOne
    @JoinColumn(name = ColumnName.PROVIDER_NAME)
    private ProviderPO provider;

    @Column(name = ColumnName.DESCRIPTION)
    private String description;

    @Column(name = ColumnName.UNIT_COST)
    private long unitCost;

    @ManyToOne
    @JoinColumn(name = ColumnName.CURRENCY)
    private EnumCurrencyPO currency;

    @Column(name = ColumnName.VARIATION, columnDefinition = "VARCHAR(255)")
    private String variation;

    @OneToOne
    @JoinColumn(name = ColumnName.IMAGE_ID)
    private ImagePO image;


}
