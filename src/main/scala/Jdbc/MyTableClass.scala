package Jdbc
import scala.slick.driver.MySQLDriver.simple._
import scala.slick.lifted.TableQuery

object MyTableClass {
  def createTable() = {
    val juniusTable = TableQuery[junius]
    val db = MySqlConnection.getDb

    db.withSession { implicit session =>
      // create schema
      juniusTable.ddl.create

      // insert
      val jj = jun(1,"junius")
      //juniusTable += jj

      println(juniusTable.size)

      juniusTable += jun(1, "junius")
      juniusTable += jun(2, "yunshu")

      //
      println(juniusTable.list)
    }


  }
    def main (args: Array[String]) {
      createTable()
  }
}
