# RSA Signature Verification

The RSA signature scheme is a widely used asymmetric cryptographic method for creating and verifying digital signatures, ensuring data integrity and authenticity. In RSA, a user generates a key pair consisting of a public key and a private key. The public key is shared openly, while the private key remains secret.

To sign a message, the signer uses their private key. To verify the signature, the recipient uses the sender's public key to raise the signature. If the recovered message matches the original, the signature is considered valid.

RSA signatures provide non-repudiation, ensuring that the signer cannot deny creating the signature, as only they possess the private key required for signing.

## Signature (Main)

The program demonstrates the implementation of the RSA algorithm for digital signature creation and verification. The program starts by initializing two prime numbers, and computes their product, and Euler's totient function. It then selects a public key exponent, and calculates the private key exponent using the modular inverse.

The program simulates the signing process by raising a message, to the power of d and taking the result modulo n, which generates the signature.

To verify the signature, it raises the signature to the power of e and takes the result modulo n, which should align with the original message.

Finally, the program checks if the recovered message matches the original message and outputs the result, indicating whether the signature is valid or not.

### Terminal Output

```
n: 3233
phi: 730
d: 43
2479
m: 5
m-check: 2139
Signatur stimmt nicht.
```
