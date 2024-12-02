package br.org.coletivoJava.integracoes.restIntmatrixchat.implementacao;

import br.org.coletivoJava.integracoes.restIntmatrixchat.api.InfoIntegracaoRestIntmatrixchatSalas;
import br.org.coletivoJava.integracoes.matrixChat.FabApiRestIntMatrixChatSalas;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;

@InfoIntegracaoRestIntmatrixchatSalas(tipo = FabApiRestIntMatrixChatSalas.SALA_MARCAR_COMO_LIDO)
public class IntegracaoRestIntmatrixchatSalaMarcarComoLido
        extends
        AcaoApiIntegracaoAbstrato {

    public IntegracaoRestIntmatrixchatSalaMarcarComoLido(
            final FabTipoAgenteClienteApi pTipoAgente,
            final ItfUsuario pUsuario, final java.lang.Object... pParametro) {
        super(FabApiRestIntMatrixChatSalas.SALA_MARCAR_COMO_LIDO, pTipoAgente,
                pUsuario, pParametro);
    }

    @Override
    public String gerarUrlRequisicao() {
        String urlRequisicao = super.gerarUrlRequisicao(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody;
        return urlRequisicao;
    }

    @Override
    public String gerarCorpoRequisicao() {
        String codigoEvento = (String) getParametros()[1];
        //"{\"m.fully_read\":\"$czTJby_4gpdPthg0-wTbr2XnKBal-g9_PT8mKDjcjS8\",\"m.read\":\"$czTJby_4gpdPthg0-wTbr2XnKBal-g9_PT8mKDjcjS8\",\"m.read.private\":\"$czTJby_4gpdPthg0-wTbr2XnKBal-g9_PT8mKDjcjS8\"}";
        String corpo = "{\n"
                + "  \"m.fully_read\": \"" + codigoEvento + "\",\n"
                + "  \"m.read\": \"" + codigoEvento + "\",\n"
                + "  \"m.read.private\": \"" + codigoEvento + "\"\n"
                + "}";
        return corpo;
    }

}
