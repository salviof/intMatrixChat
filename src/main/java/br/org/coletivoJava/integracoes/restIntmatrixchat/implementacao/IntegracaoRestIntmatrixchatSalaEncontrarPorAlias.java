package br.org.coletivoJava.integracoes.restIntmatrixchat.implementacao;

import br.org.coletivoJava.integracoes.restIntmatrixchat.api.InfoIntegracaoRestIntmatrixchatSalas;
import br.org.coletivoJava.integracoes.matrixChat.FabApiRestIntMatrixChatSalas;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ComoUsuario;

@InfoIntegracaoRestIntmatrixchatSalas(tipo = FabApiRestIntMatrixChatSalas.SALA_ENCONTRAR_POR_ALIAS)
public class IntegracaoRestIntmatrixchatSalaEncontrarPorAlias
		extends
			AcaoApiIntegracaoAbstrato {

	public IntegracaoRestIntmatrixchatSalaEncontrarPorAlias(
			final FabTipoAgenteClienteApi pTipoAgente,
			final ComoUsuario pUsuario, final java.lang.Object... pParametro) {
		super(FabApiRestIntMatrixChatSalas.SALA_ENCONTRAR_POR_ALIAS,
				pTipoAgente, pUsuario, pParametro);
	}
}