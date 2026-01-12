package br.org.coletivoJava.integracoes.restIntmatrixchat.implementacao;

import br.org.coletivoJava.integracoes.restIntmatrixchat.api.InfoIntegracaoRestIntmatrixchatSalas;
import br.org.coletivoJava.integracoes.matrixChat.FabApiRestIntMatrixChatSalas;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import java.util.Date;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoUsuario;

@InfoIntegracaoRestIntmatrixchatSalas(tipo = FabApiRestIntMatrixChatSalas.SALA_ENVIAR_MENSAGEM_AUDIO)
public class IntegracaoRestIntmatrixchatSalaEnviarMensagemAudio
        extends
        AcaoApiIntegracaoAbstrato {

    public IntegracaoRestIntmatrixchatSalaEnviarMensagemAudio(
            final FabTipoAgenteClienteApi pTipoAgente,
            final ComoUsuario pUsuario, final java.lang.Object... pParametro) {
        super(FabApiRestIntMatrixChatSalas.SALA_ENVIAR_MENSAGEM_AUDIO,
                pTipoAgente, pUsuario, pParametro);
    }

    @Override
    public String gerarUrlRequisicao() {
        if (parametros.get(1) == null) {

            parametros.set(1, String.valueOf(new Date().hashCode()) + parametros.get(2).hashCode());
        }
        String url = super.gerarUrlRequisicao();

        return url;
    }

    @Override
    public String gerarCorpoRequisicao() {
        String pMensagem = (String) parametros.get(1);
        String url = (String) parametros.get(3);

        String corpo
                = "{\n"
                + "    \"body\": \"" + pMensagem + "\",\n"
                + "    \"msgtype\": \"m.audio\",\n"
                + "    \"url\": \"" + url + "\"\n"
                + "  }\n";

        System.out.println(corpo);
        return corpo;

    }
}
