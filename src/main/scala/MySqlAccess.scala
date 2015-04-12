import com.mysql.jdbc.jdbc2.optional.MysqlDataSource

import scala.slick.driver.MySQLDriver.simple._

import scala.slick.session.Database
import scala.slick.session.Session
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource

object MySqlAccess {
  def main (args: Array[String]) {
    def database: Session = {
      val dataSource = new MysqlDataSource()
      dataSource.setUser("root")
      dataSource.setPassword("root")
      dataSource.setDatabaseName("test")

      val dataBase = Database.forDataSource(dataSource)
      dataBase.createSession
    }
  }
}
