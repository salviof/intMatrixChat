package br.org.coletivoJava.integracoes.restIntmatrixchat.implementacao;

import br.org.coletivoJava.integracoes.restIntmatrixchat.api.InfoIntegracaoRestIntmatrixchatSalas;
import br.org.coletivoJava.integracoes.matrixChat.FabApiRestIntMatrixChatSalas;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;

@InfoIntegracaoRestIntmatrixchatSalas(tipo = FabApiRestIntMatrixChatSalas.SALA_OBTER_ULTIMO_EVENTO)
public class IntegracaoRestIntmatrixchatSalaObterUltimoEvento
		extends
			AcaoApiIntegracaoAbstrato {

	public IntegracaoRestIntmatrixchatSalaObterUltimoEvento(
			final FabTipoAgenteClienteApi pTipoAgente,
			final ItfUsuario pUsuario, final java.lang.Object... pParametro) {
		super(FabApiRestIntMatrixChatSalas.SALA_OBTER_ULTIMO_EVENTO,
				pTipoAgente, pUsuario, pParametro);
	}
}