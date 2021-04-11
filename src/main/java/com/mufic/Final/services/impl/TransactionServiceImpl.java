package com.mufic.Final.services.impl;

import com.mufic.Final.api.v2.mapper.TransactionMapper;
import com.mufic.Final.api.v2.model.TransactionDTO;
import com.mufic.Final.api.v2.model.lists.TransactionsListDTO;
import com.mufic.Final.controllers.v2.TransactionController;
import com.mufic.Final.domain.Program;
import com.mufic.Final.domain.Transaction;
import com.mufic.Final.repositories.TransactionRepository;
import com.mufic.Final.services.ResourceNotFoundException;
import com.mufic.Final.services.TransactionService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionMapper transactionMapper;
    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionMapper transactionMapper, TransactionRepository transactionRepository) {
        this.transactionMapper = transactionMapper;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public TransactionDTO getById(Long id) {
        return transactionRepository.findById(id)
                .map(transactionMapper::objToDTO)
                .map(transactionDTO -> {
                    transactionDTO.setTransactionUrl(getUrl(id));
                    return transactionDTO;
                })
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public TransactionsListDTO getAll() {
        return new TransactionsListDTO(
            transactionRepository.findAll()
            .stream()
            .map(transactionMapper::objToDTO)
            .map(transactionDTO -> {
                transactionDTO.setTransactionUrl(getUrl(transactionDTO.getId()));
                return transactionDTO;
            })
            .collect(Collectors.toList())
        );
    }

    @Override
    public TransactionDTO createNew(TransactionDTO transactionDTO) {
        Transaction transaction=transactionMapper.dtoToObj(transactionDTO);
        return saveAndReturnDTO(transaction);
    }

    private TransactionDTO saveAndReturnDTO(Transaction transaction) {
        Transaction saved = transactionRepository.save(transaction);

        TransactionDTO returnDto= transactionMapper.objToDTO(saved);

        returnDto.setTransactionUrl(getUrl(saved.getId()));

        return returnDto;
    }

    @Override
    public TransactionDTO saveByDTO(Long id, TransactionDTO transactionDTO) {
        Transaction toSave = transactionMapper.dtoToObj(transactionDTO);
        toSave.setId(id);
        return saveAndReturnDTO(toSave);
    }

    @Override
    public TransactionDTO patch(Long id, TransactionDTO transactionDTO) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        transactionRepository.deleteById(id);
    }

    private String getUrl(long id) {
        return TransactionController.BASE_URL + "/" + id;
    }
}
