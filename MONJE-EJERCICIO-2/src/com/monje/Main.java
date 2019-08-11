package com.monje;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Turista> Turistas = new ArrayList();

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        double numero;
        while (true) {
            System.out.println("******************************");
            System.out.println("****Bienvenido al sistema****");
            System.out.println("1. Registrar visita");
            System.out.println("2. Mostrar visitas");
            System.out.println("3. Salir");
            int opcion = LectorDatos.solicitarEntero("Elija su opcion: ");

            switch (opcion) {
                case 1:
                    String nombre = LectorDatos.solicitarString("Ingrese su nombre: ");
                    String telefono = LectorDatos.solicitarString("Ingrese su numero telefonico: ");
                    int visita = 1;

                    Turista nuevoTurista = new Turista();
                    try {
                        nuevoTurista.setNombre(nombre);
                        nuevoTurista.setTelefono(telefono);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    nuevoTurista.setContadorVisitas(visita);

                    int indice = -1;
                    int contador = 0;
                    if (!Turistas.isEmpty())
                    {
                        for (Turista c : Turistas) {
                            if (c.getTelefono().equals(telefono)) {
                                System.out.println("Registro del numero telefonico ya existe");
                                indice = contador;
                            }
                            contador++;
                        }
                    }

                    if (indice != -1)
                    {
                        Turistas.get(indice).setContadorVisitas(visita);
                    } else {
                        if (nuevoTurista.getTelefono() != null && nuevoTurista.getNombre() != null) {
                            Turistas.add(nuevoTurista);
                            System.out.println("Registro ingresado correctamente");
                        }
                    }
                    break;
                case 2:
                    if (Turistas.isEmpty()) {
                        System.out.println("Registro vacio");
                    } else {
                        System.out.println("Mostrando los registros:");

                        for (Turista c : Turistas) {
                            System.out.println("Nombre: " + c.getNombre());
                            System.out.println("Telefono: " + c.getTelefono());
                            System.out.println("Visitas: " + c.getContadorVisitas());
                        }
                    }
                    break;
                case 3:
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
            if (opcion == 3) {
                break;
            }
        }
    }
}