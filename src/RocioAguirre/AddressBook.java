package RocioAguirre;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddressBook {
    HashMap<String, String> agenda = new HashMap<>();
    public void Create(String telefono, String nombre){

        if(!agenda.containsKey(telefono)){
            agenda.put(telefono, nombre);
            System.out.println("Se ha añadido el contacto");
        }
        else{
            System.out.println("Ya existe el contacto");
        }
    }

    public void list(){
        if(agenda.entrySet().isEmpty()){
            System.out.println("No hay contactos");
        }else{
            for (Map.Entry<String, String> entry: agenda.entrySet()){
                System.out.println("\nTelefono: "+entry.getKey()+"      Nombre: "+entry.getValue());
            }
        }
    }

    public void delete(String telefono){
        if(agenda.containsKey(telefono)){
            agenda.remove(telefono);
        }

    }

    public void load() throws IOException {
        List fileLines = new ArrayList();

        String separator = FileSystems.getDefault().getSeparator();
        String filename = String.format(
                "src%sRocioAguirre%sagenda.csv",
                separator, separator
        );

        Path path = Paths.get(filename);
        fileLines = Files.readAllLines(path, Charset.defaultCharset());
        for (var li:fileLines) {
              var cont = li.toString().split(",");
              agenda.put(cont[0],cont[1]);
        }
        
    }

    public void save(){
         String separator = FileSystems.getDefault().getSeparator();
         String filename = String.format(
                 "src%sRocioAguirre%sagenda.csv",
                 separator, separator
         );

         Path path = Paths.get(filename);

        try (
                BufferedWriter writer = Files.newBufferedWriter(path, Charset.defaultCharset())
             ) {
                 String line = null;
            for (var ag:agenda.entrySet()) {
               line = ag.getKey() + "," + ag.getValue();
               writer.write(line + System.lineSeparator());
            }
        }catch(Exception e){
            

        }
    }
}