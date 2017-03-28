package junit;

public class Test_case {
	public static void main(String[] args) {
		// switchTest("1");
		System.out.println(switchTest("7"));
	}

	private static int switchTest(String key) {

		int value = 0;
		switch (key) {
		case "1":
			value = 11;
			break;
		case "2":
			value = 22;
			break;
		default:
			value = 55;
		}

		return value;
	}
}
