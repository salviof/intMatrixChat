package br.org.coletivoJava.integracoes.restIntmatrixchat.implementacao;

import br.org.coletivoJava.integracoes.restIntmatrixchat.api.InfoIntegracaoRestIntmatrixchatSalas;
import br.org.coletivoJava.integracoes.matrixChat.FabApiRestIntMatrixChatSalas;
import br.org.coletivoJava.integracoes.matrixChat.config.FabConfigApiMatrixChat;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import java.util.Date;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoUsuario;

@InfoIntegracaoRestIntmatrixchatSalas(tipo = FabApiRestIntMatrixChatSalas.SALA_DEFINIR_ESPACO_PAI)
public class IntegracaoRestIntmatrixchatSalaDefinirEspacoPai
        extends
        AcaoApiIntegracaoAbstrato {

    public IntegracaoRestIntmatrixchatSalaDefinirEspacoPai(
            final FabTipoAgenteClienteApi pTipoAgente,
            final ComoUsuario pUsuario, final java.lang.Object... pParametro) {
        super(FabApiRestIntMatrixChatSalas.SALA_DEFINIR_ESPACO_PAI,
                pTipoAgente, pUsuario, pParametro);
    }

    @Override
    public String gerarUrlRequisicao() {

        String codigoMensagem = (String) getParametros()[1];
        String codigoFilho = (String) getParametros()[2];

        if (codigoMensagem == null) {
            codigoMensagem = String.valueOf((String.valueOf(new Date().getTime()) + codigoFilho).hashCode());
        }
        parametros.set(1, codigoMensagem);
///_matrix/client/v3/rooms/{0}/context/{1}
        String url = (getUrlServidor() + infoRest.getPachServico()).replace("{0}", (String) getParametros()[0]).replace("{1}", codigoMensagem);
        return super.gerarUrlRequisicao();

    }

    @Override
    public String gerarCorpoRequisicao() {
        String dominio = getConfiguracao().getPropriedade(FabConfigApiMatrixChat.DOMINIO_FEDERADO);

        String codigoPai = (String) getParametros()[2];

        if (!codigoPai.startsWith("!") || !codigoPai.contains(":" + dominio)) {
            throw new UnsupportedOperationException("o id da sala deve conter [!] e o dominio");
        }
        String corpo = "{\n"
                + "    \"type\": \"m.space.parent\",\n"
                + "    \"state_key\": \"" + codigoPai + "\",\n"
                + "    \"content\": {\n"
                + "        \"via\": [\"" + dominio + "\"]\n"
                + "    }\n"
                + "}";
        return corpo;
    }
}
