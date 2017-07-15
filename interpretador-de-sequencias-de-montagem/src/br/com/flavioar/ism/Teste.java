package br.com.flavioar.ism;

import java.lang.reflect.Method;

public class Teste {

	public static void main(String[] args) throws Exception {
		String classe = "Chicotes";
		String enumerador = "br.com.flavioar.ism.entidade." + classe;

		Class<?> c = Class.forName(enumerador);
		Object[] o = c.getEnumConstants();
		
		Class<?> s = o[0].getClass();
		
		Method m = s.getDeclaredMethod("getCodes");
		
		System.out.println(m.invoke(o[1]));
		
		for (Object object : o) {
			System.out.println(m.invoke(object));
			
		}
	}
}
