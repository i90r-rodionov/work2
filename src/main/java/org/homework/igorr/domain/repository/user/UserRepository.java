package org.homework.igorr.domain.repository.user;

import org.homework.igorr.domain.entity.user.User;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value = "-2")})
    @Query("select user from User user where user.id = :id")
    Optional<User> findUserWithLock(@Param("id") Long id);

    @Override
    Optional<User> findById(Long id);
}
