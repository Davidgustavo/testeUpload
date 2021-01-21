package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Combobox {

public static final int TIMEOUT = 300;

/**
 *
 * @return Var
 */
// combobox
public static Var Executar() throws Exception {
 return new Callable<Var>() {

   private Var usuario = Var.VAR_NULL;

   public Var call() throws Exception {

    usuario =
    cronapi.screen.Operations.getValueOfField(
    Var.valueOf("Teste.active.name"));

    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
    Var.valueOf("vars.testeuser"), usuario);
    return Var.VAR_NULL;
   }
 }.call();
}

}

