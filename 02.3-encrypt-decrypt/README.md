# RSA Encryption-Decryption

Encryption-Decryption refers to the process of converting readable data (plaintext) into unreadable data (ciphertext) to ensure secure transmission or storage, and then converting it back to its original form. Encryption involves applying a mathematical algorithm and a secret key to the plaintext, while decryption reverses the process using the same or a related key.

This method safeguards sensitive information from unauthorized access, ensuring confidentiality, integrity, and authenticity in various applications, such as secure communication, data storage, and online transactions.

## RSA (Main, Maven)

This program demonstrates a simple implementation of the RSA cryptosystem, which is a widely-used public key cryptosystem for secure data transmission. The program generates a public-private key pair, then prompts the user to enter a secret message. The message is encrypted using the private key, and the encrypted output is displayed. The user is then asked if they want to decrypt the RSA output. If the user selects 'y', the encrypted message is decrypted using the public key, and the original message is displayed.

## Terminal Output

```
Geben sie ihre geheime Botschaft ein:
Testnachricht
ergiebt diesen RSA-Output:
[RSA-MSG]
Wollen Sie den RSA-Output entschlüsseln? y/n
y
Nachricht lautete: Testnachricht
```
