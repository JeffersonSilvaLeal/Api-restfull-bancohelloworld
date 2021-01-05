package br.com.bancohelloworld.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

@Entity // Identifica a classe como modelo e transforma em uma tabela
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id // Gera a Primary Key
	@GeneratedValue(strategy = GenerationType.AUTO) // Gera sequência automatica
	private Long id;

	@NotNull(message = "Nome não pode ser nulo")
	@NotEmpty(message = "Nome não pode ser vazio")
	private String nome;

	@NotNull(message = "Email não pode ser nulo")
	@NotEmpty(message = "Email não pode ser vazio")
	@Email(message = ("Email inválido"))
	@Column(unique = true, nullable = false) // Garante que não irá ter duplicidade de email
	private String email;
	
	
	@NotNull(message = "Cpf não pode ser nulo!")
	@NotEmpty(message = "Cpf não pode ser vazio!")
	@Column(unique = true, nullable = false) // Garante que não irá ter duplicidade de cpf
	private String cpf;

	@DateTimeFormat(pattern = "yyyy/MM/dd") // Data como padrão brasileiro
	private LocalDate dataNascimento;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		if (cpf != null && cpf.length() == 0) {
			this.cpf = null;
		} else {
			this.cpf = cpf;
		}
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
