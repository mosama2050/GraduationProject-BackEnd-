package com.mufic.Final.api.v2.model.lists;

import com.mufic.Final.api.v2.model.PrivilegeDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PrivilegeListDTO {
    List<PrivilegeDTO> privileges;

}
