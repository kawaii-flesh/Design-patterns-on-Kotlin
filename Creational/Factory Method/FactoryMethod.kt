abstract class Product(val сaloriesKCal: Int)

interface IFabricator
{
    fun createProduct(): Product
}

class Baker: IFabricator
{
    class Bread: Product(265)

    override fun createProduct(): Bread = Bread()
}

class Farmer: IFabricator
{
    class Apple: Product(47)

    override fun createProduct(): Apple = Apple()
}

class Breakfast
{
    fun createDish(fabricator: IFabricator): Product = fabricator.createProduct()
}

fun main()
{
    val breakFast = Breakfast()
    val farmer = Farmer()

    val apple = breakFast.createDish(farmer)
}