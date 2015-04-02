package com.simple.services.core

import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.validator.constraints.NotEmpty
import org.joda.time.DateTime

/**
 * TODO: case class parameters don't seem to work properly with this but vars do?
 */

case class TransactionEntry( ) {
  @JsonProperty 
  @NotEmpty(message = "Missing id in transaction entry") 
  var id: Long = _

  @JsonProperty 
  @NotEmpty(message = "Missing name in transaction entry") 
  var name: String = _

  @JsonProperty 
  @NotEmpty(message = "Missing amount in transaction entry") 
  var amount: BigDecimal = _


  @JsonProperty 
  @NotEmpty(message = "Missing creation date in transaction entry") 
  var creationDate: DateTime  = _
  
}

object TransactionEntry {
  def apply(id: Long, name: String, amount: BigDecimal, creationDate: DateTime) : TransactionEntry = { 
      val t = new TransactionEntry()
      t.id = id
      t.name = name 
      t.amount = amount
      t.creationDate = creationDate
      return t
  }
}