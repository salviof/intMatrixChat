/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.coletivoJava.integracoes.restIntmatrixchat.implementacao;

import br.org.coletivoJava.integracoes.matrixChat.FabApiRestIntMatrixChatUsuarios;
import com.super_bits.Super_Bits.mktMauticIntegracao.configAppp.ConfiguradorCoreMatrixChatIntegracao;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.ComoFabricaIntegracaoRest;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.ItfRespostaWebServiceSimples;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.ItfResposta;
import org.junit.Assert;
import org.junit.Before;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ComoUsuario;

/**
 *
 * @author salvio
 */
public class IntegracaoResPadrao {

    @Before
    public void inicio() {
        SBCore.configurar(new ConfiguradorCoreMatrixChatIntegracao(), SBCore.ESTADO_APP.DESENVOLVIMENTO);

    }
    private ComoUsuario usuario;

    public GestaoTokenRestIntmatrixchat validarAcessoTokenAdmin() {
        return validarAcessoToken(null);
    }

    public GestaoTokenRestIntmatrixchat validarAcessoToken(ComoUsuario pUsuario) {
        GestaoTokenRestIntmatrixchat gtoke;
        usuario = pUsuario;
        if (pUsuario == null) {
            gtoke = (GestaoTokenRestIntmatrixchat) FabApiRestIntMatrixChatUsuarios.USUARIO_OBTER_DADOS.getGestaoToken();
        } else {
            gtoke = (GestaoTokenRestIntmatrixchat) FabApiRestIntMatrixChatUsuarios.USUARIO_OBTER_DADOS.getGestaoToken(pUsuario);
        }

        if (!gtoke.isTemTokemAtivo()) {
            gtoke.gerarNovoToken();
        }
        if (!gtoke.validarToken()) {
            gtoke.gerarNovoToken();
        }

        if (!gtoke.isTemTokemAtivo()) {
            Assert.fail("Faha gerando token" + gtoke.getUserID());
        }
        return gtoke;
    }

    public ItfResposta getResposta(ComoFabricaIntegracaoRest acao, Object... pParametros) {
        ItfRespostaWebServiceSimples resp = acao.getAcao(pParametros).getResposta();
        System.out.println(resp.getRespostaTexto());
        if (!resp.isSucesso()) {
            Assert.fail("Erro executando " + acao.toString() + " " + pParametros);
        }
        return resp;
    }
}
