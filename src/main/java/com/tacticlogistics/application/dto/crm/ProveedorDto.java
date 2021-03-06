package com.tacticlogistics.application.dto.crm;

public class ProveedorDto {
	private final Integer id;
	private String codigo;
	private String texto;
	private boolean activo;

	public ProveedorDto(Integer id, String codigo, String texto, boolean activo) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.texto = texto;
		this.activo = activo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Integer getId() {
		return id;
	}

	
	
}
