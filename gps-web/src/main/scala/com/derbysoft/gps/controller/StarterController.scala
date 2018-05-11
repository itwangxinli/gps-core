package com.derbysoft.gps.controller

import com.derbysoft.gps.data.base.Base
import com.derbysoft.gps.data.repository.ScalaCityRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation._

import scala.collection.JavaConverters._

@RestController
class StarterController {
  @Autowired
  var cityRepository: ScalaCityRepository = _

  @GetMapping(Array("/"))
  def home = {
    val base = new Base
    base.setId(0)
    val city = cityRepository.findByCityCode("City")
    Map("result" -> "Success", "cs" -> city).asJava
  }
}