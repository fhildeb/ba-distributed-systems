# Hash and Brute Attacks

Various Calculations regarding probabilities and computation periods.

## Pre-Image Attacks

A pre-image attack on a hash function aims to find a second input (pre-image) that, when hashed, produces the same output as a given input. The attacker attempts to find a distinct input that results in the same hash, potentially compromising the integrity of the data. This concept can be explained using a birthday paradox thought experiment, where the goal is to find someone with a specific birthday (e.g., January 1) in a group of people. The probability of a person not having that specific birthday can be calculated, and the counter probability represents the chance of finding someone with the desired birthday.

## Birthday (Main)

This Java program explores the birthday paradox concept to illustrate the pre-image attack on a hash function. The program calculates the probability of someone having a specific birthday within a group of people. By setting different probability thresholds (50%, 75%, 99%), the program determines the group size required to reach each threshold. The calculation is performed using the counter probability concept and logarithms, iterating through different group sizes until the desired probability is reached.

### Terminal Output

```bash
n: 0
n: 1
n: 2
n: 3
n: 4
```

## BirthdayAttack (Main)

This Java program, is an alternative implementation of the birthday paradox concept to illustrate pre-image attacks on hash functions. The program calculates the probability of someone having a specific birthday within a group of people by directly computing the counter probability, rather than calculating the complementary probability first as in the previous Birthday program. By setting a probability threshold (99%), the program iterates through different group sizes until the desired probability is reached.

The main difference between this program and the previous Birthday program lies in the approach to calculating probabilities. While Birthday.java calculates the probability of a person not having the specific birthday and then derives the counter probability, directly computes the counter probability by multiplying the intermediate results at each step.

### Terminal Output

```bash
n: 0
erg: 1.0027397260273974
n: 1
erg: 1.0027397260273974
n: 2
erg: 0.999992493901295
n: 3
erg: 0.9945130829758084
n: 4
erg: 0.9863390028417607
```

## Brute Force

A brute force attack is a trial-and-error method employed by attackers to gain unauthorized access to sensitive information or systems. This type of attack involves systematically attempting all possible combinations of passwords, encryption keys, or other security parameters until the correct one is found.

While brute force attacks can theoretically break any security mechanism that relies on secret information, their practicality depends on the size of the search space and the attacker's computational resources. As the complexity and length of the secret information increase, the number of possible combinations grows exponentially, making the attack significantly more time-consuming and resource-intensive.

Modern security systems often implement countermeasures to thwart brute force attacks, such as limiting the number of login attempts, introducing time delays between attempts, and utilizing more complex and longer secret information. Additionally, advanced encryption and hashing algorithms with larger output spaces provide increased resistance against brute force attacks by making the search space impractically large for an attacker to explore.

## Probability (Main)

This Java program, estimates the time required for a processor to perform a brute force attack on a hash function with a 256-bit output space. By calculating the square root of the total number of possible hash outputs (2^256 - 1), the program derives an approximate number of operations needed to find a matching hash. It then converts the total number of operations into more human-readable units of time, such as years.

The program assumes a processor speed of 1.18 million operations per microsecond and uses this value to estimate the duration of the brute force attack in various time units (seconds, minutes, hours, days, and years). The final output displays the estimated number of years required for the processor to complete the attack, providing an insight into the practicality and efficiency of brute force attacks on hash functions with large output spaces.

### Terminal Output

```bash
Der Prozessor würde: 1.2732534023551096E16 Jahre benötigen
```

# Hash Function

This is a custom Hash Function Implementation

## HashfunctionTest (Main)

The program demonstrates a custom hash function using ASCII character representation and binary conversions. The program accepts a string input and converts each character into its ASCII representation, followed by its binary equivalent. These binary strings are concatenated to form a single binary string.

The resulting binary string is further split into segments of length 9 or less. Each segment is converted back to its decimal representation, and the decimal values are summed up. The program then calculates the single-digit cross-sum (checksum) of the combined decimal value, which serves as the final output. In between all the steps, logs are shown within the terminal as well.

### Terminal Output

```bash
Nun wird eine Bytekette erstellt...

Charakter an Stelle [0]: H;
ASCII-Code: 72;
Binärcode: 1001000;
Erstellte Binarykette: 1001000

...

Charakter an Stelle [9]: t;
ASCII-Code: 116;
Binärcode: 1110100;
Erstellte Binarykette: 100100011000011101100110110011011111000001010111110010111011001110100


-------------------------------
Binär: 100100011 (reverse:) 110001001
Byte aufschlüsseln an Stelle [0]: 1
--------> daraus resultierender Wert: 1
Byte aufschlüsseln an Stelle [1]: 1
--------> daraus resultierender Wert: 2
Byte aufschlüsseln an Stelle [2]: 0
--------> daraus resultierender Wert: 0
Byte aufschlüsseln an Stelle [3]: 0
--------> daraus resultierender Wert: 0
Byte aufschlüsseln an Stelle [4]: 0
--------> daraus resultierender Wert: 0
Byte aufschlüsseln an Stelle [5]: 1
--------> daraus resultierender Wert: 32
Byte aufschlüsseln an Stelle [6]: 0
--------> daraus resultierender Wert: 0
Byte aufschlüsseln an Stelle [7]: 0
--------> daraus resultierender Wert: 0
Byte aufschlüsseln an Stelle [8]: 1
--------> daraus resultierender Wert: 256
Teilergebnis: gewandelte Dezimalsumme aus Byte: 291
-------------------------------

...

-------------------------------
Binär: 110100 (reverse:) 001011
Byte aufschlüsseln an Stelle [0]: 0
--------> daraus resultierender Wert: 0
Byte aufschlüsseln an Stelle [1]: 0
--------> daraus resultierender Wert: 0
Byte aufschlüsseln an Stelle [2]: 1
--------> daraus resultierender Wert: 4
Byte aufschlüsseln an Stelle [3]: 0
--------> daraus resultierender Wert: 0
Byte aufschlüsseln an Stelle [4]: 1
--------> daraus resultierender Wert: 16
Byte aufschlüsseln an Stelle [5]: 1
--------> daraus resultierender Wert: 32
Teilergebnis: gewandelte Dezimalsumme aus Byte: 52
-------------------------------

Alle Teilergebnisse des Strings 'Hallo Welt aufaddiert': 1886
Einstellige Quersumme aus dem gebildeten Hash: 5
```
