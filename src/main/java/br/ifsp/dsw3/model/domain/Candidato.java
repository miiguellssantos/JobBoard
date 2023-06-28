package br.ifsp.dsw3.model.domain;

public class Candidato {
    //atributos
    int id;
    String cpf;
    String nome;
    String email;
    String telefone;
    
    //construtores
    public Candidato() {
        this.id = -1;
        this.cpf = "";
        this.nome = "";
        this.email = "";
        this.telefone = "";
    }
    
    public Candidato(int id, String cpf, String nome, String email, String telefone) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    //métodos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCPF() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Candidato [id=" + id + ", cpf=" + cpf + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone
                + "]";
    }
}
