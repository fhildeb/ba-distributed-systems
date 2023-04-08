# Bitcoin Block Explorer

Block explorers are web-based tools that provide real-time information and analysis of blockchain networks. They allow users to query various data points, such as transaction history, block information, and address balances. By indexing and displaying data from the underlying distributed ledger, block explorers enable users to track and verify transactions, detect anomalies, and monitor the overall network health.

## BlockParser (Main, Maven)

This program focuses on parsing and analyzing Bitcoin blocks from the Bitcoin main network. The program reads a file containing multiple Bitcoin blocks, selects the first block, and displays its hash. It then retrieves the first transaction within the block, showing its hash, the number of inputs and outputs, and their types.

Additionally, the program determines whether the transaction is a Coinbase transaction, which is a unique type of transaction that generates new bitcoins as a reward for miners.

By providing insights into the structure and content of Bitcoin blocks and transactions, the project helps users gain a better understanding of the Bitcoin blockchain.

### Terminal Output

```
Erster Block Hash: [FIRST_FILE_BLOCK_HASH]
Erster Transaktion --Hash: [FIRST_TX_HASH]
Erster Transaktion --Anzahl Inputs: [INPUTS_ON_FIRST_TX]
Erster Transaktion --Anzahl Outputs: [OUTPUTS_ON_FIRST_TX]
Ist Transaktion Coinbase Transaction?: [BOOL]
```
