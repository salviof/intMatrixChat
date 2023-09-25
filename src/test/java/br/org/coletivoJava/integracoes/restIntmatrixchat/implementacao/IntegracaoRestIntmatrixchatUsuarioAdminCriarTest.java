/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.org.coletivoJava.integracoes.restIntmatrixchat.implementacao;

import br.org.coletivoJava.integracoes.matrixChat.FabApiRestIntMatrixChatUsuarios;
import br.org.coletivoJava.integracoes.restIntmatrixchat.UtilsbApiMatrixChat;
import com.super_bits.Super_Bits.mktMauticIntegracao.configAppp.ConfiguradorCoreMatrixChatIntegracao;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.ItfRespostaWebServiceSimples;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author salvio
 */
public class IntegracaoRestIntmatrixchatUsuarioAdminCriarTest {

    public IntegracaoRestIntmatrixchatUsuarioAdminCriarTest() {
    }

    /**
     * Test of gerarCorpoRequisicao method, of class
     * IntegracaoRestIntmatrixchatUsuarioAdminCriar.
     */
    @Test
    public void testGerarCorpoRequisicao() {
        SBCore.configurar(new ConfiguradorCoreMatrixChatIntegracao(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        if (!FabApiRestIntMatrixChatUsuarios.USUARIO_CRIAR.getGestaoToken().isPossuiAutenticacaoDeUsuario()) {
            FabApiRestIntMatrixChatUsuarios.USUARIO_CRIAR.getGestaoToken().gerarNovoToken();
        }
        String slugUsuario = "auxiliadora";
        String codigoUsuario = UtilsbApiMatrixChat.gerarCodigoBySlugUser(slugUsuario);

        //      codigo: @beatriz202:casanovadigital.com.br
//contatoswsCasanova | nome: Beatriz
//contatoswsCasanova | email:beatrizesalvio@gmail.com
//contatoswsCasanova | telefone+553198789856
//contatoswsCasanova | Senha:2034736859
        ItfRespostaWebServiceSimples resp = FabApiRestIntMatrixChatUsuarios.USUARIO_OBTER_DADOS_BY_EMAIL
                .getAcao("auxiliadora@casanovadigital.com.br").getResposta();
        System.out.println(resp.getRespostaTexto());
        ItfRespostaWebServiceSimples resposta = FabApiRestIntMatrixChatUsuarios.USUARIO_ADMIN_CRIAR
                .getAcao(codigoUsuario, slugUsuario, "Auxiliadora", "auxiliadora@casanovadigital.com.br", "553121159751", "T4!!eKxnXY0Cr^5@9Ha!").getResposta();
        //ItfRespostaWebServiceSimples respostaPesquisa = FabApiRestIntMatrixChatUsuarios.USUARIO_OBTER_DADOS_BY_EMAIL
        //        .getAcao("beatrizesalvio@gmail.com").getResposta();
        //System.out.println(respostaPesquisa.getRespostaTexto());

        //ItfRespostaWebServiceSimples resposta = FabApiRestIntMatrixChatUsuarios.USUARIO_CRIAR
        //        .getAcao("@beatriz203:casanovadigital.com.br", "teste", "Beatriz", "beatrizesalvio@gmail.com", "+553198789856", "2034736859").getResposta();
        ItfRespostaWebServiceSimples respostaAlteraSenha = FabApiRestIntMatrixChatUsuarios.USUARIO_ATUALIZAR_SENHA
                .getAcao(codigoUsuario, "").getResposta();
        System.out.println(respostaAlteraSenha.getRespostaTexto());
        resposta.dispararMensagens();
        System.out.println(resposta.getRespostaTexto());
        Assert.assertTrue("Falha criando usuário" + resposta.getRespostaTexto(), resposta.isSucesso());
        System.out.println(resposta.getCodigoResposta());
        System.out.println(resposta.getRespostaTexto());
    }

}
