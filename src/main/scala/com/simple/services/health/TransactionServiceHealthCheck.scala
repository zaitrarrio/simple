package com.simple.services.health

import com.codahale.metrics.health.HealthCheck
import com.codahale.metrics.health.HealthCheck.Result

class TransactionServiceHealthCheck extends HealthCheck {

  override def check(): Result = {
    Result.healthy("Healthy!")
  }

}