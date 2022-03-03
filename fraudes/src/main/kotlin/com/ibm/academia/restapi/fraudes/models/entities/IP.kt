package com.ibm.academia.restapi.fraudes.models.entities

import lombok.AllArgsConstructor
import lombok.Getter
import lombok.Setter
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "black_list_ip")
class IP (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
    @Column(name = "ip", nullable = false) var ip: String
)