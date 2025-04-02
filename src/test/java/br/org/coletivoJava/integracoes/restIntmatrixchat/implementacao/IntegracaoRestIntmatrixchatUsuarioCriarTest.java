package br.org.coletivoJava.integracoes.restIntmatrixchat.implementacao;

import br.org.coletivoJava.integracoes.matrixChat.FabApiRestIntMatrixChatUsuarios;
import br.org.coletivoJava.integracoes.restIntmatrixchat.UtilsbApiMatrixChat;
import com.super_bits.Super_Bits.mktMauticIntegracao.configAppp.ConfiguradorCoreMatrixChatIntegracao;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.ItfRespostaWebServiceSimples;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.token.ItfTokenGestao;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author salvio
 */
public class IntegracaoRestIntmatrixchatUsuarioCriarTest {

    public IntegracaoRestIntmatrixchatUsuarioCriarTest() {
    }

    @Test
    public void testSomeMethod() {
        SBCore.configurar(new ConfiguradorCoreMatrixChatIntegracao(), SBCore.ESTADO_APP.DESENVOLVIMENTO);

        if (!FabApiRestIntMatrixChatUsuarios.USUARIO_CRIAR.getGestaoToken().isTemTokemAtivo()) {
            FabApiRestIntMatrixChatUsuarios.USUARIO_CRIAR.getGestaoToken().gerarNovoToken();
        }
        //   System.out.println(FabApiRestIntMatrixChatUsuarios.USUARIO_REMOVER.getAcao("@salvio2:casanovadigital.com.br").getResposta().getRespostaTexto());

        ItfRespostaWebServiceSimples respostaTeste1 = FabApiRestIntMatrixChatUsuarios.USUARIO_CRIAR
                //        .getAcao(codigoUsuario, slugUsuario, "Wagner Mingote", "wagner@casanovadigital.com.br", "553121159755", "Comunic@=PIX").getResposta();
                .getAcao("@samuel:casanovadigital.com.br", "Samuel Filipe Viana", "samuel@casanovadigital.com.br", "5531986831481", "semSenha@123").getResposta();

        System.out.println(respostaTeste1.getRespostaTexto());

        String slugUsuario = "camila_bissiguini";
        String codigoUsuario = UtilsbApiMatrixChat.gerarCodigoBySlugUser(slugUsuario);

        ItfTokenGestao tokenGEstao = FabApiRestIntMatrixChatUsuarios.USUARIO_CRIAR.getGestaoToken();
        tokenGEstao.excluirToken();
        if (!tokenGEstao.isTemTokemAtivo()) {
            tokenGEstao.gerarNovoToken();
        }
        // System.out.println(FabApiRestIntMatrixChatUsuarios.USUARIO_REMOVER.getAcao("@salvio2:casanovadigital.com.br").getResposta().getRespostaTexto());

        ItfRespostaWebServiceSimples respostaTeste2 = FabApiRestIntMatrixChatUsuarios.USUARIO_CRIAR
                //        .getAcao(codigoUsuario, slugUsuario, "Wagner Mingote", "wagner@casanovadigital.com.br", "553121159755", "Comunic@=PIX").getResposta();
                .getAcao("@tiago_oliveira:casanovadigital.com.br", "Tiago Oliveira", "tiago@casanovadigital.com.br", "5531975741135", "ComunicacaoDigital@TMJ2025").getResposta();

        System.out.println(respostaTeste2.getRespostaTexto());

    }

}
