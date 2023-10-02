/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.org.coletivoJava.integracoes.restIntmatrixchat.implementacao;

import br.org.coletivoJava.integracoes.matrixChat.FabApiRestIntMatrixChatSalas;
import com.super_bits.Super_Bits.mktMauticIntegracao.configAppp.ConfiguradorCoreMatrixChatIntegracao;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilSBCoreJson;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.ItfRespostaWebServiceSimples;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.token.ItfTokenGestao;
import jakarta.json.JsonObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author salvio
 */
public class IntegracaoRestIntmatrixchatSalaAliasesTest {

    public IntegracaoRestIntmatrixchatSalaAliasesTest() {
    }

    @Test
    public void testSomeMethod() {
        SBCore.configurar(new ConfiguradorCoreMatrixChatIntegracao(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        ItfTokenGestao tokenEcontrarById = FabApiRestIntMatrixChatSalas.SALA_ENCONTRAR_POR_NOME.getGestaoToken();
        if (!tokenEcontrarById.isTemTokemAtivo()) {
            tokenEcontrarById.gerarNovoToken();
        }
        ItfRespostaWebServiceSimples resposta = FabApiRestIntMatrixChatSalas.SALA_ENCONTRAR_POR_NOME.getAcao("apenasTeste").getResposta();
        String id = resposta.getRespostaComoObjetoJson().getJsonArray("rooms").getJsonObject(0).getString("room_id");
        JsonObject sala = resposta.getRespostaComoObjetoJson().getJsonArray("rooms").getJsonObject(0);
        System.out.println(UtilSBCoreJson.getTextoByJsonObjeect(sala));
        System.out.println(resposta.getRespostaTexto());
        ItfRespostaWebServiceSimples resp = FabApiRestIntMatrixChatSalas.SALA_ALIASES.getAcao(id).getResposta();
        System.out.println(resp.getRespostaTexto());
    }

}
