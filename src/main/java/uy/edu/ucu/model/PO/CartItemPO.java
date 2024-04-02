package uy.edu.ucu.model.PO;

import javax.persistence.*;
import lombok.*;
import uy.edu.ucu.model.objects.ColumnName;
import uy.edu.ucu.model.objects.SchemaName;
import uy.edu.ucu.model.objects.TableName;

@Entity
@Table(name = TableName.CART_ITEM, schema = SchemaName.USERS)
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class CartItemPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ColumnName.ID)
    private Long id;

    @ManyToOne
    @JoinColumn(name = ColumnName.USER_BUYER_NAME)
    private BuyerUserPO buyerUser;

    @ManyToOne
    @JoinColumn(name = ColumnName.PROVIDER_NAME)
    private ProviderPO provider;

    @ManyToOne
    @JoinColumn(name = ColumnName.AGENDA_ID)
    private AgendaPO agenda;

    @ManyToOne
    @JoinColumn(name = ColumnName.SERVICE_NAME)
    private ServicePO service;

    @ManyToOne
    @JoinColumn(name = ColumnName.PRODUCT_NAME)
    private ProductPO product;

}
