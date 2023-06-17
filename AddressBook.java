package trabajo1;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class AddressBook {

    private HashMap<String, String> contactos = new HashMap<>();

    public void create(String numero, String nombre) {

        contactos.put(numero, nombre);

        System.out.println("Contacto creado");

    }

    public void load() {

        try {

            FileReader archivo = new FileReader("contactos.csv");

            BufferedReader lectura = new BufferedReader(archivo);

            String cadena = "";

            while((cadena = lectura.readLine()) != null) {

                String[] contacto = cadena.split(" ");

                contactos.put(contacto[0], contacto[1]);

            }

        } catch (IOException e) {

            System.out.println("Error al leer el archivo");


        }


    }

    public void save() {

        if(! contactos.isEmpty()) {

            try {

                FileWriter archivo = new FileWriter("contactos.txt", true);

                BufferedWriter escritura = new BufferedWriter(archivo);

                Iterator iterator = contactos.keySet().iterator();

                while (iterator.hasNext()) {

                    String key = (String) iterator.next();

                    escritura.write(key + " " + contactos.get(key));

                }

            } catch (IOException e) {

                System.out.println("Error al guardar los contactos");

            }

        }

    }

    public void delete(String numero) {

        if(contactos.isEmpty()) {

            System.out.println("No hay contactos creados");

        } else {

            if(contactos.containsKey(numero)) {

                contactos.remove(numero);

                System.out.println("Contacto eliminado");

            } else {

                System.out.println("No se encontro la clave " + numero);

            }

        }

    }

    public void list() {

        if(contactos.isEmpty()) {

            System.out.println("No hay contactos creados");

        } else {

            Iterator iterator = contactos.keySet().iterator();

            System.out.println("Contactos: \n\n");

            while (iterator.hasNext()) {

                String key = (String) iterator.next();

                System.out.println("{" + key + "} : {" + contactos.get(key) + "}");

            }

        }

    }


}
