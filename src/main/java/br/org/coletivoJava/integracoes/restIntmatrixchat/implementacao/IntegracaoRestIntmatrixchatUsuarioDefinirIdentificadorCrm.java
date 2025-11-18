package br.org.coletivoJava.integracoes.restIntmatrixchat.implementacao;

import br.org.coletivoJava.integracoes.restIntmatrixchat.api.InfoIntegracaoRestIntmatrixchatUsuarios;
import br.org.coletivoJava.integracoes.matrixChat.FabApiRestIntMatrixChatUsuarios;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ComoUsuario;

@InfoIntegracaoRestIntmatrixchatUsuarios(tipo = FabApiRestIntMatrixChatUsuarios.USUARIO_DEFINIR_IDENTIFICADOR_CRM)
public class IntegracaoRestIntmatrixchatUsuarioDefinirIdentificadorCrm
        extends
        AcaoApiIntegracaoAbstrato {

    public IntegracaoRestIntmatrixchatUsuarioDefinirIdentificadorCrm(
            final FabTipoAgenteClienteApi pTipoAgente,
            final ComoUsuario pUsuario, final java.lang.Object... pParametro) {
        super(
                FabApiRestIntMatrixChatUsuarios.USUARIO_DEFINIR_IDENTIFICADOR_CRM,
                pTipoAgente, pUsuario, pParametro);
    }

    @Override
    public String gerarCorpoRequisicao() {
        return "{\n"
                + "          \"external_ids\": [\n"
                + "            {\n"
                + "              \"auth_provider\": \"oidc-casanova\",\n"
                + "              \"external_id\": \"" + getParametros()[1] + "\"\n"
                + "            }\n"
                + "          ]\n"
                + "        }";
    }

}
