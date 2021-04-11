package com.mufic.Final.api.v2.mapper;

import com.mufic.Final.api.v2.model.TransactionDTO;
import com.mufic.Final.domain.Student;
import com.mufic.Final.domain.Term;
import com.mufic.Final.domain.Transaction;
import com.mufic.Final.repositories.StudentRepository;
import com.mufic.Final.repositories.TermRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public abstract class TransactionMapper {
//    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    @Autowired
    private TermRepository termRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Mapping(source = "term.id", target = "term")
    @Mapping(source = "student.id", target = "student")
    public abstract TransactionDTO objToDTO(Transaction obj);

    public abstract Transaction dtoToObj(TransactionDTO transactionDTO);

    public Term mapToTerm(Long id){
        return termRepository.getOne(id);
    }

    public Student mapToStudent(Long id){
        return studentRepository.getOne(id);
    }

}
