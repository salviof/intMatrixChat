package br.org.coletivoJava.integracoes.restIntmatrixchat.implementacao;

import br.org.coletivoJava.integracoes.restIntmatrixchat.api.InfoIntegracaoRestIntmatrixchatMedia;
import br.org.coletivoJava.integracoes.matrixChat.FabApiRestMatrixMedia;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilCRCBytes;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.modulos.ManipulaArquivo.FabTipoArquivoConhecido;
import java.io.InputStream;
import java.util.Map;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ComoUsuario;

@InfoIntegracaoRestIntmatrixchatMedia(tipo = FabApiRestMatrixMedia.UPLOAD_ARQUIVO)
public class IntegracaoRestIntmatrixchatUploadArquivo
        extends
        AcaoApiIntegracaoAbstrato {

    public IntegracaoRestIntmatrixchatUploadArquivo(
            final FabTipoAgenteClienteApi pTipoAgente,
            final ComoUsuario pUsuario, final java.lang.Object... pParametro) {
        super(FabApiRestMatrixMedia.UPLOAD_ARQUIVO, pTipoAgente, pUsuario,
                pParametro);
    }

    @Override
    public String gerarUrlRequisicao() {
        String urlRequisicao = super.gerarUrlRequisicao();
        return urlRequisicao;
    }

    @Override
    public Map<String, String> gerarCabecalho() {
        Map<String, String> cabecalho = super.gerarCabecalho();
        FabTipoArquivoConhecido tipo = FabTipoArquivoConhecido.getTipoArquivoByNomeArquivo((String) getParametros()[0]);
        cabecalho.put("Content-Type", tipo.getTipoConteudoRespostaHTML());
        return cabecalho;
    }

    @Override
    public String gerarCorpoRequisicao() {

        return null;
    }

    @Override
    public byte[] gerarBytesCorpoRequisicao() {
        InputStream istream = (InputStream) getParametros()[1];
        byte[] bytes = UtilCRCBytes.gerarBytePorInputstream(istream);
        return bytes;
    }

}
