package testLab
import org.scalatest.FunSpec

class CartTest extends FunSpec {
  val cart = new BasicCart
  val cart1 = new BasicCart
  describe("A cart") {
    describe("when empty") {
      it("should have size 0") {
        assert(cart1.size == 0)
      }
    }
    describe("when an element is added") {
     val item: Item = Item(Product("Test"), ItemDetails(1, Price(2.0: Double)))
      cart.add(item)
      it("should have size 1") {
        assert(cart.size == 1)
      }
      it("should have that item") {
        assert(cart.content.contains(item))
      }
      it("should cost") {
        assert(cart.totalCost == item.details.price.value)
      }
    }
  }
}
