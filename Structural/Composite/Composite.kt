abstract class Component
{
    abstract fun getNumbersOfApples(): Int
}

class Apple(val n: Int): Component()
{
    override fun getNumbersOfApples(): Int = n
}

class Box: Component()
{
    private val space = mutableListOf<Component>()  

    fun addChild(child: Component): Boolean = space.add(child)
    fun removeChild(child: Component): Boolean = space.remove(child)
    override fun getNumbersOfApples(): Int = space.sumBy{it.getNumbersOfApples()}
}

fun main()
{
    val mainBox = Box()
    val secondBox = Box()
    val emptyBox = Box()

    secondBox.addChild(Apple(7))
    secondBox.addChild(emptyBox)

    mainBox.addChild(secondBox)
    mainBox.addChild(Apple(10))

    val numbersOfApples = mainBox.getNumbersOfApples()
}