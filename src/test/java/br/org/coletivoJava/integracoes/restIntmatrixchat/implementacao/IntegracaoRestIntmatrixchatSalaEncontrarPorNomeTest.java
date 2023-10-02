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
import junit.framework.Assert;
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
public class IntegracaoRestIntmatrixchatSalaEncontrarPorNomeTest {

    public IntegracaoRestIntmatrixchatSalaEncontrarPorNomeTest() {
    }

    @Test
    public void testSomeMethod() {
        // TODO review the generated test code and remove the default call to fail.
        SBCore.configurar(new ConfiguradorCoreMatrixChatIntegracao(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        ItfTokenGestao tokenEcontrarById = FabApiRestIntMatrixChatSalas.SALA_ENCONTRAR_POR_NOME.getGestaoToken();
        if (!tokenEcontrarById.isTemTokemAtivo()) {
            tokenEcontrarById.gerarNovoToken();
        }

        ItfRespostaWebServiceSimples resposta = FabApiRestIntMatrixChatSalas.SALA_ENCONTRAR_POR_NOME.getAcao("apenasTeste").getResposta();
        System.out.println(resposta.getRespostaTexto());
        String roomID = resposta.getRespostaComoObjetoJson().get("rooms").asJsonArray().get(0).asJsonObject().getString("room_id");
        ItfRespostaWebServiceSimples respApelidos = FabApiRestIntMatrixChatSalas.SALA_ALIASES.getAcao(roomID).getResposta();
        ItfRespostaWebServiceSimples respostaAlias = FabApiRestIntMatrixChatSalas.SALA_VINCULAR_APELIDO_SALA_AO_ID.getAcao("APELIDO_APENAS_TESTE3:casanovadigital.com.br", roomID).getResposta();
        ItfRespostaWebServiceSimples respostaAlias2 = FabApiRestIntMatrixChatSalas.SALA_VINCULAR_APELIDO_SALA_AO_ID.getAcao("#APELIDO_APENAS_TESTE2:casanovadigital.com.br", roomID).getResposta();
        System.out.println(respostaAlias.getRespostaTexto());
        ItfRespostaWebServiceSimples respostaBuscaPeloAlias = FabApiRestIntMatrixChatSalas.SALA_ENCONTRAR_POR_ALIAS.getAcao("#APELIDO_APENAS_TESTE:casanovadigital.com.br").getResposta();
        System.out.println(respostaBuscaPeloAlias.getRespostaTexto());
        respostaBuscaPeloAlias = FabApiRestIntMatrixChatSalas.SALA_ENCONTRAR_POR_ALIAS.getAcao("#APELIDO_APENAS_TESTE2:casanovadigital.com.br").getResposta();
        System.out.println(respostaBuscaPeloAlias.getRespostaTexto());
        resposta.dispararMensagens();
        Assert.assertTrue("Falha obtendo sala" + resposta.getRespostaTexto(), resposta.isSucesso());
        System.out.println(resposta.getCodigoResposta());
        System.out.println(resposta.getRespostaTexto());
    }

}
