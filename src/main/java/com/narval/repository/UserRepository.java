package com.narval.repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.narval.Models.Usuario;



@Repository
public class UserRepository {
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Usuario> findAll() {

        List<Usuario> users = new ArrayList<Usuario>();

        String query = "SELECT u.id, u.email, u.name, u.active, u.role, u.winery_id FROM usuario u";

        jdbcTemplate.query(query, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                Usuario user = new Usuario();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setName(rs.getString("name"));
                user.setHashed_password(rs.getString("hashed_password"));
                users.add(user);
            }
        });


        return users;
    }
	public Optional<Usuario> findByEmail(String username) {
        String query = "SELECT * FROM Usuario WHERE email = ?";
        
        System.out.println(username+"hola");
        return jdbcTemplate.queryForObject(query, new Object[]{username},
                (rs, rowNum) -> {
                    Usuario user = new Usuario();
                    user.setId(rs.getInt("id"));
                    user.setEmail(rs.getString("email"));
                    user.setName(rs.getString("name"));
                    user.setHashed_password(rs.getString("hashed_password"));
                    
                    System.out.println(rs.getInt("id"));
                    System.out.println(rs.getString("email"));
                    System.out.println(rs.getString("name"));
                    System.out.println(rs.getString("hashed_password"));

                    
                    return Optional.of(user);
                }
        );
    }
	
	
	public int save(Usuario user){
		String query="insert into usuario (username, name, lastname, hashed_password, email) values (?,?,?,?,?)";
		
		return jdbcTemplate.update(query,user.getUsername(),user.getName(),user.getLastname(),user.getHashed_password(),user.getEmail());
	}
    

}

