package zoltanszikszo.LuckyBox.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserboxesRepository extends CrudRepository<Userboxes, Long> {
    List<Userboxes> findBoxesByName(@Param("name") String name);
}
