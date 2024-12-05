public class Primes {
    public static void main(String[] args) {
        // Create a boolean array to track prime numbers
        int n = Integer.parseInt(args[0]);
        boolean[] isPrime = new boolean[n + 1];

        // Initialize all entries as true. A value in isPrime[i] will
        // remain true if i is a prime, otherwise false.
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        // Apply Sieve of Eratosthenes
        for (int p = 2; p * p <= n; p++) {
            // If isPrime[p] is still true, p is a prime
            if (isPrime[p]) {
                // Mark multiples of p as false
                for (int multiple = p * p; multiple <= n; multiple += p) {
                    isPrime[multiple] = false;
                }
            }
        }

        // Print the primes
        int primesCounter = 0;
        System.out.printf("Prime numbers up to %d:", n);

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primesCounter ++;
                System.out.println(i);
            }
        } 

        int primesPrecentage = primesCounter*100/n;
        System.out.printf("There are %d primes between 2 and %d (%d%% are primes)", primesCounter, n, primesPrecentage);
    }
}