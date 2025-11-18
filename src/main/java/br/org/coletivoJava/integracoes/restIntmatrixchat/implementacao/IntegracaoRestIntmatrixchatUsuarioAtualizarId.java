package br.org.coletivoJava.integracoes.restIntmatrixchat.implementacao;

import br.org.coletivoJava.integracoes.restIntmatrixchat.api.InfoIntegracaoRestIntmatrixchatUsuarios;
import br.org.coletivoJava.integracoes.matrixChat.FabApiRestIntMatrixChatUsuarios;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilSBCoreJson;
import com.super_bits.modulosSB.SBCore.UtilGeral.json.ErroProcessandoJson;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ComoUsuario;

@InfoIntegracaoRestIntmatrixchatUsuarios(tipo = FabApiRestIntMatrixChatUsuarios.USUARIO_ATUALIZAR_ID)
public class IntegracaoRestIntmatrixchatUsuarioAtualizarId
        extends
        AcaoApiIntegracaoAbstrato {

    public IntegracaoRestIntmatrixchatUsuarioAtualizarId(
            final FabTipoAgenteClienteApi pTipoAgente,
            final ComoUsuario pUsuario, final java.lang.Object... pParametro) {
        super(FabApiRestIntMatrixChatUsuarios.USUARIO_ATUALIZAR_ID,
                pTipoAgente, pUsuario, pParametro);
    }

    @Override
    public String gerarCorpoRequisicao() {
        try {
            String codAnterior = (String) parametros.get(0);
            String novoCodigo = (String) parametros.get(1);

            JsonObjectBuilder jsonBUilder;
            jsonBUilder = UtilSBCoreJson.
                    getJsonBuilderBySequenciaChaveValor(
                            "name", novoCodigo
                    );

            return UtilSBCoreJson.getTextoByJsonObjeect(jsonBUilder.build());
        } catch (ErroProcessandoJson ex) {
            throw new UnsupportedOperationException("Parametros Iválidos");
        }

    }

}
