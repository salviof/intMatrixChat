package br.org.coletivoJava.integracoes.restIntmatrixchat.implementacao;

import br.org.coletivoJava.integracoes.restIntmatrixchat.api.InfoIntegracaoRestIntmatrixchatUsuarios;
import br.org.coletivoJava.integracoes.matrixChat.FabApiRestIntMatrixChatUsuarios;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;

@InfoIntegracaoRestIntmatrixchatUsuarios(tipo = FabApiRestIntMatrixChatUsuarios.USUARIO_PROFILE)
public class IntegracaoRestIntmatrixchatUsuarioProfile
		extends
			AcaoApiIntegracaoAbstrato {

	public IntegracaoRestIntmatrixchatUsuarioProfile(
			final FabTipoAgenteClienteApi pTipoAgente,
			final ItfUsuario pUsuario, final java.lang.Object... pParametro) {
		super(FabApiRestIntMatrixChatUsuarios.USUARIO_PROFILE, pTipoAgente,
				pUsuario, pParametro);
	}
}