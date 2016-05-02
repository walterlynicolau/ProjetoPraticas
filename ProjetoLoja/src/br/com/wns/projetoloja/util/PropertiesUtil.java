
package br.com.wns.projetoloja.util;

import java.util.ResourceBundle;

public class PropertiesUtil {
    private static final String FILE = "conf";
    private static final String FILE_STRINGS = "strings";
    private static final ResourceBundle resource = ResourceBundle.getBundle(FILE);
    private static final ResourceBundle resourceStrings = ResourceBundle.getBundle(FILE_STRINGS);
    
    //chaves de configuração
    public static final String JDBC_URL = "jdbc_url";
    public static final String JDBC_USERNAME = "jdbc_username";
    public static final String JDBC_PASSWORD = "jdbc_password";
    //chaves das mensagens
    public static final String MSG_ERRO_SALVAR = "msg_erro_salvar";
    public static final String MSG_ERRO_ALTERAR = "msg_erro_alterar";
    public static final String MSG_ERRO_BUSCAR = "msg_erro_buscar";
    public static final String MSG_ERRO_EXCLUIR = "msg_erro_excluir";
    public static final String MSG_ERRO_LISTAR = "msg_erro_listar";
    public static final String MSG_ERRO_LIMPAR = "msg_erro_limpar";
    
    public static String getConfValue(String key){
        return resource.getString(key);        
    }
    
    public static String getStringsValue(String key){
        return resourceStrings.getString(key);        
    }
}
