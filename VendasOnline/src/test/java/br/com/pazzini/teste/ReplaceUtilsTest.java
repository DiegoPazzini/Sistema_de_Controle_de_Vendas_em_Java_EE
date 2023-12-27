/**
 * A classe ReplaceUtilsTest contém testes unitários para a classe ReplaceUtils.
 */

package br.com.pazzini.teste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.pazzini.utils.ReplaceUtils;

public class ReplaceUtilsTest {

    /**
     * Testa a substituição de caracteres em um CPF.
     */
    @Test
    public void replaceCPF() {
        String cpf = "222.222.222-22";
        String newCpf = ReplaceUtils.replace(cpf, ".", "-");

        assertEquals(newCpf, "22222222222");
    }

    /**
     * Testa a substituição de caracteres em um número de telefone.
     */
    @Test
    public void replaceTel() {
        String tel = "(11) 99999-0000";
        String newtel = ReplaceUtils.replace(tel, "(", ")", " ", "-");

        assertEquals(newtel, "11999990000");
    }
}
