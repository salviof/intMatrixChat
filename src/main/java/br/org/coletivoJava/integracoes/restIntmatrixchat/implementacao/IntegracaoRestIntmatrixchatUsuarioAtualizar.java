package br.org.coletivoJava.integracoes.restIntmatrixchat.implementacao;

import br.org.coletivoJava.integracoes.restIntmatrixchat.api.InfoIntegracaoRestIntmatrixchatUsuarios;
import br.org.coletivoJava.integracoes.matrixChat.FabApiRestIntMatrixChatUsuarios;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilSBCoreGravatar;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilSBCoreJson;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilSBCoreStringTelefone;
import com.super_bits.modulosSB.SBCore.UtilGeral.json.ErroProcessandoJson;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.RespostaWebServiceSimples;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ComoUsuario;

@InfoIntegracaoRestIntmatrixchatUsuarios(tipo = FabApiRestIntMatrixChatUsuarios.USUARIO_ATUALIZAR)
public class IntegracaoRestIntmatrixchatUsuarioAtualizar
        extends
        AcaoApiIntegracaoAbstrato {

    public IntegracaoRestIntmatrixchatUsuarioAtualizar(
            final FabTipoAgenteClienteApi pTipoAgente,
            final ComoUsuario pUsuario, final java.lang.Object... pParametro) {
        super(FabApiRestIntMatrixChatUsuarios.USUARIO_ATUALIZAR, pTipoAgente,
                pUsuario, pParametro);
    }

    @Override
    public String gerarCorpoRequisicao() {
        JsonObjectBuilder jsonBUilder;
        try {
            if (getParametros().length != 4) {
                throw new UnsupportedOperationException("Parámetros para atualizacao de usário inválidos");
            }
            ///String usuario = (String) getParametros()[1];
            String nome = (String) getParametros()[1];
            String email = null;
            if (getParametros()[2] != null) {
                email = (String) getParametros()[2];
            }
            String telefone = null;
            if (getParametros()[3] != null) {
                telefone = UtilSBCoreStringTelefone.gerarNumeroTelefoneInternacional((String) getParametros()[3]);
            }
            // String senha = (String) getParametros()[4];

            System.out.println("Atualizando usuário:");
            System.out.println("codigo: " + getParametros()[0]);
            System.out.println("nome: " + nome);
            System.out.println("email:" + email);
            System.out.println("telefone" + telefone);

            String avatar = null;
            if (email != null) {
                avatar = UtilSBCoreGravatar.getGravatarUrl(email, 80);
            }

            jsonBUilder = UtilSBCoreJson.
                    getJsonBuilderBySequenciaChaveValor(
                            //"username", usuario,
                            "displayname", nome,
                            "admin", false,
                            "deactivated", false
                    //,"access_token", getTokenGestao().getToken()
                    );
            if (avatar != null) {
                jsonBUilder.add("avatar_url", UtilSBCoreGravatar.getGravatarUrl(email, 80));
            }
            if (email != null || telefone != null) {
                JsonArrayBuilder threepidsBuilder = Json.createArrayBuilder();
                if (email != null) {
                    JsonObject threepidEmail = UtilSBCoreJson.getJsonObjectBySequenciaChaveValor("medium", "email", "address", email);
                    threepidsBuilder.add(threepidEmail);
                }

                if (telefone != null) {
                    JsonObject threepidPhone = UtilSBCoreJson.getJsonObjectBySequenciaChaveValor("medium", "msisdn", "address", telefone);
                    threepidsBuilder.add(threepidPhone);
                }
                JsonArray idExternos = threepidsBuilder.build();
                if (!idExternos.isEmpty()) {
                    jsonBUilder.add("threepids", idExternos);
                }
            }
        } catch (ErroProcessandoJson ex) {
            throw new UnsupportedOperationException("Parametros Iválidos");
        }

        String conteudo = UtilSBCoreJson.getTextoByJsonObjeect(jsonBUilder.build());
        return conteudo;
    }

    @Override
    protected RespostaWebServiceSimples gerarRespostaTratamentoFino(RespostaWebServiceSimples pRespostaWSSemTratamento) {

        return UtilMatrixApiServer.gerarRespostaWSTratamentoFino(pRespostaWSSemTratamento);
    }
}
