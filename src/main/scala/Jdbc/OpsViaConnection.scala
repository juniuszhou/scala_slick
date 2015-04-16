package Jdbc

import java.sql.{Connection, ResultSet}

object OpsViaConnection {
  def createTable(conn: Connection) = {
    val statement = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)

    // Can not issue data manipulation statements with executeQuery()
    val rs = statement.executeQuery("CREATE TABLE my_db.junius(id INTEGER, name VARCHAR(20))")
  }

  def getAll(conn: Connection) = {
    val statement = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)

    // Execute Query
    val rs = statement.executeQuery("SELECT * FROM junius")

    // Iterate Over ResultSet
    while (rs.next) {
      println(rs.getString("name"))
    }
  }
  def main(args: Array[String]) {
    val conn = MySqlConnection.getConnection
    getAll(conn)

  }
}
