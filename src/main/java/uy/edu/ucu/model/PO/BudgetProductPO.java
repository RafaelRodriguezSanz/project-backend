package uy.edu.ucu.model.PO;

import javax.persistence.*;
import lombok.*;
import uy.edu.ucu.model.objects.ColumnName;
import uy.edu.ucu.model.objects.SchemaName;
import uy.edu.ucu.model.objects.TableName;

import java.util.UUID;

@Entity
@Table(name = TableName.BUDGET_PRODUCT, schema = SchemaName.BUDGETS)
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class BudgetProductPO {

    @Id
    @GeneratedValue
    @Column(name = ColumnName.ID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = ColumnName.PRODUCT_NAME)
    private ProductPO product;

    @ManyToOne
    @JoinColumn(name = ColumnName.PROVIDER_NAME)
    private ProviderPO provider;

    @ManyToOne
    @JoinColumn(name = ColumnName.BUDGET_ID)
    private BudgetPO budget;

    @Column(name = ColumnName.QUANTITY)
    private int quantity;


}
