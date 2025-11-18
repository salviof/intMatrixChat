/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
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
public enum FabApiRestMatrixNotificacoes implements ComoFabricaIntegracaoRest {

    @InfoConsumoRestService(getPachServico = "/_matrix/client/v3/notifications?limit=10&from={0}",
            tipoConexao = FabTipoConexaoRest.GET,
            tipoInformacaoRecebida = FabTipoArquivoImportacao.JSON,
            parametrosGet = {"from"},
            urlDocumentacao = "https://spec.matrix.org/v1.8/client-server-api/#listing-notifications",
            adicionarAutenticacaoBearer = true)
    MINHAS_NOTIFICACOES_LISTAR,
    @InfoConsumoRestService(getPachServico = "/_matrix/client/v3/sync?limit=10&from={0}",
            tipoConexao = FabTipoConexaoRest.GET,
            tipoInformacaoRecebida = FabTipoArquivoImportacao.JSON,
            parametrosGet = {"from"},
            urlDocumentacao = "https://spec.matrix.org/v1.8/client-server-api/#listing-notifications",
            adicionarAutenticacaoBearer = true)
    MEUS_EVENTOS_SINCRONIZAR,

}
