package br.org.coletivoJava.integracoes.restIntmatrixchat.implementacao;

import br.org.coletivoJava.integracoes.restIntmatrixchat.api.InfoIntegracaoRestIntmatrixchatSalas;
import br.org.coletivoJava.integracoes.matrixChat.FabApiRestIntMatrixChatSalas;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ComoUsuario;

@InfoIntegracaoRestIntmatrixchatSalas(tipo = FabApiRestIntMatrixChatSalas.SALA_REMOVER_USUARIO)
public class IntegracaoRestIntmatrixchatSalaRemoverUsuario
        extends
        AcaoApiIntegracaoAbstrato {

    public IntegracaoRestIntmatrixchatSalaRemoverUsuario(
            final FabTipoAgenteClienteApi pTipoAgente,
            final ComoUsuario pUsuario, final java.lang.Object... pParametro) {
        super(FabApiRestIntMatrixChatSalas.SALA_REMOVER_USUARIO, pTipoAgente,
                pUsuario, pParametro);
    }

    @Override
    public String gerarCorpoRequisicao() {
        String usuario = (String) getParametros()[1];
        return "{\n"
                + "  \"reason\": \"removido por admin\",\n"
                + "  \"user_id\": \"" + usuario + "\"\n"
                + "}";
    }

}
