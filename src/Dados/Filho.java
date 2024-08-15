package atividade.Dados;

public class Filho extends Pessoa {
    private Boolean alfabetizado;

    public Filho() {}

    public Filho(String nome, String cpf, String sexo, String email, String telefone, Boolean alfabetizado) {
        super(nome, cpf, sexo, email, telefone);
        this.alfabetizado = alfabetizado;
    }

    public Boolean getAlfabetizado() {
        return alfabetizado;
    }

    public void setAlfabetizado(Boolean Alfabetizado) {
        this.alfabetizado = Alfabetizado;
    }

    public Filho(Boolean alfabetizado) {
        this.alfabetizado = alfabetizado;
    }

    @Override
    public String getTipoVoz() {
        return "Infantil";
    }
}
