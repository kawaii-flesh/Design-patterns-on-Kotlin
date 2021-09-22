class ToyDetail(val name: String)

interface IToyBuilder
{
    fun addLegs(): Unit
    fun addBody(): Unit
    fun addArms(): Unit
    fun addHead(): Unit
}

fun buildRobot(init: RobotBuilder.()->Unit): Robot
{
    val robotBuilder = RobotBuilder()

    init(robotBuilder)

    return robotBuilder.build()
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

fun buildPlushSpider(init: PlushSpiderBuilder.()->Unit): PlushSpider
{
    val plushSpiderBuilder = PlushSpiderBuilder()

    init(plushSpiderBuilder)

    return plushSpiderBuilder.build()
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
    fun createRobot(): Robot
    {
        val robot =
        buildRobot()
        {
            addLegs()
            addBody()
            addArms()
            addHead()
        }
        
        return robot
    }

    fun createPlushSpider(): PlushSpider
    {
        val plushSpider = 
        buildPlushSpider()
        {
            addBody()
            for(i in 0 until 4) 
                addArms()
            addHead()
        }

        return plushSpider
    }
}

class Robot(val details: MutableList<ToyDetail>)
class PlushSpider(val details: MutableList<ToyDetail>)

fun main()
{
    val director = Director()

    val robot =  director.createRobot()

    val plushSpider = director.createPlushSpider()
}