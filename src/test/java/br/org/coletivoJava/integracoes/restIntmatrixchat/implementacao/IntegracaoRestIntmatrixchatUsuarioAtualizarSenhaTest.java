/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.org.coletivoJava.integracoes.restIntmatrixchat.implementacao;

import br.org.coletivoJava.integracoes.matrixChat.FabApiRestIntMatrixChatUsuarios;
import com.super_bits.Super_Bits.mktMauticIntegracao.configAppp.ConfiguradorCoreMatrixChatIntegracao;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.ItfRespostaWebServiceSimples;
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
public class IntegracaoRestIntmatrixchatUsuarioAtualizarSenhaTest {

    public IntegracaoRestIntmatrixchatUsuarioAtualizarSenhaTest() {
    }

    /**
     * Test of gerarCorpoRequisicao method, of class
     * IntegracaoRestIntmatrixchatUsuarioAtualizarSenha.
     */
    @Test
    public void testGerarCorpoRequisicao() {
        SBCore.configurar(new ConfiguradorCoreMatrixChatIntegracao(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        if (!FabApiRestIntMatrixChatUsuarios.USUARIO_ATUALIZAR_SENHA.getGestaoToken().isTemTokemAtivo()) {
            FabApiRestIntMatrixChatUsuarios.USUARIO_ATUALIZAR_SENHA.getGestaoToken().gerarNovoToken();
        }

        ItfRespostaWebServiceSimples resposta = FabApiRestIntMatrixChatUsuarios.USUARIO_OBTER_DADOS_BY_EMAIL.getAcao("wagner@casanovadigital.com.br").getResposta();
        if (resposta.isSucesso()) {
            String codigoUsuario;

            System.out.println(resposta.getRespostaTexto());
            codigoUsuario = resposta.getRespostaComoObjetoJson().getString("user_id");
            ItfRespostaWebServiceSimples resp = FabApiRestIntMatrixChatUsuarios.USUARIO_ATUALIZAR_SENHA.getAcao(codigoUsuario, "Comunic@=PIX").getResposta();
        } else {
            System.out.println(resposta.getRespostaTexto());
        }
    }

}
