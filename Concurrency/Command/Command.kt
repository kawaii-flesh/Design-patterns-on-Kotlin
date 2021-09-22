interface Command
{
    fun execute()
}

class CalculateSum(val a: Int, val b: Int): Command
{
    var result: Int = 0
    private set
    override fun execute(){result = a + b}
}

class CalculateProduct(val a: Int, val b: Int): Command
{
    var result: Int = 0
    private set
    override fun execute()
    {
        result = a * b
    }
}

class Executer
{
    val history = mutableListOf<Command>()
    fun executeCommand(command: Command)
    {
        command.execute()
        history.add(command)
    }
}

fun main()
{
    val executer = Executer()
    val sum = CalculateSum(1, 2)
    val product = CalculateProduct(2, 2)

    executer.executeCommand(sum)
    executer.executeCommand(product)
}