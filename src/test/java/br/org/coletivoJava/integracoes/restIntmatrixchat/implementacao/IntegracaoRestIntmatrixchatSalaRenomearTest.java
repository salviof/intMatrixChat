/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.org.coletivoJava.integracoes.restIntmatrixchat.implementacao;

import br.org.coletivoJava.integracoes.matrixChat.FabApiRestIntMatrixChatSalas;
import com.super_bits.Super_Bits.mktMauticIntegracao.configAppp.ConfiguradorCoreMatrixChatIntegracao;
import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilCRCJson;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.ItfRespostaWebServiceSimples;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.token.ItfTokenGestao;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.ItfResposta;
import com.super_bits.modulosSB.SBCore.modulos.objetos.validador.ErroValidacao;
import jakarta.json.JsonObject;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class IntegracaoRestIntmatrixchatSalaRenomearTest {

    public IntegracaoRestIntmatrixchatSalaRenomearTest() {
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
     * IntegracaoRestIntmatrixchatSalaRenomear.
     */
    @Test
    public void testGerarCorpoRequisicao() {
        SBCore.configurar(new ConfiguradorCoreMatrixChatIntegracao(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        ItfTokenGestao tokenEcontrarById = FabApiRestIntMatrixChatSalas.SALA_ENCONTRAR_POR_ID.getGestaoToken();

        if (!tokenEcontrarById.validarToken()) {
            tokenEcontrarById.excluirToken();
            tokenEcontrarById.gerarNovoToken();
        }
        JsonObject sala;
        try {
            sala = getSalaByNome("Sala testes");
            System.out.println(UtilCRCJson.getTextoByJsonObjeect(sala));
            String salaId = sala.getString("room_id");
            ItfRespostaWebServiceSimples resposta = FabApiRestIntMatrixChatSalas.SALA_RENOMEAR.getAcao(salaId, "Sala_testes_Renomeada").getResposta();
            System.out.println(resposta.getRespostaTexto());
        } catch (ErroValidacao ex) {
            Logger.getLogger(IntegracaoRestIntmatrixchatSalaRenomearTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public JsonObject getSalaByNome(String pNomeSala) throws ErroValidacao {
        ItfRespostaWebServiceSimples resposta = FabApiRestIntMatrixChatSalas.SALA_ENCONTRAR_POR_NOME.getAcao(pNomeSala).getResposta();
        if (!resposta.isSucesso()) {
            throw new ErroValidacao("Falha listando sala " + pNomeSala);
        }
        JsonObject respJson = resposta.getRespostaComoObjetoJson();

        System.out.println(resposta.isSucesso());
        if (!respJson.getJsonArray("rooms").isEmpty()) {
            JsonObject jsonSala = respJson.getJsonArray("rooms").get(0).asJsonObject();
            return jsonSala;
        } else {
            ItfRespostaWebServiceSimples respostaCRiandoSala = FabApiRestIntMatrixChatSalas.SALA_CRIAR
                    .getAcao(pNomeSala, "salaTestes").getResposta();
            JsonObject json = respostaCRiandoSala.getRespostaComoObjetoJson();
            if (!respostaCRiandoSala.isSucesso()) {
                System.out.println(respostaCRiandoSala.getRespostaTexto());
                throw new ErroValidacao("Falha criando sala " + pNomeSala);
            }
            if (json != null) {
                return json;
            }
            return null;

        }

    }
}
