package com.clipclap.rego.repository;

import com.clipclap.rego.model.entitiy.PlannerDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DetailPlanRepository extends JpaRepository<PlannerDetail, Integer> {

    void deleteByDetailPlanId(Integer detailPlanId);

    @Query(value = "SELECT AUTO_INCREMENT FROM information_schema.TABLES WHERE TABLE_SCHEMA = 'planner' AND TABLE_NAME = 'detailPlan'", nativeQuery = true)
    Integer findNextAutoIncrementValue();

    @Query("SELECT MAX(p.detailPlanId) FROM PlannerDetail p WHERE p.plan.planId = :planId")
    Integer findMaxDetailPlanIdByPlanId(@Param("planId") Integer planId);


}
