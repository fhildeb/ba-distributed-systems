# BloomFilterTest (Main, Maven)

## Terminal Output

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