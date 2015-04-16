package Jdbc
import scala.slick.driver.MySQLDriver.simple._
import scala.slick.lifted.ProvenShape

case class jun(id: Int, name: String)
class junius(tag: Tag) extends Table[jun](tag, "JUNIUS"){
  def id: Column[Int] = column[Int]("ID", O.PrimaryKey )
  def name: Column[String] = column[String]("NAME", O.NotNull)
  // def * = (id, name) <> (jun.tupled, jun.unapply)
  def * : ProvenShape[jun] = (id, name) <> (jun.tupled, jun.unapply)
}
