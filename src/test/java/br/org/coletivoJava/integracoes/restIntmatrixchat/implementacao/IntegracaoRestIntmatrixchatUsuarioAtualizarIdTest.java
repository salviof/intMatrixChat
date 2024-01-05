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
public class IntegracaoRestIntmatrixchatUsuarioAtualizarIdTest {

    public IntegracaoRestIntmatrixchatUsuarioAtualizarIdTest() {
    }

    /**
     * Test of gerarCorpoRequisicao method, of class
     * IntegracaoRestIntmatrixchatUsuarioAtualizarId.
     */
    @Test
    public void testGerarCorpoRequisicao() {

        SBCore.configurar(new ConfiguradorCoreMatrixChatIntegracao(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        if (!FabApiRestIntMatrixChatUsuarios.USUARIO_ATUALIZAR_ID.getGestaoToken().isTemTokemAtivo()) {
            FabApiRestIntMatrixChatUsuarios.USUARIO_ATUALIZAR_ID.getGestaoToken().gerarNovoToken();
        }

        ItfRespostaWebServiceSimples respostaAdmin = FabApiRestIntMatrixChatUsuarios.USUARIO_DEFINIR_ADMIN.getAcao("@salvio_furbino930:casanovadigital.com.br").getResposta();
        ItfRespostaWebServiceSimples resposta = FabApiRestIntMatrixChatUsuarios.USUARIO_ATUALIZAR_ID.getAcao("@salvio_furbino930:casanovadigital.com.br", "@salvio_furbino930RN:casanovadigital.com.br").getResposta();
        System.out.println(resposta.getRespostaTexto());
    }

}
