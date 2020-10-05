package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Leitura {

public static final int TIMEOUT = 300;

/**
 *
 * @return Var
 */
// Leitura
public static Var Executar() throws Exception {
 return new Callable<Var>() {

   private Var item = Var.VAR_NULL;

   public Var call() throws Exception {
    item = cronapi.io.Operations.fileAppDir();
    System.out.println(item.getObjectAsString());
    return Var.VAR_NULL;
   }
 }.call();
}

}

