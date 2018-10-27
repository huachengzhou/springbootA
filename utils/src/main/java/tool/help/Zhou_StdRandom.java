package tool.help;

import java.util.Random;

/**
 * @Auther: zch
 * @Date: 2018/7/26 20:59
 * @Description:
 */
public class Zhou_StdRandom {
    private static Random random = new Random(System.currentTimeMillis());
    /**
     *
     * 功能描述: Chinese 静态初始化 static initializer
     *
     * @param:
     * @return:
     * @auther: zch
     * @date: 2018/7/26 21:01
     */
    private static long seed;
    {
        seed = System.currentTimeMillis();
        random = new Random(seed);
    }

    public static void setSeed(long num) {
        seed = num;
        random = new Random(seed);
    }

   /**
    *
    * 功能描述: Returns a random real number uniformly in [0, 1]
    *
    * @param:
    * @return:
    * @auther: zch
    * @date: 2018/7/26 21:01
    */
    public static double uniform() {
        return random.nextDouble();
    }

    /**
     *
     * 功能描述: must b > a (a-b)
     *
     * @param:
     * @return:
     * @auther: zch
     * @date: 2018/7/26 21:02
     */
    public static double uniform(double a, double b) {
        if (b <= a || b - a >= Double.MAX_VALUE) {
            throw new IllegalArgumentException("argument must be positive");
        }
        return a + (b - a) * uniform();
    }

   /**
    *
    * 功能描述: 0——n
    *
    * @param:
    * @return:
    * @auther: zch
    * @date: 2018/7/26 21:02
    */
    public static int uniform(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("argument must be positive");
        }
        return random.nextInt(n);
    }

   /**
    *
    * 功能描述: a>b(a——b)
    *
    * @param:
    * @return:
    * @auther: zch
    * @date: 2018/7/26 21:02
    */
    public static int uniform(int a, int b) {
        if (b <= a || b - a >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("argument must be positive");
        }
        return a + uniform(b - a);
    }

    /**
     *
     * 功能描述: 0-n
     *
     * @param:
     * @return:
     * @auther: zch
     * @date: 2018/7/26 21:02
     */
    public static long uniformLong(long n) {
        if (n <= 0) {
            throw new IllegalArgumentException("argument must be positive");
        }
        long num = StrictMath.round((StrictMath.random() * 1) * n);
        return num;
    }

    /**
     *
     * 功能描述: a-b (b>a)
     *
     * @param:
     * @return:
     * @auther: zch
     * @date: 2018/7/26 21:01
     */
    public static long uniformLong(long a, long b) {
        if (b <= a || b - a >= Long.MAX_VALUE) {
            throw new IllegalArgumentException("argument must be positive");
        }
        long num = a + uniformLong(b - a);
        return num;
    }

   /**
    *
    * 功能描述: 0-f
    *
    * @param:
    * @return:
    * @auther: zch
    * @date: 2018/7/26 21:00
    */
    public static float uniformFloat(float f) {
        if (f <= 0) {
            throw new IllegalArgumentException("argument must be positive");
        }
        float num = StrictMath.round((StrictMath.random() * 1) * f);
        return num;
    }

   /**
    *
    * 功能描述: a-b
    *
    * @param:
    * @return:
    * @auther: zch
    * @date: 2018/7/26 21:00
    */
    public static float uniformFloat(float a, float b) {
        if (b <= a || b - a >= Float.MAX_VALUE) {
            throw new IllegalArgumentException("argument must be positive");
        }
        float num = a + uniformFloat(b - a);
        return num;
    }

    /**
     *
     * 功能描述: 不能创建对象 (don't instantiate)
     *
     * @param:
     * @return:
     * @auther: zch
     * @date: 2018/7/26 21:00
     */
    private Zhou_StdRandom() {
    }
}
