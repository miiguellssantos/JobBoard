package br.ifsp.dsw3.model.domain;

public class Vaga {
    //atributos
    int id;
    String titulo;
    String descricao;
    String localizacao;
    double salario;

    //construtor

    public Vaga(){
        this.id = -1;
        this.titulo = "";
        this.descricao = "";
        this.localizacao = "";
        this.salario = 0;
    }

    public Vaga(int id, String titulo, String descricao, String localizacao, double salario) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.localizacao = localizacao;
        this.salario = salario;
    }

    //métodos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Vaga [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", localizacao=" + localizacao
                + ", salario=" + salario + "]";
    }

    
}
