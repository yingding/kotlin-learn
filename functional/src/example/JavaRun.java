package example;

/**
 * Single Abstract Method means an interface with one method on it.
 * In java Runnable, which has a single abstract method run()
 * and Callable, which has a single abstract method, call()
 *
 * Single Abstract Methods (SAM)
 */
class JavaRun {
    public static void runNow(Runnable runnable) {
        runnable.run();
    }
}
