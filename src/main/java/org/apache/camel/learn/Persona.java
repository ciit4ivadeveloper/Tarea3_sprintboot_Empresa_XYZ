package org.apache.camel.learn;

public class Persona {

    private int codigo;
    private String identificacion;
    private String nombres;
    private String apellidos;
    private String telefonos;
    private String direccion;
    private int perfilCompra;  //Presencial 1, // 2 online
    private double valorCompra;

    public Persona() {
    }

    public Persona(int codigo, String identificacion, String nombres, String apellidos, String telefonos,
            String direccion, int perfilCompra, double valorCompra) {
        this.codigo = codigo;
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefonos = telefonos;
        this.direccion = direccion;
        this.perfilCompra = perfilCompra;
        this.valorCompra = valorCompra;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(String telefonos) {
        this.telefonos = telefonos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getPerfilCompra() {
        return perfilCompra;
    }

    public void setPerfilCompra(int perfilCompra) {
        this.perfilCompra = perfilCompra;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    @Override
    public String toString() {
        return "Persona [codigo=" + codigo + ", identificacion=" + identificacion + ", nombres=" + nombres
                + ", apellidos=" + apellidos + ", telefonos=" + telefonos + ", direccion=" + direccion
                + ", perfilCompra=" + perfilCompra + ", valorCompra=" + valorCompra + "]";
    }    
}
