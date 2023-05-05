import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Customer customer = new Customer(IntStream.range(0, want.length)
                .mapToObj(i -> new AbstractMap.SimpleEntry<>(want[i], number[i]))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));


        return customer.calculateSignUpDates(Arrays.stream(discount).collect(Collectors.toList()), 10);
    }

    private static class Customer {
        private final Map<String, Integer> want;

        public Customer(Map<String, Integer> want) {
            this.want = want;
        }

        public int calculateSignUpDates(List<String> products, int timeWindow) {
            if (products.size() <= timeWindow) {
                return canSignUp(products) ? 1 : 0;
            }

            return (int) IntStream.rangeClosed(0, products.size() - timeWindow)
                    .filter(i -> canSignUp(products.subList(i, i + timeWindow)))
                    .count();
        }

        private boolean canSignUp(List<String> products) {
            return products.stream()
                    .collect(Collectors.collectingAndThen(
                            Collectors.groupingBy(Function.identity(), Collectors.counting()),
                            groupedProducts -> want.entrySet().stream()
                                    .allMatch(entry ->
                                            groupedProducts.getOrDefault(entry.getKey(), 0L) >= entry.getValue())));
        }
    }
}