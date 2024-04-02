package uy.edu.ucu.model.PO;

import javax.persistence.*;
import java.util.UUID;
import lombok.*;
import uy.edu.ucu.model.objects.ColumnName;
import uy.edu.ucu.model.objects.SchemaName;
import uy.edu.ucu.model.objects.TableName;

import java.sql.Timestamp;

@Entity
@Table(name = TableName.RESERVATION, schema = SchemaName.PAYMENTS)
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class ReservationPO {

    @Id
    @Column(name = ColumnName.AGENDA_ID)
    private UUID agendaId;

    @Column(name = ColumnName.DATE)
    private Timestamp date;

    @ManyToOne
    @JoinColumn(name = ColumnName.PAYMENT_METHOD_ID)
    private EnumPaymentMethodPO paymentMethod;


}
