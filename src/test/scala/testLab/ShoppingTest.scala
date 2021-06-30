package testLab

import org.scalamock.scalatest.MockFactory
import org.scalatest.FunSpec

class ShoppingTest extends FunSpec with MockFactory {
    val product: Product = Product("Test")
    val mockCart: Cart = mock[Cart]
    val mockCatalog: Catalog = mock[Catalog]
    val mockWarehouse: Warehouse = mock[Warehouse]
    val shopping = new Shopping(mockWarehouse, mockCatalog, mockCart, NullLogger)

    it("should simulate a shopping session") {
      (mockWarehouse.get _).expects(product, 2).returns((product, 2))
      (mockCatalog.priceFor: (Product, Int) => Price).expects(product, 2).returns(Price(30))
      (mockCart.totalCost _).expects().returns(30)
      (mockCart.size _).expects().returns(2)
    }

    it("should not throw exception if usr asked for a product not available") {
      (mockWarehouse.get _).expects(product, 1).returns((product, 1))
      shopping.pick(product, 7)
    }
}
