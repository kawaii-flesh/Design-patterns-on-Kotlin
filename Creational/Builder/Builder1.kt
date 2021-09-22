class ToyDetail(val name: String)

interface IToyBuilder
{
    fun addLegs(): Unit
    fun addBody(): Unit
    fun addArms(): Unit
    fun addHead(): Unit
}

class RobotBuilder: IToyBuilder
{
    private val robot = Robot(mutableListOf<ToyDetail>())

    override fun addLegs(): Unit {robot.details.add(ToyDetail("Robotic legs"))}
    override fun addBody(): Unit {robot.details.add(ToyDetail("Robotic body"))}
    override fun addArms(): Unit {robot.details.add(ToyDetail("Robotic arms"))}
    override fun addHead(): Unit {robot.details.add(ToyDetail("Robotic head"))}

    fun build(): Robot
    {
        robot.details.add(ToyDetail("~Magic~"))
        return robot
    }    
}

class PlushSpiderBuilder: IToyBuilder
{
    private val plushSpider = PlushSpider(mutableListOf<ToyDetail>())

    override fun addLegs(): Unit {plushSpider.details.add(ToyDetail("Plush spider legs"))}
    override fun addBody(): Unit {plushSpider.details.add(ToyDetail("Plush spider body"))}
    override fun addArms(): Unit {plushSpider.details.add(ToyDetail("Plush spider arms"))}
    override fun addHead(): Unit {plushSpider.details.add(ToyDetail("Plush spider head"))}

    fun build(): PlushSpider
    {
        plushSpider.details.add(ToyDetail("*Magic*"))
        return plushSpider
    }    
}

class Director()
{
    fun buildRobot(builder: IToyBuilder)
    {
        builder.addLegs()
        builder.addBody()
        builder.addArms()
        builder.addHead()
    }

    fun buildPlushSpider(builder: IToyBuilder)
    {
        builder.addBody()
        for(i in 0 until 4) 
            builder.addArms()
        builder.addHead()
    }
}

class Robot(val details: MutableList<ToyDetail>)
class PlushSpider(val details: MutableList<ToyDetail>)

fun main()
{
    val director = Director()
    val robotBuilder = RobotBuilder()
    val plushSpiderBuilder = PlushSpiderBuilder()

    director.buildRobot(robotBuilder)
    val robot = robotBuilder.build()

    director.buildPlushSpider(plushSpiderBuilder)
    val plushSpider = plushSpiderBuilder.build()
}