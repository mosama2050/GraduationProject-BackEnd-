package com.mufic.Final.api.v2.model.lists;

import com.mufic.Final.api.v2.model.LabDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class LabListDTO {
    List<LabDTO> labs;

}
