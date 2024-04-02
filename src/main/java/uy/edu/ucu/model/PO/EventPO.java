package uy.edu.ucu.model.PO;

import javax.persistence.*;

import lombok.*;
import uy.edu.ucu.model.objects.ColumnName;
import uy.edu.ucu.model.objects.SchemaName;
import uy.edu.ucu.model.objects.TableName;

@Entity
@Table(name = TableName.EVENT, schema = SchemaName.SALABLES)
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class EventPO {

    @Id
    @Column(name = ColumnName.NAME)
    private String name;

    @ManyToOne
    @JoinColumn(name = ColumnName.PROVIDER_NAME)
    private ProviderPO provider;

    @Column(name = ColumnName.DESCRIPTION)
    private String description;


}
