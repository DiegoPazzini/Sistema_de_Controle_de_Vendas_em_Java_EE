/**
 * Classe que representa a entidade Cliente no contexto do domínio da aplicação.
 * A anotação @Entity indica que a classe é uma entidade JPA, mapeada para a tabela "TB_CLIENTE".
 * Implementa a interface Persistente para fornecer um identificador único.
 * 
 * @see Persistente
 * @see Entity
 * @see Table
 * @see Id
 * @see GeneratedValue
 * @see SequenceGenerator
 * @see Column
 * @author diego.pazzini
 */
package br.com.pazzini.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CLIENTE")
public class Cliente implements Persistente {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cliente_seq")
    @SequenceGenerator(name="cliente_seq", sequenceName="sq_cliente", initialValue = 1, allocationSize = 1)
    private Long id;
    
    @Column(name = "NOME", nullable = false, length = 50)
    private String nome;
    
    @Column(name = "CPF", nullable = false, unique = true)
    private Long cpf;
    
    @Column(name = "TEL", nullable = false)
    private Long tel;
    
    @Column(name = "EMAIL", nullable = false, length = 50)
    private String email;
    
    @Column(name = "ENDERECO", nullable = false, length = 100)
    private String end;
    
    @Column(name = "NUMERO", nullable = false)
    private Integer numero;
    
    @Column(name = "CIDADE", nullable = false, length = 100)
    private String cidade;
    
    @Column(name = "ESTADO", nullable = false, length = 50)
    private String estado;
    
    /**
     * Obtém o nome do cliente.
     *
     * @return Nome do cliente.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do cliente.
     *
     * @param nome Novo nome do cliente.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o CPF do cliente.
     *
     * @return CPF do cliente.
     */
    public Long getCpf() {
        return cpf;
    }

    /**
     * Define o CPF do cliente.
     *
     * @param cpf Novo CPF do cliente.
     */
    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    /**
     * Obtém o telefone do cliente.
     *
     * @return Telefone do cliente.
     */
    public Long getTel() {
        return tel;
    }

    /**
     * Define o telefone do cliente.
     *
     * @param tel Novo telefone do cliente.
     */
    public void setTel(Long tel) {
        this.tel = tel;
    }

    /**
     * Obtém o endereço do cliente.
     *
     * @return Endereço do cliente.
     */
    public String getEnd() {
        return end;
    }

    /**
     * Define o endereço do cliente.
     *
     * @param end Novo endereço do cliente.
     */
    public void setEnd(String end) {
        this.end = end;
    }

    /**
     * Obtém o número do endereço do cliente.
     *
     * @return Número do endereço do cliente.
     */
    public Integer getNumero() {
        return numero;
    }

    /**
     * Define o número do endereço do cliente.
     *
     * @param numero Novo número do endereço do cliente.
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    /**
     * Obtém a cidade do cliente.
     *
     * @return Cidade do cliente.
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * Define a cidade do cliente.
     *
     * @param cidade Nova cidade do cliente.
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * Obtém o estado do cliente.
     *
     * @return Estado do cliente.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Define o estado do cliente.
     *
     * @param estado Novo estado do cliente.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtém o ID único do cliente.
     *
     * @return ID único do cliente.
     */
    public Long getId() {
        return id;
    }

    /**
     * Define o ID único do cliente.
     *
     * @param id Novo ID único do cliente.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtém o email do cliente.
     *
     * @return Email do cliente.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o email do cliente.
     *
     * @param email Novo email do cliente.
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
