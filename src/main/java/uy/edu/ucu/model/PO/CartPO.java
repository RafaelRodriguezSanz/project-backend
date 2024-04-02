package uy.edu.ucu.model.PO;

import javax.persistence.*;
import java.util.List;
import lombok.*;
import uy.edu.ucu.model.objects.ColumnName;
import uy.edu.ucu.model.objects.SchemaName;
import uy.edu.ucu.model.objects.TableName;

@Entity
@Table(name = TableName.CART, schema = SchemaName.USERS)
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class CartPO {

    @Id
    @Column(name = ColumnName.BUYER_USER_NAME)
    private String buyerUserName;

    @OneToMany(mappedBy = "buyerUser")
    private List<CartItemPO> cartItems;

}
