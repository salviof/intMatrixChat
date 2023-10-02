package br.org.coletivoJava.integracoes.restIntmatrixchat.implementacao;

import br.org.coletivoJava.integracoes.restIntmatrixchat.api.InfoIntegracaoRestIntmatrixchatSalas;
import br.org.coletivoJava.integracoes.matrixChat.FabApiRestIntMatrixChatSalas;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;

@InfoIntegracaoRestIntmatrixchatSalas(tipo = FabApiRestIntMatrixChatSalas.SALA_CRIAR)
public class IntegracaoRestIntmatrixchatSalaCriar
        extends
        AcaoApiIntegracaoAbstrato {

    public IntegracaoRestIntmatrixchatSalaCriar(
            final FabTipoAgenteClienteApi pTipoAgente,
            final ItfUsuario pUsuario, final java.lang.Object... pParametro) {
        super(FabApiRestIntMatrixChatSalas.SALA_CRIAR, pTipoAgente, pUsuario,
                pParametro);
    }

    @Override
    public String gerarCorpoRequisicao() {
        String nomeSala = (String) parametros.get(0);//The Grand Duke Pub
        String apelidoSala = (String) parametros.get(1);//thepub
        if (apelidoSala.contains(":")) {
            apelidoSala = apelidoSala.substring(1, apelidoSala.indexOf(":"));
        }

        String corpo = "{\n"
                + "  \"preset\": \"public_chat\",\n"
                + "  \"name\": \"" + nomeSala + "\",\n"
                + "  \"room_alias_name\": \"" + apelidoSala + "\",\n"
                ///                + "  \"topic\": \"" + topico + "\",\n"
                + "  \"creation_content\": {\n"
                + "    \"m.federate\": false\n"
                + "  }\n"
                + "}";
        return corpo;
    }

}
