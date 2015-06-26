package cn.edu.buaa.jhipster.web.rest.mapper;

import cn.edu.buaa.jhipster.domain.*;
import cn.edu.buaa.jhipster.web.rest.dto.AuthorDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Author and its DTO AuthorDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface AuthorMapper {

    AuthorDTO authorToAuthorDTO(Author author);

    Author authorDTOToAuthor(AuthorDTO authorDTO);
}
