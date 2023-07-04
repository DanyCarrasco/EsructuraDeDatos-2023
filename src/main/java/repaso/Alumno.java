/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repaso;

/**
 *
 * @author danyc
 */
public class Alumno {
    
    private String legajo;
    private String nombre;
    private String apellido;
    private int DNI;
    private String tipoDNI;
    private Domicilio domicilio;
    private String nombreUsuario;
    private String claveSIU;

    public Alumno(String legajo, String nombre, String apellido, int DNI, String tipoDNI, Domicilio domicilio, String nombreUsuario, String claveSIU) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.tipoDNI = tipoDNI;
        this.domicilio = domicilio;
        this.nombreUsuario = nombreUsuario;
        this.claveSIU = claveSIU;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getApellido() {
        return apellido;
    }
    
    public int getDNI() {
        return DNI;
    }
    
    public String getTipoDNI() {
        return tipoDNI;
    }
    
    public Domicilio getDomicilio() {
        return domicilio;
    }
    
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    
    public String getClaveSIU() {
        return claveSIU;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public void setTipoDNI(String tipoDNI) {
        this.tipoDNI = tipoDNI;
    }
    
    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }
    
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
    public void setClaveSIU(String claveSIU) {
        this.claveSIU = claveSIU;
    }
    
    public boolean confirmarLegajo(String legajo) {
        return this.legajo.equals(legajo);
    }
    
    public boolean confirmarClaveSIU(String clave) {
        return this.claveSIU.equals(clave);
    }
    
    public String toString(){
        return "Legajo: "+ this.legajo.toString()+", nombre: "+ this.nombre+", apellido: "
                +this.apellido+", DNI: "+ this.DNI+ ", tipo de DNI: "+ this.tipoDNI+
                " domicilio: "+ this.domicilio.toString()+", nombre de usuario en SIU: "+ this.nombreUsuario+" ";
    }
}
