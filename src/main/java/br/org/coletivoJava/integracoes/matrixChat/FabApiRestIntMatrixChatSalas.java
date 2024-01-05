/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.org.coletivoJava.integracoes.matrixChat;

import br.org.coletivoJava.integracoes.matrixChat.config.FabConfigApiMatrixChat;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.ItfFabricaIntegracaoRest;
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
public enum FabApiRestIntMatrixChatSalas implements ItfFabricaIntegracaoRest {

    @InfoConsumoRestService(getPachServico = "/_synapse/admin/v1/rooms?search_term={0}",
            tipoConexao = FabTipoConexaoRest.GET,
            tipoInformacaoRecebida = FabTipoArquivoImportacao.JSON,
            parametrosGet = {"codigoGrupo"},
            urlDocumentacao = "https://matrix-org.github.io/synapse/latest/admin_api/rooms.html#list-room-api",
            adicionarAutenticacaoBearer = true)
    SALA_ENCONTRAR_POR_ID,
    @InfoConsumoRestService(getPachServico = "/_matrix/client/v3/directory/room/{0}",
            tipoConexao = FabTipoConexaoRest.PUT,
            tipoInformacaoRecebida = FabTipoArquivoImportacao.JSON,
            parametrosGet = {"apelido"},
            parametrosPost = {"IDRoom"},
            urlDocumentacao = "https://matrix-org.github.io/synapse/latest/admin_api/rooms.html#list-room-api",
            adicionarAutenticacaoBearer = true)
    SALA_VINCULAR_APELIDO_SALA_AO_ID,
    @InfoConsumoRestService(getPachServico = "/_matrix/client/v3/rooms/{0}/aliases",
            tipoConexao = FabTipoConexaoRest.GET,
            tipoInformacaoRecebida = FabTipoArquivoImportacao.JSON,
            parametrosGet = {"roomId"},
            urlDocumentacao = "https://matrix-org.github.io/synapse/latest/admin_api/rooms.html#list-room-api",
            adicionarAutenticacaoBearer = true)
    SALA_ALIASES,
    @InfoConsumoRestService(getPachServico = "/_synapse/admin/v1/rooms?search_term={0}",
            tipoConexao = FabTipoConexaoRest.GET,
            tipoInformacaoRecebida = FabTipoArquivoImportacao.JSON,
            parametrosGet = {"useride"},
            urlDocumentacao = "https://matrix-org.github.io/synapse/latest/admin_api/rooms.html#list-room-api",
            adicionarAutenticacaoBearer = true)

    SALA_ENCONTRAR_POR_NOME,
    @InfoConsumoRestService(getPachServico = "/_matrix/client/v3/directory/room/{0}",
            tipoConexao = FabTipoConexaoRest.GET,
            tipoInformacaoRecebida = FabTipoArquivoImportacao.JSON,
            parametrosGet = {"useride"},
            urlDocumentacao = "https://matrix-org.github.io/synapse/latest/admin_api/rooms.html#list-room-api",
            adicionarAutenticacaoBearer = true)
    SALA_ENCONTRAR_POR_ALIAS,
    @InfoConsumoRestService(getPachServico = "/_matrix/client/v3/createRoom",
            tipoConexao = FabTipoConexaoRest.POST,
            tipoInformacaoRecebida = FabTipoArquivoImportacao.JSON,
            parametrosPost = {"nome", "apelido"},
            urlDocumentacao = "https://ma1uta.github.io/spec/client_server/unstable.html#post-matrix-client-r0-createroom",
            adicionarAutenticacaoBearer = true)
    SALA_CRIAR,
    SALA_EXLUIR,
    @InfoConsumoRestService(getPachServico = "/_synapse/admin/v2/users/{0}",
            tipoConexao = FabTipoConexaoRest.PUT,
            tipoInformacaoRecebida = FabTipoArquivoImportacao.JSON,
            parametrosGet = {"useride"},
            parametrosPost = {"username", "email", "password"},
            urlDocumentacao = "https://matrix-org.github.io/synapse/v1.59/admin_api/user_admin_api.html",
            adicionarAutenticacaoBearer = true)
    SALA_ATUALIZAR,
    @InfoConsumoRestService(getPachServico = "/_synapse/admin/v1/join/{0}",
            tipoConexao = FabTipoConexaoRest.POST,
            tipoInformacaoRecebida = FabTipoArquivoImportacao.JSON,
            parametrosGet = {"useride"},
            urlDocumentacao = "https://matrix-org.github.io/synapse/latest/admin_api/room_membership.html",
            adicionarAutenticacaoBearer = true)
    SALA_ADICIONAR_USUARIO,
    @InfoConsumoRestService(getPachServico = "/_synapse/admin/v2/users/{0}",
            tipoConexao = FabTipoConexaoRest.GET,
            tipoInformacaoRecebida = FabTipoArquivoImportacao.JSON,
            parametrosGet = {"IDuSUARIO"},
            urlDocumentacao = "https://matrix-org.github.io/synapse/v1.59/admin_api/user_admin_api.html",
            adicionarAutenticacaoBearer = true)
    SALA_REMOVER_USUARIO,
    @InfoConsumoRestService(getPachServico = "/_matrix/client/r0/rooms/{0}/send/m.room.message/{1}",
            tipoConexao = FabTipoConexaoRest.PUT,
            tipoInformacaoRecebida = FabTipoArquivoImportacao.JSON,
            parametrosGet = {"roomId", "CODIGO_UNICOMENSAGEM"},
            parametrosPost = {"mensagem"},
            urlDocumentacao
            = "https://matrix-org.github.io/synapse/v1.59/admin_api/user_admin_api.html",
            adicionarAutenticacaoBearer = true
    )
    SALA_ENVIAR_MENSAGEM_TEXTO_SIMPLES,
    @InfoConsumoRestService(getPachServico = "/_matrix/client/r0/rooms/{0}/send/m.room.message/{1}",
            tipoConexao = FabTipoConexaoRest.PUT,
            tipoInformacaoRecebida = FabTipoArquivoImportacao.JSON,
            parametrosGet = {"roomId", "CODIGO_UNICOMENSAGEM"},
            parametrosPost = {"mensagem"},
            urlDocumentacao
            = "https://matrix-org.github.io/synapse/v1.59/admin_api/user_admin_api.html",
            adicionarAutenticacaoBearer = true
    )
    SALA_ENVIAR_MENSAGEM_IMAGEM,
    @InfoConsumoRestService(getPachServico = "/_matrix/client/r0/rooms/{0}/send/m.room.message/{1}",
            tipoConexao = FabTipoConexaoRest.PUT,
            tipoInformacaoRecebida = FabTipoArquivoImportacao.JSON,
            parametrosGet = {"roomId", "CODIGO_UNICOMENSAGEM"},
            parametrosPost = {"mensagem"},
            urlDocumentacao
            = "https://matrix-org.github.io/synapse/v1.59/admin_api/user_admin_api.html",
            adicionarAutenticacaoBearer = true
    )

