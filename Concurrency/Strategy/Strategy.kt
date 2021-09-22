interface IStrategy
{
    fun workIt()
    fun makeIt()
    fun doIt()
}

class Harder: IStrategy
{
    override fun workIt(){}
    override fun makeIt(){}
    override fun doIt(){}
}

class Better: IStrategy
{
    override fun workIt(){}
    override fun makeIt(){}
    override fun doIt(){}
}

class Faster: IStrategy
{
    override fun workIt(){}
    override fun makeIt(){}
    override fun doIt(){}
}

class Stronger: IStrategy
{
    override fun workIt(){}
    override fun makeIt(){}
    override fun doIt(){}
}

class Executer(var strategy: IStrategy)
{

    fun doComplexThing()
    {
        workIt()
        makeIt()
        doIt()
    }

    fun workIt() = strategy.workIt()
    fun makeIt() = strategy.makeIt()        
    fun doIt() = strategy.doIt()
}

fun main()
{
    val betterStrategy = Better()
    val harderStrategy = Harder()
    val executer = Executer(betterStrategy)

    executer.doComplexThing()
    
    executer.strategy = harderStrategy
    executer.doComplexThing()
}