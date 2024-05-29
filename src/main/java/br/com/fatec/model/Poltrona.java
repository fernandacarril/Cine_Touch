/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.model;

import java.util.Objects;

/**
 *
 * @author Fernanda
 */
public class Poltrona {
    private String idPoltrona;
    private Sala sala;
    private boolean acessibilidade;
    private boolean disponibilidade;

    @Override
    public String toString() {
        return getIdPoltrona();
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.idPoltrona);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Poltrona other = (Poltrona) obj;
        return Objects.equals(this.idPoltrona, other.idPoltrona);
    }

    
    public Poltrona(Sala sala) {
        this.sala = sala;
    }

    
    
    public Poltrona(String idPoltrona, Sala sala, boolean acessibilidade, boolean disponibilidade) {
        this.idPoltrona = idPoltrona;
        this.sala = sala;
        this.acessibilidade = acessibilidade;
        this.disponibilidade = disponibilidade;
    }
    
    public String getIdPoltrona() {
        return idPoltrona;
    }

    public void setIdPoltrona(String idPoltrona) {
        this.idPoltrona = idPoltrona;
    }

    public boolean isAcessibilidade() {
        return acessibilidade;
    }

    public void setAcessibilidade(boolean acessibilidade) {
        this.acessibilidade = acessibilidade;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
    
}
