package task_1_1;

public class Main {
	public static void main(String[] args) {
		Calculator calc = Calculator.instance.get();

		try {
			int a = calc.plus.apply(1, 2); // 3
			int b = calc.minus.apply(1, 1); // 0

//		Делить на 0 нельзя.
//		1. Можно ловить ошибку try/catch.
//		2. Можно сделать проверку значения b (if/else или тернарный оператор),
//		если оно равно 0, то возвращать "На 0 делить нельзя".

			int c = calc.devide.apply(a, b);
			calc.println.accept(c);
		} catch (ArithmeticException exception) {
			System.out.println("Делить на ноль нельзя");

		} catch (Exception exception) {
			System.out.println("Непредвиденная ошибка:" + exception.getMessage());
			exception.printStackTrace();
		}
	}
}
