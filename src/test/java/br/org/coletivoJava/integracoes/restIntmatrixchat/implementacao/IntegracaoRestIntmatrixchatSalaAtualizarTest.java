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
public class IntegracaoRestIntmatrixchatSalaAtualizarTest {

    public IntegracaoRestIntmatrixchatSalaAtualizarTest() {
    }

    @Test
    public void testSomeMethod() {
        // TODO review the generated test code and remove the default call to fail.
        SBCore.configurar(new ConfiguradorCoreMatrixChatIntegracao(), SBCore.ESTADO_APP.DESENVOLVIMENTO);

        String apelidoREferencia = "#teste:casanovadigital.com.br";
        apelidoREferencia = apelidoREferencia.substring(1, apelidoREferencia.indexOf(":"));
        System.out.println(apelidoREferencia);
        ItfTokenGestao tokenEcontrarById = FabApiRestIntMatrixChatSalas.SALA_CRIAR.getGestaoToken();
        if (!tokenEcontrarById.validarToken()) {
            tokenEcontrarById.excluirToken();
            tokenEcontrarById.gerarNovoToken();
        }
        ItfRespostaWebServiceSimples resposta = FabApiRestIntMatrixChatSalas.SALA_ENCONTRAR_POR_ALIAS.getAcao("#teste:casanovadigital.com.br").getResposta();
        System.out.println(resposta.getRespostaTexto());
        Assert.assertTrue("Falha criando usuário" + resposta.getRespostaTexto(), resposta.isSucesso());
        String roomID = resposta.getRespostaComoObjetoJson().getString("room_id");

        ItfRespostaWebServiceSimples resopstaAtualizacao = FabApiRestIntMatrixChatSalas.SALA_ATUALIZAR.getAcao("roomID", "novoNome", apelidoREferencia).getResposta();
        System.out.println(resposta.getRespostaTexto());
        resposta.dispararMensagens();
        Assert.assertTrue("Falha criando usuário" + resposta.getRespostaTexto(), resposta.isSucesso());
    }

}
