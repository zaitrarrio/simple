package com.simple.services

import javax.validation.Valid

import com.simple.services.core.{DatabaseSettings,SwaggerSettings}
import com.fasterxml.jackson.annotation.JsonProperty
import com.google.common.base.Objects
import io.dropwizard.Configuration
import org.hibernate.validator.constraints.NotEmpty


class SimpleServiceConfiguration extends Configuration {

  @JsonProperty("appName") 
  @NotEmpty  
  var appName: String = _ //  config propName differs from actual name

  @Valid 
  @JsonProperty("database")  
  var database : DatabaseSettings = _

  @Valid 
  @JsonProperty("swagger")  
  var swagger : SwaggerSettings = _
  
  override def toString: String = {
    Objects.toStringHelper(this)
      .add("appName", appName)
      .add("server", getServerFactory)
      .add("database", database)
      .add("swagger", swagger)
      .toString
  }
}