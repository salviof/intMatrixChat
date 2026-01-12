package br.org.coletivoJava.integracoes.restIntmatrixchat.implementacao;

import br.org.coletivoJava.integracoes.restIntmatrixchat.api.InfoIntegracaoRestIntmatrixchatSpaces;
import br.org.coletivoJava.integracoes.matrixChat.FabApiRestIntMatrixSpaces;
import br.org.coletivoJava.integracoes.matrixChat.config.FabConfigApiMatrixChat;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import java.util.Date;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoUsuario;

@InfoIntegracaoRestIntmatrixchatSpaces(tipo = FabApiRestIntMatrixSpaces.ESPACO_ADICIONAR_FILHO_DO_ESPACO)
public class IntegracaoRestIntmatrixchatEspacoAdicionarFilhoDoEspaco
        extends
        AcaoApiIntegracaoAbstrato {

    public IntegracaoRestIntmatrixchatEspacoAdicionarFilhoDoEspaco(
            final FabTipoAgenteClienteApi pTipoAgente,
            final ComoUsuario pUsuario, final java.lang.Object... pParametro) {
        super(FabApiRestIntMatrixSpaces.ESPACO_ADICIONAR_FILHO_DO_ESPACO,
                pTipoAgente, pUsuario, pParametro);
    }

    @Override
    public String gerarUrlRequisicao() {

        String url = super.gerarUrlRequisicao();
        return url;

    }

    @Override
    public String gerarCorpoRequisicao() {
        String dominio = getConfiguracao().getPropriedade(FabConfigApiMatrixChat.DOMINIO_FEDERADO);

        String codigoFilho = (String) getParametros()[1];

        if (!codigoFilho.startsWith("!") || !codigoFilho.contains(":" + dominio)) {
            throw new UnsupportedOperationException("o id da sala deve conter [!] e o dominio");
        }
        String corpo = "{\"via\":[\"" + dominio + "\"],\"suggested\":false}";
        return corpo;
    }
}
