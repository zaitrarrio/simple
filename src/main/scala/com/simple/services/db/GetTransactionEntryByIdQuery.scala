package com.simple.services.db

import com.simple.jdub.Row
import com.simple.jdub.FlatSingleRowQuery
import com.simple.services.core.TransactionEntry

// Query returning a TransactionEntry object for the specified id.
case class GetTransactionEntryByIdQuery(id: Long) extends FlatSingleRowQuery[TransactionEntry] {

  val sql = trim("""
      SELECT id, name, amount, creation_date
      FROM trans
      WHERE id = ?
      """)

  val values = Seq(id)

  def flatMap(row: Row) = {
    val id = row.long("id").get
    val name = row.string("name").get
    val amount = row.bigDecimal("amount").get
    val creationDate = row.datetime("creation_date").get
    Option(TransactionEntry.apply(id, name, amount, creationDate))
  }

}