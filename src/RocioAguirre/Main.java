package RocioAguirre;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    Scanner entrada = new Scanner(System.in);
    int menu;
    String f1, f2, f3;
    boolean continue_software = true;
    AddressBook contact = new AddressBook();

    public void Menu() throws IOException{

        do{
            System.out.println("\t ¡Bienvenid@ a la agenda de contactos!" +
                    "\n Selecciona la opción de tu preferencia:"+"\n 1- Lista de contactos"+
                    "\n 2- Crear contacto"+ "\n 3- Eliminar contacto");
            System.out.print("Digite la opción: ");
            menu = entrada.nextInt();
            switch (menu){
                case 1:
                    System.out.println("Contactos: ");
                    contact.list();
                    break;

                case 2:
                    System.out.println("Digite el número del contacto: ");
                    f1= entrada.next();
                    System.out.println("Digite el nombre del contacto: ");
                    f2= entrada.next();
                    contact.Create(f1,f2);
                    contact.load();
                    contact.save();
                    break;

                case 3:
                    System.out.println("Digite el numero del contacto a eliminar: ");
                    f3=entrada.next();
                    contact.delete(f3);
                    contact.save();
                    contact.load();
                    break;

                default:
                    System.out.println("Opción no valida");
                    continue_software = false;
                    break;

            }

        }while (continue_software);

    }
    public static void main(String[] args) throws IOException {
        Main d1 = new Main();
        d1.Menu();
    }
}

