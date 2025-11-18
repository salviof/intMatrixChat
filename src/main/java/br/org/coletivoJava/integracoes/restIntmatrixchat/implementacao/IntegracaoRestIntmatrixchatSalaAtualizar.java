package br.org.coletivoJava.integracoes.restIntmatrixchat.implementacao;

import br.org.coletivoJava.integracoes.restIntmatrixchat.api.InfoIntegracaoRestIntmatrixchatSalas;
import br.org.coletivoJava.integracoes.matrixChat.FabApiRestIntMatrixChatSalas;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ComoUsuario;

@InfoIntegracaoRestIntmatrixchatSalas(tipo = FabApiRestIntMatrixChatSalas.SALA_ATUALIZAR)
public class IntegracaoRestIntmatrixchatSalaAtualizar
        extends
        AcaoApiIntegracaoAbstrato {

    public IntegracaoRestIntmatrixchatSalaAtualizar(
            final FabTipoAgenteClienteApi pTipoAgente,
            final ComoUsuario pUsuario, final java.lang.Object... pParametro) {
        super(FabApiRestIntMatrixChatSalas.SALA_ATUALIZAR, pTipoAgente,
                pUsuario, pParametro);
    }

    @Override
    public String gerarCorpoRequisicao() {
        throw new UnsupportedOperationException("não existe documentação oficial sobre como renomear a sala, uma abordagem possível é usar a exclusão com redirecionamento de usuários e mensagens (previsto na api de  exclusão da sala)");
    }

}
