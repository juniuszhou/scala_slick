package Jdbc

import java.sql.{Connection, DriverManager}

import scala.slick.driver.MySQLDriver.backend.DatabaseDef
import scala.slick.driver.MySQLDriver.simple._

object MySqlConnection {
  // keep password as null if local connection.
  val conn_str = "jdbc:mysql://127.0.0.1:3306/my_db?user=root&password="
  val driver_str = "com.mysql.jdbc.Driver"
  def getConnection : Connection = {
    classOf[com.mysql.jdbc.Driver]
    DriverManager.getConnection(conn_str)
  }

  def getDb: DatabaseDef = {
    val conUrl = "jdbc:mysql://127.0.0.1:3306/my_db"
    Database.forURL(conUrl, user = "root", driver = driver_str)
  }
}
