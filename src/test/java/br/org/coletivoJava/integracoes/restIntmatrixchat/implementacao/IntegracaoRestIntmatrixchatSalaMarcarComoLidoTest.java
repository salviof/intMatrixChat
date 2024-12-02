/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.org.coletivoJava.integracoes.restIntmatrixchat.implementacao;

import br.org.coletivoJava.integracoes.matrixChat.FabApiRestIntMatrixChatSalas;
import br.org.coletivoJava.integracoes.matrixChat.config.FabConfigApiMatrixChat;
import com.super_bits.Super_Bits.mktMauticIntegracao.configAppp.ConfiguradorCoreMatrixChatIntegracao;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.ItfRespostaWebServiceSimples;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.token.ItfTokenGestao;
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
public class IntegracaoRestIntmatrixchatSalaMarcarComoLidoTest {

    public IntegracaoRestIntmatrixchatSalaMarcarComoLidoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of gerarCorpoRequisicao method, of class
     * IntegracaoRestIntmatrixchatSalaMarcarComoLido.
     */
    @Test
    public void testGerarCorpoRequisicao() {
        SBCore.configurar(new ConfiguradorCoreMatrixChatIntegracao(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        String valor = SBCore.getConfigModulo(FabConfigApiMatrixChat.class).getPropriedade(FabConfigApiMatrixChat.DOMINIO_FEDERADO);
        ItfTokenGestao tokenEcontrarById = FabApiRestIntMatrixChatSalas.SALA_ENCONTRAR_POR_ID.getGestaoToken();
        tokenEcontrarById.excluirToken();
        tokenEcontrarById.gerarNovoToken();

        ItfRespostaWebServiceSimples respostaDeclarandoLido = FabApiRestIntMatrixChatSalas.SALA_MARCAR_COMO_LIDO
                .getAcao("!QLOZIEkdxvNrMRxpfy:casanovadigital.com.br", "$RRBcTWhx1yNDeLrVM2Fr-pnLKqSxT1-ITMA4_vd4qbA").getResposta();
        System.out.println(respostaDeclarandoLido.getRespostaTexto());
        assertTrue("Falha notficando", respostaDeclarandoLido.isSucesso());
    }

}
