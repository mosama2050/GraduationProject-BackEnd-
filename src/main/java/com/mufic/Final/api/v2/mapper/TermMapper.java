package com.mufic.Final.api.v2.mapper;

import com.mufic.Final.api.v2.model.TermDTO;
import com.mufic.Final.domain.City;
import com.mufic.Final.domain.CourseInTerm;
import com.mufic.Final.domain.Term;
import com.mufic.Final.repositories.CourseInTermRepository;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public abstract class TermMapper {
//    TermMapper INSTANCE = Mappers.getMapper(TermMapper.class);

    @Autowired
    private CourseInTermRepository courseInTermRepository;

    public abstract TermDTO objToDTO(Term obj);

    public abstract Term dtoToTerm(TermDTO obj);

    @IterableMapping(elementTargetType = Long.class)
    protected abstract List<Long> maplistToLong(List<CourseInTerm> list);

    @IterableMapping(elementTargetType = CourseInTerm.class)
    protected abstract List<CourseInTerm> mapToCourseInTermList(List<Long> list);

    protected Long mapToLong(CourseInTerm courseInTerm) {
        return courseInTerm.getId();
    }

    protected CourseInTerm mapToCourseInTerm(Long id){
        return courseInTermRepository.getOne(id);
    }

}
