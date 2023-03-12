package io.github.rafaelrlc.vendasdata.domain.repository;

import io.github.rafaelrlc.vendasdata.domain.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ClientesRepository {

    private static String INSERT = "INSERT INTO CLIENTE (nome) VALUES (?) ";
    private static String SELECT_ALL = "SELECT * FROM CLIENTE ";
    private static String UPDATE = "UPDATE CLIENTE SET NOME = ? WHERE ID = ? ";
    private static String DELETE = "DELETE FROM CLIENTE WHERE ID = ? ";


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void Clientes(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public Cliente saveClient(Cliente cliente){
        jdbcTemplate.update( INSERT, cliente.getNome());
        return cliente;
    }

    public Cliente updateClient(Cliente cliente){
        jdbcTemplate.update( UPDATE, cliente.getNome(), cliente.getId());
        return cliente;
    }


    public void deleteById(Integer id){
        jdbcTemplate.update(DELETE, id);
    }

    public void deleteClient(Cliente cliente){
        deleteById(cliente.getId());
    }

    public List<Cliente> searchByName(String nome){
        return jdbcTemplate.query(
                SELECT_ALL.concat(" where nome like ? "),
                new Object[]{"%" + nome + "%"},
                getRowMapper());
    }

    public List<Cliente> getAll() {
        return jdbcTemplate.query(SELECT_ALL, getRowMapper());
    }

    private static RowMapper<Cliente> getRowMapper() {
        return new RowMapper<Cliente>() {
            @Override
            public Cliente mapRow(ResultSet resultSet, int i) throws SQLException {
                Integer id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                return new Cliente(id, nome);
            }
        };
    }

}
