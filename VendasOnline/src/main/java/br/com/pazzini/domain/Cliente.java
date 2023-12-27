/**
 * A classe Cliente representa a entidade de Cliente no sistema.
 * 
 * Anotações:
 * - @Entity: Indica que a classe é uma entidade JPA e será mapeada para uma tabela no banco de dados.
 * - @Table: Especifica o nome da tabela no banco de dados.
 * - @NamedQuery: Define uma consulta nomeada que pode ser usada para recuperar clientes por nome.
 * - @Id: Indica que o atributo é a chave primária da entidade.
 * - @GeneratedValue: Especifica a estratégia de geração de valores para a chave primária.
 * - @SequenceGenerator: Define um gerador de sequência para a estratégia de geração.
 * - @Column: Especifica detalhes da coluna no banco de dados.
 * 
 * Atributos:
 * - id: Identificador único do cliente (chave primária).
 * - nome: Nome do cliente.
 * - cpf: Número de CPF do cliente (único).
 * - tel: Número de telefone do cliente.
 * - email: Endereço de e-mail do cliente.
 * - end: Endereço do cliente.
 * - numero: Número do endereço do cliente.
 * - cidade: Cidade do endereço do cliente.
 * - estado: Estado do endereço do cliente.
 * 
 * Getters e Setters: Métodos para acessar e modificar os atributos da classe.
 */
package br.com.pazzini.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CLIENTE")
@NamedQuery(name = "Cliente.findByNome", query = "SELECT c FROM Cliente c WHERE c.nome LIKE :nome")
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
    
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Long getCpf() {
		return cpf;
	}
	
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	
	public Long getTel() {
		return tel;
	}
	
	public void setTel(Long tel) {
		this.tel = tel;
	}
	
	public String getEnd() {
		return end;
	}
	
	public void setEnd(String end) {
		this.end = end;
	}
	
	public Integer getNumero() {
		return numero;
	}
	
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}
