/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author elian_estrada
 */
public enum TipoUsuario {
    ADMINISTRADOR(1),
    CLIENTE(2);
    
    private int valor;

    private TipoUsuario(int valor) {
        this.valor = valor;
    }
    
    public int getValor() {
        return this.valor;
    }
}
