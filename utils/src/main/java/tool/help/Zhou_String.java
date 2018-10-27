package tool.help;

import java.util.Random;

/**
 * 
 * @author zhou
 * @since jdk1.6
 * @version 1.2
 * @see 随机字符串 利用的ascii码表生成
 *
 */
public class Zhou_String {
	/**
	 * a-z
	 * 
	 * @see 随机小写字符串
	 * @param length
	 * @return
	 */
	public static String toUpperCase(int length) {
		if (length < 0) {
			throw new IllegalArgumentException("argument must be positive");
		}
		final Random random = new Random();
		final StringBuilder builder = new StringBuilder();
		for (int i = 0; i < length; i++) {
			int num = random.nextInt(26) + 65;
			char c = (char) num;
			builder.append(c);
		}
		return builder.toString();
	}

	/**
	 * A-Z
	 * 
	 * @see 随机大写字符串
	 * @param length
	 * @return
	 */
	public static String toLowerCase(int length) {
		if (length < 0) {
			throw new IllegalArgumentException("argument must be positive");
		}
		final Random random = new Random();
		final int NUMBER = 26;
		final StringBuilder builder = new StringBuilder();
		for (int i = 0; i < length; i++) {
			int num = random.nextInt(NUMBER) + 97;
			char c = (char) num;
			builder.append(c);
		}
		return builder.toString();
	}

	/**
	 * @see 随机乱码字符串
	 * @param length
	 * @return
	 */
	public static String toOther(int length) {
		if (length < 0) {
			throw new IllegalArgumentException("argument must be positive");
		}
		final Random random = new Random();
		final int NUMBER = 10000;
		final StringBuilder builder = new StringBuilder();
		for (int i = 0; i < length; i++) {
			int num = random.nextInt(NUMBER) + 200;
			char c = (char) num;
			builder.append(c);
		}
		return builder.toString();
	}

	/**
	 * @see 随机数字字符串
	 * @param length
	 * @return
	 */
	public static String toMath(int length) {
		if (length < 0) {
			throw new IllegalArgumentException("argument must be positive");
		}
		final Random random = new Random();
		final int NUMBER = 10;
		final StringBuilder builder = new StringBuilder();
		for (int i = 0; i < length; i++) {
			int num = random.nextInt(NUMBER) + 48;
			char c = (char) num;
			builder.append(c);
		}
		return builder.toString();
	}

	/**
	 * a-z A-Z 0-9
	 * 
	 * @see 随机字符串
	 * @param length
	 * @return
	 */
	public static String toWord(int length) {
		if (length < 0) {
			throw new IllegalArgumentException("argument must be positive");
		}
		final String s = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		final Random random = new Random();
		final StringBuilder builder = new StringBuilder();
		for (int i = 0; i < length; i++) {
			int num = random.nextInt(s.length());
			builder.append(s.charAt(num));
		}
		return builder.toString();
	}

	private Zhou_String() {
	}
}
