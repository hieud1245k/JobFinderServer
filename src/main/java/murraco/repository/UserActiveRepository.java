package murraco.repository;

import murraco.model.UserActive;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserActiveRepository extends JpaRepository<UserActive, Integer> {

    UserActive findByUserIdAndDeletedDateNull(Integer userId);
}
