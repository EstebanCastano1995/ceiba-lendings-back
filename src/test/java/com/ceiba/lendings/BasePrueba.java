package com.ceiba.lendings;

import static org.junit.jupiter.api.Assertions.fail;
import java.util.function.Supplier;
import org.junit.Assert;

public class BasePrueba {


	private static final String EXCEPCION_THROWED = " Se lanzó ";
	private static final String EXPECTED_EXCEPTION = " Se esperaba ";

	public static <T> void assertThrows(Supplier<T> supplier, Class<? extends Exception> exception, String message) {
		try {
			supplier.get();
			fail();
		} catch (Exception e) {
			Assert.assertTrue(EXPECTED_EXCEPTION + exception.getCanonicalName() + EXCEPCION_THROWED
					+ e.getClass().getCanonicalName(), exception.isInstance(e));
			Assert.assertTrue(e.getMessage().contains(message));
		}
	}

	public static void assertThrows(Thunk thunk, Class<? extends Exception> exception, String message) {
		try {
			thunk.execute();
			fail();
		} catch (Exception e) {
			Assert.assertTrue(EXPECTED_EXCEPTION + exception.getCanonicalName() + EXCEPCION_THROWED
					+ e.getClass().getCanonicalName(), exception.isInstance(e));
			Assert.assertTrue(e.getMessage().contains(message));
		}
	}

	@FunctionalInterface
	public interface Thunk {
		void execute();
	}
}
