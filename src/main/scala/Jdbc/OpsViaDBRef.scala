package Jdbc

import scala.slick.driver.MySQLDriver.simple._
import scala.slick.lifted.TableQuery
import scala.slick.jdbc.meta.MTable

object OpsViaDBRef {


  def createTable() = {
    val juniusTable = TableQuery[junius]
    val db = MySqlConnection.getDb
    db.withSession { implicit session =>
      // create schema
      def ifTableExist(name: String): Boolean = {
        // get tables info from meta data table to see if table already there.
        MTable.getTables(name).list.nonEmpty
      }
      if (!ifTableExist("junius")) juniusTable.ddl.create
    }
  }

  def insertRecord() = {
    val juniusTable = TableQuery[junius]
    val db = MySqlConnection.getDb
    db.withSession { implicit session =>
      juniusTable += jun(1, "junius")
      juniusTable ++= Seq(jun(2,"yunshu"), jun(3, "mengyuan"))

    }
  }

  def opViaCompiledProcess() = {
    val juniusTable = TableQuery[junius]
    val db = MySqlConnection.getDb
    db.withSession { implicit session =>
      val upTo = Compiled {
        i: Column[Int] =>
          juniusTable.filter(_.id > i).sortBy(_.id)
      }
      println(upTo(1).list)
    }
  }

  def main(args: Array[String]) {
    insertRecord()
    opViaCompiledProcess()

  }
}
