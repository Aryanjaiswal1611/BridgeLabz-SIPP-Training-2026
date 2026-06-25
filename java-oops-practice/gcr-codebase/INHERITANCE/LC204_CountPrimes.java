// LeetCode 204: Count Primes
// Sieve of Eratosthenes - O(n log log n)

public class LC204_CountPrimes {
    public int countPrimes(int n) {
        if (n < 2) return 0;
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) isPrime[i] = true;

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (boolean p : isPrime) if (p) count++;
        return count;
    }

    public static void main(String[] args) {
        System.out.println("Primes < 10: " + new LC204_CountPrimes().countPrimes(10)); // 4
        System.out.println("Primes < 100: " + new LC204_CountPrimes().countPrimes(100)); // 25
    }
}
