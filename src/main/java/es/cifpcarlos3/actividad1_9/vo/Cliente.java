package es.cifpcarlos3.actividad1_9.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tools.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import tools.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    @JacksonXmlProperty(localName = "nombre")
    private String nombre;
    @JacksonXmlProperty(isAttribute = true)
    private Long id;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "sucursal")
    private List<Sucursal> sucursales;
}
