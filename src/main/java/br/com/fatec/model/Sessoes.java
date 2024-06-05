/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.model;

/**
 *
 * @author Fernanda
 */
public class Sessoes {
    private int idSessao;
    private Filme filme;
    private Sala sala;
    private String dataI, dataF;
    private String horario;

    
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idSessao;
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
        final Sessoes other = (Sessoes) obj;
        return this.idSessao == other.idSessao;
    }

    
    public Sessoes(Filme filme) {
        this.filme = filme;
    }
    
    public Sessoes(int idSessao, Filme filme, Sala sala, String dataI, String dataF, String horario) {
        this.idSessao = idSessao;
        this.filme = filme;
        this.sala = sala;
        this.dataI = dataI;
        this.dataF = dataF;
        this.horario = horario;
    }

    public int getIdSessao() {
        return idSessao;
    }

    public void setIdSessao(int idSessao) {
        this.idSessao = idSessao;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public String getDataI() {
        return dataI;
    }

    public void setDataI(String dataI) {
        this.dataI = dataI;
    }

    public String getDataF() {
        return dataF;
    }

    public void setDataF(String dataF) {
        this.dataF = dataF;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
    
}