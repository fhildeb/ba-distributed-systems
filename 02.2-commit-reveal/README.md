# Cryptographic Commit-Reveal Scheme

The commit-reveal scheme is a cryptographic protocol used to ensure that a participant in a distributed system commits to a specific value, without revealing the value itself, until a later time. This technique is commonly employed in various applications, such as secure voting, auctions, and fair exchange protocols.

In a commit-reveal scheme, the process consists of two phases:

- Commit Phase: The participant selects a value and generates a commitment using a cryptographic hash function. This commitment is a hash of the chosen value combined with a random secret. The participant then shares the commitment with other parties in the system, while keeping the value and the secret private.
- Reveal Phase: At a later time, when it is appropriate to disclose the value, the participant reveals both the original value and the secret used to create the commitment. Other parties can then verify the commitment by hashing the revealed value and secret, and comparing the result with the initially shared commitment.

The commit-reveal scheme ensures that participants cannot change their values after committing and provides a level of fairness and transparency in distributed systems.

## CommitmentAPI (Main, Maven)

The program demonstrates a simple commitment scheme using cryptographic hashing, allowing users to commit to a value without revealing it initially.

The program utilizes the SHA-256 hashing algorithm to generate a commitment hash from a message and a randomly generated key. The hash, key, and original message are stored in a list. To verify a commitment, the user inputs the commitment hash, key, and the message they claim to have committed. The program reconstructs the hash using the provided message and key and compares it to the stored commitment hash. If the hashes match, the commitment is considered valid, proving that the user had knowledge of the committed message without disclosing it beforehand.

### Terminal Output

```
[d01544650932f1e3958535c8edf805b3ef15d3588804b9f52bfac27e0c38efcd, 19686]
Geben Sie COM-KEY-MSG zum Prüfen ein:
[COM-KEY-MSG]
[RESULT]
```
