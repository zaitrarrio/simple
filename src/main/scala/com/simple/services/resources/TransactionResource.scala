package com.simple.services.resources

import javax.validation.Valid
import javax.ws.rs._
import javax.ws.rs.core.MediaType
import com.codahale.metrics.annotation.Timed
import com.simple.jdub.Database
import com.simple.services.core.DatabaseSettings
import com.wordnik.swagger.annotations.{ApiParam, ApiOperation, Api}
import com.simple.services.core.TransactionEntry
import com.simple.services.db.GetTransactionEntriesQuery
import com.simple.services.db.GetTransactionEntryByIdQuery

/**
 * RESTful resource showing off:
 *   - JAX-RS Resource Method/Path binding
 *   - Automatic marshalling of Scala Case Classes to JSON results
 *   - Automatic binding of Scala Classes to JAX-RS Query Params
 */
@Path("/transaction")
@Produces(Array(MediaType.APPLICATION_JSON))
@Api(value = "/transaction",
  description = "A service exposing bank transaction details",
  produces = MediaType.APPLICATION_JSON,
  consumes = MediaType.APPLICATION_JSON
)
class TransactionResource(jdub : Database) {

  @GET()
  @Timed
  @ApiOperation(value = "List all transactions", notes = "This returns all transactions unsorted by default")
  def retrieveTransactions(): Seq[TransactionEntry] =  {
    return jdub(GetTransactionEntriesQuery)
  }

  @GET()
  @Path("/{id}")
  @Timed
  @ApiOperation(value = "Return a specific transaction by id")
  def retrieveSingleTransaction(
  	@ApiParam(value = "Id of the transaction to retrieve", required = true)
    @PathParam("id") id: Long): TransactionEntry =  {

    return jdub(GetTransactionEntryByIdQuery(id)).get
  }

  @GET()
  @Path("refresh")
  @ApiOperation(value = "Refreshes the current set of transactions with the underlying banking data")
  def refreshTransactions() = {
    
  }


}