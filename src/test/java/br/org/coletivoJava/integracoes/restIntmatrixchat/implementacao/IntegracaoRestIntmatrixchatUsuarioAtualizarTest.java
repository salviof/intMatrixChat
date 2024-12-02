/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.org.coletivoJava.integracoes.restIntmatrixchat.implementacao;

import br.org.coletivoJava.integracoes.matrixChat.FabApiRestIntMatrixChatUsuarios;
import com.super_bits.Super_Bits.mktMauticIntegracao.configAppp.ConfiguradorCoreMatrixChatIntegracao;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.ItfRespostaWebServiceSimples;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.RespostaWebServiceSimples;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.token.ItfTokenGestao;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author salvio
 */
public class IntegracaoRestIntmatrixchatUsuarioAtualizarTest {

    public IntegracaoRestIntmatrixchatUsuarioAtualizarTest() {
    }

    @Test
    public void testSomeMethod() {
        SBCore.configurar(new ConfiguradorCoreMatrixChatIntegracao(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        GestaoTokenRestIntmatrixchat tokenGEstao = (GestaoTokenRestIntmatrixchat) FabApiRestIntMatrixChatUsuarios.USUARIO_CRIAR.getGestaoToken();
        tokenGEstao.excluirToken();
        if (!tokenGEstao.isTemTokemAtivo()) {
            tokenGEstao.gerarNovoToken();
        }
        // System.out.println(FabApiRestIntMatrixChatUsuarios.USUARIO_REMOVER.getAcao("@salvio2:casanovadigital.com.br").getResposta().getRespostaTexto());

        String usuario = tokenGEstao.getUserID();
        String email;
        if (usuario.toLowerCase().contains("auxiliadora")) {
            email = "auxiliadora@casanovadigital.com.br";
        }

        if (usuario.toLowerCase().contains("assistente")) {
            email = "gestao@casanovadigital.com.br";

            ItfRespostaWebServiceSimples respostaTeste1 = FabApiRestIntMatrixChatUsuarios.USUARIO_ATUALIZAR
                    //        .getAcao(codigoUsuario, slugUsuario, "Wagner Mingote", "wagner@casanovadigital.com.br", "553121159755", "Comunic@=PIX").getResposta();
                    .getAcao(usuario, "Assistente LaudyCardio", "gestao@laudycardio.com.br", "31984153719").getResposta();
        }

    }
}
