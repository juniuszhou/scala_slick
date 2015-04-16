package Jdbc

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource

import scala.slick.driver.MySQLDriver.simple._

object MySqlAccess {

  def main (args: Array[String]) {
    val ds = new MysqlDataSource
    val db = Database.forDataSource(ds)

    def database: Session = {
      val dataSource = new MysqlDataSource()
      dataSource.setUser("root")
      dataSource.setPassword("")
      dataSource.setDatabaseName("my_db")

      val dataBase = Database.forDataSource(dataSource)
      dataBase.createSession
    }


  }
}
