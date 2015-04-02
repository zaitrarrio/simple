package com.simple.services.db

import com.simple.jdub.CollectionQuery
import com.simple.jdub.Row
import com.simple.services.core.TransactionEntry

// Query returning a TransactionEntry object for each row.
case object GetTransactionEntriesQuery extends CollectionQuery[Seq, TransactionEntry] {

  val sql = trim("""
      SELECT id, name, amount, creation_date
      FROM trans
      """)

  val values = Seq()

  def map(row: Row) = {
    val id = row.long("id").get
    val name = row.string("name").get
    val amount = row.bigDecimal("amount").get
    val creationDate = row.datetime("creation_date").get
    TransactionEntry.apply(id, name, amount, creationDate)
  }

}