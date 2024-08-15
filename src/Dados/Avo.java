package atividade.Dados;

public class Avo extends Pessoa {
    private Boolean inss;

    public Avo() {}

    public Avo(String nome, String cpf, String sexo, String email, String telefone, Boolean inss) {
        super(nome, cpf, sexo, email, telefone);
        this.inss = inss;
    }

    public Boolean getInss() {
        return inss;
    }

    public void setInss(Boolean Inss) {
        this.inss = Inss;
    }

    @Override
    public String getTipoVoz() {
        return "Rouca";
    }
}
