# Merkle Trees

Merkle Trees are binary tree data structures used in cryptography and computer science. Each leaf node contains a cryptographic hash of transactional data, while non-leaf nodes store the combined hash of their respective child nodes. The top-most node, known as the Merkle Root, represents a single hash value that encompasses the entire tree. Merkle Trees facilitate efficient and secure data verification through Merkle Proofs, enabling the validation of specific transactions without requiring access to the full dataset, thus optimizing privacy and resource utilization.

## MerkleTreeTest (Main, Maven)

This program implements a Merkle Tree data structure and provides methods for generating and validating Merkle Proofs. The project uses Google's Guava library for hashing.

- The MerkleTree class constructs a Merkle Tree using an ArrayList of transaction data and provides a method to obtain the Merkle Root.
- The MerkleTreeWithProof class extends the MerkleTree functionality by adding a method to generate a Merkle Proof for a given transaction index.

The tester class then demonstrates how to create a Merkle Tree and validate Merkle Proofs using the provided classes.

### Terminal Output

```
Merkle Root: 5d2a8967adb92f46e3266c0cddef844418e95fc6dbe733029e8a7da6145a5afe
Merkle Path: [252f10c83610ebca1a059c0bae8255eba2f95be4d1d7bcfa89d7248a82d9f111, 520328b68932e91dbd3194a6d12050ffa99d1dc603400c375850a888d2706135, 58c89d709329eb37285837b042ab6ff72c7c8f74de0446b091b6a0131c102cfd]
Test mit enthaltener Transaktion: true
Test mit nicht enthaltener Transaktion: false
```
