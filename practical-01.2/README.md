# Bitcoin Address Generation

## Btc_Class (Main, Maven)

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
