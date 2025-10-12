/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.org.coletivoJava.integracoes.restIntmatrixchat.implementacao;

import br.org.coletivoJava.integracoes.matrixChat.FabApiRestIntMatrixChatUsuarios;
import com.super_bits.Super_Bits.mktMauticIntegracao.configAppp.ConfiguradorCoreMatrixChatIntegracao;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilSBCoreJson;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.ItfRespostaWebServiceSimples;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonValue;
import java.util.Optional;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author salvio
 */
public class IntegracaoRestIntmatrixchatUsuarioObterDadosTest {

    @Test
    public void testSomeMethod() {
        SBCore.configurar(new ConfiguradorCoreMatrixChatIntegracao(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        GestaoTokenRestIntmatrixchat gtoke = (GestaoTokenRestIntmatrixchat) FabApiRestIntMatrixChatUsuarios.USUARIO_OBTER_DADOS.getGestaoToken();

        gtoke.excluirToken();
        gtoke.gerarNovoToken();
        System.out.println(gtoke.getUserID());

        ItfRespostaWebServiceSimples resposta = FabApiRestIntMatrixChatUsuarios.USUARIO_OBTER_DADOS.getAcao("@salvio_furbino9301:casanovadigital.com.br").getResposta();

        resposta.dispararMensagens();
        Assert.assertTrue("Falha criando usuário" + resposta.getRespostaTexto(), resposta.isSucesso());
        JsonObject json = UtilSBCoreJson.getJsonObjectByTexto(resposta.getRespostaTexto());
        if (json.containsKey("external_ids")) {
            JsonArray idsExtrnod = json.getJsonArray("external_ids");
            Optional<JsonValue> pesquisaIdentificador = idsExtrnod.stream().filter(jo -> jo.asJsonObject().equals("oidc-casanova")).findFirst();
            if (pesquisaIdentificador.isPresent()) {
                String idExternoRegistrado = pesquisaIdentificador.get().asJsonObject().getString("external_id");
            }
        }
        System.out.println(resposta.getRespostaTexto());
    }
}
