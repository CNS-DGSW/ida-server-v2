package com.dgswiphak.ida.persistence.admission.score.entity

import com.dgswiphak.ida.persistence.BaseTimeEntity
import jakarta.persistence.*

@Entity
@Table(name = "score")
@DiscriminatorColumn(name = "score_type")
@Access(AccessType.FIELD)
@Inheritance(strategy = InheritanceType.JOINED)
abstract class ScoreEntity(
    id: Long? = 0,
): BaseTimeEntity() {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = id
        protected set
}
