/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.org.coletivoJava.integracoes.restIntmatrixchat.implementacao;

import br.org.coletivoJava.integracoes.matrixChat.FabApiRestIntMatrixChatSalas;
import com.super_bits.Super_Bits.mktMauticIntegracao.configAppp.ConfiguradorCoreMatrixChatIntegracao;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.ItfRespostaWebServiceSimples;
import jakarta.json.JsonObject;
import org.junit.Test;

/**
 *
 * @author salvio
 */
public class IntegracaoRestIntmatrixchatSalaEnviarMensagemTextoSimplesTest {

    public IntegracaoRestIntmatrixchatSalaEnviarMensagemTextoSimplesTest() {
    }
    private final String nomeSala = "sala teste";
    private final String nomeSalaD = "Sala teste descricao";

    /**
     * Test of gerarUrlRequisicao method, of class
     * IntegracaoRestIntmatrixchatSalaEnviarMensagemTextoSimples.
     */
    @Test
    public void testGerarUrlRequisicao() {
        SBCore.configurar(new ConfiguradorCoreMatrixChatIntegracao(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        JsonObject salaJson2 = getSalaByNome("wtzapsolucao553184178550");
        String cd = salaJson2.getString("room_id");
        //"#wtzapsolucao553184178550:casanovadigital.com.br";//
        ItfRespostaWebServiceSimples resp2 = FabApiRestIntMatrixChatSalas.SALA_ENVIAR_MENSAGEM_TEXTO_SIMPLES.
                getAcao(cd, null, "MensagemTEste").getResposta();
        System.out.println(resp2.getRespostaTexto());
        JsonObject salaJsonEntregada = getSalaByNome(nomeSala);
        String codigoSala;
        if (salaJsonEntregada != null) {
            codigoSala = salaJsonEntregada.getString("room_id");

        } else {
            ItfRespostaWebServiceSimples resposta = FabApiRestIntMatrixChatSalas.SALA_CRIAR.getAcao(nomeSala, nomeSalaD).getResposta();
            JsonObject json = resposta.getRespostaComoObjetoJson();
            codigoSala = json.getString("room_id");
        }

        ItfRespostaWebServiceSimples resp = FabApiRestIntMatrixChatSalas.SALA_ENVIAR_MENSAGEM_TEXTO_SIMPLES.getAcao(codigoSala, null, "MensagemTEste").getResposta();
        System.out.println(resp.getRespostaTexto());

    }

    public JsonObject getSalaByNome(String pNomeSala) {
        ItfRespostaWebServiceSimples resposta = FabApiRestIntMatrixChatSalas.SALA_ENCONTRAR_POR_NOME.getAcao(pNomeSala).getResposta();
        JsonObject respJson = resposta.getRespostaComoObjetoJson();
        if (!respJson.getJsonArray("rooms").isEmpty()) {
            JsonObject jsonSala = respJson.getJsonArray("rooms").get(0).asJsonObject();
            return jsonSala;
        }
        return null;

    }

    public JsonObject getSalaByID(String pNomeSala) {
        ItfRespostaWebServiceSimples resposta = FabApiRestIntMatrixChatSalas.SALA_ENCONTRAR_POR_ID.getAcao(pNomeSala).getResposta();
        JsonObject respJson = resposta.getRespostaComoObjetoJson();
        if (!respJson.getJsonArray("rooms").isEmpty()) {
            JsonObject jsonSala = respJson.getJsonArray("rooms").get(0).asJsonObject();
            return jsonSala;
        }
        return null;

    }

}
