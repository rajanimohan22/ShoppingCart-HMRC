package uk.gov.hmrc.shoppingcart

/**
  * Created by Mohan Dolla on 10/12/2017.
  */
case class ShoppingCart(items: Map[Product, Long] = Map.empty) {
  def add(product: Product) = {
    val n = items.getOrElse(product, 0L)
    copy(items + (product -> (n+1)))
  }
}

object ShoppingCart {
  def buildfromItems(items: List[Product]): ShoppingCart = {
    items.foldLeft(new ShoppingCart)(_.add(_))
  }
}
