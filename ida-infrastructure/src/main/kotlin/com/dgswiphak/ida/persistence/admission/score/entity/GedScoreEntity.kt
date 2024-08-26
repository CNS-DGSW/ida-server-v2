package com.dgswiphak.ida.persistence.admission.score.entity

import com.dgswiphak.ida.domain.admission.score.model.value.Point
import com.dgswiphak.ida.persistence.admission.score.entity.value.GedGradeVO
import jakarta.persistence.*

@Entity
@Table(name = "ged_score")
@DiscriminatorValue("G")
class GedScoreEntity(
    id: Long,
    grades: List<GedGradeVO>,
    participate: Point
) : ScoreEntity(id) {
    @OrderColumn(name = "ged_idx")
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "ged_grade", joinColumns = [JoinColumn(name = "score_id")])
    protected val mutableGrades: MutableList<GedGradeVO> = grades.toMutableList()
    val grades: List<GedGradeVO> get() = mutableGrades.toList()

    var participate: Point = participate
        protected set
}
