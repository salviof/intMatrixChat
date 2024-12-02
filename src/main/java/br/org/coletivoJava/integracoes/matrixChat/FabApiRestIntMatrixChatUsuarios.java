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
public enum FabApiRestIntMatrixChatUsuarios implements ItfFabricaIntegracaoRest {

    @InfoConsumoRestService(getPachServico = "/_synapse/admin/v2/users/{0}",
            tipoConexao = FabTipoConexaoRest.PUT,
            tipoInformacaoRecebida = FabTipoArquivoImportacao.JSON,
            parametrosGet = {"useride"},
            parametrosPost = {"email", "password"},
            urlDocumentacao = "https://matrix-org.github.io/synapse/v1.59/admin_api/user_admin_api.html",
            adicionarAutenticacaoBearer = true)
    USUARIO_CRIAR,
    @InfoConsumoRestService(getPachServico = "/_synapse/admin/v2/users/{0}",
            tipoConexao = FabTipoConexaoRest.PUT,
            tipoInformacaoRecebida = FabTipoArquivoImportacao.JSON,
            parametrosGet = {"useride"},
            parametrosPost = {"username", "email", "password"},
            urlDocumentacao = "https://matrix-org.github.io/synapse/v1.59/admin_api/user_admin_api.html",
            adicionarAutenticacaoBearer = true)
    USUARIO_ADMIN_CRIAR,
    @InfoConsumoRestService(getPachServico = "/_synapse/admin/v2/users/{0}",
            tipoConexao = FabTipoConexaoRest.PUT,
            tipoInformacaoRecebida = FabTipoArquivoImportacao.JSON,
            parametrosGet = {"useride"},
            parametrosPost = {"username", "password"},
            urlDocumentacao = "https://matrix-org.github.io/synapse/v1.59/admin_api/user_admin_api.html")
    USUARIO_ATUALIZAR_SENHA,
    @InfoConsumoRestService(getPachServico = "/_synapse/admin/v2/users/{0}",
            tipoConexao = FabTipoConexaoRest.PUT,
            tipoInformacaoRecebida = FabTipoArquivoImportacao.JSON,
            parametrosGet = {"useride"},
            parametrosPost = {"nome", "email", "telefone"},
            urlDocumentacao = "https://matrix-org.github.io/synapse/v1.59/admin_api/user_admin_api.html",
            adicionarAutenticacaoBearer = true)
    USUARIO_ATUALIZAR,
    @InfoConsumoRestService(getPachServico = "/_synapse/admin/v2/users/{0}",
            tipoConexao = FabTipoConexaoRest.PUT,
            tipoInformacaoRecebida = FabTipoArquivoImportacao.JSON,
            parametrosGet = {"useride"},
            parametrosPost = {"novoID"},
            urlDocumentacao = "https://matrix-org.github.io/synapse/v1.59/admin_api/user_admin_api.html",
            adicionarAutenticacaoBearer = true)
    USUARIO_ATUALIZAR_ID,
    @InfoConsumoRestService(getPachServico = "/_synapse/admin/v1/deactivate/{0}",
            tipoConexao = FabTipoConexaoRest.POST,
            tipoInformacaoRecebida = FabTipoArquivoImportacao.JSON,
            parametrosGet = {"codigoUsuario"},
            urlDocumentacao = "https://matrix-org.github.io/synapse/v1.59/admin_api/user_admin_api.html",
            adicionarAutenticacaoBearer = true)
    USUARIO_REMOVER,
    @InfoConsumoRestService(getPachServico = "/_synapse/admin/v2/users/{0}",
            tipoConexao = FabTipoConexaoRest.GET,
            tipoInformacaoRecebida = FabTipoArquivoImportacao.JSON,
            parametrosGet = {"IDuSUARIO"},
            urlDocumentacao = "https://matrix-org.github.io/synapse/v1.59/admin_api/user_admin_api.html",
            adicionarAutenticacaoBearer = true)
    USUARIO_OBTER_DADOS,
    @InfoConsumoRestService(getPachServico = "/_synapse/admin/v1/threepid/msisdn/users/{0}",
            tipoConexao = FabTipoConexaoRest.GET,
            tipoInformacaoRecebida = FabTipoArquivoImportacao.JSON,
            parametrosGet = {"emailusuario"},
            urlDocumentacao = "https://matrix-org.github.io/synapse/v1.59/admin_api/user_admin_api.html",
            adicionarAutenticacaoBearer = true)
    USUARIO_OBTER_DADOS_BY_TELEFONE,
    @InfoConsumoRestService(getPachServico = "/_synapse/admin/v1/threepid/email/users/{0}",
            tipoConexao = FabTipoConexaoRest.GET,
            tipoInformacaoRecebida = FabTipoArquivoImportacao.JSON,
            parametrosGet = {"emailusuario"},
            urlDocumentacao = "https://matrix-org.github.io/synapse/v1.59/admin_api/user_admin_api.html",
            adicionarAutenticacaoBearer = true)
    USUARIO_OBTER_DADOS_BY_EMAIL,
    ///_synapse/admin/v1/rooms/<room_id>/members
    @InfoConsumoRestService(getPachServico = "/_synapse/admin/v1/rooms/{0}/members",
            tipoConexao = FabTipoConexaoRest.GET,
            tipoInformacaoRecebida = FabTipoArquivoImportacao.JSON,
            parametrosGet = {"ID_GRUPO"},
            urlDocumentacao = "https://matrix-org.github.io/synapse/latest/admin_api/rooms.html",
            adicionarAutenticacaoBearer = true)
    USUARIOS_DA_SALA,
    @InfoConsumoRestService(getPachServico = "/_synapse/admin/v2/users/{0}",
            tipoConexao = FabTipoConexaoRest.GET,
            tipoInformacaoRecebida = FabTipoArquivoImportacao.JSON,
            parametrosGet = {"IDuSUARIO"},
            urlDocumentacao = "https://matrix-org.github.io/synapse/v1.59/admin_api/user_admin_api.html",
            adicionarAutenticacaoBearer = true)
    USUARIOS_LISTAGEM,
    @InfoConsumoRestService(getPachServico = "/_matrix/client/v3/presence/{0}/status",
            tipoConexao = FabTipoConexaoRest.GET,
            tipoInformacaoRecebida = FabTipoArquivoImportacao.JSON,
            parametrosGet = {"IDuSUARIO"},
            aceitarCertificadoDeHostNaoConfiavel = true,
            urlDocumentacao
            = "https://www.matrix.org/docs/api/#get-/_matrix/client/v3/presence/-userId-/status",
            adicionarAutenticacaoBearer = true
    )
    USUARIOS_STATUS,
    @InfoConsumoRestService(getPachServico = "/_synapse/admin/v2/users/{0}",
            tipoConexao = FabTipoConexaoRest.GET,
            tipoInformacaoRecebida = FabTipoArquivoImportacao.JSON,
            parametrosGet = {"IDuSUARIO"},
            urlDocumentacao = "https://matrix-org.github.io/synapse/v1.59/admin_api/user_admin_api.html",
            adicionarAutenticacaoBearer = true)
    USUARIO_DEFINIR_ADMIN,
    @InfoConsumoRestService(getPachServico = "/_matrix/client/v3/profile/{0}",
            tipoConexao = FabTipoConexaoRest.GET,
            tipoInformacaoRecebida = FabTipoArquivoImportacao.JSON,
            parametrosGet = {"IDuSUARIO"},
            urlDocumentacao = "https://www.matrix.org/docs/api/#get-/_matrix/client/v3/presence/-userId-/status",
            adicionarAutenticacaoBearer = true)
    USUARIO_PROFILE,
<<<<<<< HEAD

=======
    ///_matrix/client/v1/register/m.login.registration_token/validity
    @InfoConsumoRestService(getPachServico = "/_matrix/client/v1/register/m.login.registration_token/validity",
            tipoConexao = FabTipoConexaoRest.GET,
            tipoInformacaoRecebida = FabTipoArquivoImportacao.JSON,
            urlDocumentacao = "https://www.matrix.org/docs/api/#get-/_matrix/client/v3/presence/-userId-/status",
            adicionarAutenticacaoBearer = true)
    USUARIO_VALIDACAO_TOKEN
>>>>>>> 8194b3e (Atualizacao automática)
}
