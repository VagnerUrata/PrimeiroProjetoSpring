package br.com.primeiroprojetospring.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Entity
@Data
public class Role implements GrantedAuthority {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 5421731248947217000L;
	
	public static final String ROLE_ADMIN = "ROLE_ADMIN";
	public static final String ROLE_USER = "ROLE_USER";
	
	@Id 
	private String nomeRole;
	
	@ManyToMany(mappedBy = "roles")
	private List<Usuario>usuarios; 
	
	@Override
	public String getAuthority() {
		return this.nomeRole;
	}

	public String getNomePermissao() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
