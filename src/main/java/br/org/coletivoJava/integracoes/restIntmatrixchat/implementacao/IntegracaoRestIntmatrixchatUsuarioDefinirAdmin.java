package br.org.coletivoJava.integracoes.restIntmatrixchat.implementacao;

import br.org.coletivoJava.integracoes.matrixChat.FabApiRestIntMatrixChatUsuarios;
import br.org.coletivoJava.integracoes.restIntmatrixchat.api.InfoIntegracaoRestIntmatrixchatUsuarios;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;

@InfoIntegracaoRestIntmatrixchatUsuarios(tipo = FabApiRestIntMatrixChatUsuarios.USUARIO_DEFINIR_ADMIN)
public class IntegracaoRestIntmatrixchatUsuarioDefinirAdmin
        extends
        AcaoApiIntegracaoAbstrato {

    public IntegracaoRestIntmatrixchatUsuarioDefinirAdmin(
            final FabTipoAgenteClienteApi pTipoAgente,
            final ItfUsuario pUsuario, final java.lang.Object... pParametro) {
        super(FabApiRestIntMatrixChatUsuarios.USUARIO_DEFINIR_ADMIN, pTipoAgente,
                pUsuario, pParametro);
    }
}
