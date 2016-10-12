package com.tacticlogistics.application.services.clientes.dicermex;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ResultadoPreAlertaOrdenDeCompraDto {
	private String numeroOrdenWms;
	private ResultadoPreAlertaType resultado;
	String mensaje;
}
