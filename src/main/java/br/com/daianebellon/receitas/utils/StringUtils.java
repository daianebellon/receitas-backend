package br.com.daianebellon.receitas.utils;

public class StringUtils {

    public static boolean isNotBlank(String nome) {
        return nome != null && !nome.isBlank();
    }

    public static boolean isBlank(String nome) {
        return !isNotBlank(nome);
    }
}
