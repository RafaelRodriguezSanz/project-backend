package uy.edu.ucu.model.PO;

import javax.persistence.*;
import java.util.UUID;
import lombok.*;
import uy.edu.ucu.model.objects.ColumnName;
import uy.edu.ucu.model.objects.SchemaName;
import uy.edu.ucu.model.objects.TableName;

@Entity
@Table(name = TableName.IMAGE, schema = SchemaName.USERS)
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class ImagePO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = ColumnName.ID)
    private UUID id;

    @Column(name = ColumnName.DATA, columnDefinition = "BYTEA")
    private byte[] data;


}
