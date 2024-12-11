/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.org.coletivoJava.integracoes.restIntmatrixchat.implementacao;

import br.org.coletivoJava.integracoes.matrixChat.config.FabConfigApiMatrixChat;
import com.super_bits.Super_Bits.mktMauticIntegracao.configAppp.ConfiguradorCoreMatrixChatIntegracao;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilSBCoreOutputs;
import org.junit.Test;

/**
 *
 * @author salvio
 */
public class IntegracaoRestIntmatrixchatDownloadArquivoTest {

    public IntegracaoRestIntmatrixchatDownloadArquivoTest() {
    }

    @Test
    public void testSomeMethod() {
        //https://matrix.laudycardio.com.br/_matrix/media/r0/download/laudycardio.com.br/JlefQcrTuHwElyjmqZnZLgsP

        SBCore.configurar(new ConfiguradorCoreMatrixChatIntegracao(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        String matrixUri = "mxc://casanovadigital.com.br/JlefQcrTuHwElyjmqZnZLgsP";
        String matrixMediaSemProtocolo = matrixUri.substring(6, matrixUri.length());
        String dominioPR = SBCore.getConfigModulo(FabConfigApiMatrixChat.class).getPropriedade(FabConfigApiMatrixChat.DOMINIO_FEDERADO);
        String docminio = matrixMediaSemProtocolo.split("/")[0];
        String idMedia = matrixMediaSemProtocolo.split("/")[1];
        byte[] arquivo = UtilMatrixApiServer.getMediaBytesByID(idMedia);

        UtilSBCoreOutputs.salvarArquivoByte(arquivo, "/home/salvio/Downloads/teste.png");
    }

}
