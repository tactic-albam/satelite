package com.tacticlogistics.application.rules.distribucion;

import com.tacticlogistics.application.dto.common.MensajesDTO;
import com.tacticlogistics.application.rules.Regla;
import com.tacticlogistics.domain.model.oms.Orden;

public class ReglaCitaEntrega implements Regla<Orden> {

	@Override
	public MensajesDTO<?> validar(Orden object) {
		MensajesDTO<?> mensajes = new MensajesDTO<>();
		
		return mensajes;
	}

}