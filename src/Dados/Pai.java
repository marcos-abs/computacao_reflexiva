package atividade.Dados;

public class Pai extends Pessoa {
    private Boolean Reservista;

    public Pai() {}

    public Pai(String nome, String cpf, String sexo, String email, String telefone, Boolean reservista) {
        super(nome, cpf, sexo, email, telefone);
        this.Reservista = reservista;
    }

    public Boolean getReservista() {
        return Reservista;
    }

    public void setReservista(Boolean Reservista) {
        this.Reservista = Reservista;
    }

    @Override
    public String getTipoVoz() {
        return "Grave";
    }
}
