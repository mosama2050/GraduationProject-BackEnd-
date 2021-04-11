package com.mufic.Final.api.v2.model.lists;

import com.mufic.Final.api.v2.model.TeachingStaffDTO;
import com.mufic.Final.domain.TeachingStaff;
import com.mufic.Final.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TeachingStaffListDTO {
    List<TeachingStaffDTO> teachingStaffs;
}
