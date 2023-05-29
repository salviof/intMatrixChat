/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.org.coletivoJava.integracoes.restIntmatrixchat.implementacao;

import br.org.coletivoJava.integracoes.matrixChat.FabApiRestIntMatrixChatUsuarios;
import br.org.coletivoJava.integracoes.restIntmatrixchat.UtilsbApiMatrixChat;
import com.super_bits.Super_Bits.mktMauticIntegracao.configAppp.ConfiguradorCoreMatrixChatIntegracao;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.ItfRespostaWebServiceSimples;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author salvio
 */
public class IntegracaoRestIntmatrixchatUsuarioCriarTest {

    public IntegracaoRestIntmatrixchatUsuarioCriarTest() {
    }

    @Test
    public void testSomeMethod() {
        SBCore.configurar(new ConfiguradorCoreMatrixChatIntegracao(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        if (!FabApiRestIntMatrixChatUsuarios.USUARIO_CRIAR.getGestaoToken().isPossuiAutenticacaoDeUsuario()) {
            FabApiRestIntMatrixChatUsuarios.USUARIO_CRIAR.getGestaoToken().gerarNovoToken();
        }
        String slugUsuario = "renata_mota";
        String codigoUsuario = UtilsbApiMatrixChat.gerarCodigoBySlugUser(slugUsuario);
        ItfRespostaWebServiceSimples resposta = FabApiRestIntMatrixChatUsuarios.USUARIO_CRIAR
                .getAcao(codigoUsuario, slugUsuario, "Renata Mota", "renata.mota@casanovadigital.com.br", "553198535825", "renata@Casalover").getResposta();

        ItfRespostaWebServiceSimples respostaAlteraSenha = FabApiRestIntMatrixChatUsuarios.USUARIO_CRIAR
                .getAcao(codigoUsuario, "renata@Casalover").getResposta();
        resposta.dispararMensagens();
        Assert.assertTrue("Falha criando usuário" + resposta.getRespostaTexto(), resposta.isSucesso());
        System.out.println(resposta.getCodigoResposta());
        System.out.println(resposta.getRespostaTexto());
    }

}
