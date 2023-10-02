/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author elian_estrada
 */
public enum TipoProducto {
    COMIDA(1),
    JUGUETES(2),
    MEDICINA(3);
    
    private int valor;
    
    TipoProducto(int valor) {
        this.valor = valor;
    }
    
    public int getValor() {
        return this.valor;
    }
}
