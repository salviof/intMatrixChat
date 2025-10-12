/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.org.coletivoJava.integracoes.restIntmatrixchat.implementacao;

import br.org.coletivoJava.integracoes.matrixChat.FabApiRestIntMatrixChatUsuarios;
import br.org.coletivoJava.integracoes.restIntmatrixchat.UtilsbApiMatrixChat;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilSBCoreStringFiltros;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilSBCoreStringsCammelCase;
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
public class IntegracaoRestIntmatrixchatUsuarioDefinirIdentificadorCrmTest extends IntegracaoResPadrao {

    private String gerarCodigoUsuario(String pIdentificadoHumano, String pIdentificadorSistema) {
        String pTipo = "at";
        String identificadorHumano = UtilSBCoreStringsCammelCase.getCamelCaseTextoSemAcentuacaoECaracterEspecial(pIdentificadoHumano);
        identificadorHumano = UtilSBCoreStringFiltros.getPrimeirasXLetrasDaString(identificadorHumano, 50);
        String identificadorSistema = UtilSBCoreStringFiltros.removeCaracteresEspeciaisAcentoMantendoApenasLetrasNumerosEspaco(pIdentificadorSistema);
        String codigoUsuario = UtilsbApiMatrixChat.gerarCodigoBySlugUser(identificadorHumano + "." + identificadorSistema + "." + pTipo);
        return codigoUsuario;
    }

    @Test
    public void testSomeMethod() {

        GestaoTokenRestIntmatrixchat tokenGEstao = validarAcessoTokenAdmin();

        String usuario = tokenGEstao.getUserID();

        final String codigoUsuario = "@salvio_furbino930:casanovadigital.com.br";

        final String codigoAtendimento
                = gerarCodigoUsuario("Salvio Frubino", "salvio@casanovadigital.com.br");
        getResposta(FabApiRestIntMatrixChatUsuarios.USUARIO_DEFINIR_IDENTIFICADOR_CRM, codigoUsuario, "salvio_furbino930");

    }
}
