import java.sql.{ResultSet, DriverManager}

import scala.slick.driver.MySQLDriver.simple._

object MyJdbcConnection {
def main (args: Array[String]) {
  // keep password as null if local connection.
  val conn_str = "jdbc:mysql://127.0.0.1:3306/my_db?user=root&password="
  classOf[com.mysql.jdbc.Driver]

  val conn = DriverManager.getConnection(conn_str)

  val statement = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)

  // Execute Query
  val rs = statement.executeQuery("SELECT * FROM junius")

  // Iterate Over ResultSet
  while (rs.next) {
    println(rs.getString("quote"))
  }
  }
}
