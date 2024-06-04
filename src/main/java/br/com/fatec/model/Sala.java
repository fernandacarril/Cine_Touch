/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.model;

/**
 *
 * @author Fernanda
 */
public class Sala {
    private int numeroSala;
    private int tipoSala;
    private int capacidade;
    private Poltrona poltronas;
    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.numeroSala;
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
        final Sala other = (Sala) obj;
        return this.numeroSala == other.numeroSala;
    }
    
    public Sala() {
    }
    
    
    public Sala(int numeroSala, int tipoSala, int capacidade, Poltrona poltronas) {
        this.numeroSala = numeroSala;
        this.tipoSala = tipoSala;
        this.capacidade = capacidade;
        this.poltronas = poltronas;
    }
    
    
    public int getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }

    public int getTipoSala() {
        return tipoSala;
    }

    public void setTipoSala(int tipoSala) {
        this.tipoSala = tipoSala;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public Poltrona getPoltronas() {
        return poltronas;
    }

    public void setPoltronas(Poltrona poltronas) {
        this.poltronas = poltronas;
    }
    
    
}
