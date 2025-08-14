package template.testing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import template.testing.TestingEntity;

@Repository
public interface TestingEntityRepository extends JpaRepository<TestingEntity, Long> {

}
