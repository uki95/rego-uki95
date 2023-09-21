package com.clipclap.rego.model.entitiy;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/*

세부 플래너 (DetailPlan) 테이블

세부플랜ID (detailPlanId):      주요 식별자 (자동 생성)
플랜 ID (planId):             외래 키로 연결된 플랜의 식별자
내용/설명 (content):            세부 플랜에 대한 내용 또는 설명
위도,경도 (latitude, longitude):위도, 경도 정보   --> DB에있는 관광지가 아닐 경우
시작시간 (startTime):           세부 플랜의 시작 시간
종료시간 (endTime):             세부 플랜의 종료 시간
관광지 (touristAttraction):     관광지 정보

*/

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "detailPlan")
public class PlannerDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long detailPlanId;

    @ManyToOne
    @JoinColumn(name = "planId", referencedColumnName = "planId")
    private Planner plan;

    @Column(nullable = false)
    private String content;

    private double latitude;

    private double longitude;

    @Column(nullable = false)
    private LocalDate startTime;

    @Column(nullable = false)
    private LocalDate endTime;

    @ManyToOne
    @JoinColumn(name = "touristAttraction", referencedColumnName = "touristAttractionId")
    private TouristAttraction touristAttraction;

}




