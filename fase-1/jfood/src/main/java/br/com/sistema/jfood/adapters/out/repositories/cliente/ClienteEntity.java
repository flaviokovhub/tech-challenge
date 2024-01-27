package br.com.sistema.jfood.adapters.out.repositories.cliente;

import br.com.sistema.jfood.core.domain.cliente.Cliente;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.data.domain.Persistable;


@Entity
@Table(name = "clientes")
public class ClienteEntity implements Persistable<String> {

    @Id private String cpf;
    private String nome;

    private String email;

    public ClienteEntity(){}

    public ClienteEntity(String cpf, String nome, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    public Cliente toCliente() {
        return new Cliente(cpf,nome,email);
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public boolean isNew() {
        return true;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}
