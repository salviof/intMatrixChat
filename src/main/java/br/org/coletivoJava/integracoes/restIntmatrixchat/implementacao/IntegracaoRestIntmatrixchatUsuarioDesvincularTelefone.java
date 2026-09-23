package br.org.coletivoJava.integracoes.restIntmatrixchat.implementacao;

import br.org.coletivoJava.integracoes.restIntmatrixchat.api.InfoIntegracaoRestIntmatrixchatUsuarios;
import br.org.coletivoJava.integracoes.matrixChat.FabApiRestIntMatrixChatUsuarios;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoUsuario;

@InfoIntegracaoRestIntmatrixchatUsuarios(tipo = FabApiRestIntMatrixChatUsuarios.USUARIO_DESVINCULAR_TELEFONE)
public class IntegracaoRestIntmatrixchatUsuarioDesvincularTelefone
        extends
        AcaoApiIntegracaoAbstrato {

    public IntegracaoRestIntmatrixchatUsuarioDesvincularTelefone(
            final FabTipoAgenteClienteApi pTipoAgente,
            final ComoUsuario pUsuario, final java.lang.Object... pParametro) {
        super(FabApiRestIntMatrixChatUsuarios.USUARIO_DESVINCULAR_TELEFONE,
                pTipoAgente, pUsuario, pParametro);
    }

    @Override
    public String gerarCorpoRequisicao() {
        if (getParametros().length != 2) {
            throw new UnsupportedOperationException("Parámetros inválidos, envie código e email do usuário");
        }

        String email = (String) getParametros()[1];
        if (!email.contains("@")) {
            throw new UnsupportedOperationException("email inválido");
        }
        String conteudo = "{\n"
                + "        \"threepids\": [\n"
                + "          { \"medium\": \"email\", \"address\": \"" + email + "\" }\n"
                + "        ]\n"
                + "      }";
        return conteudo;

    }

}
