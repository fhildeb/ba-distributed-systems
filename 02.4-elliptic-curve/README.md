# Elliptic Curve Digital Signature

Elliptic curves are mathematical objects defined by a smooth cubic equation in two variables. They exhibit unique properties and have applications in number theory and cryptography.

In cryptography, elliptic curve algorithms are used for key exchange, digital signatures, and encryption due to their efficiency and high security. Compared to traditional cryptographic methods, elliptic curve cryptography offers similar levels of security with smaller key sizes, resulting in faster computations, lower power consumption, and reduced storage requirements, making them suitable for resource-constrained environments.

## ECDSA (Main, Maven)

This program demonstrates the implementation of Elliptic Curve Digital Signature Algorithm for creating and verifying digital signatures in Java using the Bouncy Castle library. It first generates a key pair using a specified elliptic curve. Then, it creates a digital signature using the private key and a given plaintext message. Finally, the program verifies the signature using the corresponding public key to ensure its authenticity. This demonstrates how ECDSA can be used for secure message exchange and to confirm the integrity and origin of the message.

### Terminal Output

```
EC Public Key [KEY]
            X: encrypted string
            Y: encrypted string

EC Private Key [KEY]
            X: encrypted string
            Y: encrypted string

[B@661972b0
Result: true
```
