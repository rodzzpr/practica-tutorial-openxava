package com.tuempresa.facturacion.modelo;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.util.Collection;
import org.openxava.annotations.*;
import lombok.*;

@Entity @Getter @Setter
public class Autor {

    @Id @GeneratedValue(generator="system-uuid") @Hidden
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(length=32)
    String oid;

    @Column(length=50) @Required
    String nombre;

    @OneToMany(mappedBy="autor")
    @ListProperties("numero, descripcion, precio")
    Collection<Producto> productos;
}