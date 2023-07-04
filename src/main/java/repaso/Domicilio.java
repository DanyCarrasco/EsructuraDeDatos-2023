/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repaso;

/**
 *
 * @author danyc
 */
public class Domicilio {

    private String calle;
    private int numero;
    private String ciudad;

    public Domicilio(String nomCalle, int numCalle, String nomCiudad) {
        calle = nomCalle;
        numero = numCalle;
        ciudad = nomCiudad;
    }

    public String getCalle() {
        return this.calle;
    }

    public int getNumero() {
        return this.numero;
    }

    public String getCiudad() {
        return this.ciudad;
    }

    public void setCalle(String nomCalle) {
        this.calle = nomCalle;
    }

    public void setNumero(int num) {
        this.numero = num;
    }

    public void setCiudad(String nomCiudad) {
        this.ciudad = nomCiudad;
    }
    
    public String toString(){
        return "Calle: "+ this.ciudad+", numero de calle: "+this.numero+", ciudad: "+ this.ciudad;
    }
}
