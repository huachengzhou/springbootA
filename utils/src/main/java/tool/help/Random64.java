package tool.help;
/**
 * 随机数
 * @author zhou
 *
 */
public class Random64 {
	/**
	 * Wichman-Hill随机数产生器 线性
	 * 
	 * @param x
	 * @return
	 */
	public static float randomWH(int x) {
		int[] seed = new int[3];
		seed[0] = (171 * x) % 30269;
		seed[1] = (172 * (30000 - 1)) % 30307;
		seed[2] = (170 * x) % 30323;
		float num = (x / Math.abs(x)) * (seed[0] / 30269.0F + seed[1] / 30307.0F + seed[2] / 30323.0F % 1.0F);
		return num;
	}

	/**
	 * 非线性和Java random接近但是没有Random优秀
	 * 
	 * @param x
	 * @return
	 */
	public static float randomBasic(int x) {
		x = (x << 13) ^ x;
		float num = (float) Math.abs((1.0 - ((x * (x * x * 15731 + 789221) + 1376312589) & 0x7fffffff) / 1073741824.0));
		return num;
	}

}
