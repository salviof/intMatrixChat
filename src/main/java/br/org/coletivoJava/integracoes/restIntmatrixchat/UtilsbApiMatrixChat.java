/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.coletivoJava.integracoes.restIntmatrixchat;

import br.org.coletivoJava.integracoes.matrixChat.FabApiRestMatrixMedia;
import br.org.coletivoJava.integracoes.matrixChat.config.FabConfigApiMatrixChat;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.ConfigGeral.arquivosConfiguracao.ConfigModulo;
import com.super_bits.modulosSB.SBCore.UtilGeral.UTilSBCoreInputs;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilSBCoreBytes;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilSBCoreStringSlugs;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilSBCoreStringValidador;
<<<<<<< HEAD
import com.super_bits.modulosSB.SBCore.modulos.objetos.validador.ErroValidacao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
=======
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.UtilSBApiRestClient;
import static com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.UtilSBApiRestClient.getHTTPConexaoPadrao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.validador.ErroValidacao;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
>>>>>>> 8194b3e (Atualizacao automática)

/**
 *
 * @author salvio
 */
public class UtilsbApiMatrixChat {

    private static ConfigModulo config = SBCore.getConfigModulo(FabConfigApiMatrixChat.class);

    public static String gerarSenhaPadrao(String pEmail) {
        String chaveSenhaMi = config.getPropriedade(FabConfigApiMatrixChat.SEGREDO);
        StringBuilder senhaBuilder = new StringBuilder();

        senhaBuilder.append("Senha@");
        String hash = chaveSenhaMi + pEmail;
        senhaBuilder.append(hash.hashCode());

        return senhaBuilder.toString();
    }

    public static String gerarSlugUserCompativel(String pTexto) {
        String slugnome = UtilSBCoreStringSlugs.gerarSlugCaixaAlta(pTexto).toLowerCase();
        return slugnome;
    }

    public static String gerarALiasChatDirect(String pCodUsuario1, String pCodusuario2) throws ErroValidacao {
        validarAlias(pCodUsuario1);
        validarAlias(pCodusuario2);
        List<String> usrs = new ArrayList<>();
        usrs.add(pCodUsuario1);
        usrs.add(pCodusuario2);
        Collections.sort(usrs);
        String alias = String.valueOf((usrs.get(0) + usrs.get(1)).hashCode());
        return alias;
    }

    public static void validarAlias(String pCodigoValidacao) throws ErroValidacao {
        if (UtilSBCoreStringValidador.isNuloOuEmbranco(pCodigoValidacao)) {
            throw new ErroValidacao("não pode ser nulo");
        }
        if (!pCodigoValidacao.contains(":")) {
            throw new ErroValidacao("falta separador [:]");
        }
        if (!pCodigoValidacao.startsWith("@")) {
            throw new ErroValidacao("o código começa com @");
        }

    }

<<<<<<< HEAD
    public static String gerarCodigoBySlugUser(String pUsername) {

        return "@" + pUsername.toLowerCase() + ":"
                + config.getPropriedade(FabConfigApiMatrixChat.DOMINIO_FEDERADO);
        //":casanovadigital.com.br";
=======
    public static boolean isCodigoUsuarioModoCanonico(String pTesteCase) {
        if (pTesteCase == null || pTesteCase.isEmpty()) {
            return false;
        }
        if (!pTesteCase.startsWith("@")) {
            return false;
        }

        if (pTesteCase.contains(":") && pTesteCase.contains(".")) {
            return true;
        }
        return false;
    }

    public static String gerarCodigoBySlugUser(String pUsername) {
        if (isCodigoUsuarioModoCanonico(pUsername)) {
            return pUsername;
        }
        return "@" + pUsername.toLowerCase() + ":"
                + config.getPropriedade(FabConfigApiMatrixChat.DOMINIO_FEDERADO);

>>>>>>> 8194b3e (Atualizacao automática)
    }

}
