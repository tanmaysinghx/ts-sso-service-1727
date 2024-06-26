package com.ts.ts_sso_service_1727.repo;

import com.ts.ts_sso_service_1727.entity.RefreshTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author tanmay
 */
@Repository
public interface RefreshTokenRepo extends JpaRepository<RefreshTokenEntity, Long> {
    Optional<RefreshTokenEntity> findByRefreshToken(String refreshToken);

}
