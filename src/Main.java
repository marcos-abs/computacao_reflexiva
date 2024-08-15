package atividade;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Reflexao.introspectarClasse(JOptionPane.showInputDialog(
                "Complete o nome da classe:",
                "atividade.Dados."
        ));
    }
}
