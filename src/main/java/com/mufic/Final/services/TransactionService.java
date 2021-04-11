package com.mufic.Final.services;

import com.mufic.Final.api.v2.model.TransactionDTO;
import com.mufic.Final.api.v2.model.lists.TransactionsListDTO;

public interface TransactionService {
    TransactionDTO getById(Long id);

    TransactionsListDTO getAll();

    TransactionDTO createNew(TransactionDTO transactionDTO);

    TransactionDTO saveByDTO(Long id, TransactionDTO transactionDTO);

    TransactionDTO patch(Long id, TransactionDTO transactionDTO);

    void deleteById(Long id);
}
