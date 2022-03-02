package com.ibm.academia.restapi.fraudes.models.entities

import lombok.AllArgsConstructor
import lombok.Getter
import lombok.Setter
import java.io.Serializable
import javax.persistence.*

@Entity
@Setter
@Getter
@AllArgsConstructor
@Table(name = "black_list_ip")
class IP: Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null

    @Column(name = "ip", nullable = false)
    private val ip: String? = null
}