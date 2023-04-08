# Bloom Filters

Bloom Filters are space-efficient, probabilistic data structures designed to test set membership. They use multiple hash functions to map elements into a fixed-size bit array. A query returns positive if all hash positions are set, but false positives can occur. However, false negatives are impossible. The false positive rate depends on the filter's size, the number of hash functions, and the number of elements.

Bloom Filters are advantageous for scenarios where memory constraints exist and a small false positive rate is tolerable, such as in web caching, network routing, or database indexing.

## BloomFilterTest (Main, Maven)

### Bloom Filter Class

This class implements a Bloom Filter, a probabilistic data structure used to test whether an element is a member of a set. It efficiently handles false positives but guarantees no false negatives. The BloomFilter class supports adding elements to the filter, checking for their membership, clearing the filter, cloning, hashing, and merging with other compatible Bloom Filters.

The RandomInRange class is used to generate hash functions for the filter. This data structure is ideal for situations where space efficiency is crucial, and a small false positive rate is acceptable, such as in web caching, network routing, or database indexing.

### Tester

The tester class is a testing suite for the BloomFilter class, designed to assess the correctness, insertion speed, query speed, and merge functionality of Bloom Filter implementations.

- Correctness tests ensure no false negatives occur and check the false positive rate against expected values.
- Insertion speed tests measure the time taken to insert elements into the filter, while query speed tests evaluate the time required to perform lookups.
- The merge test verifies the ability to combine two distinct Bloom Filters correctly, ensuring that no elements are lost during the merging process and that the resulting merged filters are symmetrical.

### Terminal Output

```
Testing a bloom filter containing n=1000000 elements in a bit array of m=10000000 bits (=1,2Mib)

Testing correctness.
Creating a Set and filling it together with our filter...

Elements incorrectly found to be inside:        7/1000     (0,70%)
Elements incorrectly found to be inside:       16/2000     (0,80%)
Elements incorrectly found to be inside:       28/3000     (0,93%)
[...]

Testing insertion speed...
Inserted 1000000 elements in 277632000 ns.
Insertion speed: 3,60189e+06 elements/second

Testing query speed...
Queried 1000000 elements in 3364000 ns.
Query speed: 2,97265e+08 elements/second
```
