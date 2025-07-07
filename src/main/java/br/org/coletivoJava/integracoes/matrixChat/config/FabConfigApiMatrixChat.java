/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.coletivoJava.integracoes.matrixChat.config;

import com.super_bits.modulosSB.SBCore.ConfigGeral.arquivosConfiguracao.ItfFabConfigModulo;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilSBCoreNumeros;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilSBCoreStringGerador;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.tipoModulos.integracaoOauth.FabPropriedadeModuloIntegracaoOauth;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.tipoModulos.integracaoOauth.InfoPropriedadeConfigRestIntegracao;

/**
 *
 * @author desenvolvedorninja01
 */
public enum FabConfigApiMatrixChat implements ItfFabConfigModulo {

    @InfoPropriedadeConfigRestIntegracao(tipoPropriedade = FabPropriedadeModuloIntegracaoOauth.CHAVE_PUBLICA)
    SEGREDO,
    @InfoPropriedadeConfigRestIntegracao(tipoPropriedade = FabPropriedadeModuloIntegracaoOauth.URL_SERVIDOR_API)
    URL_MATRIX_SERVER,
    @InfoPropriedadeConfigRestIntegracao(tipoPropriedade = FabPropriedadeModuloIntegracaoOauth.USUARIO)
    USUARIO_ADMIN,
    @InfoPropriedadeConfigRestIntegracao(tipoPropriedade = FabPropriedadeModuloIntegracaoOauth.SENHA)
    SENHA_USUARIO_ADMIN,
    DOMINIO_FEDERADO;
    /**
     * https://api.galaxpay.com.br/v2, ou
     * https://api.sandbox.cloud.galaxpay.com.br/v2
     */
    public static final String NOME_INTEGRACAO = "intMatrixChat";

    @Override

    public String getValorPadrao() {
        switch (this) {

            case SEGREDO:
                return UtilSBCoreStringGerador.getStringRandomicaTokenAleatorio(120);

            case URL_MATRIX_SERVER:
                return "https://matrix.meudominio.com.br";

            case USUARIO_ADMIN:
                return "admin@meudominio.com.br";

            case SENHA_USUARIO_ADMIN:
                return UtilSBCoreStringGerador.getStringRandomicaTokenAleatorio(120);

            case DOMINIO_FEDERADO:
                return "meudominio.com.br";

            default:
                throw new AssertionError();
        }

    }
}
