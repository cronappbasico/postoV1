package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class CalculaConsumoMedio {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @return Var
	 */
	// CalculaConsumoMedio
	public static Var CalcMedia() throws Exception {
		return new Callable<Var>() {

			private Var placa = Var.VAR_NULL;
			private Var ConsultaAbastecimentos = Var.VAR_NULL;
			private Var consumo = Var.VAR_NULL;

			public Var call() throws Exception {
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"), Var.valueOf("success"),
						Var.valueOf("oi"));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"), Var.valueOf("success"),
						Var.valueOf("oi de novo"));
				placa = Var.valueOf("ABC-9999");
				ConsultaAbastecimentos = cronapi.database.Operations.query(Var.valueOf("app.entity.Abastecimento"),
						Var.valueOf(
								"select a.km, a.valor, a.precoLitro from Abastecimento a where a.carro.placa = :carroPlaca"),
						Var.valueOf("carroPlaca", placa));
				while (cronapi.database.Operations.hasElement(ConsultaAbastecimentos).getObjectAsBoolean()) {
					cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"),
							Var.valueOf("success"), Var.valueOf("Consumo calculado"));
					consumo = cronapi.math.Operations.divisor(
							cronapi.database.Operations.getField(ConsultaAbastecimentos, Var.valueOf("this[0]")),
							cronapi.math.Operations.divisor(
									cronapi.database.Operations.getField(ConsultaAbastecimentos,
											Var.valueOf("this[1]")),
									cronapi.database.Operations.getField(ConsultaAbastecimentos,
											Var.valueOf("this[2]"))));
					cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"),
							Var.valueOf("success"), consumo);
				} // end while
				return Var.VAR_NULL;
			}
		}.call();
	}

}
