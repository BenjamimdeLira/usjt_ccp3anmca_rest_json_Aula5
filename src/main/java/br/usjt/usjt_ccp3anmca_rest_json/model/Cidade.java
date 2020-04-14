package br.usjt.usjt_ccp3anmca_rest_json.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cidade implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private int latitude;
	private int longitude;
	
	public Long getId() {
		return id;
		}
	
	public String getNome() {
		return nome;
		}
	
	public int getLatitude() {
		return latitude;
		}

	public int getLongitude() {
		return longitude;
		}
	
	public void setId(Long id) {
		this.id = id;
		}
	
	public void setNome(String nome) {
		this.nome = nome;
		}
	
	public void setLatitude(int latitude) {
		this.latitude = latitude;
		}
	
	public void setLongitude(int longitude) {
		this.longitude = longitude;
		}

}
