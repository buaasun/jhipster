package cn.edu.buaa.jhipster.repository;

import cn.edu.buaa.jhipster.domain.Author;
import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Author entity.
 */
public interface AuthorRepository extends JpaRepository<Author,Long> {

}
