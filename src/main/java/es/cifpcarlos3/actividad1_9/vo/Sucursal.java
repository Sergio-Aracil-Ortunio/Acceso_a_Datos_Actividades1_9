package es.cifpcarlos3.actividad1_9.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sucursal {
    private String calle;
    private String ciudad;
    private String provincia;
    private Long cp;
}
