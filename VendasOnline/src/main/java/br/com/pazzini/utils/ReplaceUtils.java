/**
 * A classe ReplaceUtils fornece uma funcionalidade para substituir padrões em uma string.
 * 
 * Métodos:
 * - replace(String value, String ...patterns): Substitui todas as ocorrências dos padrões especificados na string de entrada.
 */

package br.com.pazzini.utils;

public class ReplaceUtils {

    /**
     * Substitui todas as ocorrências dos padrões especificados na string de entrada.
     * 
     * @param value String de entrada onde ocorrerão as substituições.
     * @param patterns Array de strings representando os padrões a serem substituídos.
     * @return String resultante após a substituição.
     */
    public static String replace(String value, String ...patterns) {
        String retorno = value;
        for (String pattern : patterns) {
            retorno = retorno.replace(pattern, "");
        }
        return retorno;
    }
}
