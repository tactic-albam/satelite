package com.tacticlogistics.domain.model.oms;

import static com.tacticlogistics.infrastructure.services.Basic.coalesce;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.tacticlogistics.domain.model.common.TipoContenido;
import com.tacticlogistics.domain.model.common.valueobjects.Dimensiones;
import com.tacticlogistics.domain.model.common.valueobjects.MensajeEmbeddable;
import com.tacticlogistics.domain.model.wms.Bodega;
import com.tacticlogistics.domain.model.wms.Producto;
import com.tacticlogistics.domain.model.wms.Unidad;

@Entity
@Table(name = "LineasOrden", catalog = "oms", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "id_orden", "numeroItem" }) })

public class OmsLineaOrden implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_linea_orden", unique = true, nullable = false)
    private Integer id;

    @Column(name = "id_orden", nullable = false, insertable = true, updatable = false)
    @NotNull
    private Integer ordenId;

    // ---------------------------------------------------------------------------------------------------------
    private int numeroItem;

    @Column(nullable = false, length = 300)
    @NotNull
    private String descripcion;

    private int cantidadSolicitada;
    private int cantidadPlanificada;
    private int cantidadAlistada;
    private int cantidadEntregada;
    private int cantidadNoEntregada;
    private int cantidadNoEntregadaLegalizada;
    private int cantidadSobrante;
    private int cantidadSobranteLegalizada;

    // ---------------------------------------------------------------------------------------------------------
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "id_producto", nullable = true)
    private Producto producto;

    @Column(nullable = false, length = 50)
    @NotNull
    private String productoCodigo;

    @Column(nullable = false, length = 50)
    @NotNull
    private String productoCodigoAlterno;

    // ---------------------------------------------------------------------------------------------------------
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "id_unidad", nullable = true)
    private Unidad unidad;

    @Column(nullable = false, length = 2)
    @NotNull
    private String unidadCodigo;

    @Column(nullable = false, length = 50)
    @NotNull
    private String unidadCodigoAlterno;

    // ---------------------------------------------------------------------------------------------------------
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "id_tipo_contenido", nullable = true)
    private TipoContenido tipoContenido;

    @Column(nullable = false, length = 20)
    @NotNull
    private String tipoContenidoCodigo;

    @Column(nullable = false, length = 50)
    @NotNull
    private String tipoContenidoCodigoAlterno;

    // ---------------------------------------------------------------------------------------------------------
    @Embedded
    private Dimensiones dimensiones;

    // ---------------------------------------------------------------------------------------------------------
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "id_bodega_origen", nullable = true)
    private Bodega bodegaOrigen;

    @Column(nullable = false, length = 32)
    @NotNull
    private String bodegaOrigenCodigo;

    @Column(nullable = false, length = 50)
    @NotNull
    private String bodegaOrigenCodigoAlterno;

    @Column(name = "id_estado_inventario_origen", nullable = false, length = 4)
    @NotNull
    private String estadoInventarioOrigenId;

    @Column(nullable = false, length = 35)
    @NotNull
    private String numeroOrdenWmsOrigen;

    // ---------------------------------------------------------------------------------------------------------
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "id_bodega_destino", nullable = true)
    private Bodega bodegaDestino;

    @Column(nullable = false, length = 32)
    @NotNull
    private String bodegaDestinoCodigo;

    @Column(nullable = false, length = 50)
    @NotNull
    private String bodegaDestinoCodigoAlterno;

    @Column(name = "id_estado_inventario_destino", nullable = false, length = 4)
    @NotNull
    private String estadoInventarioDestinoId;

    @Column(nullable = false, length = 35)
    @NotNull
    private String numeroOrdenWmsDestino;

    // ---------------------------------------------------------------------------------------------------------
    @Column(nullable = false, length = 30)
    @NotNull
    private String lote;

    @Column(nullable = false, length = 30)
    @NotNull
    private String serial;

    @Column(nullable = false, length = 30)
    @NotNull
    private String cosecha;

    // ---------------------------------------------------------------------------------------------------------
    @Column(nullable = false, length = 30)
    @NotNull
    private String requerimientoEstampillado;

    @Column(nullable = false, length = 30)
    @NotNull
    private String requerimientoSalud;

    @Column(nullable = false, length = 30)
    @NotNull
    private String requerimientoImporte;

    @Column(nullable = false, length = 30)
    @NotNull
    private String requerimientoDistribuido;

    @Column(nullable = false, length = 30)
    @NotNull
    private String requerimientoNutricional;

    @Column(nullable = false, length = 30)
    @NotNull
    private String requerimientoBl;

    @Column(nullable = false, length = 30)
    @NotNull
    private String requerimientoFondoCuenta;

    @Column(nullable = false, length = 30)
    @NotNull
    private String requerimientoOrigen;

    // ---------------------------------------------------------------------------------------------------------
    @Column(nullable = false, length = 30)
    @NotNull
    private String numeroOrdenTms;

    @Column(nullable = true, columnDefinition = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaOrdenTms;

    @Column(nullable = false, length = 100)
    @NotNull
    private String predistribucionDestinoFinal;

    @Column(nullable = false, length = 100)
    @NotNull
    private String predistribucionRotulo;

    // ---------------------------------------------------------------------------------------------------------
    @Column(nullable = true)
    private Integer valorDeclaradoPorUnidad;

    @Column(nullable = false, length = 200)
    private String notas;

    // ---------------------------------------------------------------------------------------------------------
    @Column(nullable = false, columnDefinition = "DATETIME2(0)")
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date fechaCreacion;

    @Column(nullable = false, length = 50)
    @NotNull
    private String usuarioCreacion;

    @Column(nullable = false, columnDefinition = "DATETIME2(0)")
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date fechaActualizacion;

    @Column(nullable = false, length = 50)
    @NotNull
    private String usuarioActualizacion;

    // ---------------------------------------------------------------------------------------------------------
    @ElementCollection
    @CollectionTable(name = "lineas_ordenes_mensajes", catalog = "oms", joinColumns = @JoinColumn(name = "id_linea_orden", referencedColumnName = "id_linea_orden"))
    private Set<MensajeEmbeddable> mensajes = new HashSet<MensajeEmbeddable>();

    // ---------------------------------------------------------------------------------------------------------

    public OmsLineaOrden() {
        super();
        this.setId(null);
        this.setOrdenId(null);
        this.setNumeroItem(0);
        this.setDescripcion("");
        this.setCantidadSolicitada(0);
        this.setCantidadPlanificada(0);
        this.setCantidadAlistada(0);
        this.setCantidadEntregada(0);
        this.setCantidadNoEntregada(0);
        this.setCantidadNoEntregadaLegalizada(0);
        this.setCantidadSobrante(0);
        this.setCantidadSobranteLegalizada(0);
        this.setProducto(null);
        this.setProductoCodigo("");
        this.setProductoCodigoAlterno("");
        this.setUnidad(null);
        this.setUnidadCodigo("");
        this.setUnidadCodigoAlterno("");
        this.setTipoContenido(null);
        this.setTipoContenidoCodigo("");
        this.setTipoContenidoCodigoAlterno("");
        this.setDimensiones(null);
        this.setBodegaOrigen(null);
        this.setBodegaOrigenCodigo("");
        this.setBodegaOrigenCodigoAlterno("");
        this.setEstadoInventarioOrigenId("");
        this.setNumeroOrdenWmsOrigen("");
        this.setBodegaDestino(null);
        this.setBodegaDestinoCodigo("");
        this.setBodegaDestinoCodigoAlterno("");
        this.setEstadoInventarioDestinoId("");
        this.setNumeroOrdenWmsDestino("");
        this.setLote("");
        this.setSerial("");
        this.setCosecha("");
        this.setRequerimientoEstampillado("");
        this.setRequerimientoSalud("");
        this.setRequerimientoImporte("");
        this.setRequerimientoDistribuido("");
        this.setRequerimientoNutricional("");
        this.setRequerimientoBl("");
        this.setRequerimientoFondoCuenta("");
        this.setRequerimientoOrigen("");
        this.setNumeroOrdenTms("");
        this.setFechaOrdenTms(null);
        this.setPredistribucionDestinoFinal("");
        this.setPredistribucionRotulo("");
        this.setValorDeclaradoPorUnidad(null);
        this.setNotas("");
        this.setFechaCreacion(null);
        this.setUsuarioCreacion("");
        this.setFechaActualizacion(null);
        this.setUsuarioActualizacion("");

        this.mensajes = new HashSet<>();
    }

    // ---------------------------------------------------------------------------------------------------------
    public Integer getId() {
        return id;
    }

    public Integer getOrdenId() {
        return ordenId;
    }

    public int getNumeroItem() {
        return numeroItem;
    }

    // ---------------------------------------------------------------------------------------------------------
    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidadSolicitada() {
        return cantidadSolicitada;
    }

    public int getCantidadPlanificada() {
        return cantidadPlanificada;
    }

    public int getCantidadAlistada() {
        return cantidadAlistada;
    }

    public int getCantidadEntregada() {
        return cantidadEntregada;
    }

    public int getCantidadNoEntregada() {
        return cantidadNoEntregada;
    }

    public int getCantidadNoEntregadaLegalizada() {
        return cantidadNoEntregadaLegalizada;
    }

    public int getCantidadSobrante() {
        return cantidadSobrante;
    }

    public int getCantidadSobranteLegalizada() {
        return cantidadSobranteLegalizada;
    }

    // ---------------------------------------------------------------------------------------------------------
    public Producto getProducto() {
        return producto;
    }

    public String getProductoCodigo() {
        return productoCodigo;
    }

    public String getProductoCodigoAlterno() {
        return productoCodigoAlterno;
    }

    // ---------------------------------------------------------------------------------------------------------
    public Unidad getUnidad() {
        return unidad;
    }

    public String getUnidadCodigo() {
        return unidadCodigo;
    }

    public String getUnidadCodigoAlterno() {
        return unidadCodigoAlterno;
    }

    // ---------------------------------------------------------------------------------------------------------
    public TipoContenido getTipoContenido() {
        return tipoContenido;
    }

    public String getTipoContenidoCodigo() {
        return tipoContenidoCodigo;
    }

    public String getTipoContenidoCodigoAlterno() {
        return tipoContenidoCodigoAlterno;
    }

    // ---------------------------------------------------------------------------------------------------------
    public BigDecimal getLargoPorUnidad() {
        return getDimensiones().getLargoPorUnidad();
    }

    public BigDecimal getAnchoPorUnidad() {
        return getDimensiones().getAnchoPorUnidad();
    }

    public BigDecimal getAltoPorUnidad() {
        return getDimensiones().getAltoPorUnidad();
    }

    public BigDecimal getPesoBrutoPorUnidad() {
        return getDimensiones().getPesoBrutoPorUnidad();
    }

    public BigDecimal getPesoBrutoVolumetricoPorUnidad() {
        return getDimensiones().getPesoBrutoVolumetricoPorUnidad();
    }

    protected Dimensiones getDimensiones() {
        if (this.dimensiones == null) {
            this.setDimensiones(new Dimensiones());
        }
        return dimensiones;
    }

    // ---------------------------------------------------------------------------------------------------------
    public Bodega getBodegaOrigen() {
        return bodegaOrigen;
    }

    public String getBodegaOrigenCodigo() {
        return bodegaOrigenCodigo;
    }

    public String getBodegaOrigenCodigoAlterno() {
        return bodegaOrigenCodigoAlterno;
    }

    public String getEstadoInventarioOrigenId() {
        return estadoInventarioOrigenId;
    }

    public String getNumeroOrdenWmsOrigen() {
        return numeroOrdenWmsOrigen;
    }

    // ---------------------------------------------------------------------------------------------------------
    public Bodega getBodegaDestino() {
        return bodegaDestino;
    }

    public String getBodegaDestinoCodigo() {
        return bodegaDestinoCodigo;
    }

    public String getBodegaDestinoCodigoAlterno() {
        return bodegaDestinoCodigoAlterno;
    }

    public String getEstadoInventarioDestinoId() {
        return estadoInventarioDestinoId;
    }

    public String getNumeroOrdenWmsDestino() {
        return numeroOrdenWmsDestino;
    }

    // ---------------------------------------------------------------------------------------------------------
    public String getLote() {
        return lote;
    }

    public String getSerial() {
        return serial;
    }

    public String getCosecha() {
        return cosecha;
    }

    // ---------------------------------------------------------------------------------------------------------
    public String getRequerimientoEstampillado() {
        return requerimientoEstampillado;
    }

    public String getRequerimientoSalud() {
        return requerimientoSalud;
    }

    public String getRequerimientoImporte() {
        return requerimientoImporte;
    }

    public String getRequerimientoDistribuido() {
        return requerimientoDistribuido;
    }

    public String getRequerimientoNutricional() {
        return requerimientoNutricional;
    }

    public String getRequerimientoBl() {
        return requerimientoBl;
    }

    public String getRequerimientoFondoCuenta() {
        return requerimientoFondoCuenta;
    }

    public String getRequerimientoOrigen() {
        return requerimientoOrigen;
    }

    // ---------------------------------------------------------------------------------------------------------
    public String getNumeroOrdenTms() {
        return numeroOrdenTms;
    }

    public Date getFechaOrdenTms() {
        return fechaOrdenTms;
    }

    public String getPredistribucionDestinoFinal() {
        return predistribucionDestinoFinal;
    }

    public String getPredistribucionRotulo() {
        return predistribucionRotulo;
    }

    // ---------------------------------------------------------------------------------------------------------
    public Integer getValorDeclaradoPorUnidad() {
        return valorDeclaradoPorUnidad;
    }

    public String getNotas() {
        return notas;
    }

    // ---------------------------------------------------------------------------------------------------------
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public String getUsuarioActualizacion() {
        return usuarioActualizacion;
    }

    public Set<MensajeEmbeddable> getMensajes() {
        return mensajes;
    }

    // ---------------------------------------------------------------------------------------------------------
    protected void setId(Integer id) {
        this.id = id;
    }

    protected void setOrdenId(Integer ordenId) {
        this.ordenId = ordenId;
    }

    // ---------------------------------------------------------------------------------------------------------
    protected void setNumeroItem(int numeroItem) {
        this.numeroItem = numeroItem;
    }

    protected void setDescripcion(String value) {
        this.descripcion = coalesce(value, "");
    }

    // ---------------------------------------------------------------------------------------------------------
    protected void setCantidadSolicitada(int cantidadSolicitada) {
        this.cantidadSolicitada = cantidadSolicitada;
    }

    protected void setCantidadPlanificada(int cantidadPlanificada) {
        this.cantidadPlanificada = cantidadPlanificada;
    }

    protected void setCantidadAlistada(int cantidadAlistada) {
        this.cantidadAlistada = cantidadAlistada;
    }

    protected void setCantidadEntregada(int cantidadEntregada) {
        this.cantidadEntregada = cantidadEntregada;
    }

    protected void setCantidadNoEntregada(int cantidadNoEntregada) {
        this.cantidadNoEntregada = cantidadNoEntregada;
    }

    protected void setCantidadNoEntregadaLegalizada(int cantidadNoEntregadaLegalizada) {
        this.cantidadNoEntregadaLegalizada = cantidadNoEntregadaLegalizada;
    }

    protected void setCantidadSobrante(int cantidadSobrante) {
        this.cantidadSobrante = cantidadSobrante;
    }

    protected void setCantidadSobranteLegalizada(int cantidadSobranteLegalizada) {
        this.cantidadSobranteLegalizada = cantidadSobranteLegalizada;
    }

    // ---------------------------------------------------------------------------------------------------------
    protected void setProducto(Producto producto) {
        this.producto = producto;
    }

    protected void setProductoCodigo(String value) {
        this.productoCodigo = coalesce(value, "");
    }

    protected void setProductoCodigoAlterno(String value) {
        this.productoCodigoAlterno = coalesce(value, "");
    }

    // ---------------------------------------------------------------------------------------------------------
    protected void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    protected void setUnidadCodigo(String value) {
        this.unidadCodigo = coalesce(value, "");
    }

    protected void setUnidadCodigoAlterno(String value) {
        this.unidadCodigoAlterno = coalesce(value, "");
    }

    // ---------------------------------------------------------------------------------------------------------
    protected void setTipoContenido(TipoContenido tipoContenido) {
        this.tipoContenido = tipoContenido;
    }

    protected void setTipoContenidoCodigo(String value) {
        this.tipoContenidoCodigo = coalesce(value, "");
    }

    protected void setTipoContenidoCodigoAlterno(String value) {
        this.tipoContenidoCodigoAlterno = coalesce(value, "");
    }

    // ---------------------------------------------------------------------------------------------------------
    protected void setDimensiones(Dimensiones dimensiones) {
        this.dimensiones = coalesce(dimensiones, new Dimensiones());
    }

    // ---------------------------------------------------------------------------------------------------------
    protected void setBodegaOrigen(Bodega bodegaOrigen) {
        this.bodegaOrigen = bodegaOrigen;
    }

    protected void setBodegaOrigenCodigo(String value) {
        this.bodegaOrigenCodigo = coalesce(value, "");
    }

    protected void setBodegaOrigenCodigoAlterno(String value) {
        this.bodegaOrigenCodigoAlterno = coalesce(value, "");
    }

    protected void setEstadoInventarioOrigenId(String value) {
        this.estadoInventarioOrigenId = coalesce(value, "");
    }

    protected void setNumeroOrdenWmsOrigen(String value) {
        this.numeroOrdenWmsOrigen = coalesce(value, "");
    }

    // ---------------------------------------------------------------------------------------------------------
    protected void setBodegaDestino(Bodega bodegaDestino) {
        this.bodegaDestino = bodegaDestino;
    }

    protected void setBodegaDestinoCodigo(String value) {
        this.bodegaDestinoCodigo = coalesce(value, "");
    }

    protected void setBodegaDestinoCodigoAlterno(String value) {
        this.bodegaDestinoCodigoAlterno = coalesce(value, "");
    }

    protected void setEstadoInventarioDestinoId(String value) {
        this.estadoInventarioDestinoId = coalesce(value, "");
    }

    protected void setNumeroOrdenWmsDestino(String value) {
        this.numeroOrdenWmsDestino = coalesce(value, "");
    }

    // ---------------------------------------------------------------------------------------------------------
    protected void setLote(String value) {
        this.lote = coalesce(value, "");
    }

    protected void setSerial(String value) {
        this.serial = coalesce(value, "");
    }

    protected void setCosecha(String value) {
        this.cosecha = coalesce(value, "");
    }

    // ---------------------------------------------------------------------------------------------------------
    protected void setRequerimientoEstampillado(String value) {
        this.requerimientoEstampillado = coalesce(value, "");
    }

    protected void setRequerimientoSalud(String value) {
        this.requerimientoSalud = coalesce(value, "");
    }

    protected void setRequerimientoImporte(String value) {
        this.requerimientoImporte = coalesce(value, "");
    }

    protected void setRequerimientoDistribuido(String value) {
        this.requerimientoDistribuido = coalesce(value, "");
    }

    protected void setRequerimientoNutricional(String value) {
        this.requerimientoNutricional = coalesce(value, "");
    }

    protected void setRequerimientoBl(String value) {
        this.requerimientoBl = coalesce(value, "");
    }

    protected void setRequerimientoFondoCuenta(String value) {
        this.requerimientoFondoCuenta = coalesce(value, "");
    }

    protected void setRequerimientoOrigen(String value) {
        this.requerimientoOrigen = coalesce(value, "");
    }

    // ---------------------------------------------------------------------------------------------------------
    protected void setNumeroOrdenTms(String value) {
        this.numeroOrdenTms = coalesce(value, "");
    }

    protected void setFechaOrdenTms(Date fechaOrdenTms) {
        this.fechaOrdenTms = fechaOrdenTms;
    }

    protected void setPredistribucionDestinoFinal(String value) {
        this.predistribucionDestinoFinal = coalesce(value, "");
    }

    protected void setPredistribucionRotulo(String value) {
        this.predistribucionRotulo = coalesce(value, "");
    }

    // ---------------------------------------------------------------------------------------------------------
    protected void setValorDeclaradoPorUnidad(Integer valorDeclaradoPorUnidad) {
        this.valorDeclaradoPorUnidad = valorDeclaradoPorUnidad;
    }

    protected void setNotas(String value) {
        this.notas = coalesce(value, "");
    }

    // ---------------------------------------------------------------------------------------------------------
    protected void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    protected void setUsuarioCreacion(String value) {
        this.usuarioCreacion = coalesce(value, "");
    }

    protected void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    protected void setUsuarioActualizacion(String value) {
        this.usuarioActualizacion = coalesce(value, "");
    }

    // ---------------------------------------------------------------------------------------------------------
    protected void setMensajes(Set<MensajeEmbeddable> mensajes) {
        this.mensajes = mensajes;
    }

    // ---------------------------------------------------------------------------------------------------------
    public void cambiarDimensiones(BigDecimal largoPorUnidad, BigDecimal anchoPorUnidad, BigDecimal altoPorUnidad,
            BigDecimal pesoBrutoPorUnidad) {
        this.setDimensiones(new Dimensiones(largoPorUnidad, anchoPorUnidad, altoPorUnidad, pesoBrutoPorUnidad));
    }

    // ---------------------------------------------------------------------------------------------------------
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + numeroItem;
        result = prime * result + ((ordenId == null) ? 0 : ordenId.hashCode());
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
        OmsLineaOrden other = (OmsLineaOrden) obj;
        if (numeroItem != other.numeroItem)
            return false;
        if (ordenId == null) {
            if (other.ordenId != null)
                return false;
        } else if (!ordenId.equals(other.ordenId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        final int maxLen = 3;
        StringBuilder builder = new StringBuilder();
        builder.append("OmsLineaOrden [");
        if (id != null) {
            builder.append("id=").append(id).append(", ");
        }
        if (ordenId != null) {
            builder.append("ordenId=").append(ordenId).append(", ");
        }
        builder.append("numeroItem=").append(numeroItem).append(", ");
        if (descripcion != null) {
            builder.append("descripcion=").append(descripcion).append(", ");
        }
        builder.append("cantidadSolicitada=").append(cantidadSolicitada).append(", cantidadEntregada=")
                .append(cantidadEntregada).append(", ");
        if (producto != null) {
            builder.append("producto=").append(producto).append(", ");
        }
        if (productoCodigo != null) {
            builder.append("productoCodigo=").append(productoCodigo).append(", ");
        }
        if (productoCodigoAlterno != null) {
            builder.append("productoCodigoAlterno=").append(productoCodigoAlterno).append(", ");
        }
        if (unidad != null) {
            builder.append("unidad=").append(unidad).append(", ");
        }
        if (unidadCodigo != null) {
            builder.append("unidadCodigo=").append(unidadCodigo).append(", ");
        }
        if (unidadCodigoAlterno != null) {
            builder.append("unidadCodigoAlterno=").append(unidadCodigoAlterno).append(", ");
        }
        if (tipoContenido != null) {
            builder.append("tipoContenido=").append(tipoContenido).append(", ");
        }
        if (tipoContenidoCodigo != null) {
            builder.append("tipoContenidoCodigo=").append(tipoContenidoCodigo).append(", ");
        }
        if (tipoContenidoCodigoAlterno != null) {
            builder.append("tipoContenidoCodigoAlterno=").append(tipoContenidoCodigoAlterno).append(", ");
        }
        if (bodegaOrigen != null) {
            builder.append("bodegaOrigen=").append(bodegaOrigen).append(", ");
        }
        if (bodegaOrigenCodigo != null) {
            builder.append("bodegaOrigenCodigo=").append(bodegaOrigenCodigo).append(", ");
        }
        if (bodegaOrigenCodigoAlterno != null) {
            builder.append("bodegaOrigenCodigoAlterno=").append(bodegaOrigenCodigoAlterno).append(", ");
        }
        if (estadoInventarioOrigenId != null) {
            builder.append("estadoInventarioOrigenId=").append(estadoInventarioOrigenId).append(", ");
        }
        if (numeroOrdenWmsOrigen != null) {
            builder.append("numeroOrdenWmsOrigen=").append(numeroOrdenWmsOrigen).append(", ");
        }
        if (bodegaDestino != null) {
            builder.append("bodegaDestino=").append(bodegaDestino).append(", ");
        }
        if (bodegaDestinoCodigo != null) {
            builder.append("bodegaDestinoCodigo=").append(bodegaDestinoCodigo).append(", ");
        }
        if (bodegaDestinoCodigoAlterno != null) {
            builder.append("bodegaDestinoCodigoAlterno=").append(bodegaDestinoCodigoAlterno).append(", ");
        }
        if (estadoInventarioDestinoId != null) {
            builder.append("estadoInventarioDestinoId=").append(estadoInventarioDestinoId).append(", ");
        }
        if (numeroOrdenWmsDestino != null) {
            builder.append("numeroOrdenWmsDestino=").append(numeroOrdenWmsDestino).append(", ");
        }
        if (lote != null) {
            builder.append("lote=").append(lote).append(", ");
        }
        if (serial != null) {
            builder.append("serial=").append(serial).append(", ");
        }
        if (cosecha != null) {
            builder.append("cosecha=").append(cosecha).append(", ");
        }
        if (requerimientoEstampillado != null) {
            builder.append("requerimientoEstampillado=").append(requerimientoEstampillado).append(", ");
        }
        if (requerimientoSalud != null) {
            builder.append("requerimientoSalud=").append(requerimientoSalud).append(", ");
        }
        if (requerimientoImporte != null) {
            builder.append("requerimientoImporte=").append(requerimientoImporte).append(", ");
        }
        if (requerimientoDistribuido != null) {
            builder.append("requerimientoDistribuido=").append(requerimientoDistribuido).append(", ");
        }
        if (requerimientoNutricional != null) {
            builder.append("requerimientoNutricional=").append(requerimientoNutricional).append(", ");
        }
        if (requerimientoBl != null) {
            builder.append("requerimientoBl=").append(requerimientoBl).append(", ");
        }
        if (requerimientoFondoCuenta != null) {
            builder.append("requerimientoFondoCuenta=").append(requerimientoFondoCuenta).append(", ");
        }
        if (requerimientoOrigen != null) {
            builder.append("requerimientoOrigen=").append(requerimientoOrigen).append(", ");
        }
        if (numeroOrdenTms != null) {
            builder.append("numeroOrdenTms=").append(numeroOrdenTms).append(", ");
        }
        if (fechaOrdenTms != null) {
            builder.append("fechaOrdenTms=").append(fechaOrdenTms).append(", ");
        }
        if (predistribucionDestinoFinal != null) {
            builder.append("predistribucionDestinoFinal=").append(predistribucionDestinoFinal).append(", ");
        }
        if (predistribucionRotulo != null) {
            builder.append("predistribucionRotulo=").append(predistribucionRotulo).append(", ");
        }
        if (valorDeclaradoPorUnidad != null) {
            builder.append("valorDeclaradoPorUnidad=").append(valorDeclaradoPorUnidad).append(", ");
        }
        if (notas != null) {
            builder.append("notas=").append(notas).append(", ");
        }
        if (fechaCreacion != null) {
            builder.append("fechaCreacion=").append(fechaCreacion).append(", ");
        }
        if (usuarioCreacion != null) {
            builder.append("usuarioCreacion=").append(usuarioCreacion).append(", ");
        }
        if (fechaActualizacion != null) {
            builder.append("fechaActualizacion=").append(fechaActualizacion).append(", ");
        }
        if (usuarioActualizacion != null) {
            builder.append("usuarioActualizacion=").append(usuarioActualizacion).append(", ");
        }
        if (mensajes != null) {
            builder.append("mensajes=").append(toString(mensajes, maxLen));
        }
        builder.append("]");
        return builder.toString();
    }

    private String toString(Collection<?> collection, int maxLen) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        int i = 0;
        for (Iterator<?> iterator = collection.iterator(); iterator.hasNext() && i < maxLen; i++) {
            if (i > 0) {
                builder.append(", ");
            }
            builder.append(iterator.next());
        }
        builder.append("]");
        return builder.toString();
    }

    // ---------------------------------------------------------------------------------------------------------

}
