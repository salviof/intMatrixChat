package br.org.coletivoJava.integracoes.restIntmatrixchat.implementacao;

import br.org.coletivoJava.integracoes.restIntmatrixchat.api.InfoIntegracaoRestIntmatrixchatDirect;
import br.org.coletivoJava.integracoes.matrixChat.FabApiRestInteMatrixChatDirect;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ComoUsuario;

@InfoIntegracaoRestIntmatrixchatDirect(tipo = FabApiRestInteMatrixChatDirect.DIRECT_CRIAR_SALA)
public class IntegracaoRestIntmatrixchatDirectCriarSala
        extends
        AcaoApiIntegracaoAbstrato {

    public IntegracaoRestIntmatrixchatDirectCriarSala(
            final FabTipoAgenteClienteApi pTipoAgente,
            final ComoUsuario pUsuario, final java.lang.Object... pParametro) {
        super(FabApiRestInteMatrixChatDirect.DIRECT_CRIAR_SALA, pTipoAgente,
                pUsuario, pParametro);
    }

    @Override
    public String gerarCorpoRequisicao() {
        String us1 = (String) parametros.get(0);//The Grand Duke Pub

        //   try {
        //  alias = UtilsbApiMatrixChat.gerarALiasChatDirect(us1, us2);
        //  } catch (ErroValidacao ex) {
        //       throw new UnsupportedOperationException("código usuário invalido");
        //   }
        String corpo = "{\n"
                + "  \"preset\": \"private_chat\",\n"
                + "  \"visibility\": \"private\", \n"
                + "  \"guest_access\": \"forbidden\", \n"
                + "  \"join_rules\": \"invite\", \n"
                + "  \"is_direct\": true,\n"
                //   + "  \"room_alias_name\": \"" + alias + "\",\n"
                + "  \"invite\": [\"" + us1 + "\""
                //  + ",\"" + us2 + "\""
                + "],\n"
                + "  \"creation_content\": {\n"
                + "    \"m.federate\": false,\n"
                + "    \"type\": \"direto\"   \n "
                + "  }\n"
                + "}";
        System.out.println(corpo);
        return corpo;
    }

}
