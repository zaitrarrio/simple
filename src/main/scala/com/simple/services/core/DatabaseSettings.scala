package com.simple.services.core

import javax.validation.constraints.{Max, Min}

import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.validator.constraints.NotEmpty

/**
 * TODO: case class parameters don't seem to work properly with this but vars do?
 */

case class DatabaseSettings( ) {
  @JsonProperty 
  @NotEmpty(message = "Missing driver class in settings") 
  var driverClass: String = _

  @JsonProperty 
  @NotEmpty(message = "Missing url in settings") 
  var url: String = _

  @JsonProperty 
  @NotEmpty(message = "Missing user in settings") 
  var user: String = _

  @JsonProperty 
  var password: String = _
  
}

object DatabaseSettings {
  def apply(driverClass: String, url: String, user: String, pass: String) : DatabaseSettings = { 
    val s = new DatabaseSettings(); 
    s.driverClass = driverClass
    s.url = url
    s.user = user
    s.password = pass
    return s
  }
}