  package testLab

  import org.scalatest.WordSpec

  class CatalogTest  extends WordSpec{
    val emptyCatalog = new BasicCatalog(Map.empty)
    val notEmptyCatalog = new BasicCatalog(Map(
      Product("Test product1")-> Price(1.0),
      Product("Test product2")-> Price(1.0),
    ))
    "A catalog" when{
      "empty" should{
        "have no elements" in{
          assert(emptyCatalog.products.empty==Map.empty)
        }
      }
      "however if not empty, it" should{
        "have some elements" in {
          assert(notEmptyCatalog.products.nonEmpty)
        }
          "Elements" should{
            "have a name" in{
              assert(notEmptyCatalog.products.keys==Iterable(Product("Test product1"), Product("Test product2")).toSet)
            }
            "and have a price" in{
              assert(notEmptyCatalog.products.values==Iterable(Price(1.0), Price(2.0)).toSet)
            }
          }
        "and one" should{
          "be able to retrieve it by name" in{
            assert(notEmptyCatalog.priceFor(Product("Test product1"))==Price(1.0))
          }
        }
        }
      }

  }
