# Bitcoin Wallet

A Bitcoin wallet is a software application or hardware device that manages private and public keys, enabling users to securely store, send, and receive Bitcoin.

In a technical sense, the wallet doesn't store the actual coins; instead, it tracks ownership by recording transactions on the decentralized blockchain.

Wallets are responsible for generating private keys, deriving public keys and addresses, constructing and signing transactions, and broadcasting them to the network. They also monitor the blockchain to update the user's balance and transaction history, ensuring that only the owner with the correct private key can access the funds.

## Custom Implementation

This project is a Bitcoin testnet application built using the BitcoinJ library, and it demonstrates the functionality of sending and receiving Bitcoin transactions on the TestNet3 network.

The WalletAppKit is used for managing the wallet and interacting with the TestNet3 network, while event listeners are implemented to provide real-time updates on transaction confirmations and balance changes.

## BTCTestNetReceiveCoins (Main, Maven)

Listens for incoming transactions and displays the received amount.

### Terminal Output

```
Sende Geld an: mu7wJpNEoUspu8GdE8ngPSF8t9fLzbm4dU
Erhaltene Transaktion für 0.0001 BTC :   b281d0ea1d95aa94052ad8c6daf40eb413d778abdde26876012f4a851b7aca59
  updated: 2019-04-26T13:39:17Z
  version 2
  time locked until block 1512508
     in   PUSHDATA(22)[00141a7e8ceff06dc46ca76c7699cd47fc13be0fce61]
          outpoint:c494955f84f970838d214bd165f25fb26558e2aa6e8571b2b7116c688dc8c087:1
          sequence:fffffffe
     out  DUP HASH160 PUSHDATA(20)[95375ebdac677ff408d660d03f2684add2b753eb] EQUALVERIFY CHECKSIG 0.0001 BTC
     out  HASH160 PUSHDATA(20)[c5b850cd04aa5204eaa0cca328e8bff3ffe4a64f] EQUAL 0.01946742 BTC
     prps UNKNOWN

```

## BTCTestNetSendCoins (Main, Maven)

Sends a specified amount of Bitcoin to a designated address.

### Terminal Output

```
Wallet: Wallet containing 0.0001 BTC (spendable: 0.0001 BTC) in:
	  0 pending transactions
	  1 unspent transactions
	  0 spent transactions
	  0 dead transactions
	Last seen best block: 1512535 (2019-04-26T15:11:09Z): 00000000000003adc31858a132aa8593a27ad7dc88e87e54e386477b085f0c8a

	Keys:
	Earliest creation time: 2019-04-26T13:36:12Z
	Seed birthday: 1556285772  [2019-04-26T13:36:12Z]
	Key to watch:  tpubD9QeuVFCZb4VU4CLobtz9q9A5BpoLFhoVmw7dkBBj1Hujm9FvZet8hDjhKYK48Xv4dq8A3ywvqaaH626VNgJHttgKWweHVC7JRZ4gdARkcf
	  addr:mytp5todwXLN8VrMBcoSNpaCH1Kt4jwe51  hash160:c9948febcefbd20bfd91aa3129681abd08c6fdfd  (M/0H/0/0)
	  addr:mu7wJpNEoUspu8GdE8ngPSF8t9fLzbm4dU  hash160:95375ebdac677ff408d660d03f2684add2b753eb  (M/0H/0/1)
	  addr:n3n7vANzbLvecMV4eSBa4Mu8Vdexv6n5Lh  hash160:f4310a07a0b9c1b0e1ec874014fd5f4b24ca369c  (M/0H/0/2)


	>>> UNSPENT:
	0.0001 BTC total value (sends 0.00 BTC and receives 0.0001 BTC)
	  confidence: Seen by 6 peers (most recently: 2019-04-26T13:39:17Z). Appeared in best chain at height 1512510, depth 26. Source: NETWORK
	  b281d0ea1d95aa94052ad8c6daf40eb413d778abdde26876012f4a851b7aca59
	  updated: 2019-04-26T13:39:17Z
	  version 2
	  time locked until block 1512508
	     in   PUSHDATA(22)[00141a7e8ceff06dc46ca76c7699cd47fc13be0fce61]
	          outpoint:c494955f84f970838d214bd165f25fb26558e2aa6e8571b2b7116c688dc8c087:1
	          sequence:fffffffe
	     out  DUP HASH160 PUSHDATA(20)[95375ebdac677ff408d660d03f2684add2b753eb] EQUALVERIFY CHECKSIG 0.0001 BTC
	     out  HASH160 PUSHDATA(20)[c5b850cd04aa5204eaa0cca328e8bff3ffe4a64f] EQUAL 0.01946742 BTC
	     prps UNKNOWN
```
