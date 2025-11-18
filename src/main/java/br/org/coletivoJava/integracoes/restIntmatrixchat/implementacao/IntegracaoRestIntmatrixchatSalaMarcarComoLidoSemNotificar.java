package br.org.coletivoJava.integracoes.restIntmatrixchat.implementacao;

import br.org.coletivoJava.integracoes.restIntmatrixchat.api.InfoIntegracaoRestIntmatrixchatSalas;
import br.org.coletivoJava.integracoes.matrixChat.FabApiRestIntMatrixChatSalas;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ComoUsuario;

@InfoIntegracaoRestIntmatrixchatSalas(tipo = FabApiRestIntMatrixChatSalas.SALA_MARCAR_COMO_LIDO_SEM_NOTIFICAR)
public class IntegracaoRestIntmatrixchatSalaMarcarComoLidoSemNotificar
		extends
			AcaoApiIntegracaoAbstrato {

	public IntegracaoRestIntmatrixchatSalaMarcarComoLidoSemNotificar(
			final FabTipoAgenteClienteApi pTipoAgente,
			final ComoUsuario pUsuario, final java.lang.Object... pParametro) {
		super(FabApiRestIntMatrixChatSalas.SALA_MARCAR_COMO_LIDO_SEM_NOTIFICAR,
				pTipoAgente, pUsuario, pParametro);
	}
}