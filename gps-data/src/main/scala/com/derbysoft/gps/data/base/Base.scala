package com.derbysoft.gps.data.base

import java.time.LocalDateTime

import javax.persistence._

import scala.beans.BeanProperty
@MappedSuperclass
class Base {


  @BeanProperty
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Long = _

  @BeanProperty
  var createdTime: LocalDateTime = _

  @BeanProperty
  var lastModifyTime: LocalDateTime = _

  @PrePersist
  @PreUpdate
  def init(): Unit = {
    if (id == null) createdTime = LocalDateTime.now
    lastModifyTime = LocalDateTime.now
  }

}
