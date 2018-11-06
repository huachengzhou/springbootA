package tool.thread.pool;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

/**
 * <p>
 * 实现描述：可复用的公共线程池
 * </p>
 *
 * @author red
 * @version v1.0.0
 */
public class ShareableThreadPoolExecutor implements ExecutorService {

    private static final Logger logger = LoggerFactory.getLogger(ShareableThreadPoolExecutor.class);

    public static final int DEFAULT_MAX_POOL_SIZE = 64; // 默认64线程
    public static final int DEFAULT_KEEPALIVE_SECONDS = 60; // 默认1分钟idle

    private final ThreadPoolExecutor executor;

    private static final BlockingQueue<Runnable> UNBOUNDED_WORK_QUEUE = new LinkedBlockingQueue<>(Integer.MAX_VALUE);

    private static final Supplier<ShareableThreadPoolExecutor> DEFAULT_EXECUTOR = Suppliers
            .memoize(new Supplier<ShareableThreadPoolExecutor>() {
                @Override
                public ShareableThreadPoolExecutor get() {
                    final ShareableThreadPoolExecutor executor = new ShareableThreadPoolExecutor(DEFAULT_MAX_POOL_SIZE,
                            DEFAULT_KEEPALIVE_SECONDS, "default-executor");
                    return executor;
                }
            });

    public ShareableThreadPoolExecutor(int maxPoolSize, int keepaliveSeconds, String threadNamePrefix) {
        ThreadFactory factory = new CustomizableThreadFactory(threadNamePrefix);
        executor = new ThreadPoolExecutor(maxPoolSize, maxPoolSize, keepaliveSeconds, TimeUnit.SECONDS,
                UNBOUNDED_WORK_QUEUE, factory); // 无界队列，线程池默认占满
        executor.allowCoreThreadTimeOut(true);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                shutdown();
            }
        });
    }

    public static ShareableThreadPoolExecutor get() {
        return DEFAULT_EXECUTOR.get(); // 单例
    }

    @Override
    public void shutdown() {
        executor.shutdown();
    }

    @Override
    public List<Runnable> shutdownNow() {
        return executor.shutdownNow();
    }

    @Override
    public boolean isShutdown() {
        return executor.isShutdown();
    }

    @Override
    public boolean isTerminated() {
        return executor.isShutdown();
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return executor.awaitTermination(timeout, unit);
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        return executor.submit(task);
    }

    @Override
    public <T> Future<T> submit(Runnable task, T result) {
        return executor.submit(task, result);
    }

    @Override
    public Future<?> submit(Runnable task) {
        return executor.submit(task);
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        return executor.invokeAll(tasks);
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
            throws InterruptedException {
        return executor.invokeAll(tasks, timeout, unit);
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        return executor.invokeAny(tasks);
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
            throws InterruptedException, ExecutionException, TimeoutException {
        return executor.invokeAny(tasks, timeout, unit);
    }

    @Override
    public void execute(Runnable command) {
        executor.execute(command);
    }

}
