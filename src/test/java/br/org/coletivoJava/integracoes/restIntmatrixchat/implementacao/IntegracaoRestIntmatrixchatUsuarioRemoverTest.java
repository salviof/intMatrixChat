/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.org.coletivoJava.integracoes.restIntmatrixchat.implementacao;

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
public class IntegracaoRestIntmatrixchatUsuarioRemoverTest {

    public IntegracaoRestIntmatrixchatUsuarioRemoverTest() {
    }

    /**
     * Test of gerarCorpoRequisicao method, of class
     * IntegracaoRestIntmatrixchatUsuarioRemover.
     */
    @Test
    public void testGerarCorpoRequisicao() {
        System.out.println("gerarCorpoRequisicao");
        IntegracaoRestIntmatrixchatUsuarioRemover instance = null;
        String expResult = "";
        String result = instance.gerarCorpoRequisicao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
