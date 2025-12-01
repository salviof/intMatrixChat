package br.org.coletivoJava.integracoes.restIntmatrixchat.implementacao;

import br.org.coletivoJava.integracoes.restIntmatrixchat.api.InfoIntegracaoRestIntmatrixchatSalas;
import br.org.coletivoJava.integracoes.matrixChat.FabApiRestIntMatrixChatSalas;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilCRCJson;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import jakarta.json.JsonObject;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ComoUsuario;

@InfoIntegracaoRestIntmatrixchatSalas(tipo = FabApiRestIntMatrixChatSalas.SALA_PERMICOES_ATUALIZAR)
public class IntegracaoRestIntmatrixchatSalaPermicoesAtualizar
        extends
        AcaoApiIntegracaoAbstrato {

    public IntegracaoRestIntmatrixchatSalaPermicoesAtualizar(
            final FabTipoAgenteClienteApi pTipoAgente,
            final ComoUsuario pUsuario, final java.lang.Object... pParametro) {
        super(FabApiRestIntMatrixChatSalas.SALA_PERMICOES_ATUALIZAR,
                pTipoAgente, pUsuario, pParametro);
    }

    @Override
    public String gerarCorpoRequisicao() {

        /*
            {
                "users": {
                    "@novo_admin:matrix.org": 100,
                    "@ja_existente:matrix.org": 100
                },
                "users_default": 0,
                "state_default": 50,
                "events_default": 0,
                "ban": 50,
                "kick": 50,
                "redact": 50
            }
         */
        String prarmetroJson = (String) parametros.get(1);
        JsonObject jsonValidacao = UtilCRCJson.getJsonObjectByTexto(prarmetroJson);

        return UtilCRCJson.getTextoByJsonObjeect(jsonValidacao);
    }

}
