package com.simple.services

import com.simple.services.health.TransactionServiceHealthCheck
import com.simple.services.resources.TransactionResource
import com.simple.services.util.CORSBundle
import com.massrelevance.dropwizard.ScalaApplication
import com.massrelevance.dropwizard.bundles.ScalaBundle
import io.dropwizard.setup.{Bootstrap, Environment}
import io.federecio.dropwizard.swagger.{SwaggerBundle, SwaggerBundleConfiguration}
import com.simple.jdub.Database


object SimpleServiceApp extends ScalaApplication[SimpleServiceConfiguration] {
	private var appName = "Simple Service"

			override def getName: String = appName

			override def initialize(bootstrap: Bootstrap[SimpleServiceConfiguration]): Unit = {

			bootstrap.addBundle(new CORSBundle)
			bootstrap.addBundle(new ScalaBundle)
			bootstrap.addBundle(new SwaggerBundle[SimpleServiceConfiguration]() {
				override def getSwaggerBundleConfiguration(configuration: SimpleServiceConfiguration): SwaggerBundleConfiguration = {
						new SwaggerBundleConfiguration(configuration.swagger.host, configuration.swagger.port)
				}
			})

	}

	override def run(conf: SimpleServiceConfiguration, env: Environment): Unit = {
			this.appName = conf.appName

			//println(conf)
			env.getValidator.validate(conf)

			// register some resources
      Class.forName(conf.database.driverClass)
			val jdub = Database.connect(conf.database.url, conf.database.user, conf.database.password)
			env.jersey().register(new TransactionResource(jdub))

			// healthchecks
			env.healthChecks().register("simpleService", new TransactionServiceHealthCheck)
	}
}