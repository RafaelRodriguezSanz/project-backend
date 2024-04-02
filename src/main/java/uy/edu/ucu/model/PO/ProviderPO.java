package uy.edu.ucu.model.PO;

import javax.persistence.*;

import lombok.*;
import uy.edu.ucu.model.objects.ColumnName;
import uy.edu.ucu.model.objects.SchemaName;
import uy.edu.ucu.model.objects.TableName;

@Entity
@Table(name = TableName.PROVIDER, schema = SchemaName.USERS)
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class ProviderPO {

    @Id
    @Column(name = ColumnName.NAME)
    private String name;

    @Column(name = ColumnName.DESCRIPTION)
    private String description;

    @Column(name = ColumnName.QUALIFICATION)
    private int qualification;

    @OneToOne
    @JoinColumn(name = ColumnName.PROFILE_IMAGE_ID)
    private ImagePO profileImage;


}
