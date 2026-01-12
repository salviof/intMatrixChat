package br.org.coletivoJava.integracoes.restIntmatrixchat.implementacao;

import br.org.coletivoJava.integracoes.restIntmatrixchat.api.InfoIntegracaoRestIntmatrixchatUsuarios;
import br.org.coletivoJava.integracoes.matrixChat.FabApiRestIntMatrixChatUsuarios;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoUsuario;

@InfoIntegracaoRestIntmatrixchatUsuarios(tipo = FabApiRestIntMatrixChatUsuarios.USUARIO_OBTER_DADOS_BY_TELEFONE)
public class IntegracaoRestIntmatrixchatUsuarioObterDadosByTelefone
		extends
			AcaoApiIntegracaoAbstrato {

	public IntegracaoRestIntmatrixchatUsuarioObterDadosByTelefone(
			final FabTipoAgenteClienteApi pTipoAgente,
			final ComoUsuario pUsuario, final java.lang.Object... pParametro) {
		super(FabApiRestIntMatrixChatUsuarios.USUARIO_OBTER_DADOS_BY_TELEFONE,
				pTipoAgente, pUsuario, pParametro);
	}
}