package com.mufic.Final.api.v2.model.lists;

import com.mufic.Final.api.v2.model.TermDTO;
import com.mufic.Final.domain.Term;
import com.mufic.Final.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TermListDTO {
    List<TermDTO> terms;
}
