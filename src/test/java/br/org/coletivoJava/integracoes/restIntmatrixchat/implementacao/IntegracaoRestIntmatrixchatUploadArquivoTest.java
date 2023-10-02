/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.org.coletivoJava.integracoes.restIntmatrixchat.implementacao;

import br.org.coletivoJava.integracoes.matrixChat.FabApiRestIntMatrixChatSalas;
import br.org.coletivoJava.integracoes.matrixChat.FabApiRestMatrixMedia;
import com.super_bits.Super_Bits.mktMauticIntegracao.configAppp.ConfiguradorCoreMatrixChatIntegracao;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.UtilGeral.UTilSBCoreInputs;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilSBCoreResources;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.ItfRespostaWebServiceSimples;
import jakarta.json.JsonObject;
import java.io.InputStream;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author salvio
 */
public class IntegracaoRestIntmatrixchatUploadArquivoTest {

    private static final String NOME_SALA = "testesEnvioMedia";
    private final String NOME_SALA_DESCRICAO = "Sala teste descricao";

    public IntegracaoRestIntmatrixchatUploadArquivoTest() {
    }

    @Test
    public void testSomeMethod() {

        SBCore.configurar(new ConfiguradorCoreMatrixChatIntegracao(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        JsonObject salaJson2 = getSalaByNome(NOME_SALA);
        String roomID = null;
        if (salaJson2 != null) {
            roomID = salaJson2.getString("room_id");
        } else {
            throw new UnsupportedOperationException("");
        }
        //"#wtzapsolucao553184178550:casanovadigital.com.br";//

        JsonObject salaJsonEntregada = getSalaByNome(NOME_SALA);
        String codigoSala = "";
        if (salaJsonEntregada != null) {
            codigoSala = salaJsonEntregada.getString("room_id");

        } else {
            Assert.fail("Sala não encontrada");
        }
        InputStream istream = IntegracaoRestIntmatrixchatUploadArquivo.class.getResourceAsStream("/upload/logo_negativa_300_CND.png");
        ItfRespostaWebServiceSimples resp = FabApiRestMatrixMedia.UPLOAD_ARQUIVO.getAcao("logoCasanova.png",
                istream).getResposta();
        System.out.println(resp.getRespostaTexto());

        if (!resp.isSucesso()) {
            System.out.println("Falha enviando arquiv");
            Assert.fail("Falha enviando arquivo");
        } else {
            System.out.println("Arquivo Enviado com sucesso");
        }
        String uriImagem = resp.getRespostaComoObjetoJson().getString("content_uri");

        ItfRespostaWebServiceSimples respEnvioImagem = FabApiRestIntMatrixChatSalas.SALA_ENVIAR_MENSAGEM_IMAGEM.
                getAcao(codigoSala, null, "Mensagem teste updates",
                        uriImagem)
                .getResposta();
        System.out.println(respEnvioImagem.getRespostaTexto());

    }

    public JsonObject getSalaByNome(String pNomeSala) {
        ItfRespostaWebServiceSimples resposta = FabApiRestIntMatrixChatSalas.SALA_ENCONTRAR_POR_NOME.getAcao(pNomeSala).getResposta();
        JsonObject respJson = resposta.getRespostaComoObjetoJson();
        if (!respJson.getJsonArray("rooms").isEmpty()) {
            JsonObject jsonSala = respJson.getJsonArray("rooms").get(0).asJsonObject();
            return jsonSala;
        } else {
            ItfRespostaWebServiceSimples respostaCRiandoSala = FabApiRestIntMatrixChatSalas.SALA_CRIAR
                    .getAcao(NOME_SALA, NOME_SALA_DESCRICAO).getResposta();
            JsonObject json = respostaCRiandoSala.getRespostaComoObjetoJson();
            if (json != null) {
                return json;
            }
            return null;

        }

    }
}
