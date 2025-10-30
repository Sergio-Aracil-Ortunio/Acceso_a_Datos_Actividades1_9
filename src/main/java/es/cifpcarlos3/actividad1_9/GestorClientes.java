package es.cifpcarlos3.actividad1_9;

import es.cifpcarlos3.actividad1_9.vo.Cliente;
import es.cifpcarlos3.actividad1_9.vo.ListaClientes;
import es.cifpcarlos3.actividad1_9.vo.Sucursal;
import tools.jackson.dataformat.xml.XmlMapper;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class GestorClientes {
    public static void main(String[] args) {
        Path base = Path.of("src","main","java","es","cifpcarlos3","actividad1_9");
        Path XML = base.resolve("clientes.xml");
        var xmlMapper = XmlMapper.builder().build();
        try (var br = Files.newBufferedReader(XML, StandardCharsets.UTF_8)) {
            ListaClientes datos = xmlMapper.readValue(br, ListaClientes.class);
            for (Cliente cliente : datos.getCliente()){
                if(cliente.getNombre() == null || cliente.getId() == null){
                    System.err.println("Nombre o Id no válido");
                    System.exit(1);
                }
                if(cliente.getSucursales().isEmpty()){
                    System.err.println("El cliente debe tener al menos una sucursal");
                    System.exit(1);
                }
                System.out.println("Cliente: " + cliente.getNombre() + " (id: " + cliente.getId() + ")\n");
                System.out.println("Sucursales (" + cliente.getSucursales().size() + "):");
                for (Sucursal sucursal: cliente.getSucursales()){
                    if(sucursal.getCalle().isEmpty() || sucursal.getCiudad().isEmpty()){
                        System.out.println("Calle y Ciudad no deben estar vacíos");
                        System.exit(1);
                    }
                    try{
                        int cp = Integer.parseInt(String.valueOf(sucursal.getCp()));
                    }catch (NumberFormatException e){
                        System.out.println("Cp debe ser numérico");
                        System.exit(1);
                    }
                    if(sucursal.getProvincia() == null && sucursal.getCp() == null){
                        System.out.println(sucursal.getCalle() + ", " + sucursal.getCiudad());
                    }else if(sucursal.getProvincia() == null){
                        System.out.println(sucursal.getCalle() + ", " + sucursal.getCiudad() + " - CP " +  sucursal.getCp());
                    }else if(sucursal.getCp() == null){
                        System.out.println(sucursal.getCalle() + ", " + sucursal.getCiudad() + " [" + sucursal.getProvincia());
                    }else{
                        System.out.println(sucursal.getCalle() + ", " + sucursal.getCiudad() + " [" + sucursal.getProvincia() + "] - CP " +  sucursal.getCp());
                    }
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}