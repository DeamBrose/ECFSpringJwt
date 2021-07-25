package company.aex.SpringSecurity.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class Retiros implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Date fecha;

    @Column
    private Integer monto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente")
    private Cliente cliente;
}
