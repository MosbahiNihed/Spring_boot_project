package com.grokonez.jwtauthentication.repository;

import com.grokonez.jwtauthentication.model.Plat;
import com.grokonez.jwtauthentication.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface PlatRepository extends JpaRepository<Plat, Long> {
    Optional<Plat> findPlatById(long id);

    void deletePlatById(Long id);
    @Query(value="select * from plat  where nomplat = :nom", nativeQuery = true)
    List<Plat> findByName(@Param("nom") String nom);
}
