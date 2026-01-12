package br.org.coletivoJava.integracoes.restIntmatrixchat.implementacao;

import br.org.coletivoJava.integracoes.restIntmatrixchat.api.InfoIntegracaoRestIntmatrixchatNotificacoes;
import br.org.coletivoJava.integracoes.matrixChat.FabApiRestMatrixNotificacoes;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoUsuario;

@InfoIntegracaoRestIntmatrixchatNotificacoes(tipo = FabApiRestMatrixNotificacoes.MINHAS_NOTIFICACOES_LISTAR)
public class IntegracaoRestIntmatrixchatMinhasNotificacoesListar
        extends
        AcaoApiIntegracaoAbstrato {

    public IntegracaoRestIntmatrixchatMinhasNotificacoesListar(
            final FabTipoAgenteClienteApi pTipoAgente,
            final ComoUsuario pUsuario, final java.lang.Object... pParametro) {
        super(FabApiRestMatrixNotificacoes.MINHAS_NOTIFICACOES_LISTAR,
                pTipoAgente, pUsuario, pParametro);
    }

    @Override
    public String gerarUrlRequisicao() {
        String url;
        if (getParametros().length > 0 && getParametros()[0] != null) {
            url = super.gerarUrlRequisicao();
        } else {
            url = getUrlServidor() + infoRest.getPachServico();
            url = url.replace("&from={0}", "");
        }

        return url;
    }

    @Override
    public String gerarCorpoRequisicao() {
        return super.gerarCorpoRequisicao(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
