package testLab

class ShoppingTest {

  import org.scalatest.FunSpec

  class CartTest extends FunSpec {
    val cart = new BasicCart()

    describe("A cart") {
      describe("when empty") {
        it("should have size 0") {
          assert(cart.size == 0)
        }

        it("when an element is added") {
          val p1: Product=Product ("Shoe")
          val price:Price = Price(2.0: Double)
          val details:ItemDetails = ItemDetails(4, price)
          val item:Item = Item(p1, details)
          cart.add(item)
          it("should have size 1") {
            assert(cart.size == 1)
          }
          it("should have that item") {
            assert(cart.content == item)
          }
          it("should have cost") {
            val quantity:Integer=item.details.qty
            val price:Double=item.details.price.value
            val total= quantity*price
            assert(cart.totalCost == total)
          }
        }
      }
    }
  }

  import org.scalatest.FlatSpec
  import testLab.TryShopping.{p1, p2}

  class CatalogTest extends FlatSpec {
    val catalog= new BasicCatalog(Map[Product,Price](
      p1 -> Price(78),
      p2 -> Price(34)
    ))

    "Catalog " should "contain" in {
      assert(catalog.products == Map[Product,Price](
        p1 -> Price(78),
        p2 -> Price(34)
      ))
    }

    "Products' prices should be" should "be" in {
      assert(catalog.priceFor(p1) == Price(78))
      assert(catalog.priceFor(p2) == Price(34))
    }
    "Prices for two products of the same type" should "be" in {
      assert(catalog.priceFor(p1, 2) == Price(78).value*2)
      assert(catalog.priceFor(p2, 2) == Price(34).value*2)
    }
  }

  import org.scalatest.FunSuite
  class WarehouseTest extends FunSuite {
    val (p1,p2) = (Product("Shoe"), Product("Hat"))
    val warehouse = new BasicWarehouse
    warehouse.supply(p1, 2)
    warehouse.supply(p2, 50)

    test("add product to cart") {
      assert(warehouse.get(p1, 2) === (p1,0))
      assert(warehouse.get(p2, 2) === (p2,48))
    }

  }
}
