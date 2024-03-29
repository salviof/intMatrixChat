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
import org.junit.Test;

/**
 *
 * @author salvio
 */
public class IntegracaoRestIntmatrixchatSalaCriarTest {

    public IntegracaoRestIntmatrixchatSalaCriarTest() {
    }

    @Test
    public void testSomeMethod() {
        SBCore.configurar(new ConfiguradorCoreMatrixChatIntegracao(), SBCore.ESTADO_APP.DESENVOLVIMENTO);

        String teste = "#teste:casanovadigital.com.br";
        teste = teste.substring(1, teste.indexOf(":"));
        System.out.println(teste);
        ItfTokenGestao tokenEcontrarById = FabApiRestIntMatrixChatSalas.SALA_CRIAR.getGestaoToken();
        if (!tokenEcontrarById.isTemTokemAtivo()) {
            tokenEcontrarById.gerarNovoToken();
        }
        ItfRespostaWebServiceSimples resposta = FabApiRestIntMatrixChatSalas.SALA_CRIAR.getAcao("Apenas Teste", "Apenasteste12", "#espaço_testes:casanovadigital.com.br").getResposta();
        System.out.println(resposta.getRespostaTexto());
        resposta.dispararMensagens();
        Assert.assertTrue("Falha criando usuário" + resposta.getRespostaTexto(), resposta.isSucesso());

        System.out.println(resposta.getCodigoResposta());
        System.out.println(resposta.getRespostaTexto());
        resposta = FabApiRestIntMatrixChatSalas.SALA_ENCONTRAR_POR_ALIAS.getAcao("#Apenasteste10:casanovadigital.com.br").getResposta();
        System.out.println(resposta.getCodigoResposta());
        System.out.println(resposta.getRespostaTexto());

    }

}
