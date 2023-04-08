# Bitcoin Address Generation

A Bitcoin address is a unique, alphanumeric string that serves as a public identifier for a user's Bitcoin wallet, allowing them to send and receive bitcoins.

The address is derived from the user's public key using a series of cryptographic hash functions (SHA-256 and RIPEMD-160) and encoding steps (adding a version byte, checksum, and Base58 encoding). The process ensures that the address is secure, as it is computationally infeasible to deduce the private key from the public key or the address.

Bitcoin addresses are designed to be single-use, promoting anonymity and enhancing security. Users can generate multiple addresses for different transactions, making it difficult to link transactions to a single individual. The decentralized and pseudonymous nature of Bitcoin addresses has made them an integral part of the cryptocurrency ecosystem.

## BTCClass (Main, Maven)

The program demonstrates Bitcoin address generation from a given public key. It features two methods which generate the address using distinct approaches.

- The first method converts the public key to a byte array, applies the OP_HASH160 function (SHA-256 then RIPEMD-160), and utilizes the Address class from the BitcoinJ library.
- The second method performs each step of address generation manually, including appending the version byte, calculating the double SHA-256 hash, adding the checksum, and converting the result into a Base58 encoded string.

Both methods output the generated Bitcoin address.

### Terminal Output

```
Erfolgreiche Tests:

010966776006953d5567439e5e39f86a0d273bee
Die BTC-Adresse: 16UwLL9Risc3QfPqBUvKofHmBQ7wMtjvM

[B@edf4efb
Die BTC-Adressse: 16UwLL9Risc3QfPqBUvKofHmBQ7wMtjvM
```
