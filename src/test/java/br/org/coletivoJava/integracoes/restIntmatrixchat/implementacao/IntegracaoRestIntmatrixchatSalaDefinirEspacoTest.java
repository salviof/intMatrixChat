/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.org.coletivoJava.integracoes.restIntmatrixchat.implementacao;

import br.org.coletivoJava.integracoes.matrixChat.FabApiRestIntMatrixChatSalas;
import br.org.coletivoJava.integracoes.matrixChat.FabApiRestIntMatrixChatUsuarios;
import br.org.coletivoJava.integracoes.matrixChat.FabApiRestIntMatrixSpaces;
import com.super_bits.Super_Bits.mktMauticIntegracao.configAppp.ConfiguradorCoreMatrixChatIntegracao;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilCRCJson;
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
public class IntegracaoRestIntmatrixchatSalaDefinirEspacoTest {

    public IntegracaoRestIntmatrixchatSalaDefinirEspacoTest() {
    }

    @Before
    public void setUp() {
        SBCore.configurar(new ConfiguradorCoreMatrixChatIntegracao(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        ItfTokenGestao tokenEcontrarById = FabApiRestIntMatrixChatSalas.SALA_ENCONTRAR_POR_NOME.getGestaoToken();
        if (!tokenEcontrarById.isTemTokemAtivo()) {
            tokenEcontrarById.gerarNovoToken();
        }
    }

    /**
     * Test of gerarCorpoRequisicao method, of class
     * IntegracaoRestIntmatrixchatSalaDefinirEspaco.
     */
    @Test
    public void testGerarCorpoRequisicao() {
        ItfRespostaWebServiceSimples resp_criar_sala = FabApiRestIntMatrixSpaces.ESPACO_CRIAR.getAcao("Meu espaço testes", "meu_espaco_teste_api").getResposta();
        JsonObject usuarioSalvioJson = FabApiRestIntMatrixChatUsuarios.USUARIO_OBTER_DADOS_BY_EMAIL.getAcao("salvio@casanovadigital.com.br").getResposta().getRespostaComoObjetoJson();
        System.out.println(UtilCRCJson.getTextoByJsonObjeect(usuarioSalvioJson));
        String usuarioID = usuarioSalvioJson.getString("user_id");
        if (!resp_criar_sala.isSucesso()) {
            System.out.println(resp_criar_sala.getRespostaTexto());
            ItfRespostaWebServiceSimples resp_obterSala = FabApiRestIntMatrixChatSalas.SALA_ENCONTRAR_POR_ALIAS.getAcao("#meu_espaco_teste_api:casanovadigital.com.br").getResposta();
            System.out.println(resp_obterSala.getRespostaTexto());
            assertTrue("Falha obtendo sala por alias", resp_obterSala.isSucesso());
            if (resp_obterSala.isSucesso()) {
                System.out.println(resp_obterSala.getRespostaTexto());
                String roomidEspaço = resp_obterSala.getRespostaComoObjetoJson().getString("room_id");
                ItfRespostaWebServiceSimples detalhesSalaSpace = FabApiRestIntMatrixChatSalas.SALA_ENCONTRAR_POR_ID.getAcao(roomidEspaço).getResposta();
                System.out.println(detalhesSalaSpace.getRespostaTexto());
                ItfRespostaWebServiceSimples resp_criar_sala_filho = FabApiRestIntMatrixChatSalas.SALA_CRIAR.getAcao("SalaFilho03", "salaFilho3").getResposta();
                if (!resp_criar_sala_filho.isSucesso()) {
                    ItfRespostaWebServiceSimples resp_obterSalaFilho = FabApiRestIntMatrixChatSalas.SALA_ENCONTRAR_POR_ALIAS.getAcao("#salaFilho3:casanovadigital.com.br").getResposta();
                    String roomidFilho = resp_obterSalaFilho.getRespostaComoObjetoJson().getString("room_id");
                    System.out.println(FabApiRestIntMatrixChatSalas.SALA_ADICIONAR_USUARIO.getAcao(roomidEspaço, usuarioID).getResposta().getRespostaTexto());
                    System.out.println(FabApiRestIntMatrixChatSalas.SALA_ADICIONAR_USUARIO.getAcao(roomidFilho, usuarioID).getResposta().getRespostaTexto());
                    ItfRespostaWebServiceSimples resp_vincular = FabApiRestIntMatrixSpaces.ESPACO_ADICIONAR_FILHO_DO_ESPACO.getAcao(roomidEspaço, roomidFilho, roomidFilho).getResposta();
                    //     ItfRespostaWebServiceSimples resp_vincular2 = FabApiRestIntMatrixChatSalas.SALA_DEFINIR_ESPACO_PAI.getAcao(roomidFilho, roomidEspaço, roomidEspaço).getResposta();
                    System.out.println(resp_vincular.getRespostaTexto());
                    // System.out.println(resp_vincular2.getRespostaTexto());
                }

            }
        }
    }

}