    SALA_ENVIAR_MENSAGEM_DOCUMENTO,
    @InfoConsumoRestService(getPachServico = "/_matrix/client/r0/rooms/{0}/send/m.room.message/{1}",
            tipoConexao = FabTipoConexaoRest.PUT,
            tipoInformacaoRecebida = FabTipoArquivoImportacao.JSON,
            parametrosGet = {"roomId", "CODIGO_UNICOMENSAGEM"},
            parametrosPost = {"mensagem"},
            urlDocumentacao
            = "https://matrix-org.github.io/synapse/v1.59/admin_api/user_admin_api.html",
            adicionarAutenticacaoBearer = true
    )
    SALA_ENVIAR_MENSAGEM_VIDEO,
    @InfoConsumoRestService(getPachServico = "/_matrix/client/r0/rooms/{0}/send/m.room.message/{1}",
            tipoConexao = FabTipoConexaoRest.PUT,
            tipoInformacaoRecebida = FabTipoArquivoImportacao.JSON,
            parametrosGet = {"roomId", "CODIGO_UNICOMENSAGEM"},
            parametrosPost = {"mensagem"},
            urlDocumentacao
            = "https://matrix-org.github.io/synapse/v1.59/admin_api/user_admin_api.html",
            adicionarAutenticacaoBearer = true
    )
    SALA_ENVIAR_MENSAGEM_AUDIO,
    @InfoConsumoRestService(getPachServico = "/_matrix/client/r0/rooms/{0}/send/m.room.message/{1}",
            tipoConexao = FabTipoConexaoRest.PUT,
            tipoInformacaoRecebida = FabTipoArquivoImportacao.JSON,
            parametrosGet = {"roomId", "CODIGO_UNICOMENSAGEM"},
            parametrosPost = {"mensagem"},
            urlDocumentacao
            = "https://matrix-org.github.io/synapse/v1.59/admin_api/user_admin_api.html",
            adicionarAutenticacaoBearer = true
    )
    SALA_ADMIN_DEFINIR,
    @InfoConsumoRestService(getPachServico = "/_matrix/client/v3/rooms/{0}/state/m.room.name/",
            tipoConexao = FabTipoConexaoRest.PUT,
            tipoInformacaoRecebida = FabTipoArquivoImportacao.JSON,
            parametrosGet = {"roomId", "CODIGO_UNICOMENSAGEM"},
            parametrosPost = {"roomChild"},
            urlDocumentacao
            = "https://matrix-org.github.io/synapse/v1.59/admin_api/user_admin_api.html",
            adicionarAutenticacaoBearer = true
    )
    SALA_RENOMEAR,
    @InfoConsumoRestService(getPachServico = "/_matrix/client/v3/rooms/{0}/state/m.space.parent/{1}",
            tipoConexao = FabTipoConexaoRest.PUT,
            tipoInformacaoRecebida = FabTipoArquivoImportacao.JSON,
            parametrosGet = {"roomId", "CODIGO_UNICOMENSAGEM"},
            parametrosPost = {"roomChild"},
            urlDocumentacao
            = "https://matrix-org.github.io/synapse/v1.59/admin_api/user_admin_api.html",
            adicionarAutenticacaoBearer = true
    )
    SALA_DEFINIR_ESPACO_PAI;

}
