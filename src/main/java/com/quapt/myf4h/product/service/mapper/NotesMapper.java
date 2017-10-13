/**
 * 
 */
package com.quapt.myf4h.product.service.mapper;

import com.quapt.myf4h.product.domain.Notes;
import com.quapt.myf4h.product.rest.dto.NotesDto;

import org.mapstruct.Mapper;

/**
 * @author logesh
 *
 */
@Mapper(componentModel = "spring", uses = {})
public interface NotesMapper {

    NotesDto toDto(Notes notes);

    Notes toEntity(NotesDto notesDto);

}
