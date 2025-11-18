/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.coletivoJava.integracoes.matrixChat;

import br.org.coletivoJava.integracoes.matrixChat.config.FabConfigApiMatrixChat;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.ComoFabricaIntegracaoRest;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.FabTipoConexaoRest;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.InfoConsumoRestService;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.servicoRegistrado.FabTipoAutenticacaoRest;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.servicoRegistrado.InfoConfigRestClientIntegracao;
import com.super_bits.modulosSB.SBCore.modulos.ManipulaArquivo.importacao.FabTipoArquivoImportacao;

/**
 *
 * @author salvio
 */
@InfoConfigRestClientIntegracao(enderecosDocumentacao = "https://spec.matrix.org/v1.8/client-server-api/",
        tipoAutenticacao = FabTipoAutenticacaoRest.CHAVE_ACESSO_METODOLOGIA_PROPRIA,
        nomeIntegracao = FabConfigApiMatrixChat.NOME_INTEGRACAO,
        configuracao = FabConfigApiMatrixChat.class
)
public enum FabApiRestMatrixMedia implements ComoFabricaIntegracaoRest {
//
    @InfoConsumoRestService(getPachServico = "/_matrix/media/r0/upload?filename={0}",
            tipoConexao = FabTipoConexaoRest.POST,
            tipoInformacaoRecebida = FabTipoArquivoImportacao.JSON,
            parametrosGet = {"filename"},
            parametrosPost = {"byte"},
            corpoRequisicaoEmBytes = true,
            urlDocumentacao = "https://matrix-org.github.io/synapse/v1.59/admin_api/user_admin_api.html",
            adicionarAutenticacaoBearer = true)
    UPLOAD_ARQUIVO,
    @InfoConsumoRestService(getPachServico = "/_matrix/media/r0/download/{0}/{1}",
            tipoConexao = FabTipoConexaoRest.GET,
            tipoInformacaoRecebida = FabTipoArquivoImportacao.JSON,
            parametrosGet = {"serverName", "mediaId"},
            corpoRequisicaoEmBytes = true,
            urlDocumentacao = "https://matrix-org.github.io/synapse/v1.59/admin_api/user_admin_api.html",
            adicionarAutenticacaoBearer = true)
    DOWNLOAD_ARQUIVO,

}
