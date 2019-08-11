package com.monje;

public class Turista {
    public String nombre;
    public String telefono;
    public int contadorVisitas =0;

    //setter modifican y getters muestran

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws Exception {
        if(nombre.length()>50){
            throw new Exception("Sobrepaso el limite de 50 caracteres");
        }
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) throws Exception {
        if (!telefono.matches("^[0-9]{4}(\\-)[0-9]{4}")){
            throw new Exception("El numero de telefono es invalido");
        }
        this.telefono = telefono;
    }

    public int getContadorVisitas() {
        return contadorVisitas;
    }

    public void setContadorVisitas(int contadorVisitas) {

        this.contadorVisitas = contadorVisitas + this.contadorVisitas;
    }
}
