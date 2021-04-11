package com.mufic.Final.services;

import com.mufic.Final.api.v2.model.TermDTO;
import com.mufic.Final.api.v2.model.lists.TermListDTO;

public interface TermService {
    TermDTO getById(Long id);

    TermListDTO getAll();

    TermDTO createNew(TermDTO termDTO);

    TermDTO saveByDTO(Long id, TermDTO termDTO);

    TermDTO patch(Long id, TermDTO termDTO);

    void deleteById(Long id);
}
