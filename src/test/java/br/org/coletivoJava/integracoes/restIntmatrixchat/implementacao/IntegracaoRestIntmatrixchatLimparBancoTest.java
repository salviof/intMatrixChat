/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.org.coletivoJava.integracoes.restIntmatrixchat.implementacao;

import br.org.coletivoJava.integracoes.matrixChat.FabApiRestIntMatrixChatUsuarios;
import br.org.coletivoJava.integracoes.matrixChat.FabApiRestIntMatrixSpaces;
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
public class IntegracaoRestIntmatrixchatLimparBancoTest extends IntegracaoResPadrao {

    @Test
    public void testSomeMethod() {

        GestaoTokenRestIntmatrixchat tokenGEstao = validarAcessoTokenAdmin();

        String usuario = tokenGEstao.getUserID();

    }
}
