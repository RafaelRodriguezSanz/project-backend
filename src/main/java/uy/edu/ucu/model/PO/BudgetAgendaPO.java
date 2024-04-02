package uy.edu.ucu.model.PO;

import javax.persistence.*;
import java.util.UUID;
import lombok.*;
import uy.edu.ucu.model.objects.ColumnName;
import uy.edu.ucu.model.objects.SchemaName;
import uy.edu.ucu.model.objects.TableName;

@Entity
@Table(name = TableName.BUDGET_AGENDA, schema = SchemaName.BUDGETS)
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class BudgetAgendaPO {

    @Id
    @GeneratedValue
    @Column(name = ColumnName.ID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = ColumnName.AGENDA_ID)
    private AgendaPO agenda;

    @ManyToOne
    @JoinColumn(name = ColumnName.BUDGET_ID)
    private BudgetPO budget;

}
