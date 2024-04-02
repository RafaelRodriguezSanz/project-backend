package uy.edu.ucu.model.PO;

import javax.persistence.*;
import lombok.*;
import uy.edu.ucu.model.objects.ColumnName;
import uy.edu.ucu.model.objects.SchemaName;
import uy.edu.ucu.model.objects.TableName;

import java.util.UUID;

@Entity
@Table(name = TableName.PRODUCT_DISCOUNT, schema = SchemaName.DISCOUNTS)
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class ProductDiscountPO {

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
    @JoinColumn(name = ColumnName.DISCOUNT_ID)
    private DiscountPO discount;


}
