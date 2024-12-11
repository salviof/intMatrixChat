/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.org.coletivoJava.integracoes.restIntmatrixchat.implementacao;

import br.org.coletivoJava.integracoes.matrixChat.FabApiRestIntMatrixChatSalas;
import com.super_bits.Super_Bits.mktMauticIntegracao.configAppp.ConfiguradorCoreMatrixChatIntegracao;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.ItfRespostaWebServiceSimples;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.token.ItfTokenGestao;
import org.junit.Test;

/**
 *
 * @author salvio
 */
public class IntegracaoRestIntmatrixchatSalaEncontrarPorAliasTest {

    public IntegracaoRestIntmatrixchatSalaEncontrarPorAliasTest() {
    }

    @Test
    public void testSomeMethod() {
        SBCore.configurar(new ConfiguradorCoreMatrixChatIntegracao(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        ItfTokenGestao tokenEcontrarById = FabApiRestIntMatrixChatSalas.SALA_ENCONTRAR_POR_NOME.getGestaoToken();
        if (!tokenEcontrarById.isTemTokemAtivo()) {
            tokenEcontrarById.gerarNovoToken();
        }
        ItfRespostaWebServiceSimples resposta = FabApiRestIntMatrixChatSalas.SALA_ENCONTRAR_POR_NOME.getAcao("apenasTeste").getResposta();
        System.out.println(resposta.getRespostaTexto());
        if (resposta.isSucesso()) {
            String roomID = resposta.getRespostaComoObjetoJson().get("rooms").asJsonArray().get(0).asJsonObject().getString("room_id");
            ItfRespostaWebServiceSimples respostaAlias2 = FabApiRestIntMatrixChatSalas.SALA_VINCULAR_APELIDO_SALA_AO_ID.getAcao("#APELIDO_APENAS_TESTE2:casanovadigital.com.br", roomID).getResposta();
            System.out.println(respostaAlias2.getRespostaTexto());
        }
        ItfRespostaWebServiceSimples respostaBuscaPeloAliasCamila = FabApiRestIntMatrixChatSalas.SALA_ENCONTRAR_POR_ALIAS.getAcao("#553195171605wv:casanovadigital.com.br").getResposta();
        System.out.println(respostaBuscaPeloAliasCamila.getRespostaTexto());

        ItfRespostaWebServiceSimples respostaBuscaPeloAlias = FabApiRestIntMatrixChatSalas.SALA_ENCONTRAR_POR_ALIAS.getAcao("#APELIDO_APENAS_TEST:casanovadigital.com.br").getResposta();
        System.out.println(respostaBuscaPeloAlias.getRespostaTexto());

        ItfRespostaWebServiceSimples respostaBuscaPeloAliasCamila2 = FabApiRestIntMatrixChatSalas.SALA_ENCONTRAR_POR_ALIAS.getAcao("#553195171605wv:casanovadigital.com.br").getResposta();
        System.out.println(respostaBuscaPeloAliasCamila.getRespostaTexto());

    }

}
