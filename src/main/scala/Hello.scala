import scalikejdbc._


object Hello{
  def main(args: Array[String]): Unit = {
    val ages = Seq(42, 75, 29, 64)
    println(s"The oldest person is ${ages.max}")


    Class.forName("org.postgresql.Driver")

    ConnectionPool.singleton("jdbc:postgresql://127.0.0.1:5432/fzjz", "cw", "fzjz6dd")

   // implicit val session = AutoSession

    /*Seq("keyboard", "screen", "vedio") foreach { name =>
      sql"insert into products (name) values (${name})".update.apply()
    }
    */

    case class Products(product_no: Int, name: String, price: Option[Int] ){

      override def toString: String = s"$product_no:$name:${price.getOrElse("EmptyValue")}"
    }

    DB readOnly { implicit session =>
      sql"select * from products".foreach { rs =>
        println(Products(rs.int("product_no"), rs.string("name"), rs.intOpt("price")))
      }
    }


    val headvertex: List[String] = DB readOnly { implicit session =>
      sql"select distinct headvertex from edges".map(rs => rs.string("headvertex")).list.apply()
    }

    val tailvertex: List[String] = DB readOnly { implicit session =>
      sql"select distinct tailvertex from edges".map(rs => rs.string("tailvertex")).list.apply()
    }


    println((headvertex ::: tailvertex).toSet.toList)
    //println(tailvertex)


  }

}