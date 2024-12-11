/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.org.coletivoJava.integracoes.restIntmatrixchat.implementacao;

import br.org.coletivoJava.integracoes.matrixChat.FabApiRestIntMatrixChatUsuarios;
import br.org.coletivoJava.integracoes.matrixChat.FabApiRestInteMatrixChatDirect;
import com.super_bits.Super_Bits.mktMauticIntegracao.configAppp.ConfiguradorCoreMatrixChatIntegracao;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.ItfRespostaWebServiceSimples;
import org.junit.Test;

/**
 *
 * @author salvio
 */
public class IntegracaoRestIntmatrixchatDirectCriarSalaTest {

    public IntegracaoRestIntmatrixchatDirectCriarSalaTest() {
    }

    @Test
    public void testGerarCorpoRequisicao() {
        SBCore.configurar(new ConfiguradorCoreMatrixChatIntegracao(), SBCore.ESTADO_APP.DESENVOLVIMENTO);

        GestaoTokenRestIntmatrixchat gtoke = (GestaoTokenRestIntmatrixchat) FabApiRestIntMatrixChatUsuarios.USUARIO_OBTER_DADOS.getGestaoToken();
        if (!gtoke.isTemTokemAtivo()) {
            gtoke.gerarNovoToken();
        }
        ItfRespostaWebServiceSimples respostaAliasUsuario = FabApiRestIntMatrixChatUsuarios.USUARIO_OBTER_DADOS_BY_EMAIL.getAcao("salvio@casanovadigital.com.br").getResposta();
        System.out.println(respostaAliasUsuario.getRespostaTexto());
        String userIdUsuario1 = respostaAliasUsuario.getRespostaComoObjetoJson().getString("user_id");
        ItfRespostaWebServiceSimples respostaAliasUsuario2 = FabApiRestIntMatrixChatUsuarios.USUARIO_OBTER_DADOS_BY_EMAIL.getAcao("auxiliadora@casanovadigital.com.br").getResposta();
        System.out.println(respostaAliasUsuario2.getRespostaTexto());
        String userIdUsuario2 = respostaAliasUsuario2.getRespostaComoObjetoJson().getString("user_id");
        ItfRespostaWebServiceSimples resposta = FabApiRestInteMatrixChatDirect.DIRECT_CRIAR_SALA.getAcao(userIdUsuario2, userIdUsuario1).getResposta();

        System.out.println(resposta.getRespostaTexto());
        String direct = resposta.getRespostaComoObjetoJson().getString("room_id");

    }

}
