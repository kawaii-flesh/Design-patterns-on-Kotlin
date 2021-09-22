abstract class CPU
{
    abstract fun addTwoOperands(a: Int, b: Int): Int
}

class ARM : CPU()
{
    override fun addTwoOperands(a: Int, b: Int): Int
    {
        // Do special operations for ARM
        return a + b
    }
}

class x86 : CPU()
{
    override fun addTwoOperands(a: Int, b: Int): Int
    {
        // Do special operations for x86
        return a + b
    }
}

open class UniversalComputer(val cpu: CPU)
{
    fun addTwoInt(a: Int, b: Int): Int =
        cpu.addTwoOperands(a, b)
}

class ComputerWithNewFeatures(cpu: CPU): UniversalComputer(cpu)
{
    fun doNewFeature(){}
}


fun main()
{
    val myCPU = ARM()
    val myComputer = UniversalComputer(myCPU)
}