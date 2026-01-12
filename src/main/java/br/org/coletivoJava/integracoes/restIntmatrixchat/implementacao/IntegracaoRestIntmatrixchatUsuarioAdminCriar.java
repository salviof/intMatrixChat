package br.org.coletivoJava.integracoes.restIntmatrixchat.implementacao;

import br.org.coletivoJava.integracoes.restIntmatrixchat.api.InfoIntegracaoRestIntmatrixchatUsuarios;
import br.org.coletivoJava.integracoes.matrixChat.FabApiRestIntMatrixChatUsuarios;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilCRCGravatar;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilCRCJson;
import com.super_bits.modulosSB.SBCore.UtilGeral.json.ErroProcessandoJson;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.RespostaWebServiceSimples;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoUsuario;

@InfoIntegracaoRestIntmatrixchatUsuarios(tipo = FabApiRestIntMatrixChatUsuarios.USUARIO_ADMIN_CRIAR)
public class IntegracaoRestIntmatrixchatUsuarioAdminCriar
        extends
        AcaoApiIntegracaoAbstrato {

    public IntegracaoRestIntmatrixchatUsuarioAdminCriar(
            final FabTipoAgenteClienteApi pTipoAgente,
            final ComoUsuario pUsuario, final java.lang.Object... pParametro) {
        super(FabApiRestIntMatrixChatUsuarios.USUARIO_ADMIN_CRIAR, pTipoAgente,
                pUsuario, pParametro);
    }

    @Override
    public String gerarCorpoRequisicao() {
        JsonObjectBuilder jsonBUilder;
        try {

            String usuario = (String) getParametros()[1];
            String nome = (String) getParametros()[2];
            String email = (String) getParametros()[3];
            String telefone = (String) getParametros()[4];
            String senha = (String) getParametros()[5];

            System.out.println("Criando usuário:");
            System.out.println("codigo: " + getParametros()[0]);
            System.out.println("nome: " + nome);
            System.out.println("email:" + email);
            System.out.println("telefone" + telefone);
            System.out.println("Senha:" + senha);

            jsonBUilder = UtilCRCJson.
                    getJsonBuilderBySequenciaChaveValor(
                            "username", usuario,
                            "displayname", nome,
                            "password", senha,
                            "avatar_url", UtilCRCGravatar.getGravatarUrl(email, 80),
                            "admin", true,
                            "deactivated", false
                    //,"access_token", getTokenGestao().getToken()
                    );

            JsonObject threepidEmail = UtilCRCJson.getJsonObjectBySequenciaChaveValor("medium", "email", "address", email);
            JsonArrayBuilder threepidsBuilder = Json.createArrayBuilder();
            threepidsBuilder.add(threepidEmail);
            if (telefone != null) {
                JsonObject threepidPhone = UtilCRCJson.getJsonObjectBySequenciaChaveValor("medium", "msisdn", "address", telefone);

                threepidsBuilder.add(threepidPhone);
            }
            jsonBUilder.add("threepids", threepidsBuilder.build());
        } catch (ErroProcessandoJson ex) {
            throw new UnsupportedOperationException("Parametros Iválidos");
        }
        return UtilCRCJson.getTextoByJsonObjeect(jsonBUilder.build());
    }

    @Override
    protected RespostaWebServiceSimples gerarRespostaTratamentoFino(RespostaWebServiceSimples pRespostaWSSemTratamento) {

        return UtilMatrixApiServer.gerarRespostaWSTratamentoFino(pRespostaWSSemTratamento);
    }
}
