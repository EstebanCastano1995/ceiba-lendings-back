package com.ceiba.lendingstest;

import static org.junit.jupiter.api.Assertions.fail;
import java.util.function.Supplier;

import org.junit.Assert;

public class BasePrueba {


	private static final String SE_LANZO = " Pero se lanzó ";
	private static final String SE_ESPERABA = "Se esperaba excepción ";

	public static <T> void assertThrows(Supplier<T> supplier, Class<? extends Exception> exception, String message) {
		try {
			supplier.get();
			fail();
		} catch (Exception e) {
			Assert.assertTrue(SE_ESPERABA + exception.getCanonicalName() + SE_LANZO
					+ e.getClass().getCanonicalName(), exception.isInstance(e));
			Assert.assertTrue(e.getMessage().contains(message));
		}
	}

	public static void assertThrows(Thunk thunk, Class<? extends Exception> exception, String message) {
		try {
			thunk.execute();
			fail();
		} catch (Exception e) {
			Assert.assertTrue(SE_ESPERABA + exception.getCanonicalName() + SE_LANZO
					+ e.getClass().getCanonicalName(), exception.isInstance(e));
			Assert.assertTrue(e.getMessage().contains(message));
		}
	}

	@FunctionalInterface
	public interface Thunk {
		void execute();
	}
}
