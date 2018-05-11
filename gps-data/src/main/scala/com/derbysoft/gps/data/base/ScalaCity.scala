package com.derbysoft.gps.data.base

import javax.persistence.{Entity, Table, UniqueConstraint}

import scala.beans.BeanProperty

@Entity
@Table(uniqueConstraints = Array(new UniqueConstraint(columnNames = Array("cityCode"))))
class ScalaCity extends Base {
  @BeanProperty
  var cityCode: String = _

  @BeanProperty
  var cityName: String = _
}
