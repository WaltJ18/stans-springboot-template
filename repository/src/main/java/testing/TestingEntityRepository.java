package testing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestingEntityRepository extends JpaRepository<TestingEntity, Long> {

}
