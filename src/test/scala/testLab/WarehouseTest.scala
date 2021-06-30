package testLab

import org.scalatest.FreeSpec

class WarehouseTest extends FreeSpec{
  val warehouse = new BasicWarehouse()
  "A Warehouse" - {
    "should let usr" - {
      "take products if present" in {
        warehouse.supply(Product("Test1"), 1)
        warehouse.supply(Product("Test2"), 2)
        assert(warehouse.get(Product("Test1"), 1) == (Product("Test1"), 1))
      }
      "and it should complain if not present" in {
        assert(warehouse.get(Product("Test2"), 2) == (Product("Test2"), 2))
      }
    }
  }
}
