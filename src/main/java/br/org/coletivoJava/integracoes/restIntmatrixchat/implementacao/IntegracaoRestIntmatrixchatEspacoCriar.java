package br.org.coletivoJava.integracoes.restIntmatrixchat.implementacao;

import br.org.coletivoJava.integracoes.restIntmatrixchat.api.InfoIntegracaoRestIntmatrixchatSpaces;
import br.org.coletivoJava.integracoes.matrixChat.FabApiRestIntMatrixSpaces;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoUsuario;

@InfoIntegracaoRestIntmatrixchatSpaces(tipo = FabApiRestIntMatrixSpaces.ESPACO_CRIAR)
public class IntegracaoRestIntmatrixchatEspacoCriar
        extends
        AcaoApiIntegracaoAbstrato {

    public IntegracaoRestIntmatrixchatEspacoCriar(
            final FabTipoAgenteClienteApi pTipoAgente,
            final ComoUsuario pUsuario, final java.lang.Object... pParametro) {
        super(FabApiRestIntMatrixSpaces.ESPACO_CRIAR, pTipoAgente, pUsuario,
                pParametro);
    }

    @Override
    public String gerarCorpoRequisicao() {
        String nomeEspaço = (String) parametros.get(0);//The Grand Duke Pub
        String apelidoEspaco = (String) parametros.get(1);//thepub
        String corpo = "{ \"name\": \"" + nomeEspaço + "\",\n"
                + "  \"preset\": \"private_chat\",\n"
                + "  \"visibility\": \"private\",\n"
                + "  \"room_alias_name\": \"" + apelidoEspaco + "\",\n"
                + "  \"power_level_content_override\": {\n"
                + "    \"events_default\": 100,\n"
                + "    \"invite\": 50\n"
                + "  },\n"
                + "  \"creation_content\": {\n"
                + "    \"type\": \"m.space\"\n"
                + "  }\n"
                + "}";

        return corpo;
    }

}
