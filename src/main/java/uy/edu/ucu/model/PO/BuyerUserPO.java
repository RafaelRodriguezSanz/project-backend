package uy.edu.ucu.model.PO;

import javax.persistence.*;

import lombok.*;
import uy.edu.ucu.model.objects.ColumnName;
import uy.edu.ucu.model.objects.SchemaName;
import uy.edu.ucu.model.objects.TableName;

@Entity
@Table(name = TableName.BUYER_USER, schema = SchemaName.USERS)
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class BuyerUserPO {

    @Id
    @Column(name = ColumnName.NAME)
    private String name;

    @Column(name = ColumnName.QUALIFICATION)
    private int qualification;

    @OneToOne
    @JoinColumn(name = ColumnName.PROFILE_IMAGE_ID)
    private ImagePO profileImage;


}
