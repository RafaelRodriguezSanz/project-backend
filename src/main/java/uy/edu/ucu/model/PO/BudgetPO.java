package uy.edu.ucu.model.PO;

import javax.persistence.*;
import java.util.UUID;
import lombok.*;
import uy.edu.ucu.model.objects.ColumnName;
import uy.edu.ucu.model.objects.SchemaName;
import uy.edu.ucu.model.objects.TableName;

import java.sql.Timestamp;

@Entity
@Table(name = TableName.BUDGET, schema = SchemaName.BUDGETS)
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class BudgetPO {

    @Id
    @GeneratedValue
    @Column(name = ColumnName.ID)
    private UUID id;

    @Column(name = ColumnName.CREATION_DATE)
    private Timestamp creationDate;

    @ManyToOne
    @JoinColumn(name = ColumnName.PROVIDER_NAME)
    private ProviderPO provider;

    @ManyToOne
    @JoinColumn(name = ColumnName.BUYER_USER_NAME)
    private BuyerUserPO buyerUser;

    @ManyToOne
    @JoinColumn(name = ColumnName.DISCOUNT_ID)
    private DiscountPO discount;


}
