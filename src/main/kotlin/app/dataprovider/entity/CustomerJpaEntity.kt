package app.dataprovider.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "customers")
class CustomerJpaEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,
    var name: String? = null
) {
}