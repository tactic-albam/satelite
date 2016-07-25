package com.tacticlogistics.domain.model.requerimientos.valueobjects;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OpcionesDeRequerimientoEmbeddable.class)
public abstract class OpcionesDeRequerimientoEmbeddable_ {

	public static volatile SingularAttribute<OpcionesDeRequerimientoEmbeddable, Integer> numeroMaximoDeArchivosAdjuntos;
	public static volatile SingularAttribute<OpcionesDeRequerimientoEmbeddable, Boolean> requiereNotasEnCasoDeNoConformidad;
	public static volatile SingularAttribute<OpcionesDeRequerimientoEmbeddable, Boolean> requiereDocumentoFisico;
	public static volatile SingularAttribute<OpcionesDeRequerimientoEmbeddable, Integer> numeroMinimoDeArchivosAdjuntos;
	public static volatile SingularAttribute<OpcionesDeRequerimientoEmbeddable, Integer> tamanoMaximoPorArchivoAdjuntos;
	public static volatile SingularAttribute<OpcionesDeRequerimientoEmbeddable, String> textoPreguntaRequerimientoDeCumplimiento;
	public static volatile SingularAttribute<OpcionesDeRequerimientoEmbeddable, Boolean> permitirPersonalizarOpcionesDeArchivosAdjuntos;
	public static volatile SingularAttribute<OpcionesDeRequerimientoEmbeddable, Boolean> requiereNumeroDeReferenciaDelDocumento;
	public static volatile SingularAttribute<OpcionesDeRequerimientoEmbeddable, Boolean> permitirPersonalizarOpcionesParaDispositivosMoviles;
	public static volatile SingularAttribute<OpcionesDeRequerimientoEmbeddable, Boolean> requiereNotasEnCasoDeConformidad;
	public static volatile SingularAttribute<OpcionesDeRequerimientoEmbeddable, Boolean> permitirPersonalizarOpcionesParaRequerimientosDocumentales;
	public static volatile SingularAttribute<OpcionesDeRequerimientoEmbeddable, Boolean> permitirPersonalizarOpcionesParaRequerimientosDeCumplimiento;
	public static volatile SingularAttribute<OpcionesDeRequerimientoEmbeddable, Boolean> habilitarOpcionParaAdjuntarArchivosEnDispositivosMoviles;

}
