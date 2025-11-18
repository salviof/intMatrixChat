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
public enum FabApiRestIntMatrixSpaces implements ComoFabricaIntegracaoRest {
    // https://matrix.casanovadigital.com.br   /_matrix/client/v3/rooms/!WNxhqanyFQutrEgzmc%3Acasanovadigital.com.br/state/m.space.child/!DSWyNGIiCEINZHBych%3Acasanovadigital.com.br
    @InfoConsumoRestService(getPachServico = "/_matrix/client/v3/rooms/{0}/state/m.space.child/{1}",
            tipoConexao = FabTipoConexaoRest.PUT,
            tipoInformacaoRecebida = FabTipoArquivoImportacao.JSON,
            parametrosGet = {"roomId", "roomFilhoID"},
            urlDocumentacao
            = "https://matrix-org.github.io/synapse/v1.59/admin_api/user_admin_api.html",
            adicionarAutenticacaoBearer = true
    )
    ESPACO_ADICIONAR_FILHO_DO_ESPACO,
    @InfoConsumoRestService(getPachServico = "/_matrix/client/v3/createRoom",
            tipoConexao = FabTipoConexaoRest.POST,
            tipoInformacaoRecebida = FabTipoArquivoImportacao.JSON,
            parametrosPost = {"nome", "apelido"},
            urlDocumentacao = "https://ma1uta.github.io/spec/client_server/unstable.html#post-matrix-client-r0-createroom",
            adicionarAutenticacaoBearer = true)
    ESPACO_CRIAR;

}
