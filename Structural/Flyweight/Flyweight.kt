class Sprite
class Color

class DrawableObject(val x: Int, val y: Int, val resSet: ResSet)

class ResSet(val sprite: Sprite, val color: Color)
{
    // Other heavyweight properties
}

object ResSetFabric
{
    private val collection = mutableListOf<ResSet>()

    fun getResSet(sprite: Sprite, color: Color): ResSet
    {
        var resSet = collection.find{it.sprite == sprite && it.color == color}
        if(resSet == null)
        {
            resSet = ResSet(sprite, color)
            collection.add(resSet)
        }
        return resSet
    }
}

fun main()
{
    val listOfObjects = List(10){DrawableObject((-10..10).random(), (-10..10).random(), 
                                    ResSetFabric.getResSet(Sprite(), Color()))}
}