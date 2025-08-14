package template.testing.primary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestingPrimaryEntityRepository extends JpaRepository<TestingPrimaryEntity, Long> {

}
