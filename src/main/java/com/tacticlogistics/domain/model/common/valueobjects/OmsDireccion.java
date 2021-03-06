package com.tacticlogistics.domain.model.common.valueobjects;

import static com.tacticlogistics.infrastructure.services.Basic.coalesce;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import com.tacticlogistics.common.ddd.AssertionConcern;

@Embeddable
public class OmsDireccion extends AssertionConcern {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 1L;

    @Column(name = "id_ciudad")
    private Integer ciudadId;

    @Column(nullable = false, length = 150)
    @NotNull
    private String direccion;

    @Column(nullable = false, length = 150)
    @NotNull
    private String indicacionesDireccion;

    @Column(nullable = false, length = 150)
    private String direccionEstandarizada;

    @Column(nullable = true, precision = 18, scale = 15)
    private BigDecimal longitud;

    @Column(nullable = true, precision = 18, scale = 15)
    private BigDecimal latitud;

    // ---------------------------------------------------------------------------------------------------------
    public OmsDireccion() {
        this(null, "", "");
    }

    public OmsDireccion(final Integer ciudadId, final String direccion, final String indicacionesDireccion) {
        super();
        this.setCiudadId(ciudadId);
        this.setDireccion(direccion);
        this.setIndicacionesDireccion(indicacionesDireccion);
        this.setDireccionEstandarizada("");
        this.setLongitud(null);
        this.setLatitud(null);
    }

    public OmsDireccion(OmsDireccion model) {
        super();
        this.assertArgumentNotNull(model, "model no puede ser null");
        this.setCiudadId(model.getCiudadId());
        this.setDireccion(model.getDireccion());
        this.setIndicacionesDireccion(model.getIndicacionesDireccion());
        this.setDireccionEstandarizada(model.getDireccionEstandarizada());
        this.setLongitud(model.getLongitud());
        this.setLatitud(model.getLatitud());
    }

    // ---------------------------------------------------------------------------------------------------------
    public Integer getCiudadId() {
        return ciudadId;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getIndicacionesDireccion() {
        return indicacionesDireccion;
    }

    public String getDireccionEstandarizada() {
        return direccionEstandarizada;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public BigDecimal getLatitud() {
        return latitud;
    }

    // ---------------------------------------------------------------------------------------------------------
    protected void setCiudadId(final Integer value) {
        this.ciudadId = value;
    }

    protected void setDireccion(String value) {
        this.direccion = coalesce(value, "");
    }

    protected void setIndicacionesDireccion(String value) {
        this.indicacionesDireccion = coalesce(value, "");;
    }

    protected void setDireccionEstandarizada(String value) {
        this.direccionEstandarizada = coalesce(value, "");;
    }

    protected void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }

    protected void setLatitud(BigDecimal latitud) {
        this.latitud = latitud;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ciudadId == null) ? 0 : ciudadId.hashCode());
        result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
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
        OmsDireccion other = (OmsDireccion) obj;
        if (ciudadId == null) {
            if (other.ciudadId != null)
                return false;
        } else if (!ciudadId.equals(other.ciudadId))
            return false;
        if (direccion == null) {
            if (other.direccion != null)
                return false;
        } else if (!direccion.equals(other.direccion))
            return false;
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Direccion [");
        if (ciudadId != null) {
            builder.append("ciudadId=").append(ciudadId).append(", ");
        }
        if (direccion != null) {
            builder.append("direccion=").append(direccion).append(", ");
        }
        if (indicacionesDireccion != null) {
            builder.append("indicacionesDireccion=").append(indicacionesDireccion);
        }
        builder.append("]");
        return builder.toString();
    }
}
