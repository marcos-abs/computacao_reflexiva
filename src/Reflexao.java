package atividade;

import atividade.Dados.Pessoa;

import javax.swing.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Reflexao {

    public static void introspectarClasse(String classDescription) {
        String saida = "";

        try {
            Class<?> cls = Class.forName(classDescription);
            saida = coletarMetaClasse(cls) + "\n\nA classe " + cls.getSimpleName() +
                    ((Pessoa.class.isAssignableFrom(cls)) ? " pertence a classe Pessoa.\n" : " não pertence a classe Pessoa.\n");
        } catch(ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao introspectar dados da classe: " +  e);
            System.exit(1);
        }
        exibirClasse(saida);
    }

    public static void exibirClasse(String message) {
        try {
            JTextArea textArea = new JTextArea(message, 30, 60);
            textArea.setEditable(false);
            textArea.setWrapStyleWord(true);

            JScrollPane jsp = new JScrollPane(textArea);
            jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
            jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

            JOptionPane.showMessageDialog(null, jsp);
        } catch (Throwable e) {
            JOptionPane.showMessageDialog(null, e);
            System.exit(1);
        }
    }

    private static String coletarMetaClasse(Class<?> cls) {
        return coletarMetaHeranca(cls, new StringBuilder()).toString();
    }

    private static StringBuilder coletarMetaHeranca(Class<?> cls, StringBuilder texto) {
        Class<?> superclasse = cls.getSuperclass();
        StringBuilder saida = texto.append("\nNome da Classe: ")
                .append(cls.getSimpleName())
                .append(coletarMetaComponentes(cls));
        if (superclasse != Object.class) {
            return coletarMetaHeranca(superclasse, saida);
        }
        return saida;
    }

    private static String coletarMetaComponentes(Class<?> cls) {
        String saida = "";
        saida += mostraMetodos(cls.getDeclaredMethods());
        saida += mostraCampos(cls.getDeclaredFields());
        return saida;
    }

    private static String mostraMetodos(Method[] metodos) {
        StringBuilder saida = new StringBuilder();
        if (metodos.length > 0) {
            Arrays.stream(metodos).forEach(m -> {
                saida.append(
                        String.format("""
                                        
                                        Nome do método: %s\
                                        
                                        Nome do pacote completo: %s\
                                        
                                        Modificadores: %s\
                                        
                                        Tipo do retorno: %s\
                                        
                                        Número de parâmetros: %s\
                                        
                                        """,
                                m.getName(),
                                m,
                                Modifier.toString(m.getModifiers()),
                                m.getReturnType(),
                                m.getParameterCount()));

                if (m.getParameterCount() > 0) {
                    saida.append("Lista de parâmetros:\n");
                    Arrays.stream(m.getParameterTypes()).forEach(p ->
                            saida.append(p.getName()).append("\n"));
                } else {
                    saida.append("Não há parâmetros nesse método\n");
                }
                saida.append("\n\n");
            });
        } else {
            saida.append("\nNão há métodos nesta classe\n");
        }
        return saida.toString();
    }

    private static String mostraCampos(Field[] campos) {
        StringBuilder saida = new StringBuilder();
        if (campos.length > 0) {
            Arrays.stream(campos).forEach(f -> saida.append(
                    String.format("""
                                    
                                    Nome do atributo: %s\
                                    
                                    Nome do pacote completo: %s\
                                    
                                    Modificadores: %s\
                                    
                                    Tipo: %s\
                                    
                                    """,
                            f.getName(),
                            f,
                            Modifier.toString(f.getModifiers()),
                            f.getType().getSimpleName())));

        } else {
            saida.append("\nNão há atributos\n");
        }
        return saida.toString();
    }
}
