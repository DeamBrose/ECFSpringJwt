package company.aex.SpringSecurity.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer n_cuenta;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private String dni;

}
