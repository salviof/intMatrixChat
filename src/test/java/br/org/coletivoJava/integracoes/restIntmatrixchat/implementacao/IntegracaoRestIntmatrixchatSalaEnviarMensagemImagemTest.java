/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.org.coletivoJava.integracoes.restIntmatrixchat.implementacao;

import br.org.coletivoJava.integracoes.matrixChat.FabApiRestIntMatrixChatSalas;
import br.org.coletivoJava.integracoes.matrixChat.FabApiRestIntMatrixChatUsuarios;
import com.super_bits.Super_Bits.mktMauticIntegracao.configAppp.ConfiguradorCoreMatrixChatIntegracao;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.ItfRespostaWebServiceSimples;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.token.ItfTokenGestao;
import jakarta.json.JsonObject;
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
public class IntegracaoRestIntmatrixchatSalaEnviarMensagemImagemTest {

    public IntegracaoRestIntmatrixchatSalaEnviarMensagemImagemTest() {
    }

    private final static String URI_ARQUIVO = "mxc://casanovadigital.com.br/oKvcoWAwbqYOBrrebwzXNHME";
    private static final String NOME_SALA = "testesEnvioMedia";
    private final String NOME_SALA_DESCRICAO = "Sala teste descricao";

    /**
     * Test of gerarCorpoRequisicao method, of class
     * IntegracaoRestIntmatrixchatSalaEnviarMensagemImagem.
     */
    @Test
    public void testGerarCorpoRequisicao() {
        SBCore.configurar(new ConfiguradorCoreMatrixChatIntegracao(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        ItfTokenGestao tokenEcontrarById = FabApiRestIntMatrixChatSalas.SALA_ENCONTRAR_POR_ID.getGestaoToken();
        if (!tokenEcontrarById.isTemTokemAtivo()) {
            tokenEcontrarById.gerarNovoToken();
        }
        JsonObject salaJsonEntregada = getSalaByNome(NOME_SALA);
        String codigoSala = null;
        if (salaJsonEntregada != null) {
            codigoSala = salaJsonEntregada.getString("room_id");

        } else {
            Assert.fail("Sala não encontrada");
        }
        ItfRespostaWebServiceSimples respGetUsuario = FabApiRestIntMatrixChatUsuarios.USUARIO_OBTER_DADOS_BY_EMAIL.getAcao("salvio@casanovadigital.com.br").getResposta();
        System.out.println(respGetUsuario.getRespostaTexto());
        JsonObject usuario = respGetUsuario.getRespostaComoObjetoJson();
        String codigoUsuario = usuario.getString("user_id");
        System.out.println(respGetUsuario.getRespostaTexto());
        ItfRespostaWebServiceSimples respAddUsuario = FabApiRestIntMatrixChatSalas.SALA_ADICIONAR_USUARIO.getAcao(codigoSala, codigoUsuario).getResposta();
        System.out.println(respAddUsuario.getRespostaTexto());
        ItfRespostaWebServiceSimples resp = FabApiRestIntMatrixChatSalas.SALA_ENVIAR_MENSAGEM_IMAGEM.getAcao(codigoSala, "Arquivo teste", null, URI_ARQUIVO).getResposta();
        System.out.println(resp.getRespostaTexto());

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
