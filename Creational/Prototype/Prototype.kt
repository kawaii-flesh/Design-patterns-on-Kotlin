interface Prototype
{
    fun createClone(): Prototype
}

class Sheep(val name: String, val color: String): Prototype
{
    private var somePrivateProperty: Int = (0..10).random()
    override fun createClone(): Prototype
    {
        val clone = Sheep(name, color)
        clone.somePrivateProperty = somePrivateProperty

        return clone
    }
}

fun main()
{
    val sheepDolly = Sheep("Dolly", "White")
    val sheepClone = sheepDolly.createClone()
}