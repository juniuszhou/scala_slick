import scala.slick.driver.MySQLDriver.simple._
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource

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
