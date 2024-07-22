// 329238919 Shalev Wengrowsky

/**
 * The type Counter.
 */
public class Counter {
    private int count;

    /**
     * Instantiates a new Counter.
     */
    public Counter() {
        this.count = 0;
    }

    /**
     * Add number to current count.
     *
     * @param number the number to add
     */
    public void increase(int number) {
        this.count += number;
    }

    /**
     * Subtract number from current count.
     *
     * @param number the number to subtract
     */
    public void decrease(int number) {
        this.count -= number;
    }

    /**
     * Get current count.
     *
     * @return the value
     */
    public int getValue() {
        return this.count;
    }
}