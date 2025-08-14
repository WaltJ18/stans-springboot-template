package template.testing.secondary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestingSecondaryEntityRepository extends JpaRepository<TestingSecondaryEntity, Long> {

}
