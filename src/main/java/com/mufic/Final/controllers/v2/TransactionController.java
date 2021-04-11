package com.mufic.Final.controllers.v2;

import com.mufic.Final.api.v2.model.TransactionDTO;
import com.mufic.Final.api.v2.model.UserDTO;
import com.mufic.Final.api.v2.model.lists.TransactionsListDTO;
import com.mufic.Final.services.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(TransactionController.BASE_URL)
public class TransactionController {
    public static final String BASE_URL = "/api/v2/transactions";


    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public TransactionsListDTO getList(){
        return transactionService.getAll();
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public TransactionDTO getById(@PathVariable Long id){
        return transactionService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionDTO createNew(@RequestBody TransactionDTO dto){
        return transactionService.createNew(dto);
    }

    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public TransactionDTO updateVendor(@PathVariable Long id, @RequestBody TransactionDTO dto){
        return transactionService.saveByDTO(id, dto);
    }

    @PatchMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public TransactionDTO patchVendor(@PathVariable Long id, @RequestBody TransactionDTO dto){
        return transactionService.saveByDTO(id, dto);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteVendor(@PathVariable Long id){
        transactionService.deleteById(id);
    }

}
