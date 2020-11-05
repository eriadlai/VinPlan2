package com.narval.repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.narval.Models.Usuario;

@Repository
public class UserRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public Optional<Usuario> findByEmail(String email) {
		String query = "SELECT * FROM Usuarios WHERE email = ?";
				
		return jdbcTemplate.queryForObject(query, new Object[]{email},
				(rs, rowNum) -> {
                	Usuario Usuario = new Usuario();
                	Usuario.setId(rs.getInt("id"));
					Usuario.setEmail(rs.getString("email"));
					Usuario.setName(rs.getString("name"));
					Usuario.setHashed_password(rs.getString("password"));
					//Rol y activo
					
                	return Optional.of(Usuario);
				}
        );
	}
	

	public List<Usuario> findAll() {
		
		List<Usuario> Usuarios = new ArrayList<Usuario>();
						
		String query = "SELECT u.id, u.email, u.name, u.active, u.role, u.winery_id FROM Usuarios u";
		
		jdbcTemplate.query(query, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				Usuario Usuario = new Usuario();
				Usuario.setId(rs.getInt("id"));
				Usuario.setEmail(rs.getString("email"));
				Usuario.setName(rs.getString("name"));
				//Usuario.setRole(rs.getString("role"));
				//Usuario.setActive(rs.getBoolean("active"));
						
		        Usuarios.add(Usuario);
			}
		});
		
		
		return Usuarios;
	}
	
	
	
	
    public int save(Usuario Usuario) {
    	
    	String query = "INSERT INTO Usuarios (email, name, role, active) VALUES (?,?,?,?)";
    	
        return jdbcTemplate.update(query, Usuario.getEmail(), Usuario.getName());
    }
    
}
