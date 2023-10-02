package model;

public class Producto {
    
    private int id;
    private String nombre;
    private float precio;
    private int existencia;
    private String descripcion;
    private TipoProducto tipo;

    public Producto(String nombre, float precio, int existencia, String descripcion, TipoProducto tipo) {
        this.nombre = nombre;
        this.precio = precio;
        this.existencia = existencia;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoProducto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProducto tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", existencia=" + existencia + ", descripcion=" + descripcion + ", tipo=" + tipo + '}';
    }
    
    
}
