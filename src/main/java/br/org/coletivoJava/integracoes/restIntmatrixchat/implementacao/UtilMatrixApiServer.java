/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.coletivoJava.integracoes.restIntmatrixchat.implementacao;

import br.org.coletivoJava.integracoes.matrixChat.FabApiRestMatrixMedia;
import br.org.coletivoJava.integracoes.matrixChat.config.FabConfigApiMatrixChat;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.UtilGeral.UTilSBCoreInputs;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilSBCoreBytes;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilSBCoreJson;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilSBCoreStringValidador;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.RespostaWebServiceSimples;
import jakarta.json.JsonObject;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author salvio
 */
public class UtilMatrixApiServer {

    public static RespostaWebServiceSimples gerarRespostaWSTratamentoFino(RespostaWebServiceSimples pRespostaWSSemTratamento) {
        if (pRespostaWSSemTratamento == null) {
            return pRespostaWSSemTratamento;
        }
        if (UtilSBCoreStringValidador.isNuloOuEmbranco(pRespostaWSSemTratamento.getResposta())) {
            return pRespostaWSSemTratamento;
        }
        JsonObject json = UtilSBCoreJson.getJsonObjectByTexto(pRespostaWSSemTratamento.getResposta());
        if (json.containsKey("error")) {
            //M_FORBIDDEN
            String cofigoErro = json.getString("errcode");
            pRespostaWSSemTratamento.addErro("Erro código" + cofigoErro + ", " + json.getString("error"));
        }

        return pRespostaWSSemTratamento;
    }

    /**
     *
     * @param pURL Ex: mxc://casanovadigital.com.br/JlefQcrTuHwElyjmqZnZLgsP
     * @return
     */
    public static byte[] getMediaByteaIDByURIMatrix(String pURL) {

        String matrixMediaSemProtocolo = pURL.substring(6, pURL.length());
        String docminio = matrixMediaSemProtocolo.split("/")[0];
        String idMedia = matrixMediaSemProtocolo.split("/")[1];
        return getMediaBytesByID(idMedia);
    }

    public static byte[] getMediaBytesByID(String pId) {
        String dominioPR = SBCore.getConfigModulo(FabConfigApiMatrixChat.class).getPropriedade(FabConfigApiMatrixChat.DOMINIO_FEDERADO);
        String urlServidor = SBCore.getConfigModulo(FabConfigApiMatrixChat.class).getPropriedade(FabConfigApiMatrixChat.URL_MATRIX_SERVER);
        String token = FabApiRestMatrixMedia.DOWNLOAD_ARQUIVO.getGestaoToken().getToken();
        String segredo = SBCore.getConfigModulo(FabConfigApiMatrixChat.class).getPropriedade(FabConfigApiMatrixChat.SEGREDO);
        String urlRequisicao = urlServidor + "/_matrix/media/r0/download/" + dominioPR + "/" + pId;

        Map<String, String> cabecalho = new HashMap<>();
        cabecalho.put("Authorization", "Bearer " + token);
        cabecalho.put("segredo", segredo);
        cabecalho.put("Content-Type", "application/json");

        InputStream input = UTilSBCoreInputs.getStreamByURL(urlRequisicao, 5000, 15000, cabecalho);
        return UtilSBCoreBytes.gerarBytePorInputstream(input);
        //https://matrix.casanovadigital.com.br/_matrix/media/r0/download/casanovadigital.com.br/JlefQcrTuHwElyjmqZnZLgsP

    }
}
