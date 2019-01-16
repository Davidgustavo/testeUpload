package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Upload {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @return Var
	 */
	// Upload
	public static Var Upload() throws Exception {
		return new Callable<Var>() {

			private Var upload = Var.VAR_NULL;

			public Var call() throws Exception {
				cronapi.util.Operations.upload(Var.valueOf("Selecione o arquivo a ser enviando!\n"), Var.valueOf("*"),
						Var.valueOf("20MB\n"), Var.valueOf("true"), (sender_upload) -> {
							upload = Var.valueOf(sender_upload);
							System.out.println(upload.getObjectAsString());
							cronapi.io.Operations.fileMove(cronapi.list.Operations.get(upload, Var.valueOf(1)),
									Var.valueOf(cronapi.io.Operations.fileAppDir().toString()
											+ cronapi.io.Operations.fileSeparator().toString()
											+ Var.valueOf("Pasta Upload").toString()));
						});
				return Var.VAR_NULL;
			}
		}.call();
	}

}
