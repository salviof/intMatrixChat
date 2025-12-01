/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.org.coletivoJava.integracoes.restIntmatrixchat.implementacao;

import br.org.coletivoJava.integracoes.matrixChat.FabApiRestIntMatrixChatSalas;
import br.org.coletivoJava.integracoes.matrixChat.config.FabConfigApiMatrixChat;
import com.super_bits.Super_Bits.mktMauticIntegracao.configAppp.ConfiguradorCoreMatrixChatIntegracao;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilCRCJson;
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
public class IntegracaoRestIntmatrixchatSalaObterUltimoEventoTest {

    public IntegracaoRestIntmatrixchatSalaObterUltimoEventoTest() {
    }

    @Before
    public void setUp() {
        SBCore.configurar(new ConfiguradorCoreMatrixChatIntegracao(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSomeMethod() {

        String valor = SBCore.getConfigModulo(FabConfigApiMatrixChat.class).getPropriedade(FabConfigApiMatrixChat.DOMINIO_FEDERADO);
        ItfTokenGestao tokenEcontrarById = FabApiRestIntMatrixChatSalas.SALA_ENCONTRAR_POR_ID.getGestaoToken();
        tokenEcontrarById.excluirToken();
        tokenEcontrarById.gerarNovoToken();
        assertTrue("Falha obtendo token", tokenEcontrarById.isTemTokemAtivo());
        ItfRespostaWebServiceSimples respUltimoEvento = FabApiRestIntMatrixChatSalas.SALA_OBTER_ULTIMO_EVENTO
                .getAcao("!QLOZIEkdxvNrMRxpfy:casanovadigital.com.br").getResposta();
        String ultimoEvento
                = UtilCRCJson.getValorApartirDoCaminho("chunk[0].event_id", respUltimoEvento.getRespostaComoObjetoJson());
        System.out.println(ultimoEvento);
        System.out.println(respUltimoEvento.getRespostaTexto());
        assertTrue("Falha notficando", respUltimoEvento.isSucesso());
    }

}
