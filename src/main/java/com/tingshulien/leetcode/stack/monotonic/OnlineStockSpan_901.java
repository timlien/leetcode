package com.tingshulien.leetcode.stack.monotonic;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/online-stock-span/description/">901. Online Stock Span</a>
 * <p>
 * Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day.
 * <p>
 * The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and going backward)
 * for which the stock price was less than or equal to today's price.
 * <p>
 * For example, if the price of a stock over the next 7 days were [100,80,60,70,60,75,85], then the stock spans would be [1,1,1,2,1,4,6].
 * Implement the StockSpanner class:
 * <p>
 * StockSpanner() Initializes the object of the class.
 * int next(int price) Returns the span of the stock's price given that today's price is price.
 */
public class OnlineStockSpan_901 {

    private final Deque<Integer> deque;

    private final Map<Integer, Integer> spanByPrice;

    public OnlineStockSpan_901() {
        this.deque = new ArrayDeque<>();
        this.spanByPrice = new HashMap<>();
    }

    public int next(int price) {
        while (!deque.isEmpty() && price >= deque.getLast()) {
            int removed = deque.removeLast();

            int removedSpan;
            if (spanByPrice.containsKey(removed)) {
                removedSpan = spanByPrice.remove(removed);
            } else {
                removedSpan = 1;
            }

            spanByPrice.put(price, spanByPrice.getOrDefault(price, 1) + removedSpan);
        }

        deque.addLast(price);
        return spanByPrice.getOrDefault(price, 1);
    }

}
