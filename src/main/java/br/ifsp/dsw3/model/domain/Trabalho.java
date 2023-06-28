package br.ifsp.dsw3.model.domain;

import java.sql.Date;

public class Trabalho {
    //atributos
    int id;
    Vaga vaga;
    Candidato candidato;
    Date dataInicio;
    
    //construtores
    public Trabalho() {
        this.id = -1;
        this.vaga = null;
        this.candidato = null;
    }
    
    public Trabalho(int id, Vaga vaga, Candidato candidato, Date dataInicio) {
        this.id = id;
        this.vaga = vaga;
        this.candidato = candidato;
        this.dataInicio = dataInicio;
    }

    //métodos 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    @Override
    public String toString() {
        return "Trabalho [id=" + id + ", vaga=" + vaga + ", candidato=" + candidato + ", dataInicio=" + dataInicio
                + "]";
    }
}
