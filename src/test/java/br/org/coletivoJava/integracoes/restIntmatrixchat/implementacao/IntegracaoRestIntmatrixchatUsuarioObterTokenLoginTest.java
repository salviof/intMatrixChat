/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.org.coletivoJava.integracoes.restIntmatrixchat.implementacao;

import br.org.coletivoJava.integracoes.matrixChat.FabApiRestIntMatrixChatUsuarios;
import com.super_bits.Super_Bits.mktMauticIntegracao.configAppp.ConfiguradorCoreMatrixChatIntegracao;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.ItfRespostaWebServiceSimples;
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
public class IntegracaoRestIntmatrixchatUsuarioObterTokenLoginTest {

    public IntegracaoRestIntmatrixchatUsuarioObterTokenLoginTest() {
    }

    /**
     * Test of gerarCorpoRequisicao method, of class
     * IntegracaoRestIntmatrixchatUsuarioObterTokenLogin.
     */
    @Test
    public void testGerarCorpoRequisicao() {
        SBCore.configurar(new ConfiguradorCoreMatrixChatIntegracao(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        GestaoTokenRestIntmatrixchat gtoke = (GestaoTokenRestIntmatrixchat) FabApiRestIntMatrixChatUsuarios.USUARIOS_STATUS.getGestaoToken();
        gtoke.excluirToken();
        if (!gtoke.isTemTokemAtivo()) {
            gtoke.gerarNovoToken();
        } else {
            System.out.println(gtoke.getToken());
        }
        ItfRespostaWebServiceSimples resposta1 = FabApiRestIntMatrixChatUsuarios.USUARIOS_STATUS.getAcao(gtoke.getUserID()).getResposta();
        if (!resposta1.isSucesso()) {
            gtoke.excluirToken();
            gtoke.gerarNovoToken();
        } else {
            System.out.println(resposta1.getRespostaTexto());
        }
//        ItfRespostaWebServiceSimples resposta2 = FabApiRestIntMatrixChatUsuarios.USUARIO_OBTER_TOKEN_LOGIN.getAcao(gtoke.getUserID()).getResposta();
        //      System.out.println(resposta2.getRespostaTexto());
    }

}
