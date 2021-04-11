package com.mufic.Final.api.v2.model.lists;

import com.mufic.Final.api.v2.model.TransactionDTO;
import com.mufic.Final.domain.Transaction;
import com.mufic.Final.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TransactionsListDTO {
    List<TransactionDTO> transactions;
}
