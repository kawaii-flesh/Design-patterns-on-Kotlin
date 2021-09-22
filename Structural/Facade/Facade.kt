class Subsystem1
{
    fun doSomething1(){}
}
class Subsystem2
{
    fun doSomething2(){}
}
class Subsystem3
{
    fun doSomething3(){}
}

class Facade
{
    fun doComplexThingEasy()
    {
        val s1 = Subsystem1()
        val s2 = Subsystem2()
        val s3 = Subsystem3()

        // Do complex thing with subsystems
    }
}

fun main()
{
    val facade = Facade()
    facade.doComplexThingEasy()    
}