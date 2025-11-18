package br.org.coletivoJava.integracoes.restIntmatrixchat.implementacao;

import br.org.coletivoJava.integracoes.restIntmatrixchat.api.InfoIntegracaoRestIntmatrixchatSalas;
import br.org.coletivoJava.integracoes.matrixChat.FabApiRestIntMatrixChatSalas;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilSBCoreJson;
import com.super_bits.modulosSB.SBCore.UtilGeral.json.ErroProcessandoJson;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.RespostaWebServiceSimples;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import java.util.Date;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ComoUsuario;

@InfoIntegracaoRestIntmatrixchatSalas(tipo = FabApiRestIntMatrixChatSalas.SALA_ENVIAR_MENSAGEM_TEXTO_SIMPLES)
public class IntegracaoRestIntmatrixchatSalaEnviarMensagemTextoSimples
        extends
        AcaoApiIntegracaoAbstrato {

    public IntegracaoRestIntmatrixchatSalaEnviarMensagemTextoSimples(
            final FabTipoAgenteClienteApi pTipoAgente,
            final ComoUsuario pUsuario, final java.lang.Object... pParametro) {
        super(FabApiRestIntMatrixChatSalas.SALA_ENVIAR_MENSAGEM_TEXTO_SIMPLES,
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
        String pMensagem = (String) parametros.get(2);
        try {
            String jsonTexto = UtilSBCoreJson.getJsonStringBySequenciaChaveValor("body", pMensagem, "msgtype", "m.text");

            return jsonTexto;
        } catch (ErroProcessandoJson ex) {
            return null;
        }
    }

    @Override
    protected RespostaWebServiceSimples gerarRespostaTratamentoFino(RespostaWebServiceSimples pRespostaWSSemTratamento) {
        return UtilMatrixApiServer.gerarRespostaWSTratamentoFino(pRespostaWSSemTratamento);
    }

}
