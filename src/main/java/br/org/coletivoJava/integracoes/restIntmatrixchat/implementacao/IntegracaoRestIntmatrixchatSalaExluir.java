package br.org.coletivoJava.integracoes.restIntmatrixchat.implementacao;

import br.org.coletivoJava.integracoes.restIntmatrixchat.api.InfoIntegracaoRestIntmatrixchatSalas;
import br.org.coletivoJava.integracoes.matrixChat.FabApiRestIntMatrixChatSalas;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;

@InfoIntegracaoRestIntmatrixchatSalas(tipo = FabApiRestIntMatrixChatSalas.SALA_EXLUIR)
public class IntegracaoRestIntmatrixchatSalaExluir
        extends
        AcaoApiIntegracaoAbstrato {

    public IntegracaoRestIntmatrixchatSalaExluir(
            final FabTipoAgenteClienteApi pTipoAgente,
            final ItfUsuario pUsuario, final java.lang.Object... pParametro) {
        super(FabApiRestIntMatrixChatSalas.SALA_EXLUIR, pTipoAgente, pUsuario,
                pParametro);
    }

    @Override
    public String gerarCorpoRequisicao() {
        // new room e room name são nomes para uma nova sala em caso de exluzão movendo para uma nova sala
        String corpo = "{\n"
                //   + "    \"new_room_user_id\": \"@someuser:example.com\",\n"
                //   + "    \"room_name\": \"Content Violation Notification\",\n"
                //       + "    \"message\": \"Bad Room has been shutdown due to content violations on this server. Please review our Terms of Service.\",\n"
                //        + "    \"block\": true,\n"
                + "    \"purge\": true\n"
                + "}";
        return corpo;
    }

}
