package br.org.coletivoJava.integracoes.restIntmatrixchat.implementacao;

import br.org.coletivoJava.integracoes.restIntmatrixchat.api.InfoIntegracaoRestIntmatrixchatMedia;
import br.org.coletivoJava.integracoes.matrixChat.FabApiRestMatrixMedia;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;

@InfoIntegracaoRestIntmatrixchatMedia(tipo = FabApiRestMatrixMedia.DOWNLOAD_ARQUIVO)
public class IntegracaoRestIntmatrixchatDownloadArquivo
		extends
			AcaoApiIntegracaoAbstrato {

	public IntegracaoRestIntmatrixchatDownloadArquivo(
			final FabTipoAgenteClienteApi pTipoAgente,
			final ItfUsuario pUsuario, final java.lang.Object... pParametro) {
		super(FabApiRestMatrixMedia.DOWNLOAD_ARQUIVO, pTipoAgente, pUsuario,
				pParametro);
	}
}