package br.org.coletivoJava.integracoes.restIntmatrixchat.implementacao;

import br.org.coletivoJava.integracoes.restIntmatrixchat.api.InfoIntegracaoRestIntmatrixchatNotificacoes;
import br.org.coletivoJava.integracoes.matrixChat.FabApiRestMatrixNotificacoes;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ComoUsuario;

@InfoIntegracaoRestIntmatrixchatNotificacoes(tipo = FabApiRestMatrixNotificacoes.MEUS_EVENTOS_SINCRONIZAR)
public class IntegracaoRestIntmatrixchatMeusEventosSincronizar
        extends
        AcaoApiIntegracaoAbstrato {

    public IntegracaoRestIntmatrixchatMeusEventosSincronizar(
            final FabTipoAgenteClienteApi pTipoAgente,
            final ComoUsuario pUsuario, final java.lang.Object... pParametro) {
        super(FabApiRestMatrixNotificacoes.MEUS_EVENTOS_SINCRONIZAR,
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
